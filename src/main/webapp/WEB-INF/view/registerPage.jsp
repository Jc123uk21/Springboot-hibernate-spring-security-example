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
<!-- current page heading -->
<div align = "center">
<h2>Register</h2>
</div>

<!-- create spring form to collect customer details -->
<div class = "registrationForm">
<form:form action = "registerCustomer" modelAttribute = "customer" method= "POST" class = "formContainer">
<h2>Registration Details</h2>
<label>First Name: </label><form:input path = "firstName" maxlength="50" required = "true"></form:input><br>
<label>Last Name: </label><form:input path = "lastName" maxlength="50" required = "true"></form:input><br>
<label>Address: </label><form:input path = "address"  maxlength="80" required = "true"></form:input><br>
<label>Email: </label><form:input type = "email" path ="email"  required = "true"></form:input><br>
<br>
<label>Password:</label><form:input path = "password" required = "true"></form:input><br>
<label>Contact number:</label><form:input type = "tel" path="contactNumber" pattern = "^\s*\(?(020[7,8]{1}\)?[ ]?[1-9]{1}[0-9{2}[ ]?[0-9]{4})|(0[1-8]{1}[0-9]{3}\)?[ ]?[1-9]{1}[0-9]{2}[ ]?[0-9]{3})\s*$"  
  required = "true"></form:input><br>
<br>
<input type = "submit" value = "Register">
</form:form>
</div>
</section>
</body>
</html>