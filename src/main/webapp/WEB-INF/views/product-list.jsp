<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TOKOKU</title>
</head>
<body>
<center>
<h1>PRODUCT LIST</h1>
<hr>
<br>
<a href="formProduct"><input type="button" value="ADD BUTTON"></a>
<br><br>
<table border="1">
	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>TYPE</th>
		<th>PRICE</th>
	</tr>
	<c:forEach items="${listProduct}" var="p">
		<tr>	
			<td><c:out value="${p.id}"></c:out></td>
			<td><c:out value="${p.name}"></c:out></td>
			<td><c:out value="${p.type}"></c:out></td>
			<td><c:out value="${p.price}"></c:out></td>		
		</tr>
	</c:forEach>
</table>

</center>
</body>
</html>