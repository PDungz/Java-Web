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
		String msp = request.getParameter("msp");
	%>
	<h1>Xoa sản phẩm</h1>
	<form action="/QLSP/views/delete" method="get">
		Msp: <input type="text" name="msp" value="<%=msp%>"> <br>
		<input type="submit" value="Xóa">
	</form>
	<a href="/QLSP/">Back qlsp</a>
</body>
</html>