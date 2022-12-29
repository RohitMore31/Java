package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.service.StudentServiceImpl;


@WebServlet("/examstart")
public class StartExam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		//Getting Parameter using QueryString
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		//Passing these Parameter to check Authentication
		StudentServiceImpl ss = new StudentServiceImpl();
		boolean status = ss.startExam(pass,email);
		if(status) {
			out.println("<h2>Successfully logged </h2>");
			if(!session.isNew()) {
				session.setAttribute("status", true);
				session.setAttribute("index", 0);
			}
			// logged successfully then pass to examQpaper.jsp
			RequestDispatcher rd = request.getRequestDispatcher("/ExamQpaper.jsp");
			rd.include(request, response);
			
		}else {
			out.println("<h2>Failed in Register</h2>");
			out.println("<a href='index.html'>Home page</a>");
		}
		out.println("<a href='index.html'>for result go home page</a>");
		// back control to index.html
	}

}