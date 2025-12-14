package com.tca;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class First extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<body bgcolor='green'>");
		out.println("<h1>This is my first Servlet Application !</h1>");
		out.println("<h2>Not really !</h2>");
		out.println(req.getLocalAddr());
		out.println(req.getLocalName());
		out.println(req.getLocalPort());
		out.print("Starting from today : " + LocalDateTime.now().toString());
		out.println("</body>");
		out.close();
	}
	
}
