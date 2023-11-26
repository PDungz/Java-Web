<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
</head>
</head>
<body>
	<%
	String msv = request.getParameter("msv");
	String hoten = request.getParameter("hoten");
	String ngaysinh = request.getParameter("ngaysinh");
	String lop = request.getParameter("lop");
	String sdt = request.getParameter("sdt");
	String diachi = request.getParameter("diachi");
	
	
	%>
	<div class="container">
		<div class="mt-5 w-50 ml-auto mr-auto shadow rounded">
			<div class="bg-success pt-3 pb-3 rounded">
				<h1 class="text-center">Sửa thông tin sinh viên</h1>
			</div>
			<form action="/QLSV/views/update" method="get"
				class="needs-validation p-3" novalidate>
				<div class="form-group">
					<input type="text" name="msv" value="<%=msv%>"
						class="form-control">
				</div>
				<div class="form-group">
					<label for="hoten">Họ và tên:</label> 
					<input type="text" class="form-control" id="hoten" placeholder="Họ và tên" value="<%=hoten%>" name="hoten" required>
					<div class="invalid-feedback">Nhập họ và tên.</div>
				</div>
				<div class="form-group">
					<c:set var="dateString" value="<%=ngaysinh %>" />
					<!-- Doi kieu du lieu -->
					<fmt:parseDate value="${dateString}" pattern="yyyy-MM-dd HH:mm:ss" var="parsedDate" />
					<fmt:formatDate value="${parsedDate}" pattern="yyyy-MM-dd" var="formattedDate" />
					<label for="ngaysinh">Ngày sinh:</label> 
					<input type="date" value="${formattedDate}" class="form-control" id="ngaysinh" name="ngaysinh" required>
					<div class="invalid-feedback">Chọn này sinh.</div>
				</div>
				<div class="form-group">
					<label for="lop">Lớp:</label> 
					<input type="text" class="form-control" id="lop" placeholder="Nhập lớp" name="lop" value="<%=lop%>" required>
					<div class="invalid-feedback">Nhập lớp.</div>
				</div>
				<div class="form-group">
					<label for="sdt">Số điện thoại:</label> 
					<input type="text" class="form-control" id="sdt" placeholder="Nhập số điện thoại" value="<%=sdt%>" name="sdt" required>
					<div class="invalid-feedback">Nhập số điện thoại.</div>
				</div>
				<div class="form-group">
					<label for="diachi">Địa chỉ:</label> 
					<input type="text" class="form-control" id="diachi" placeholder="Nhập địa chỉ nơi ở" value="<%=diachi%>" name="diachi" required>
					<div class="invalid-feedback">Nhập địa chỉ.</div>
				</div>
				<button type="submit" class="btn btn-block btn-success">Sửa</button>
				<a href="/QLSV/sinhvienController" class="btn btn-block btn-danger">Hủy</a>
			</form>
		</div>
	</div>


	<script>
		// Disable form submissions if there are invalid fields
		(function() {
			'use strict';
			window.addEventListener('load',
					function() {
						// Get the forms we want to add validation styles to
						var forms = document
								.getElementsByClassName('needs-validation');
						// Loop over them and prevent submission
						var validation = Array.prototype.filter.call(forms,
								function(form) {
									form.addEventListener('submit', function(
											event) {
										if (form.checkValidity() === false) {
											event.preventDefault();
											event.stopPropagation();
										}
										form.classList.add('was-validated');
									}, false);
								});
					}, false);
		})();
	</script>
</body>
</html>