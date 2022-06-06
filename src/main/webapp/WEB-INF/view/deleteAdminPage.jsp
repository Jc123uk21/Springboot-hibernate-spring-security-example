<%@ taglib prefix ="form" uri = "http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

<!-- show logged in username -->
<h4 style = "text-align:right;">logged in as : ${username}</h4>

<!-- Site navigation with access control -->
<div align ="center">
<sec:authorize access = 'hasAnyAuthority("user", "admin")'>
<a href = "/userHome">Home</a>
</sec:authorize>
<sec:authorize access = 'hasAuthority("admin")'>
<a href = "/adminRegistrationPage">Add Admin User</a>
<a href = "/deleteAdminUserPage">Delete Admin User</a>
<a href = "/updateAdminDetails">Update Admin details</a>
<a href = "addHotelPage">Add Hotel</a>
<a href = "deleteHotelPage">Delete Hotel</a>
</sec:authorize>
</div>

<!-- add logout button -->
<div>
<form:form action = "logout" method = "POST" align = "right" class = "logoutBtn">
<input type = "submit" value = "logout"/>
</form:form>
</div>

<!-- current page heading -->
<section>
<div align = "center">
<h2>Delete Administrator User</h2>
</div>
<!-- create spring form to collect administrator details -->
<div class ="registrationForm">
<form:form action = "/deleteAdminUser"  method = "POST" class = "formContainer">
<h2>Administrator's email</h2>
<label>Administrator email: </label><input type = "email" name = "email" required><br>
<br>
<input type = "submit" value = "delete">
</form:form>
</div>
</section>

</body>
</html>