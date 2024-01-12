<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>

<p style="text-align:center ">${pc }</p>

<form action="add"> 
  <fieldset >
    <legend>Employee Form</legend>
    <div class="mb-3">
      <label for="disabledTextInput" class="form-label">EID</label>
      <input type="text" id="disabledTextInput" class="form-control" name="eid" placeholder="enter eid">
    </div>
        <div class="mb-3">
      <label for="disabledTextInput" class="form-label">ENAME</label>
      <input type="text" id="disabledTextInput" class="form-control" name="ename" placeholder="enter ename">
    </div>
    <div class="mb-3">
      <label for="disabledTextInput" class="form-label">SALARY</label>
      <input type="text" id="disabledTextInput" class="form-control" name="salary" placeholder="enter salary" >
    </div>
    <label>DEPARTMENT</label><select name="dept">
<option>--select--</option>
<option>HR</option>
<option>IT</option>
<option>Trainee</option>
<option>Admin</option></select><br>
    
    <input type="submit" value="Add">
<input type="reset">
  </fieldset>
 </form> 













<!-- <form action="view">
<input type="submit" value="View">

</form>><br>

<form action="delete">
<label>Enter Id</label><input type="text" name="eid">
<input type="submit">
</form>


<form action="search">
<label>search</label><input type="text" name="dept">
<input type="submit" value="Search">
</form> -->





</body>
</html>