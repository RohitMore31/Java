package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.service.StudentServiceImpl;

@WebServlet("/registerStudent")
public class RegisterStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String email=request.getParameter("email");
		String topic1=request.getParameter("topic");
		
		//creating session
		HttpSession session = request.getSession();
		if(session.isNew()) {
			System.out.println("first time seesion is created!!!!");
			session.setAttribute("topic", topic1);	
			session.setAttribute("totalmark", 0);
			System.out.println("intial vale of mark  from session = "+(Integer)session.getAttribute("totalmark"));
		}else{
			// setting attribute to session
		}
		
		// creating ob of StudentService
		StudentServiceImpl ss = new StudentServiceImpl();
		boolean status = ss.addNewStudent(uname,pass,email);
		if(status) {
			out.println("<h2>Register Successfully</h2>");
		}else {
			out.println("<h2>Failed in Register</h2>");
		}
		out.println("<a href='index.html'>Home page</a>");
		// back controll to index.html
		
		
	}

}
