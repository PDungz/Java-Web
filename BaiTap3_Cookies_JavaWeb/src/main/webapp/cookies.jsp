<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("username")) {
					out.print(cookie.getName() + "  ");
					out.print(cookie.getValue());
				}
			}
			
		}
	%>
	<form action="setCookies.jsp" method="post">
		UserName: <input type="text" name="username"> <br>
		PassWord: <input type="password" name="password"> <br>
		<input type="submit" value="Đăng nhập">
	</form>
</body>
</html>