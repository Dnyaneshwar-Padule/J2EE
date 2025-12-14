package com.tca;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h1>You have to submit name from the form !</h1>");
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("name");
	
	
		if(userName.isEmpty()) {
			out.println("<h2>Input not received !</h2>");
		}
		else if(userName.length() > 30) {
			out.println("<h2>Invalid user name !</h2>");
		}
		else {
			out.println("<h2> Reveived User name : " + userName.toUpperCase()  + "</h2>");
		}
		
		out.close();
	}

}
