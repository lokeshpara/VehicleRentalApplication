<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="./AdminLogin.css">

</head>
<body>
<%
String context = request.getContextPath();
%>
<section>
	<div class="form-container">
		<h1>Login</h1>	
	<form action="UserProcess.do" method="post">  
		<div class="control">
			<label for="UserName">User Name</label>
			<input type="text" name="UserName" placeHolder="User Name">
		</div>
		
		<div class="control">
			<label for="admin_password">Password</label>
			<input type="password" name="password" placeHolder="Password">
		</div>
		<div class="control">
			<input class="bt1" type="submit" name="action" value="Login">
		</div>
		<p>don't have an account?<a style="
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
" href="<%=context%>\pages\UserRegister.jsp">Register</a></p></td>

		<table>
			<tr>
				<td colspan="2"><c:if test="${requestScope.Err!=null}">
				<font color="red">${requestScope.Err}</font>
				</c:if></td>
			</tr>
		</table>
</form>
</body>
</html>