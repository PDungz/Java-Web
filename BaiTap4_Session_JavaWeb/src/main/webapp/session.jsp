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
		out.print(session.getAttribute("username"));
	%>
	<form action="setSession.jsp" method="post">
		UserName: <input type="text" name="username"> <br>
		PassWord: <input type="password" name="password"> <br>
		<input type="submit" value="Đăng nhập">
	</form>
</body>
</html>