<%@ taglib prefix ="form" uri = "http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html>
<html>
<head>
<!-- include css style sheet and set view-->
<link rel = "stylesheet" type = "text/css" href = "/resources/css/main.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Hotel Booking System</title>
</head>
<body>

<!-- Main heading -->
<h1>Hotel Booking System</h1>

<div align = "right">
<sec:authorize access = 'hasAnyAuthority("user")'>
<!-- Show logged in user -->
<h4 style = "text-align:right;">logged in as : <sec:authentication property="principal.username" /></h4>

<!-- show logout button to only logged in users -->
<form:form action = "logout" method = "POST" align = "right" class = "logoutBtn">
<input type = "submit" value = "logout"/>
</form:form>
</sec:authorize>
</div>

<!-- navigation for unlogged in users -->
<div align ="center">
<sec:authorize access = "isAnonymous">
<a href = "/">Home</a>
<a href = "/findRoom">Search Stay</a>
<a href = "/registerUserPage">Register</a>
<a href = "/login">Login</a>
</sec:authorize>

<!-- navigation for logged in users -->
<sec:authorize access = 'hasAuthority("user")'>
<a href = "/userHome">User Home</a>
<a href = "/findRoom">Search Stay</a>
<a href = "/bookingsList">My Bookings</a>
<a href = "/accountDetails">My Account</a>
</sec:authorize>
</div>

<!-- show logged in username if user is logged in -->
<sec:authorize access = 'hasAuthority("user")'>
<h4 style = "text-align:right;">logged in as : <sec:authentication property="principal.username" /></h4>
</sec:authorize>

<!-- Current page heading -->
<section>
<h2>Find Room</h2>
</section>

<!-- search form -->
<div class = "resSearchForm">
<form:form action = "/getAvailability"  method = "POST" modelAttribute= "reservation" class = "formContainer">
<!-- search form heading -->
<h3>Required Room</h3>
<!-- drop menu for room type selection -->
<form:label path="roomType">Room Type: </form:label>
<form:select path="roomType" required = "true">
<form:option value = "familyRoom" label = "Family"/>
<form:option value = "kingSize" label = "KingSize"/>
<form:option value = "double" label = "Double"/>
<form:option value = "single" label = "Single"/>
</form:select><br>
<!-- input fields to select required stay dates -->
<br>
<h3>Required Dates</h3>
<label>Start Date: </label><form:input path = "startDate"  type = "date" required = "true"/><br>
<br>
<br>
<label>End Date: </label><form:input path = "endDate" type = "date" required = "true"/><br>
<br>
<br>
<input type = "submit" value = "confirm">
</form:form>
</div>
</body>
</html>