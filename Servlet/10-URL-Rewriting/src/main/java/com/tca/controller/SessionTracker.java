package com.tca.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/get")
public class SessionTracker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		Integer i = 0;
		
		try {
			i = (Integer)session.getAttribute("count");
			if(i == null)
				i = 1;
		}
		catch(Exception e) {
			i = 1;
		}
		
		if(i > 1) {
			out.print("Welcome back !<br>");
		}
		else {
			out.println("Nice to meet you !<br>");
		}
		
		if(request.isRequestedSessionIdFromCookie()) {
			out.print("Cookies are enabled ! sessionId stored in cookie<br>");
		}
		else if(request.isRequestedSessionIdFromURL()) {
			out.print("Cookies are disables, trying to encode the sessionId in URL....<br>");
		}
		

		out.print("<a href='" +  response.encodeURL("get") +"'> Click Me ! </a>");
		session.setAttribute("count", ++i);
		
		
	}

}
