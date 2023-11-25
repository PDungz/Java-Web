<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="confirmLogin.jsp" method="get">
		UserName: <input type="text" name="username"> <br>
		PassWord: <input type="password" name="password"> <br>
		<input type="submit" value="Đăng nhập">
	</form>
	
	<!-- Lay cookie co chua thong bao  -->
	<%
		String thongbao = "";
		// Lay cookie tu trinh duyet 
		Cookie[] cookies = request.getCookies();
		
		// Lay cookie
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("thongbao1")) {
					thongbao = cookie.getValue();					
				}
			}
		}
		out.print(thongbao);
	%>
</body>
</html>