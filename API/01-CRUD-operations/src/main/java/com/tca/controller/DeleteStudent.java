package com.tca.controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tca.factory.StudentServiceFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteStudent/*")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		
		try {	
			String rollNumberStr = request.getPathInfo();
			
			if(rollNumberStr == null || rollNumberStr.length() <= 1) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				mapper.writeValue(response.getWriter(), "Roll number not found !");
			}
			else {	
				boolean status = StudentServiceFactory
						.getStudentServiceInstance()
						.removeStudent(Integer.parseInt(rollNumberStr.substring(1)));
					
				if(status) {
					response.setStatus(HttpServletResponse.SC_NO_CONTENT);
					mapper.writeValue(response.getWriter(), status);					
				}
				else {
					response.setStatus(HttpServletResponse.SC_NOT_FOUND);					
					mapper.writeValue(response.getWriter(), "Student with roll number " + Integer.parseInt(rollNumberStr.substring(1)) + " does not exits !");
				}
					
			}			
		}
		catch(Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			mapper.writeValue(response.getWriter(), "Invalid format of roll number");
		}
		
	}

}
