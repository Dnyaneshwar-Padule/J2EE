package com.tca.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tca.entities.Student;
import com.tca.factory.StudentServiceFactory;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SaveStudent")
public class SaveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws IOException {

	    response.setContentType("application/json");
	    ObjectMapper mapper = new ObjectMapper();

	    try {
	        Student student = mapper.readValue(request.getReader(), Student.class);

	        boolean status = StudentServiceFactory
	                .getStudentServiceInstance()
	                .saveStudent(student);

	        if (status) {
	            response.setStatus(HttpServletResponse.SC_CREATED);
	            mapper.writeValue(response.getWriter(), student);
	        } else {
	            response.setStatus(HttpServletResponse.SC_CONFLICT);

	            Map<String, String> error = new HashMap<>();
	            error.put("error", "Conflict");
	            error.put(
	                "message",
	                "Student with roll number " + student.getRno() + " already exists"
	            );

	            mapper.writeValue(response.getWriter(), error);
	        }

	    } catch (Exception e) {
	        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

	        Map<String, String> error = new HashMap<>();
	        error.put("error", "Bad Request");
	        error.put("message", "Invalid JSON or values");

	        mapper.writeValue(response.getWriter(), error);
	    }
	}

}
