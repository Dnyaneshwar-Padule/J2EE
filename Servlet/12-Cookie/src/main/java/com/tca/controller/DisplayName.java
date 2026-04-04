package com.tca.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DisplayName
 */
@WebServlet("/get-name")
public class DisplayName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean cookieFound = false;
		String name = null;
		Cookie[] cookies = request.getCookies();
		for(int i = 0; i < cookies.length; ++i) {
			Cookie c = cookies[i];
			
			if(c.getName().equals("name")) {
				cookieFound = true;
				name = c.getValue();
			}
		}
		
		if(cookieFound) {			
			displayName(response, name);
		}
		else {
			request.getRequestDispatcher("/form.jps").forward(request, response);			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		if(name != null && ! name.isBlank()) {
			Cookie cookie = new Cookie("name", name);
			cookie.setHttpOnly(true);
			cookie.setMaxAge(60);
			response.addCookie(cookie);
			displayName(response, name);
		}
		else {
			request.getRequestDispatcher("/form.jsp").forward(request, response);
		}
	}
	
	private void displayName(HttpServletResponse response, String name) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("Hello " + name + ", nice to meet you again !");
		out.close();
	}

}