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
		<!-- Cu phap hien thi -->
		${i}
		<!-- Vong lap  -->
		<c:forEach var="i" begin="1" end="5">
        	   Item ${i}
        </c:forEach>
        <!-- Cau dieu kien -->
        <c:if test="Kiem tra">
    			<!-- Thực hiện khi điều kiện đúng -->
		</c:if>
</body>
</html>