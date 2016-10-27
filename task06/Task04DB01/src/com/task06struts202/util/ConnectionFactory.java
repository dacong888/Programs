package com.task06struts202.util;

import java.sql.Connection;
import java.sql.DriverManager;
//数据库连接类
public class ConnectionFactory {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String db_url = "jdbc:mysql://localhost:3306/tang_poetry?useUnicode=true&characterEncoding=UTF-8";
	private static String user = "root";
	private static String password = "123123";

	private static final ConnectionFactory factory = new ConnectionFactory();
	private Connection conn = null;

	private ConnectionFactory() {
	}

	public static ConnectionFactory getInstance() {
		return factory;
	}

	public Connection doConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(db_url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
}
