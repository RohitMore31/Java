package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/numberOp2")
public class numberOp2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int n1 = Integer.parseInt(request.getParameter("num1"));
		String ch = request.getParameter("btn");
		
		switch(ch) {
		case "oddeven":
		if(n1%2==0){
		out.println("number is even");
		}
		else {
			out.println("number is odd");
		}
		break;
		
		case "prime":
		boolean f=false;
		for(int i=2;i<n1;i++) {
			if(n1/i==0) {
				out.println("NOT prime number");
				f=true;
				break;
			}
		}
		if(!f)
			out.println("Prime number");
		break;
		
		case "fact":
			int fact =1;
			while(n1!=1) {
				fact=fact*n1;
				n1=n1-1;
			}
			out.print("FACTORIAL = "+fact);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
