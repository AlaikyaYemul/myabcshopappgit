<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Registration Success</h1>
	
	<%
	
//  	String fname = request.getParameter("fname");
// 	String lname = request.getParameter("lname");
	String fullName = (String) request.getAttribute("myFullName");
	
	%>
	
	<h3>Thank you <%= fullName %></h3>

</body>
</html>