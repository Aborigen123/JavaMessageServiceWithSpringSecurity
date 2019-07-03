<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Email address ${userEmail} successfully verified.
<br>
<h1> Please authorization</h1>
<br>
<a href="${pageContext.request.contextPath}/login">Login</a>
</body>
</html>