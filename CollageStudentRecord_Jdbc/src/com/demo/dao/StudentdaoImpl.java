package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.Student;

public class StudentdaoImpl implements Studentdao {
	static Connection con;
	static PreparedStatement ps; 
	static {
		// register driver
		try {
			con = DBUtils.CreateMyConnection();
			ps = con.prepareStatement("insert into Student values(?,?,?,?,?)");
			System.out.println(ps);
			 
			 
		} catch (SQLException e) {
			e.getMessage();
		}

		

	}

	@Override
	public boolean AddNewStudent(Student std) {
		try {
			//binding data to statement
			ps.setInt(1, std.getId());
			ps.setString(2, std.getName());
			ps.setFloat(3, std.getSub1());
			ps.setFloat(4, std.getSub2());
			ps.setFloat(5, std.getSub3());
			ps.setFloat(6, std.getPercentage());
			// Executing Query
			int n = ps.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return false;
	}

}
