<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<body>
	<%
	String msv = request.getParameter("msv");	
	%>
	<div class="container">
		<div class="mt-5 w-50 ml-auto mr-auto shadow rounded">
			<div class="bg-success pt-3 pb-3 rounded">
				<h1 class="text-center">Xóa sinh viên</h1>
			</div>
			<form action="/QLSV/views/delete" method="get"
				class="p-3" novalidate>
				<div class="form-group">
					<input type="text" name="msv" value="<%=msv%>"
						class="form-control">
				</div>
				<button type="submit" class="btn btn-block btn-success">Xóa</button>
				<a href="/QLSV/sinhvienController" class="btn btn-block btn-danger">Hủy</a>
			</form>
		</div>
	</div>
</body>
</html>