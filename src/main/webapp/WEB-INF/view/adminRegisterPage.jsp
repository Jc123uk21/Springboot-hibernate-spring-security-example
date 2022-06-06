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
<!-- Site navigation -->
<div align ="center">
<!-- configure navigation access for users -->
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
<div>
<!-- add logout button -->
<form:form action = "logout" method = "POST" align = "right" class = "logoutBtn">
<input type = "submit" value = "logout"/>
</form:form>
</div>

<section>
<!-- current page heading -->
<div align = "center">
<h2>Register New Administrator User</h2>
</div>

<!-- create spring form to collect new administrator details -->
<div class ="registrationForm">
<form:form action = "/addAdminUser" modelAttribute = "newAdministrator" method = "POST" class = "formContainer">
<h2>Registration Details</h2>
<label>First Name: </label><form:input path = "firstName" value = "first name" maxlength="50" required = "true"></form:input><br>
<label>Last Name: </label><form:input path = "lastName" value = "last name" maxlength="50" required = "true"></form:input><br>
<label>Email: </label><form:input type = "email" path ="email" value = "email" required = "true"></form:input><br>
<br>
<label>Password:</label><form:password path = "password" value = "password" maxlength = "15" required = "true"></form:password><br>
<br>
<input type = "submit" value = "Register">
</form:form>
</div>
</section>

</body>
</html>