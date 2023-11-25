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
		if(request.getParameter("chieudai") != null && request.getParameter("chieurong") != null) {
			if(request.getParameter("chieudai") != "" && request.getParameter("chieurong") != "") {
				double chieudai = Double.parseDouble(request.getParameter("chieudai"));
				double chieurong = Double.parseDouble(request.getParameter("chieurong"));
				
				double dientich = chieudai * chieudai;
				out.print(dientich);						
			} else {
				out.print("Yeu cau nhap chieu dai va chieu rong");
			}
		}
	%>
	<form action="" method="get">
		Chieu dai: <input type="text" name="chieudai">  <br>
		Chieu rong: <input type="text" name="chieurong"> <br>
		<input type="submit"  value="Tinh dien tich HCN">
	</form>
</body>
</html>