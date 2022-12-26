package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Qpaper;

public class StudentdaoImpl {
	static Connection con;
	static PreparedStatement ps,ps1,ps2,qp,ps5;
	static List <Qpaper> list;

	static{
		try {
			con=DBUtils.getMyConnection();
			ps=con.prepareStatement("insert into Studentregister values(?,?,?,?)");
			ps1 = con.prepareStatement("select * from studentRegister ");
			ps2 = con.prepareStatement("select * from studentRegister where email=? and pass=? ");
			qp=con.prepareStatement("select * from Qpaper");
			ps5=con.prepareStatement("select  mark from Qpaper");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public boolean AddNewStudent(String uname, String pass, String email) {
		//binding value to ps such as
		//	(uname varchar(20),email varchar(30), pass varchar(20),mark double);

		try {
			ps.setString(1, uname);
			ps.setString(2, email);
			ps.setString(3, pass);
			ps.setDouble(4, 0);
			int x = ps.executeUpdate();
			if(x>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}



	public boolean StartExam(String pass, String email) {
		try {
			ps2.setString(1, email);
			ps2.setString(2, pass);
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public List<Qpaper> AllQuestion() {
		list = new ArrayList<>();
		try {
			ResultSet rs = qp.executeQuery();
			while(rs.next()) {
				 String que =rs.getString(1);
				 String op1 =rs.getString(2);
				 String op2= rs.getString(3);
				 String op3= rs.getString(4);
				 String op4= rs.getString(5);
				 String ans = rs.getString(6);
				 String topic= rs.getString(7);
				 list.add(new Qpaper(que,op1,op2,op3,op4,ans,topic));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public List<String> AllQuestionAns() {
		List<String> anslist= new ArrayList<String>();
		for (Qpaper qpans : list) {
			anslist.add(qpans.getAns());
		}
		System.out.println(anslist);
		return anslist;
	}















}
