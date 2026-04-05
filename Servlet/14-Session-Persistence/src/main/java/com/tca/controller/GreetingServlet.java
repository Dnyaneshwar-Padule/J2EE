package com.tca.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.tca.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/greet")
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);  // Don't create a new session, get the old session.
		
		if(session == null) {
			request.getRequestDispatcher("/form.jsp").forward(request, response);
		}
		else {
			displayInfo(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String ageString = request.getParameter("age");
		
		if(name == null || name.isBlank() || ageString == null || ageString.isBlank()) {
			request.getRequestDispatcher("/form.jsp").forward(request, response);
			return;
		}
		
		User user = new User();
		user.setName(name);
		
		try {
			user.setAge(Integer.parseInt(ageString));
		}
		catch(Exception e){
			request.getRequestDispatcher("/form.jsp").forward(request, response);
			return;
		}
		
		HttpSession session = request.getSession(false);
		
		if(session == null) {
			System.out.println("creating new session");
			session = request.getSession(true);
		}
		
		System.out.println(session.isNew());
		
		session.setAttribute("user", user);
		displayInfo(request, response);
	}
	
	private void displayInfo(HttpServletRequest request, HttpServletResponse response ) throws IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			PrintWriter out = response.getWriter();
			User user = (User)session.getAttribute("user");
			
			if(session.isNew()) {
				out.print("Hello, " + user.getName() + " ! Nice to meet you .");
			}
			else {
				out.print("Welcome back, " + user.getName() + ". It looks like you are " + user.getAge() + " years old !");
			}
			
			out.close();
		}
	}
}
