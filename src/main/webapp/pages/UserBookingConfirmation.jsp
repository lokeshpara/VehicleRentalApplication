

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Booking Confirmation</title>
<link rel="stylesheet" href="./AllUserDetails.css">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<body>
<%
String context = request.getContextPath();
%>
<div class="content">
<h1>Booking Details</h1>
</div>
<table class="content-table">
  <thead>
    <tr>
      <th scope="col">Customer Name</th>
      <th scope="col">Vehicle Name</th>
      <th scope="col">Purchased Date</th>
      <th scope="col">No of Days</th>
      <th scope="col">quantity</th>
      <th scope="col">Booking Price</th>
    </tr>
  </thead>
  <tbody>

    <tr>
      <td>${requestScope.bookingList.getUserName()}</td>
      <td>${requestScope.bookingList.getVehicleName()}</td>
      <td>${requestScope.bookingList.getPurchasedDate()}</td>
      <td>${requestScope.bookingList.getNo_of_Days()}</td>
      <td>${requestScope.bookingList.getQuantity()}</td>
      <td>${requestScope.bookingList.getBookedPrice()}</td>
    </tr>
  </tbody>
</table>
<div class="links">
<form action="UserProcess.do" method="post">
	<input type="hidden" name="userName" value="${requestScope.details}" >
	<input type="hidden" name="vehicleID" value="${requestScope.detail}" >
	<input type="hidden" name="bookingDate" value="${requestScope.bookingList.getPurchasedDate()}" >
	<input type="hidden" name="no_of_days" value="${requestScope.bookingList.getNo_of_Days()}" >
	<input type="hidden" name="quantity" value="${requestScope.bookingList.getQuantity()}" >
	<input type="hidden" name="bookingPrice" value="${requestScope.bookingList.getBookedPrice()}" >
	<input type="submit" name="action" class="box" value="Confirm Booking">
	<input type="submit" name="action" class="box" value="Home">
</form>
</div>
<font color="green" size="3px" style="
    font-family: serif;
    font-weight: bolder;
    align:
    center;
    display: flex;
    align-items: center;
    justify-content: center;
">${requestScope.success }</font>
<label><c:if test="${requestScope.Err!=null}">
		<font color="red" align="center">${requestScope.Err}</font>
	</c:if></label>
</body>
</html>