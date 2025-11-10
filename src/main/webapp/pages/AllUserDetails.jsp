<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Iterator" %>
<%@page import="com.keane.training.domain.UserDetails" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="./AllUserDetails.css">
<title>All Users</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<body>
<%
String context = request.getContextPath();
%>
<div class="content">
<h1>Customer Details</h1>
</div>
<div class="links">
<form action="AdminProcess.do" method="post">
	<input type="hidden" name="Name" value="${requestScope.Name}" >
	<input class="box" type="submit" name="action" value="Add Customer">
	<input class="box" type="submit" name="action" value="Home">
</form>
</div>
<section>

<table class="content-table">
  <thead>
    <tr>
      <th scope="col">CustomerID</th>
      <th scope="col">Customer Name</th>
      <th scope="col">Password</th>
      <th scope="col">City</th>
      <th scope="col">Email</th>
      <th scope="col">Phone Number</th>
    </tr>
  </thead>
  <tbody>
 <%
 for(UserDetails user: ((ArrayList<UserDetails>) request.getAttribute("userList"))) {
 %>
    <tr>
      <td ><%= user.getUserID()%></td>
      <td><%= user.getUserName() %></td>
      <td><%= user.getUserPassword() %></td>
      <td><%= user.getCity()%></td>
      <td><%= user.getEmail()%></td>
      <td><%= user.getPhoneNumber()%></td>
    <%} %>
    </tr>
  </tbody>
</table>
</section>

</body>
</html>