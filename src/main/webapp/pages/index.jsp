<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
String context = request.getContextPath(); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehicle Rental</title>
 <link rel="stylesheet" href="./pages/index.css">
 <link rel="stylesheet" href="./index.css">
</head>
<body>


<div class="background-image">
	<div class="content">
	<h1>Welcome to Vehicle Rental</h1>
	<div>
	<a class="bt1" href="<%=context%>\pages\AdminLogin.jsp">Admin</a>
	<a class="bt2" href="<%=context%>\pages\UserLogin.jsp">Customer</a>
	</div>
	</div>
 </div>
</body>
</html>

 