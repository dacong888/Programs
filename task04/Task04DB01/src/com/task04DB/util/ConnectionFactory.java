package com.task04DB.util;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectionFactory {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String db_url = "jdbc:mysql://localhost:3306/tang_poetry?useUnicode=true&characterEncoding=utf-8";
	private static String user = "root";
	private static String password = "123123";	
	private static final ConnectionFactory factory = new ConnectionFactory();
	private Connection conn = null;
	
	private ConnectionFactory(){}
	
	public static ConnectionFactory getInstance(){
		return factory;
	}
	
	public Connection doConnection(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(db_url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
