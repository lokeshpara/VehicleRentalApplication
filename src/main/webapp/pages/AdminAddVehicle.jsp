<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Vehicle</title>
<link rel="stylesheet" href="./AdminAddVehicle.css">
</head>
<body>
<div class="Adduser-form">
<h1 align="center">Add Vehicle</h1>
<form action="AdminProcess.do" method="post">
	<input type="hidden" name="Name" value="${requestScope.Name}" >
	<p>Vehicle Name:</p>
	<input type="text" name="vehicleName">
	
	<p>Vehicle Type:</p>
        <select name="vehicleType" >
  			<option value="Car">Car</option>
  			<option value="Bike">Bike</option>
  			<option value="Bus">Bus</option>
		</select>
	<p>Vehicle Register Number:</p>
    <input type="tel" name="vehicleRegNo" placeHolder="KA-01A-1234" pattern="[A-Za-z]{2}-[0-9]{2}[A-Za-z]{1,2}-[0-9]{4}" required>
	<p>Vehicle Price</p>
	<input type="text" name="price"><br><br>
	<input type="submit" name="action" value="Add Vehicle">
	<label><c:if test="${requestScope.Err!=null}">
		<font color="red">${requestScope.Err}</font>
	</c:if></label>
</form>
</div>
</body>
</html>