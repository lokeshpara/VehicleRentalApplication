<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invalid</title>
</head>
<body>
<div style="
	display:flex;
	align-items:center;
	justify-content:center;"> 
<font style="
    position: absolute;
    top: 40%;
    left: 50%;
    transform:
    translate(-50%,-50%);
 width:400px;
    font-size: 35px;
    color: #ff5757;
    font-family: sans-serif;
    font-weight: bold;
">${requestScope.Err}</font>
<form action="UserProcess.do" method="post">
<input type="hidden" name="userName" value="${requestScope.details}" >
<input style="text-decoration: none;
    color: #fff;
    display: inline-block;
    background: #5fa597;
    border-radius: 6px;
    padding: 10px 20px;
    box-sizing: border-box;
    border: none;
    margin: 1em;
    outline: none;
    text-decoration: none;
    box-shadow: 3px 8px 22px rgb(94 28 68 / 15%);
    cursor: pointer;
    position: absolute;
    top: 45%;
    left: 45%;
    "type="submit" name="action" value="Home">
</form>
</div>
</body>
</html>