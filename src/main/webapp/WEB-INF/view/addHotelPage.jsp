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
<title>Hotel Booking system</title>
</head>
<body>
<!-- Main heading -->
<h1>Hotel Booking System</h1>
<!-- show logged in username -->
<h4 style = "text-align:right;">logged in as : ${username}</h4>
<!-- Site navigation -->
<div align ="center">
<sec:authorize access = 'hasAnyAuthority("user", "admin")'>
<a href = "/userHome">Home</a>
</sec:authorize>
<sec:authorize access = 'hasAuthority("admin")'>
<a href = "/adminRegistrationPage">Add Admin User</a>
<a href = "/deleteAdminUserPage">Delete Admin User</a>
<a href = "/updateAdminDetailsPage">Update Admin details</a>
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
<div align = "center">
<h2>Add Hotel</h2>
</div>
<!-- Form to collect new hotel details -->
<div class= "addHotelForm">
<form:form action = "addHotel" modelAttribute = "newHotel" method = "POST" class = "formContainer">
<h2>New Hotel details</h2>
<label>Name: </label><form:input path = "name" maxLength = "30" required = "true"></form:input><br>
<label>Email: </label><form:input type = "email" path = "email" required = "true"></form:input><br>
<label>Contact Number: </label><form:input type = "long" path = "contactNumber"  pattern = "^\s*\(?(020[7,8]{1}\)?[ ]?[1-9]{1}[0-9{2}[ ]?[0-9]{4})|(0[1-8]{1}[0-9]{3}\)?[ ]?[1-9]{1}[0-9]{2}[ ]?[0-9]{3})\s*$"
	required = "true"></form:input><br>
<label>Address: </label><form:input path = "address" maxLength = "80" required = "true"></form:input><br>
<label>Number of kingSize rooms: </label><form:input type = "number" path = "numberOfKingSizeRooms" ></form:input><br>
<label>Number of double rooms: </label><form:input type = "number" path = "numberOfDoubleRooms" ></form:input><br>
<label>Number of family rooms: </label><form:input type = "number" path = "numberOffamilyRooms" ></form:input><br>
<label>Number of single rooms: </label><form:input type = "number" path = "numberOfSingleRooms" ></form:input><br>
<br>
<input type = "submit" value = "Add Hotel">
</form:form>
</div>
</body>
</html>