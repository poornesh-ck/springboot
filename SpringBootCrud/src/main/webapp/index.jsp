<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="add">
<label>Employee id</label><input type="text" name="eid" placeholder="enter eid"><br>
<label>Employee name</label><input type="text" name="ename" placeholder="enter ename"><br>
<label>Employee salary</label><input type="number" name="salary" placeholder="enter salary"><br>

<label>Departments</label><select name="dept">
<option>--select--</option>
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

</body>
</html>