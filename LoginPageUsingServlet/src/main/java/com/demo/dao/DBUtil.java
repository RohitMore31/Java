package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil
 {
	static Connection con=null;
	// class for singleton pattern
	
	static Connection getMyConnection() 
	{
		if(con==null) 
		{
			try {
				// create connection and return
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				String url="jdbc:mysql://localhost:3306/test?useSSL=false";
				String username="root";
				String password="root";
				con=DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
		
	}
	// close connection and return
	static void closeMyConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
