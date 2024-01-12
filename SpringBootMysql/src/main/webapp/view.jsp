<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.demo.entity.Employee,java.util.List" %>
    <%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table class="table table-dark table-striped"> 
		<thead> 
			<tr class="table-dark"> 
				<th>Eid</th> 
				<th>Name</th> 
				<th>Salary</th> 
				<th>Department</th> 
				<th>Controls</th>
			</tr> 
		</thead> 
		<tbody> 
			<% 
				int i = 1; 
				List<Employee> list = (List) request.getAttribute("elist"); 
			%> 
 
			<% 
				for (Employee u : list) { 
			%> 
			<tr class="table-dark"> 
				<%-- <td class="table-dark"><%=i++%></td>  --%>
				<td class="table-dark"><%=u.getEid()%></td> 
				<td class="table-dark"><%=u.getEname() %></td> 
				<td class="table-dark"><%=u.getSalary() %></td> 
				<td class="table-dark"><%=u.getDept()%></td> 
				<td><a href="/edit">Edit</a>
				<a href="/delete?eid=<%=u.getEid()%>">Delete</a></td>
			</tr> 
			<% 
				} 
			%> 
		</tbody> 
	</table> 



</body>
</html>