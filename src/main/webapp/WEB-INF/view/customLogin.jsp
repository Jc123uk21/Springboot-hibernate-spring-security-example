<%@ taglib prefix ="form" uri = "http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html>
<html>
<head>
<!-- include css style sheet -->
<link rel = "stylesheet" type = "text/css" href = "/resources/css/main.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Hotel Booking System</title>
</head>
<body>
<!-- Main heading -->
<h1>Hotel Booking System</h1>

<!-- Site navigation -->
<div align ="center">
<a href = "/">Home</a>
<a href = "/registerUserPage">Register</a>
<a href = "/findRoom">Search Stay</a>
<a href = "/login">Login</a>
</div>

<section>
<h2>Login</h2>
<!-- test login credentials and return error message if incorrect -->
<c:if test="${param.error != null}">
	<i>Invalid email or password, please re-enter login details</i>
</c:if>

<!-- test user has logged out ok  -->
<c:if test="${param.logout != null}">
	<i>Logged out successfully</i>
</c:if>
<!-- create spring form to collect login details -->
<div class = "loginform">
<form:form  action = "process-login" method = "POST" class = "formContainer">
<h3>Login Details</h3>
<label for ="eamil">Email: </label><input type = "text"  name = "username" required/><br>
<label for = "password">Password: </label><input type = "password"  name = "password" required/><br>
<input type = "submit" value = "Login" class = "btn"/><br>
</form:form>
</div>
</section>
</body>
</html>