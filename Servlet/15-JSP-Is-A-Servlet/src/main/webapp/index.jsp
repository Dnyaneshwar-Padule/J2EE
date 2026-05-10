<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.tca.util.Counter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World !</title>
</head>
<body>

	<%
		System.out.println("Hello World !");
		Integer count = Counter.getCount();
		System.out.println("Current Count : " + count);
	%>

	<p>Current Count : <%=count%></p>

</body>
</html>
