package com.tca.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet("/get")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ServletContext context  = getServletContext();
		Enumeration<String> parms = context.getInitParameterNames();
		PrintWriter out = response.getWriter();
		
		while(parms.hasMoreElements()) {
			String parameterName = parms.nextElement();
			out.println(parameterName +  " : " + context.getInitParameter(parameterName) + "<br>");
		}
		
		out.print("Server Info : " +  context.getServerInfo() + "<br>");
		out.print("Major Version : " + context.getMajorVersion() + "<br>");
		out.print("Minor Version : " + context.getMinorVersion() + "<br>");
		
		out.close();
	}

}
