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
<a href = "/findRoom">Search stay</a>
<a href = "/login">Login</a>
</div>
<section>
<h2>Home</h2>
<!-- Welcome paragraph -->
<p>
Welcome to the hotel booking system
</p>
</section>

<!-- Page image -->
<div class = homePageImage></div>
</body>
</html>
