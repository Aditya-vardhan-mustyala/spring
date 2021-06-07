<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>

<html>
<body>
<h3>custom login</h3>

<form:form action="${pageContext.request.contextPath}/processlogin" method="POST">
<jstl:if test="${param.error != null }">
	<i style="color:red" >error exists: ${param.error} invalid credentials</i><br>
</jstl:if>
<jstl:if test="${param.logout != null }">
	<i style="color:green" >You just logged out</i><br>
</jstl:if>

user name:<input type="text" name="username"/><br>
password:<input type="password" name="password"/><br>

<input type="submit" value="login"/>

</form:form>
</body>
</html>