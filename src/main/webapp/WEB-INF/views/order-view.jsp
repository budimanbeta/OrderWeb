<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>


<form:form  action="order-submit" method="post">
<h1>FORM ORDER</h1>
<hr><br>
<h3>PRODUCT ITEM</h3>
<table border="1" cellpadding="5px" width="20%">
	<tr>
		<th>NAME</th>
		<th>PRICE</th>
		<th>QTY</th>
		<th>TOTAL</th>
	</tr>
	<c:forEach items="${cart.orderItemsDto}" var="item">
	<tr>
		<td>
			<input type="hidden" name="id" value="<c:out value="${item.id}"></c:out>" />
			<c:out value="${item.name}"></c:out>
		</td>
		<td><c:out value="${item.price}"></c:out></td>
		<td>
			<input type="hidden" name="quantity" value="<c:out value="${item.quantity}"></c:out>" />
			<c:out value="${item.quantity}"></c:out>
		</td>
		<td><c:out value="${item.totalPrice}"></c:out></td>
	</tr>
	</c:forEach>
	<tr>
		<td>Total</td>
		<td></td>
		<td></td>
		<td><c:out value="${cart.totalPrice}"></c:out></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td>
			<a href="choose-product"><input type="button" name="add" id="add" value="ADD PRODUCT"></a>
		</td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td>
		<p align="center">
			<input type="submit" value="PROCESS">
		</p>
		</td>
		<td></td>
	</tr>
</table>
	
</form:form>

</body>
</html>