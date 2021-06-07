<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<style>
.showerror
{color:red}
</style>
</head>
<body>
<form:form action="formvalid" modelAttribute="customer">
first name:<form:input path="firstName"/>
<br>
last name:<form:input path="lastName"/><form:errors path="lastName" cssClass="showerror"/>
<br>
address: <form:input path="address"/>
<form:errors path="address" cssClass="showerror"/>
<br>
<input type="submit"/>
</form:form>
</body>
</html>