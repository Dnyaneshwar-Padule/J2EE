package com.tca.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.tca.model.BeerExpert;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SelectBeer")
public class BeerSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String color = request.getParameter("color");
		
		if(color.isBlank()) {
			out.print("Please provide valid input !");
		}
		else {
			BeerExpert expert = new BeerExpert();
			List<String> recommendation = expert.getBrands(color);
			request.setAttribute("recommendations", recommendation);
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

}
