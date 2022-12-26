package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	static Connection con=null;
	static Connection getMyConnection() {
		if(con==null) {
			try {
				
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				String url="jdbc:mysql://localhost/collegeExam?useSSL=false";
				String username="root";
				String password="root";
				con=DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return con;
		
	}
	static void closeMyConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
