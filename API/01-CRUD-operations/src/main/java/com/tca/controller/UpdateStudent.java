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


@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		
		try {
		    Student student = mapper.readValue(request.getReader(), Student.class);
		    boolean result = StudentServiceFactory.getStudentServiceInstance().updateStudent(student);
		    
		    if(result) {
		    	response.setStatus(HttpServletResponse.SC_OK);
		    	mapper.writeValue(response.getWriter(), student);
		    }
		    else {
		    	response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		    	mapper.writeValue(response.getWriter(), "Student with rno " + student.getRno() + " not exists !");		    	
		    }
		}
		catch(Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			mapper.writeValue(response.getWriter(), "Invalid values !");
		}
	}

}
