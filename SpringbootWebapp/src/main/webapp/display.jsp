<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@page import="com.example.demo.model.Employee"  %>   

<%@page import="java.util.List" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${elist }

<% List<Employee> nlist= (List)request.getAttribute("elist");




%>





</body>
</html>