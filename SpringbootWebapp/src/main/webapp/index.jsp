<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- <h1>Hi poornesh </h1>

<form action="/poornesh">
<input type="text" name="uname" placeholder="Enter your name">
<input type="submit"></form> -->



<!-- <form action="/poornesh1">
<input type="text" name="uname" placeholder="Enter your name">
<input type="submit"></form> -->


<form action="add">
<label>Employee id</label><input type="text" name="eid" placeholder="enter eid"><br>
<label>Employee name</label><input type="text" name="ename" placeholder="enter ename"><br>
<label>Employee salary</label><input type="number" name="salary" placeholder="enter salary"><br>

<label>Departments</label><select name="departments">
<option>HR</option>
<option>IT</option>
<option>Trainee</option>
<option>Admin</option></select><br>

<input type="submit" value="Add">
<input type="reset">

</form>
<form action="view">
<input type="submit" value="View">

</form>

${o}

</body>
</html>






