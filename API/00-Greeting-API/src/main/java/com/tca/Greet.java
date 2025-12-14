package com.tca;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet({ "/Greet", "/greet/*" })
public class Greet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setStatus(200);  //OK
		
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Hello User, How are you !");
		map.put("secret", "Is there any secret !");
	
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(response.getWriter(), map);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		HashMap<String, String> map = new HashMap<>();
		String user = request.getPathInfo();
		
		String message = null;
		String secret = "asfjr3rakabskwvbkqw";
		
		ObjectMapper mapper = new ObjectMapper();
		
		if(user == null || user.length() <= 1) {
			message = "User name is missing !";
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		else {
			response.setStatus(HttpServletResponse.SC_OK);
			message = "Hello " + user.substring(1) + ", all good ?";
			map.put("secret", secret);
		}

		map.put("message", message);
		mapper.writeValue(response.getOutputStream(), map);
	}

}
