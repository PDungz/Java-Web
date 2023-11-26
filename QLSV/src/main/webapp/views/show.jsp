<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="shadow">	
			<div class="bg-success pt-4 pb-4 mt-5">
				<h1 class="text-center text-light">DANH SÁCH SINH VIÊN</h1>
				<h1 class="text-center text-danger">${alert}</h1>
			</div>
			<div class="mt-3 mb-2 d-flex flex-row-reverse">
				<a class="btn btn-success mr-3 pr-5 pl-5 shadow" href="/QLSV/views/insert.jsp">Thêm</a>
			</div>
			<div class="p-3 border">
				<table border="1" class="table table-light table-striped border">
					<thead>
						<tr>
							<th>Mã sinh viên</th>
							<th>Họ và tên</th>
							<th>Ngày sinh</th>
							<th>Lớp</th>
							<th>Số điện thoại</th>
							<th>Địa chỉ</th>
							<th>Sửa</th>
							<th>Xóa</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="sinhvien" items="${sinhviens}">
							<tr>
								<td>${sinhvien.getMsv()}</td>
								<td>${sinhvien.getHoten()}</td>
								<td>${sinhvien.getNgaysinh()}</td>
								<td>${sinhvien.getLop()}</td>
								<td>${sinhvien.getSdt()}</td>
								<td>${sinhvien.getDiachi()}</td>
								<td><a href="/QLSV/views/update.jsp?msv=${sinhvien.getMsv()}&hoten=${sinhvien.getHoten()}&ngaysinh=${sinhvien.getNgaysinh()}&lop=${sinhvien.getLop()}&sdt=${sinhvien.getSdt()}&diachi=${sinhvien.getDiachi()}">Sửa</a></td>
								<td><a href="/QLSV/views/delete.jsp?msv=${sinhvien.getMsv()}&delete=delete">Xóa</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>