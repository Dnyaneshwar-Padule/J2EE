package com.tca.controller;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tca.entities.Student;
import com.tca.factory.StudentServiceFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/FetchAllStudents")
public class FetchAllStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		
		List<Student> students = StudentServiceFactory.getStudentServiceInstance().fetchStudents();
		
		if(students != null) {
			response.setStatus(HttpServletResponse.SC_OK);
			mapper.writeValue(response.getWriter(), students);
		}
		else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			mapper.writeValue(response.getWriter(), "Records not found !");
		}
	}

}
