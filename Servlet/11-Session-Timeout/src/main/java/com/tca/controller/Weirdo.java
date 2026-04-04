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
 * Servlet implementation class Weirdo
 */
@WebServlet("/foo")
public class Weirdo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		session.setAttribute("foo", "77");
		session.setMaxInactiveInterval(0);
		
		String foo = (String) session.getAttribute("foo");
		
		if(session.isNew()) {
			out.print("Nice to meet you !");
		}
		else {
			out.print("Welcome Back !");
		}
		
		out.print("<br>Foo : " + foo);
		
	}

}
