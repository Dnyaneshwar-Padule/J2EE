package com.tca.util;

import com.tca.entity.Dog;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SessionUtil {

	
	public static void addDogToSession(HttpServletRequest request, Dog dog) {
		HttpSession session = request.getSession(true);
		if(session != null)
			System.out.println("SessionUtil.addDogToSession()");
			session.setAttribute("dog", dog);
	}
	
	public static Dog getDogFromSession(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		
		if(session != null) {
			System.out.println("SessionUtil.getDogFromSession()");
			return (Dog)session.getAttribute("dog");
		}
		
		return null;
	}

	public static void removeDogFromSession(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		if(session != null) {
			System.out.println("SessionUtil.removeDogFromSession()");
			session.removeAttribute("dog");
			session.invalidate();
		}
		
	}
	
}
