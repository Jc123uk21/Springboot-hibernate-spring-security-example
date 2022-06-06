<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="form" uri = "http://www.springframework.org/tags/form"%> 
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
<!-- show logged in username -->
<h4 style = "text-align:right;">logged in as : ${username}</h4>
<!-- Site navigation -->
<div align ="center">
<sec:authorize access = 'hasAnyAuthority("user", "admin")'>
<a href = "/userHome">Home</a>
</sec:authorize>
<sec:authorize access = 'hasAuthority("user")'>
<a href= "/search">Search Stay</a>
<a href = "/bookingsList">My Bookings</a>
<a href = "/accountDetails">My Account</a>
</sec:authorize>
</div>
<div>
<!-- add logout button -->
<form:form action = "logout" method = "POST" align = "right" class = "logoutBtn">
<input type = "submit" value = "logout"/>
</form:form>
</div>
<!-- Page heading -->
<h2>Account holder details</h2>
<!-- table containing user details -->
<div>
<table class = "userDetailsTable">
<thead>
  <tr>
     <td>User ${username} details</td>
  </tr>
</thead>
	<c:forEach var = "customer" items = "${user}">
	<tr>
		<td>First Name: <c:out value ="${customer.firstName}"></c:out></td>
	</tr>
	<br>
	<tr>
		<td>Last Name: <c:out value="${customer.lastName}"></c:out></td>
	</tr>
	<br>
	<tr>
		<td>Address: <c:out value="${customer.address}"></c:out></td>
	</tr>
	<br>
	<tr>
		<td>Email: <c:out value="${customer.email}"></c:out></td>
	</tr>
	<br>
	<tr>
		<td>Contact Number: <c:out value="${customer.contactNumber}"></c:out></td>
	</tr>
	<br>
	</c:forEach>
</table>
</div>
<!-- image to be displayed below table -->
<div class = "userDetailsImage">
</div>
</body>
</html>