    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Home</h1>
<sec:authorize access="!isAuthenticated()">
			
		            <li><a href="${pageContext.request.contextPath}/login"  >Login</a>
		            <li><a href="${pageContext.request.contextPath}/registration" >Register</a>   
		             <li><a href="${pageContext.request.contextPath}/admins" >Admin</a>       
		     </sec:authorize>
		    

		     
		     <sec:authorize access="isAuthenticated()">
		     		<sec:authentication property="principal.username" var="username"/>
	     			<li><a href="/user" style="color:#ffffff">${username}</a></li>

					<c:url var="logoutUrl" value="/logout" />
					<form:form action="${logoutUrl}" method="post" cssStyle="padding-top: 7px;">
						<li><input class="btn btn-danger" type="submit" value="logout" /></li>
					</form:form>
			</sec:authorize>
			
			 <a href="${pageContext.request.contextPath}/admins">Admin</a>  
			 <a href="${pageContext.request.contextPath}/moderator">Moderator</a>  
</body>
</html>