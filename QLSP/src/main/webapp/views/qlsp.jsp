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
	<h1>${thongbao}</h1> 
	<!-- Tim kiem -->
	<form action="/QLSP/views/search" method="get">
		<input type="text" name="search">
		<input type="submit" value="Tìm kiếm">
	</form>
	<!-- Chuyen huong den trang them -->
	<a href="/QLSP/views/insert.jsp">Thêm</a>
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
			<c:forEach var="sanpham" items="${sanphamList}">
				<tr>
					<td>${sanpham.getMsp()}</td>
					<td>${sanpham.getTensp()}</td>
					<td>${sanpham.getNgaynhap()}</td>
					<td>${sanpham.getGiatien()}</td>
					<td>${sanpham.getGhichu()}</td>
					<!-- Chuyen huong den trang sua -->
					<td><a href="/QLSP/views/update.jsp?msp=${sanpham.getMsp()}&tensp=${sanpham.getTensp()}&ngaynhap=${sanpham.getNgaynhap()}&
					giatien=${sanpham.getGiatien()}&ghichu=${sanpham.getGhichu()}">Sửa</a></td>
					<!-- Chuyen huong den trang xoa -->
					<td><a href="/QLSP/views/delete.jsp?msp=${sanpham.getMsp()}">Xóa</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>