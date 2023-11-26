package com.qlsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	private static final String URL = "jdbc:mysql://localhost:3308/db_qlsp";
	private static final String USER = "root";
	private static final String PASSWORD = "phungvandung03062003@1q";
	
	// Tao ket noi
	public static Connection getConnection() {
		Connection connection = null;
		
		// Kiem tra loi
		try {
			// Dang ky ket noi mysql
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			// Mo ket noi
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}
	
	// Dong ket noi
	public static void closeConnection(Connection connection) {
		try {
			if(connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
