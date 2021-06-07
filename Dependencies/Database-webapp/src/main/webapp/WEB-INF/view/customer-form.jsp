<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<title>add customer</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

</head>
<body>
<div id="wrapper">
	<div id="header">
		<h2>Enter Details</h2>
	</div>
	
	<div id="customer">
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			
			<form:hidden path="id"/>
			<table>
			<tbody>
				<tr>
				<td><label>First name: </label></td>
				<td><form:input path="firstName"/></td>
				</tr>
				<tr>
				<td><label>Last name: </label>
				<td><form:input path="lastName"/></td>
				</tr>
				<tr>
				<td><label>email: </label></td>
				<td><form:input path="email"/></td>
				</tr>
				<tr>
				<td><label></label></td>
				<td><input type="submit" class="save" value="ADD"></td>
				</tr>
			</tbody>
			</table>
			
		</form:form>
		
		<div style="clear;both;"></div>
		<a href="${pageContext.request.contextPath}/customer/list">Go back</a>
	</div>
</div>

</body></html>