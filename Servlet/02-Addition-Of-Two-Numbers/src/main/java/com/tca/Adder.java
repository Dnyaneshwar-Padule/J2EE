package com.tca;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Adder extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Provide numbers from the form ! </h1>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			int firstNumber = Integer.parseInt( request.getParameter("firstNumber") ); 
			int secondNumber = Integer.parseInt( request.getParameter("secondNumber") );
			int sum = firstNumber + secondNumber;
			
			out.println("<h2>Sum of " +  firstNumber + " and " +  secondNumber + " is " + sum  + "</h2>");
			
		}
		catch(NumberFormatException e) {
			out.println("Please enter valid integer numbers !");
		}
		catch(Exception e) {
			out.println("Something went wrong !");
		}
		
		out.close();
	}

}
