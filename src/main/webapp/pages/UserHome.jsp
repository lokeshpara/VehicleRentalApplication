<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="./Adminhome.css">

</head>
<body>
<%
String context = request.getContextPath();
%>
<div class="container">
<form action="UserProcess.do" method="post">
	
	<div class="navbar">
	<img src="./images/logo.png" class="logo">
	<nav>
	  <ul>
	  	<li><input type="hidden" name="userName" value="${requestScope.details}" ></li>
		<li><input type="submit" name="action" value="Book Vehicle"></li>
	
		<li><input type="submit" name="action" value="Discounts"></li>
	
		<li><input type="submit" name="action" value="Booking Details"></li>
	
		<li><input type="submit" name="action" value="Log Out"></li>
	  </ul>
	 </nav>
	<label><c:if test="${requestScope.Err!=null}">
		<font color="red">${requestScope.Err}</font>
	</c:if></label>
	</div>	
	
	<div class="content" >
		<h1>HELLO CUSTOMER</h1>
		<p>${requestScope.details}</p>
	</div>
</form>
</div>
</body>
</html>