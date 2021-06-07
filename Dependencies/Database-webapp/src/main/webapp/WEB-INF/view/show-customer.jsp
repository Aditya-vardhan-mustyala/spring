<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>
CRM
</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
	<div id="header">
		<h2>CRM-Customer Relationship Manager</h2>
	</div>
	
	<div id="container">
		<div id="content">
		
			<input type="button" value="add customer" class="add-button" onclick="window.location.href='showformtoadd';return false;"/>
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="customer" items="${customers}">
					<c:url var="updateurl" value="/customer/showformtoupdate">
						<c:param name="customerId" value="${customer.id}"/>
					</c:url>
					<c:url var="deleteurl" value="/customer/deletecustomer">
						<c:param name="customerId" value="${customer.id}"/>
					</c:url>
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td><a href="${updateurl}">update</a>|<a href="${deleteurl}" onclick="if (!confirm('confirm delete?')) return false">delete</a></td>
					</tr>
				</c:forEach>
			
			</table>
		
		</div>
	
	</div>

</div>

</body></html>