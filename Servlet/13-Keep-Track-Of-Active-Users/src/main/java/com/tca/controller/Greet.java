package com.tca.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Greet
 */
@WebServlet("/greet")
public class Greet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int count = 0;
		
		try {
			count = (Integer)session.getAttribute("count");			
		}
		catch(Exception e) {
			count = 0;
		}
		
		if(count == 0) {
			out.print("Nice to meet you !");
			count++;
		}
		else {
			out.print("Welcome back !<br>Your request no.: " + count);
		}
		
		session.setAttribute("count", ++count);
		
	}

}
