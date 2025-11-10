<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<h2 align="center">Register</h2>



<form action="register.do">     


<table>
	<tr>
		<td colspan="2"><c:if test="${requestScope.Err!=null}">
			<font color="red">${requestScope.Err}</font>
		</c:if></td>
	</tr>
	<tr>
		<td>Portal id</td>
		<td><input type="text" name="portal_id"></td>
	</tr>
	<tr>
		<td>Name</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>Employee Id</td>
		<td><input type="text" name="emp_id"></td>
	</tr>
	<tr>
		<td>Technology</td>
		<td><select name="tech">
			<option value="Java">Java</option>
			<option value=".Net">.Net</option>
			<option value="MF">Mainframe</option>
		</select></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit"
			value="Register"></td>
	</tr>
</table>
</form>
</body>
</html>