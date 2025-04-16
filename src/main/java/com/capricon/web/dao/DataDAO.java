package com.capricon.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataDAO {
	
	private static final String URL = "jdbc:mysql://localhost:3306/books_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "rootu$er";
	
	// Load MySQL JDBC driver once
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException("Error loading MySQL driver, ", ex);
		}
	}
	
	// Connect to the database
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException ex) {
			throw new RuntimeException("Failed to connect to the database: ", ex);
		}
	}

}
