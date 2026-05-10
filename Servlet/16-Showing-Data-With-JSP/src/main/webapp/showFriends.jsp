<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Friends !</title>
</head>
<body>

	

	<%
		String[] myFriends = request.getParameterValues("myFriend");
		int len;
		
		if(myFriends != null)
			len = myFriends.length;
		else
			len = 0;
		
		String msg = null;
		
		if(len == 0)
		{ 
			msg = "You are going alone !!!";
		}
		else if(len < 6)
		{
			msg = "You have got someone's company !!!!";
		}
		else
		{
			msg = "You've got everybody with you !";
		}
	%>

	<p><%= msg %></p>


</body>
</html>