<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		// Lay du lieu cua form gui qua
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	%>
	<!-- Hien thi gia tri form  -->
	<h1><%= username %></h1>
	<h1><%= password %></h1>
</body>
</html>