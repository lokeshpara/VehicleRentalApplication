<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="./Adminhome.css">

</head>
<body>
<%
String context = request.getContextPath();
%>
<div class="container">

<form action="AdminProcess.do" method="post">
	<input type="hidden" name="Name" value="${requestScope.Name}" >
	<div class="navbar">
	<img src="./images/logo.png" class="logo">
	<nav>
	  <ul>
		<li><input type="submit" name="action"  value="Customer Details"></li>
		<li><input type="submit" name="action" value="Vehicles Details"></li>
		<li><input type="submit" name="action" value="Booking Details"></li>
		<li><input type="submit" name="action" value="Discounts"></li>
		<li><input type="submit" name="action"  value="Feedbacks"></li>
		<li><input type="submit" name="action"  value="Log Out"></li>
	   </ul>
	</nav>	
	<label><c:if test="${requestScope.Err!=null}">
		<font color="red">${requestScope.Err}</font>
	</c:if></label>
	</div>	
	
	<div class="content" >
		<h1>HELLO ADMIN</h1>
		<p>${requestScope.Name}</p>
	</div>
</form>
</div>
</body>
</html>