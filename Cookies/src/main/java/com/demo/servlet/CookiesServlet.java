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
		
		// request dispatcher to transfer control
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		switch(btn) {
		case "add":
			//create new cookies
			Cookie c =new Cookie(name, pass);
			// add cookies to response
			response.addCookie(c);
			out.print("Cookies Created");
			// forwarding control 
			rd.include(request, response);
			break;
			
		case "delete":
			// get list of cookies
			Cookie[] arr= request.getCookies();
			for (Cookie ck : arr) {
				if(ck.getName().equals(name)) {
					out.print(name);
					// deleting cookies
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
			// get list of cookies
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
