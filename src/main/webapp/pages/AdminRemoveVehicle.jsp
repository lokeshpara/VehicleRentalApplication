<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change vehicle active Status</title>
</head>
<body>
<form action="AdminProcess.do" method="post">
	<label><c:if test="${requestScope.Err!=null}">
		<font color="red">${requestScope.Err}</font>
	</c:if></label>
	<label>Vehicle Name</label>
	<input type="text" name="vehicleName">
	<br><br>
	<label>Vehicle Type</label>
        <select name="vehicleType" >
  			<option value="Car">Car</option>
  			<option value="Bike">Bike</option>
  			<option value="Bus">Bus</option>
		</select>
	<br><br>
	<label><c:if test="${requestScope.Err!=null}">
		<font color="red">${requestScope.Err}</font>
	</c:if></label>
	<label>Vehicle Register Number</label>
    <input type="tel" name="vehicleRegNo" placeHolder="KA-01A-1234" pattern="[A-Za-z]{2}-[0-9]{2}[A-Za-z]{1,2}-[0-9]{4}" required>
	<br><br>
	<input type="submit" name="action" value="Remove Vehicle">
</body>
</html>