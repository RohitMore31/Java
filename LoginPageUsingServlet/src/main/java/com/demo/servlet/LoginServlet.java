package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.User;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

@WebServlet("/validate")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("name");
		String pass=request.getParameter("pass");
		
		// create ob of service class
		LoginService ls=new LoginServiceImpl();
		User u=ls.validateUser(uname,pass);
		
		// Process on user return by LoginService
		if(u!=null) {
			//valid user
			if(u.getRole().equals("admin")) {
				
				//server side transfer of control
                  RequestDispatcher rd=request.getRequestDispatcher("admin");
                  rd.forward(request, response);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("user");
                rd.forward(request, response);
			}
		}else {
			//invalid user
			out.println("invalid credentials");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
            rd.include(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
