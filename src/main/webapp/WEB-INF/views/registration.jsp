<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Registration</h1>
<form:form method="POST" action="/registration" modelAttribute="registerModel">
						
						<form:errors path="*" cssClass="error"/>
						
						
						
							<label><span>1. </span><strong>Name User:</strong></label>
							<form:input path="nameCustomer"  title="Name User" />
						<br>
					
							<label><span>2. </span><strong>Email:</strong></label>
							<form:input path="email"  title="Email" />
						<br>
						
						
							<label><span>3. </span><strong>Password:</strong></label>
							<form:password path="password"  title="Password" />
						<br>
						
					
							<label><span>4. </span><strong>Password Confirmation:</strong></label>
							<form:password path="passwordConfirmation"  title="Password Confirmation" />
						<br>
						
						
						
						<div class="offers">
						<input type="submit" class="all" value="Register" />
						</div>
                         </form:form>
						
</body>
</html>