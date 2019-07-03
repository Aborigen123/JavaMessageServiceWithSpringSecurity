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
	<form:form method="POST" action="/login" modelAttribute="loginModel">
						
						<form:errors path="*" cssClass="error"/>
						
						
					
					
							<label><span>1. </span><strong>Phone number:</strong></label>
							<form:input path="email"  class="txb large" title="Email" />
						<br>
						
						
							<label><span>2. </span><strong>Password:</strong></label>
							<form:password path="password" class="txb large" title="Password" />
						<br>
						
						
						<input type="submit" class="all" value="Login" />
                         </form:form>
                       <a href="${pageContext.request.contextPath}/forget_password">Forget Password</a>
</body>
</html>