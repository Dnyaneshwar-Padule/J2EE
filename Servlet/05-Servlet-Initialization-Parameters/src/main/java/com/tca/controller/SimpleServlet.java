package com.tca.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SimpleServlet() {
		System.out.println("SimpleServlet.SimpleServlet()");
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init()");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
				
		// Servlet Config is separate for every Servlet
		// It is created by the container, while initialization of the Servlet
		// It has initialization parameters (from Deployment Descriptor)
		ServletConfig config = this.getServletConfig();
		
		Enumeration<String> parms = config.getInitParameterNames();
		
		while(parms.hasMoreElements()) {
			String parameterName = parms.nextElement();
			out.println(parameterName + " : " + config.getInitParameter(parameterName) + "<br>");
		}
		
		out.flush();
		out.close();
	}

}
