package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Student;

public class StudentdaoImpl implements Studentdao {
	static Connection con;
	static PreparedStatement ps,ps1,ps2,ps3,ps4,ps5; 
	static {
		try {
			// Creating connection 
			con = DBUtils.CreateMyConnection();
			
			// Preparing Statements 
			ps = con.prepareStatement("insert into Student values(?,?,?,?,?,?)");
			ps1 = con.prepareStatement("Select * from Student ");
			ps2 =con.prepareStatement("select * from Student where id=?");
			ps3 =con.prepareStatement("select * from Student order by sub? desc limit 1");
			ps4 =con.prepareStatement("select dense_rank() over(order by percentage desc)Rank_in_class,name,percentage from student;");
			ps5 =con.prepareStatement("delete from student where id=?");
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
				// Execute Successfully then returning true
				return true;
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public List<Student> ShowAllStudent() {
		// List of Student
		List<Student> lt = new ArrayList<>();
		try {
			// Executing Query
			ResultSet rs = ps1.executeQuery();
			while(rs.next()) {
				// Create of of Student using data from Result set 
				Student st = new Student(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getFloat(4),rs.getFloat(5));
				lt.add(st);
			}
			
			// Return list
			return lt;
		} catch (SQLException e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public Student SearchByID(int n) {
		try {
			// setting value of n to QueryString
			ps2.setInt(1, n);
			
			// executing ps2 statement
			ResultSet rs = ps2.executeQuery();
			
			while(rs.next()) {
			//	converting result set into object of student
				Student st = new Student(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getFloat(4),rs.getFloat(5));
			
			//  Returning student object to serviceImpl 
				return st;
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		// if not found the returning null
		return null;
	}

	@Override
	public Student FindSubTopper(int n) {
		try {
			ps3.setInt(1, n);
			ResultSet rs = ps3.executeQuery();
			while(rs.next()) {
				Student st = new Student(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getFloat(4),rs.getFloat(5));
				return st;
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return null;
	}

	
	@Override
	public List<Student> RankStudent() {
		try {
			List<Student> lt = new ArrayList<>();
			// executing ps4 statement
			ResultSet rs = ps4.executeQuery();
			
			while(rs.next()) {
			//	converting result set into object of student
				Student st = new Student(rs.getInt(1),rs.getString(2),rs.getFloat(3));
				lt.add(st);
			//  Returning student object to serviceImpl 
				return lt;
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public boolean DeleteByID(int n) {
		try {
			//binding data to statement
			ps5.setInt(1, n);
			
			// Executing Query
			int result = ps5.executeUpdate();
			if(n>0) {
				// Execute Successfully then returning true
				return true;
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return false;

	}
	
	
	
}
