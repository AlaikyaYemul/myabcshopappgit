<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	String fname = request.getParameter("fname");

	String lname = request.getParameter("lname");

%>

<h2>Full Name : <%=fname+" "+lname %></h2>

</body>
</html>