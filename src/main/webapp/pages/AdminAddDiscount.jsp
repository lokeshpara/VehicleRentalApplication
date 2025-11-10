<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Discount</title>
<link rel="stylesheet" href="./AdminAddCustomer.css">

</head>
<body>
<div class="Adduser-form">
<h1 align="center">Add Discount</h1>
<form action="AdminProcess.do" methos="post">
<input type="hidden" name="Name" value="${requestScope.Name}" >
	<p>No of days</p>
	<input type="number" name="days">
	<p>No of vehicles</p>
	<input type="number" name="no_of_vehicles">
	<p>Discount</p>
	<input type="number" name="discount">

	<input type="submit" class="bt1" name="action" value="Add Discount">
</form>
</div>
</body>
</html>