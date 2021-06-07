<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gamazon</title>
</head>
<body>

	<h2>Hello</h2>
	<security:authorize access="isAuthenticated()">
	<h3> user <security:authentication property="principal.username"/><br>
	Having roles: <security:authentication property="principal.authorities"/></h3>
	</security:authorize>

	<h3>Welcome to gamazon</h3>
	<a href="${pageContext.request.contextPath}/products">view products</a>




<security:authorize access="isAuthenticated()">
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="Logout"/>
</form:form>
</security:authorize>


<security:authorize access="!isAuthenticated()">
<form:form action="${pageContext.request.contextPath}/customLogin" method="GET">
<input type="submit" value="Login"/>
</form:form>
</security:authorize>



</p>
</body>
</html>
