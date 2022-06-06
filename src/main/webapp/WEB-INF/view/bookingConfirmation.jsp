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

<!-- Site navigation -->
<div align ="center">
<!-- logged in user navigation control -->
<sec:authorize access = 'hasAuthority("user")'>
<a href = "/userHome">Home</a>
<a href= "/search">Search Stay</a>
<a href = "/bookingsList">My Bookings</a>
<a href = "/accountDetails">My Account</a>
</sec:authorize>
</div>

<!-- Display logout button -->
<div>
<sec:authorize access = 'hasAuthority("user")'>
<!-- add logout button -->
<form:form action = "logout" method = "POST" align = "right" class = "logoutBtn">
<input type = "submit" value = "logout"/>
</form:form>
</sec:authorize>
</div>

<!-- Current page heading -->
<section>
<h2>Confirm Booking</h2>
</section>

<section>
<div align = "center">
<h3>Confirm Booking details</h3>
<table class = "userDetailsTable">
<thead>
  <tr>
     <td>Reservation details</td>
  </tr>
</thead>
	<c:forEach var = "res" items = "${reservations}">
	<tr>
		<td>First Name: <c:out value ="${res.customer.firstName}"></c:out></td>
	</tr>
	<br>
	<tr>
		<td>Last Name: <c:out value ="${res.customer.lastName}"></c:out></td>
	</tr>
	<tr>
		<td>Start Date: <c:out value ="${res.startDate}"></c:out></td>
	</tr>
	<br>
	<tr>
		<td>End Date: <c:out value="${res.endDate}"></c:out></td>
	</tr>
	<br>
	<tr>
		<td>Room Type: <c:out value="${res.room.roomType}"></c:out></td>
	</tr>
	<br>
	<tr>
		<td>Room Capacity: <c:out value="${res.room.maxCapacity}"></c:out></td>
	</tr>
	<br>
	<tr>
		<td>Total Price: <c:out value="${res.totalCost}"></c:out></td>
	</tr>
	<br>
	</c:forEach>
</table>
</div>
<div align = "center">
<sec:authorize access = 'hasAuthority("user")'>
<form:form action = "/confirmBooking" method = "POST">
<input type = "submit" value = "proceed">
</form:form>
</sec:authorize>
</div>
<div class = "resResultPageImage">

</div>
</section>
</body>
</html>