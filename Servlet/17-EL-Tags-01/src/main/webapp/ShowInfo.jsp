<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Info</title>
</head>
<body>

	<jsp:useBean id="person" class="com.tca.entity.Person" scope="request">
		<jsp:setProperty name="person" property="name" value="NA"/>
		<jsp:setProperty name="person" property="age" value="0"/>
	</jsp:useBean>
	
	Name : <jsp:getProperty name="person" property="name"/>
	Age : <jsp:getProperty name="person" property="age"/>

</body>
</html>