package com.task03.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*
 * 定义连接类。
 */
public class ConnectionFactory {
	private static String driver;
	private static String db_url;
	private static String user;
	private static String password;
	
	private static final ConnectionFactory factory = new ConnectionFactory();
	
	private Connection conn = null;
	
	//定义静态代码段，用于执行属性文件的读取。其中属性文件为目录下的：dbconfig.properties
	static{
		Properties properties = new Properties();
		try {
			InputStream inputStream = new BufferedInputStream(new FileInputStream("src/dbconfig.properties"));
			properties.load(inputStream);
		} catch (Exception e) {
			System.out.println("配置文件dbconfig.properties读取失败...");
		} 
		
		driver = properties.getProperty("driver");
		db_url = properties.getProperty("db_url");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
	}
	
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
