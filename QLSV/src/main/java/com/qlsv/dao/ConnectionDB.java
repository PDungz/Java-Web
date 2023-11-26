package com.qlsv.dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionDB {
	private static final String URL = "jdbc:mysql://localhost:3308/qlsv";
	private static final String USER = "root";
	private static final String PASSWORD = "phungvandung03062003@1q";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			// Đăng ký kết nối
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			// Mơ kết nối
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
