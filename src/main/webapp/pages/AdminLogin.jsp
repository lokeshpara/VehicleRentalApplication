<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="./AdminLogin.css">
</head>
<body>
<%
String context = request.getContextPath();
%>

<section>
	<div class="form-container">
		<h1>Login</h1>	
		<form action="AdminProcess.do" method="post">  
			<div class="control">
				<label for="admin_userName">Name</label>
				<input type="text" name="admin_userName">
			</div>
			
			<div class="control">
				<label for="admin_password">Password</label>
				<input type="password" name="admin_password">
			</div>
			
			<div class="control">
				<input class="bt1" type="submit" name="action" value="Login">
			</div>
			
			
			<table>
				<tr>
				<td colspan="2">
					<c:if test="${requestScope.Err!=null}">
					<font>${requestScope.Err}</font>
					</c:if></td>
				</tr>
			</table>
		</form>
	</div>
</section>
</body>
</html>