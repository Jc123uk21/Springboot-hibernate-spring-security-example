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
<a href= "/userHome">Home</a>
<a href= "/findRoom">Search Stay</a>
<a href = "/bookingsList">My Bookings</a>
<a href = "/accountDetails">My Account</a>
</sec:authorize>
</div>
<!-- Display logout button -->
<sec:authorize access = 'hasAuthority("user")'>
<div>
<!-- add logout button -->
<form:form action = "logout" method = "POST" align = "right" class = "logoutBtn">
<input type = "submit" value = "logout"/>
</form:form>
</div>
</sec:authorize>

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
     <td>Booking Confirmation</td>
  </tr>
</thead>
	<tr>
		<td>First Name: <c:out value ="${reservation.customer.firstName}"></c:out></td>
	</tr>
	<tr>
		<td>Last Name: <c:out value ="${reservation.customer.lastName}"></c:out></td>
	</tr>
	<tr>
		<td>Email: <c:out value="${reservation.customer.email}"></c:out></td>
	</tr>
	<tr>
		<td>Contact Number: <c:out value="${reservation.customer.contactNumber}"></c:out></td>
	</tr>
	<tr>
		<td>Start Date: <c:out value ="${reservation.startDate}"></c:out></td>
	</tr>
	<tr>
		<td>End Date: <c:out value="${reservation.endDate}"></c:out></td>
	</tr>
	<tr>
		<td>Room Type: <c:out value="${reservation.room.roomType}"></c:out></td>
	</tr>
	<tr>
		<td>Room Capacity: <c:out value="${reservation.room.maxCapacity}"></c:out></td>
	</tr>
	<tr>
		<td>Total Price: <c:out value="${reservation.totalCost}"></c:out></td>
	</tr>
</table>
</div>
<div class = "resResultPageImage">

</div>
</section>
</body>
</html>