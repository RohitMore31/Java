package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.ResultStreamer;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class TestStudent {
	public static void main(String[] args) {
		// this is for Test
		/* Steps to connect database
		 * 1) Register Driver
		 * 2) Get Connection
		 * 3) Create Statement => 1)creatStatement 2)PrepareStatement 3)CallableStatement
		 * 4) Execute Statement => 1)executeQuery 2)executeUpdate 3)execute
		 * 5) Process Data
		 * 6) Close Connection
		 */
		try {
			// register driver
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			// creating connection
			String url ="jdbc:mysql://localhost:3306/prandfn?useSSL=false";
			String uname="root";
			String Pass="root";
			Connection con = DriverManager.getConnection(url,uname,Pass);

			// create Statement
			PreparedStatement ps = con.prepareStatement("select * from test");
			// execute Statement
			ResultSet rs = ps.executeQuery();

			// crud Ops => insert
			PreparedStatement ps1 = con.prepareStatement("insert into test values(?,?,?)");
			int id = 34;
			String name ="Ajit";
			int per = 78;
			ps1.setInt(2, id);
			ps1.setString(1, name);
			ps1.setInt( 3, per);
			int n = ps1.executeUpdate();
			if(n>0) System.out.println("Inserted !!!!");
			else System.out.println("error");

			// delete
			id=34;
//			System.out.println("delet from test where id="+id+";");
			PreparedStatement ps2 = con.prepareStatement("delet from test where id="+id+";");
//			ps2.setInt(2,id);
			ps2.executeUpdate();

			//execute Statement
			n = ps2.executeUpdate();
			if(n>0) System.out.println("deleted !!!!");
			else System.out.println("error");

			// processing data
			while(rs.next()) {
				System.out.println("id = "+rs.getInt(2));
				System.out.println("name = "+rs.getString(1));
				System.out.println("per = "+rs.getInt(3));
				System.out.println("=============================");
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
