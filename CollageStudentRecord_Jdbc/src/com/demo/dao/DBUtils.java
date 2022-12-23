package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Implementing single Ton design Pattern
public class DBUtils {
	static Connection con=null;
	static Connection CreateMyConnection() {
		try {
			// Register Driver Manager
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url ="jdbc:mysql://localhost:3306/prandfn?useSSL=false";
			String uname="root";
			String Pass="root";
			
			// Get Connection
			con = DriverManager.getConnection(url,uname,Pass);
			
			// Return connection
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	static void CloseMyConnection() {
		// closing connection
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
