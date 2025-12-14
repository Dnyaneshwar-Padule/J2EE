package com.tca.controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tca.entities.Student;
import com.tca.factory.StudentServiceFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/FetchStudent/*")
public class FetchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
			String rollNumberStr = request.getPathInfo();
			
			if(rollNumberStr == null || rollNumberStr.length() <= 1) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				mapper.writeValue(response.getWriter(), "Roll number not found !");
			}
			else {
				
				Student student = StudentServiceFactory
						.getStudentServiceInstance()
						.fetchStudent(Integer.parseInt(rollNumberStr.substring(1)));
				
				if(student == null) {
					response.setStatus(HttpServletResponse.SC_NOT_FOUND);					
					mapper.writeValue(response.getWriter(), "Student with roll number " + Integer.parseInt(rollNumberStr.substring(1)) + " does not exits !");
				}
				else {
					response.setStatus(HttpServletResponse.SC_FOUND);
					mapper.writeValue(response.getWriter(), student);
				}
				
			}			
		}
		catch(Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			mapper.writeValue(response.getWriter(), "Invalid format of roll number");
		}
		
		
	}

}
