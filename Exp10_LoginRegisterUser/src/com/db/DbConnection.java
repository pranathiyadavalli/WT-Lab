package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection getConnection() {
		Connection connection = null;
		//String URL = "jdbc:mysql://localhost:8080/pranathi";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");					
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exp10", "root", "1234");			
			return connection;			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
		
	}
}