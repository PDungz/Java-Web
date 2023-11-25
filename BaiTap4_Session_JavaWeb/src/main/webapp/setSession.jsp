<%@page import="javax.websocket.Session"%>
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
		String username = request.getParameter("username");
		session.setAttribute("username", username);
		session.setMaxInactiveInterval(5);
		response.sendRedirect("session.jsp");
	%>
</body>
</html>