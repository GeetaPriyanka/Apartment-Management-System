<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Persons</title>
</head>
<body>
<h3>Persons List</h3>
<c:if test="${!empty listUsers}">
	<table border="1">
		<tr>
			<th width="80">First Name</th>
			<th width="120">Last Name</th>
			<th width="120">Unit</th>
		</tr>
		<c:forEach items="${listUsers}" var="user">
			<tr>
				<td>${user.firstname}</td>
				<td>${user.lastname}</td>
				<td>${user.unit}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>