package com.task06struts202.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.task06struts202.dao.PoetCheck;
import com.task06struts202.pojo.PoetInfo;
import com.task06struts202.util.ConnectionFactory;

//实现获取信息接口
public class PoetCheckImpl implements PoetCheck {

	// 通过作者查找内容
	private List<PoetInfo> getContentByAuthor(Connection conn, String content) {
		String sql = "select title, poets.name from poetries join poets on poetries.poet_id = poets.id where poets.name like ?";
		PreparedStatement ps;
		LinkedList<PoetInfo> listPoet = new LinkedList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + content + "%");
			ResultSet rs = ps.executeQuery();
			PoetInfo pi = null;
			while (rs.next()) {
				pi = new PoetInfo();
				pi.setName(rs.getString("poets.name"));
				pi.setTitle(rs.getString("poetries.title"));
				listPoet.add(pi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listPoet;
	}

	// 通过题目查找内容
	private List<PoetInfo> getContentByTitle(Connection conn, String content) {
		String sql = "select * from poetries where title like ?";
		PreparedStatement ps;
		LinkedList<PoetInfo> listPoet = new LinkedList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + content + "%");
			ResultSet rs = ps.executeQuery();
			PoetInfo pi = null;
			while (rs.next()) {
				pi = new PoetInfo();
				pi.setTitle(rs.getString("title"));
				pi.setContent(rs.getString("content"));
				listPoet.add(pi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPoet;
	}

	// 通过诗句查找内容
	private List<PoetInfo> getPoetByContent(Connection conn, String content) {
		// String sqlPoet = "select content, title, poet_id from poetries where
		// content like ?";
		String sql = "select content, title, poets.name from poetries join poets on poetries.poet_id=poets.id where content like ?";
		PreparedStatement ps;
		LinkedList<PoetInfo> listPoet = new LinkedList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + content + "%");
			ResultSet rs = ps.executeQuery();
			PoetInfo pi = null;
			while (rs.next()) {
				pi = new PoetInfo();
				pi.setContent(rs.getString("content"));
				pi.setTitle(rs.getString("title"));
				pi.setName(rs.getString("poets.name"));
				listPoet.add(pi);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPoet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.task04DB.dao.PoetCheck#getPoetInfo( java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<PoetInfo> getPoetInfo(String tag, String content) throws SQLException {
		Connection conn = ConnectionFactory.getInstance().doConnection();
		if (tag.equals("作者")) {
			return getContentByAuthor(conn, content);
		} else if (tag.equals("题目")) {
			return getContentByTitle(conn, content);
		} else if (tag.equals("内容")) {
			return getPoetByContent(conn, content);
		}
		return null;
	}
}
