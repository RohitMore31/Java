package com.demo.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.service.StudentServiceImpl;


@WebServlet("/ansSheet")
public class AnsSheet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
//		Print?Writer out = response.getWriter();

		// Creating object of StudentServiceImpl
		StudentServiceImpl ss = new StudentServiceImpl();
		List <String> anslist = ss.allQuestionAns();

		String ans = request.getParameter("qid");

		// Checking ans
		boolean status=false;
		for (String s : anslist) {
			if(s.equals(ans)) {
				status=true;
				break;
			}
		}
		
		if(status) {
			System.out.println(anslist.contains(ans));
			//creating session
			HttpSession session = request.getSession();
			//Calculating mark and storing into session 
			if(!session.isNew()) {
				// setting attribute to session
				System.out.println((Integer)session.getAttribute("totalmark"));
				session.setAttribute("totalmark", (Integer)session.getAttribute("totalmark")+1);	
			}
		}else {
			System.out.println("wrong ans");
		}
		//Again Forwarding control to ExamQpaper.jsp
		RequestDispatcher rd = request.getRequestDispatcher("/ExamQpaper.jsp");
		rd.forward(request, response);

	}



}
