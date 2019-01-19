<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Rest Demo</title>
</head>
<body>
Spring Rest Demo
<hr>
<!-- without forward slash before -->
<a href="test/hello">Hello</a>
<br>
<!-- with forward slash before -->
<a href="${pageContext.request.contextPath}/test/hello">HelloForward</a> 
<br>
<a href="${pageContext.request.contextPath}/api/students">Get All Students</a>
</body>
</html>