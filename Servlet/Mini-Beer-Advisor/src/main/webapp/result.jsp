<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Beer Advice</title>
</head>
<body>
	<h1 align="center">Beer Recommendation JSP</h1>
	<p>
	<%
		List<String> styles = (List)request.getAttribute("recommendations");
		for(String brand : styles){
			out.println("<br> try : " + brand);
		}
	%>
	
	<h3>Good luck !</h3>
	
</body>
</html>