<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify to available</title>
<link rel="stylesheet" href="./AdminAddCustomer.css">

</head>
<body>
<div class="Adduser-form">
<h1>Modify Vehicle Status</h1>

<form action="AdminProcess.do" method="post">
	<input type="hidden" name="Name" value="${requestScope.Name}" >
	<p>Vehicle ID:</p>
	<input type="number" name="vehicleID" placeHolder="vehicleID">
	<input type="submit" class="bt1" name="action" value="Modify Available">
	<label><c:if test="${requestScope.Err!=null}">
		<font color="red">${requestScope.Err}</font>
	</c:if></label>
</form>
</div>
</body>
</html>