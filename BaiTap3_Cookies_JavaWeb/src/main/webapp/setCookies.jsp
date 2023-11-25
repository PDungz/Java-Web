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
		
		// Set cookies
		Cookie cookie = new Cookie("username", username);
		
		// Dat thoi  gian ton tai cho cookie
		cookie.setMaxAge(1000);
		
		// Gui cookie len trinh quyet
		response.addCookie(cookie);
		response.sendRedirect("cookies.jsp");
		
	%>
</body>
</html>