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
		// Xu ly form
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if("admin".equals(username) && "123".equals(password)) {
			//out.print("Dang nhap thanh cong");
			response.sendRedirect("successLoign.jsp");
		} else {
			//out.print("Dang nhap that bai");
			response.sendError(404);
		}
	%>
	
</body>
</html>