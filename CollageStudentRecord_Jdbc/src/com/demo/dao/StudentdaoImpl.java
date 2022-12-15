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
	static PreparedStatement ps,ps1,ps2,ps4; 
	static {
		try {
			con = DBUtils.CreateMyConnection();
			ps = con.prepareStatement("insert into Student values(?,?,?,?,?,?)");
			ps1 = con.prepareStatement("Select * from Student ");
			ps2 =con.prepareStatement("select * from Student where id=?");
			

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

	@Override
	public List<Student> ShowAllStudent() {
		List<Student> lt = new ArrayList<>();
		try {
			ResultSet rs = ps1.executeQuery();
			while(rs.next()) {
				Student st = new Student(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getFloat(4),rs.getFloat(5));
				lt.add(st);
			}
			return lt;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}

	@Override
	public Student SearchByID(int n) {
		try {
			ps2.setInt(n, n);
			ResultSet rs = ps2.executeQuery();
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
	public Student FindSubTopper(int n) {
		try {
			PreparedStatement ps3 =con.prepareStatement("select * from Student order by "+n+" desc limit 1");
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
}
