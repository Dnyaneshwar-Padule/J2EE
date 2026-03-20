package com.tca.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.tca.service.CaesarCipherService;

@WebServlet("/caesarCipher")
public class CaesarCipherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CaesarCipherService service = new CaesarCipherService();
			String message = request.getParameter("message");			
			int shift = Integer.parseInt( request.getParameter("shift") );
			String caesarCipherText = service.convertText(message, shift);
			request.setAttribute("cipherText", caesarCipherText);
			request.getRequestDispatcher("./").forward(request, response);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			request.getRequestDispatcher("./").forward(request, response);
		}
	}

}
