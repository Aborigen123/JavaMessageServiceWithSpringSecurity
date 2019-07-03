<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Reset Password</h1>
<form:form method="POST" action="${pageContext.request.contextPath}/reset_password/${id}" modelAttribute="resetPasswordForm">
						
						<form:errors path="*" cssClass="error"/>
						
						
					
				
			
				<%-- 	<form:hidden path = "id" value="${id}"/>  --%>
							<label><span>1. </span><strong>Password:</strong></label>
						<form:input path="password"  title="Password" />
						<br>
						
					
							<label><span>2. </span><strong>Password Confirmation:</strong></label>
							<form:input path="passwordConfirmation"  title="Password Confirmation" />
						<br>
						
						
						<input type="submit"  value="Change Password" />
                         </form:form>
</body>
</html>