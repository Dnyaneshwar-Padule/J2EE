package com.tca.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.tca.entity.Dog;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListenerTest
 */
@WebServlet("/listen")
public class ListenerTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		ServletContext context = getServletContext();
		PrintWriter out = response.getWriter();		
		Dog dog =  (Dog) context.getAttribute("dog");
		out.println("Gog breed : " + dog.getBreed());
		out.close();
	}

}
