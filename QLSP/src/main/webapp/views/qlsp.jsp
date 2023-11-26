<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Quản lý sản phẩm</h1>
	<!-- Tim kiem -->
	<form action="" method="get">
		<input type="text" name="search">
		<input type="submit" value="Tìm kiếm">
	</form>
	<!-- Chuyen huong den trang them -->
	<a href="insert.jsp">Thêm</a>
	<!-- Hien thi danh sach san pham -->
	<table border="1">
		<thead>
			<tr>
				<th>MSP</th>
				<th>Tên sản phẩm</th>
				<th>Ngày nhập</th>
				<th>Giá tiền</th>
				<th>Ghi chú</th>
				<th>Sửa</th>
				<th>Xóa</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="i" items="1, 2, 3, 4, 5">
				<tr>
					<td>${i}</td>
					<td>San pham${i}</td>
					<td> Ngay ${i}</td>
					<td>12 ${i}</td>
					<td>jkasl${i}</td>
					<!-- Chuyen huong den trang sua -->
					<td><a href="update.jsp">Sửa</a></td>
					<!-- Chuyen huong den trang xoa -->
					<td><a href="delete.jsp">Xóa</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>