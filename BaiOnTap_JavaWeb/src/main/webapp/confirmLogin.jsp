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
		// Lay du lieu duoc gui tu form dang nhap
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// Kiem tra
		if("admin".equals(username) && "123".equals(password)) {
			// Luu username bang cookie
				// Tao mot cookie
				Cookie cookie = new Cookie("username", username);
				
				// Gioi han thoi gian song cua no
				cookie.setMaxAge(100);
				
				// Gui no len trinh duyet de luu
				response.addCookie(cookie);
				
			// chuyen huong den trang success
				response.sendRedirect("successLogin.jsp");
		} else {
			// Luu username bang cookie
				// Tao mot cookie
				String thongbao = "Ten_dang_nhap_sai_hoac_mat_khau_sai";
				Cookie cookieE = new Cookie("thongbao1", thongbao);
				
				// Gioi han thoi gian song cua no
				cookieE.setMaxAge(100);
				
				// Gui no len trinh duyet de luu
				response.addCookie(cookieE);
			
			// chuyen huong den trang success
				response.sendRedirect("formLogin.jsp");
		}
	%>
</body>
</html>