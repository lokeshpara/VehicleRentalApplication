<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
<link rel="stylesheet" href="./AdminAddCustomer.css">

</head>
<body>
<div class="Adduser-form">
<h1 align="center">Add Customer</h1>
<form action="AdminProcess.do" method="post">
	<input type="hidden" name="Name" value="${requestScope.Name}" >
	<p>User Name:</p>
	<input type="text" name="userName" placeHolder="User name">
	<p>Password:</p>
	<input type="text" name="password" placeHolder="Password">
	<p>City</p>
        <select name="city" >
  			<option value="Bangalore">Bangalore</option>
  			<option value="Hyderabad">Hyderabad</option>
  			<option value="chennai">chennai</option>
  			<option value="Noida">Noida</option>
		</select>
	<p>Email:<p>
    <input type="email" id="email" name="email" placeHolder="Email">
	<p>Phone Number:<p>
	<input type="tel" name="phoneNumber" placeHolder="Enter 10 Digit Number" pattern="[0-9]{10}" required><br><br>
	
	<input type="submit" class="bt1" name="action" value="Add User">
	<label><c:if test="${requestScope.Err!=null}">
		<font color="red">${requestScope.Err}</font>
	</c:if></label>
</form>
</div>
</body>
</html>