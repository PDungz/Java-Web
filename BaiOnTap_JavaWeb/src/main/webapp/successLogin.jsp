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
		String username = "";
		// Lay cookie tu trinh duyet 
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("username")) {
					username = cookie.getValue();					
				}
			}
		}
	%>
	<h1>Dang nhap thanh cong</h1>
	<h1>Chao mung ban <%=username %></h1>
</body>
</html>