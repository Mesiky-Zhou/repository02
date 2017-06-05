<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<center>
		<h1>User List</h1>
		<table border="0">
			<c:forEach var="user" items="${users}" varStatus="status">
				<tr>
			         <td>${user.id}</td>
			         <td>${user.username}</td>
			         <td>${user.password}</td>
			         <td>${user.created}</td>
			     </tr>
			</c:forEach> 
		</table>
	</center>

</body>
</html>