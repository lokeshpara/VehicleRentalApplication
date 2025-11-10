<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Iterator" %>
<%@page import="com.keane.training.domain.FeedbackDetails" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>User Feedbacks</title>
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
<h1>Feedback Details</h1>
</div>
<section>
<table class="content-table">
  <thead>
    <tr>
      <th scope="col">CustomerID</th>
      <th scope="col">VehicleID</th>
      <th scope="col">Feedback</th>
    </tr>
  </thead>
  <tbody>
 <%
 for(FeedbackDetails book: ((ArrayList<FeedbackDetails>) request.getAttribute("feedbackList"))) {
 %>
    <tr>
      <td ><%= book.getUserID()%></td>
      <td><%= book.getVehicleID() %></td>
      <td><%= book.getFeedback() %></td>
    <%} %>
    </tr>
  </tbody>
</table>
</section>
<div class="links">
<form action="UserProcess.do" method="post">
		<input type="hidden" name="userName" value="${requestScope.details}">
		<input class="box" type="submit" name="action" value="Home">
</form>
</div>
</body>
</html>