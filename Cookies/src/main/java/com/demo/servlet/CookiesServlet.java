package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String btn =request.getParameter("btn");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		switch(btn) {
		case "add":
			Cookie c =new Cookie(name, pass);
			response.addCookie(c);
			out.print("Cookies Created");
			rd.include(request, response);
			break;
			
		case "delete":
			Cookie[] arr= request.getCookies();
			for (Cookie ck : arr) {
				if(ck.getName().equals(name)) {
					out.print(name);
					ck.setMaxAge(0);
					response.addCookie(ck);
					out.print("Cookies deleted");
					rd.include(request, response);
					break;
				}
			}
			out.print("Cookies Not Found");
			break;
			
		case "show":
			Cookie[]carr = request.getCookies();
			for (Cookie ck : carr) {
				out.println("<h3>"+ck+"</h3>");
			}
			break;
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
