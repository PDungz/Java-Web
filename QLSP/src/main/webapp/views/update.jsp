<%@page import="javax.xml.crypto.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String msp = request.getParameter("msp");
		String tensp = request.getParameter("tensp");
		String ngaynhap = request.getParameter("ngaynhap");
		String giatien = request.getParameter("giatien");
		String ghichu = request.getParameter("ghichu");
	%>
	<h1>Sửa sản phẩm</h1>
	<form action="/QLSP/views/update" method="get">
		Msp: <input type="text" name="msp" value="<%=msp %>"> <br>
		Tên sản phẩm: <input type="text" name="tensp" value="<%=tensp %>" required="required"> <br>
		
		<!-- Ep kieu du lieu string sang date -->
		<c:set var="dateString" value="<%=ngaynhap %>" />
		<fmt:parseDate value="${dateString}" pattern="yyyy-MM-dd" var="parsedDate" />
		<fmt:formatDate value="${parsedDate}" pattern="yyyy-MM-dd" var="formattedDate" />
		
		Ngay nhap: <input type="date" name="ngaynhap" value="${formattedDate}" required="required"> <br>
		Gia tien: <input type="text" name="giatien" value="<%=giatien %>" required="required"> <br>
		Ghi chu: <input type="text" name="ghichu" value="<%=ghichu %>"> <br> 
		<input type="submit" value="Sửa">
	</form>
	<a href="/QLSP/">Back qlsp</a>
</body>
</html>