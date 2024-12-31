<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>First JSP</h2>
	
	<!-- JSP Element : Declaration -->
	<%!
		int cube(int n){
		return n*n*n;
	}
	%>
	
	<!-- JSP Element : Scriptlet -->
	<%
	
		int a = 10;
		int b = 20;
		int c = a+b;

		out.println("<h3>Sum : "+c+"</h3>");
		
	%>
	
	<!-- JSP Element : Expression : method calling, value displaying-->
	<h2>Sum : <%= c %></h2>
	
	<h4> Result : <%= 2*2*2 %> </h4>
	
	<h1>Cube of a Number using Declaration : <%= cube(3) %></h1>
	

</body>
</html>