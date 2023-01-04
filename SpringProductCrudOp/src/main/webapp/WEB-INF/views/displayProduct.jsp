<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="3">
		<tr>
			<th>Pid</th>
			<th>Pname</th>
			<th>Qty</th>
			<th>Price</th>
		</tr>
		<c:forEach var="plist1" items="${plist}"> 
		<tr>
			<td>${ plist1.pid}</td>
			<td>${ plist1.pname}</td>
			<td>${ plist1.qty}</td>
			<td>${ plist1.price}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>