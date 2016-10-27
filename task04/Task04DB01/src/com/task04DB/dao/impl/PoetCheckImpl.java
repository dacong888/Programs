package com.task04DB.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.task04DB.dao.PoetCheck;

import com.task04DB.dto.PoetInfo;

public class PoetCheckImpl implements PoetCheck {

	private List<PoetInfo> getTitle(Connection conn, String content) {
		String sql = "select * from poets where name = ?";
		PreparedStatement ps;
		LinkedList<PoetInfo> listPoet = new LinkedList<>();
		int pt_id = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, content);
			ResultSet rSet = ps.executeQuery();
			while (rSet.next()) {
				pt_id = rSet.getInt("id");
			}
			
			if(pt_id == -1){
				return null;
			}

			// 查找poetries
			String sql_poetries = "select * from poetries where poet_id = ?";
			ps = conn.prepareStatement(sql_poetries);
			ps.setInt(1, pt_id);
			ResultSet rs = ps.executeQuery();
			PoetInfo pi = null;
			while (rs.next()) {
				pi = new PoetInfo();
				pi.setTitle(rs.getString("title"));
				pi.setName(content);
				listPoet.add(pi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPoet;
	}

	private List<PoetInfo> getInfo(Connection conn, String content) {
		// 如果是title
		String sql_title = "select * from poetries where title = ?";
		PreparedStatement ps;
		LinkedList<PoetInfo> listPoet = new LinkedList<>();
		try {
			PoetInfo pi = null;
			ps = conn.prepareStatement(sql_title);
			ps.setString(1, content);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pi = new PoetInfo();
				pi.setContent(rs.getString("content"));
				listPoet.add(pi);
			}

			if (listPoet.size() != 0) {
				return listPoet;
			} else {
				// 通过名句，搜索相关信息
				PoetInfo pi_content = new PoetInfo();
				String sql_content = "select content from poetries";
				ps = conn.prepareCall(sql_content);
				ResultSet rSet = ps.executeQuery();
				while (rSet.next()) {
					if(rSet.getString("content").indexOf(content) != -1){
						pi_content.setContent(rSet.getString("content"));
					}
				}
				
				if (pi_content.getContent() == null) {
					return null;
				}
				
				String sql_info = "select * from poetries where content = ?";
				ps = conn.prepareStatement(sql_info);
				ps.setString(1, pi_content.getContent());
				ResultSet rs_info = ps.executeQuery();
				while(rs_info.next()){
					pi_content.setPoet_id(rs_info.getInt("poet_id"));
					pi_content.setTitle(rs_info.getString("title"));
				}

				// 通过poet_id查找另一张表对应的姓名
				String sql_name = "select * from poets where id = ?";
				ps = conn.prepareStatement(sql_name);
				ps.setInt(1, pi_content.getPoet_id());
				ResultSet rs_name = ps.executeQuery();
				while (rs_name.next()) {
					pi_content.setName(rs_name.getString("name"));
				}

				listPoet.add(pi_content);
				return listPoet;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tast04DB.dao.PoetCheck#getResult(java.sql.Connection,
	 * java.lang.String)
	 */
	@Override
	public List<PoetInfo> getResult(Connection conn, String content) throws SQLException {
		List<PoetInfo> pi = null;
		if (content.length() <= 5) {
			pi = getTitle(conn, content);
			if (pi == null) {
				return getInfo(conn, content);
			} else {
				return pi;
			}
		}else{
			return getInfo(conn, content);
		}
	}
}
