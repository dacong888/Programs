package com.task04DB.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import com.task04DB.dao.PoetCheck;
import com.task04DB.dao.impl.PoetCheckImpl;
import com.task04DB.dto.PoetInfo;


public class Test {

	public static void main(String[] args) {
//		Connection conn = ConnectionFactory.getInstance().doConnection();
//		System.out.println(conn);
//		
//		PoetCheck pc = new PoetCheckImpl();
//		try {
//			List<PoetInfo> pi = pc.getResult(conn, "李清照");
//			if (pi == null) {
//				conn.close();
//				
//			}else{
//			//int i = 0;
//			for (PoetInfo poetInfo : pi) {
//				//System.out.println(++i + ":" + poetInfo.getTitle());
//				//System.out.println(poetInfo.getContent());
//				System.out.println(poetInfo.getName());
//				System.out.println(poetInfo.getTitle());
//				System.out.println(poetInfo.getContent());
//				conn.close();
//			}
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
