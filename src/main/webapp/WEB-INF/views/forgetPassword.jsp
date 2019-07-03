<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Insert Password</h1>

<form:form method="POST" action="/forget_password" modelAttribute="checkEmail">
						
						<form:errors path="*" cssClass="error"/>
			
							<form:input path="email"  title="Email" />
						<br>
			
							<input type="submit" value="Find Email" />
                         </form:form>

                         </body>
                         </html>