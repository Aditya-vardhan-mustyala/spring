<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>


<html>
<body>


<h3>welcome to spring security</h3>
<hr>
Hello 
user :<security:authentication property="principal.username"/><br>
role :<security:authentication property="principal.authorities"/><br>


<security:authorize access="hasRole('TEACHER')">
<a href="${pageContext.request.contextPath}/teachers">only for teachers</a><br>
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
<a href="${pageContext.request.contextPath}/admins">only for admins</a><br>
</security:authorize>

<form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="logout"/>
</form:form>


</body>
</html>