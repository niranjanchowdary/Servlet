<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<style>
body {
	background-image: url("img/download111111.jpg");
	background-position: center center;
	background-size: 90% auto;
}
</style>
<body>
<center style="margin-top: 200px">
		<h1>${username} Welcome to Full User family </h1>
		<%
		if(session.getAttribute("username")==null)
		response.sendRedirect("/");
		%>
		
		
		<form id="f1" action="/welcome" method="post">
		<input type="button" value="logout" class="emailjob" align="middle"
				onclick="document.getElementById('f1').submit();" />
		</form>
		<footer style="margin-top :240px">&copy; Copyright 2017 Full</footer>
		
</center>
</body>
</html>