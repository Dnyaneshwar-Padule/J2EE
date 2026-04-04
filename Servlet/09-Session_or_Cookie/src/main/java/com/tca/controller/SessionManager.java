package com.tca.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/get")
public class SessionManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Integer i = 0;
		
		HttpSession session =  request.getSession(true);
		
		try {
			i = (Integer)session.getAttribute("count");
		}catch(Exception e) {
			i = 1;
		}
		
		if(session != null && i != null) {
			out.println("Hey ! what's up ! I remember you !<br>");
			out.print("You have made " + i.intValue() + " requests !");
			session.setAttribute("count", ++i);
		}
		else {
			out.println("Hey ! How are you ?<br>Nice, to meet you !");
			session.setAttribute("count", 1);
		}
		
		System.out.println("Session ID: " + session.getId());
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(int j = 0; j < cookies.length; j++) {
				System.out.println("Cookie " + j + " : " + cookies[j].getName() + "::" + cookies[j].getValue());
			}
		}
		
	
	}

}
