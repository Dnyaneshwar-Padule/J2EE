package com.tca.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.tca.entity.Person;


@WebServlet("/person")
public class PersonInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/index.html").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Person person = new Person();
		try {
			person.setName(request.getParameter("name"));			
			person.setAge( Integer.parseInt( request.getParameter("age") ) );
			request.setAttribute("person", person);
		}
		catch(Exception e) {
			
		}
		
		request.getRequestDispatcher("/ShowInfo.jsp").forward(request, response);
	}

}
