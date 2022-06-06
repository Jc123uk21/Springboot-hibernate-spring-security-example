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
<!-- set view to device capabilities -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Hotel Booking System</title>
</head>
<body>
<!-- Main heading -->
<h1>Hotel Booking System</h1>
<!-- show logged in username -->
<div align = "right">
<h4 style = "text-align:right;">logged in as : ${username}</h4>
<!-- add logout button -->
<form:form action = "logout" method = "POST" align = "right" class = "logoutBtn">
<input type = "submit" value = "logout"/>
</form:form>
</div>
<div align ="center">
<!-- Site navigation -->

<!-- navigation links accessible to both users and admin -->
<sec:authorize access = 'hasAnyAuthority("user", "admin")'>
<a href = "/userHome">Home</a>
</sec:authorize>
<!-- navigation links accessible to admin users only -->
<sec:authorize access = 'hasAuthority("admin")'>
<a href = "/adminRegistrationPage">Add Admin User</a>
<a href = "/deleteAdminUserPage">Delete Admin User</a>
<a href = "/updateAdminDetails">Update Admin details</a>
<a href = "addHotelPage">Add Hotel</a>
<a href = "deleteHotelPage">Delete Hotel</a>
</sec:authorize>
<!-- navigation links accessible to users only -->
<sec:authorize access = 'hasAuthority("user")'>
<a href= "/findRoom">Search Stay</a>
<a href = "/bookingsList">My Bookings</a>
<a href = "/accountDetails">My Account</a>
</sec:authorize>
</div>

<p>

</p>

<!-- Page image -->
<div class = regUserHomeImage></div>
</body>
</html>