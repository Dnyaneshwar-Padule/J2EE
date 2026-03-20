package com.tca.controller;

import java.io.IOException;
import java.util.List;

import com.tca.service.CaesarCipherService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/decryptCaesarCipher")
public class DecryptCaesarCipherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CaesarCipherService caesarCipherService = new CaesarCipherService();
			String cipherText = request.getParameter("cipherMessage");			
			List<String> possibilities = caesarCipherService.convertToPlainText(cipherText);
			request.setAttribute("possibilities", possibilities);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		request.getRequestDispatcher("./").forward(request, response);
	}

}
