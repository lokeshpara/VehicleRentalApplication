<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Register</title>
<link rel="stylesheet" href="./AdminAddCustomer.css">

</head>
<body>
<%
String context = request.getContextPath();
%>
<div class="Adduser-form">
<h2 align="center">Register</h2>
<form action="UserProcess.do" method="post">
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
	<input type="tel" name="phoneNumber" placeHolder="Enter 10 Digit Number" pattern="[0-9]{10}" required>
	<input type="submit" class="bt1" name="action" value="Register">
	<p>Already have an account?<a style="
    text-decoration: none;
    text-decoration: none;
    color: #fff;
    font-family: serif;
    display: inline-block;
    background: #5aa86b;
    border-radius: 6px;
    padding: 5px 10px;
    box-sizing: border-box;
    border:none;
    margin-bottom:5px;
    margin-left: 5px;
    outline:
    none;
    text-decoration: none;
    box-shadow: 3px 8px 22px rgba(94,28,68,0.15);
    cursor: pointer;
" href="<%=context%>\pages\UserLogin.jsp">Login</a></p>
	<font color="green" size="3px" style="
    font-family: serif;
    font-weight: bolder;
">${requestScope.success }</font>
	<label><c:if test="${requestScope.Err!=null}">
		<font color="red">${requestScope.Err}</font>
	</c:if></label>
</form>
</body>
</html>