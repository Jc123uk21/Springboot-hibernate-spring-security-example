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
<h4 style = "text-align:right;">logged in as : ${username}</h4>
<!-- add logout button -->
<form:form action = "logout" method = "POST" align = "right" class = "logoutBtn">
<input type = "submit" value = "logout"/>
</form:form>
</div>
<div align = "center">
<h3>My Bookings</h3>
<table>
	<thead>
		<tr>
			<td>Reservation Number</td>
			<td>Start Date</td>
			<td>End Date</td>
			<td>Room Type</td>
			<td>Checked-In</td>
			<td>Checked-out</td>
			<td>Total Price</td>
		</tr>
	</thead>
	
	<c:forEach var = "reservation" items = "${myBookings}">
	<tr>
		<td><c:out value="${reservation.reservationNumber}"></c:out></td>
		<td><c:out value="${reservation.startDate }"></c:out></td>
		<td><c:out value="${reservation.endDate }"></c:out></td>
		<td><c:out value = "${reservation.room.roomType}"></c:out></td>
		<td><c:out value = "${reservation.checkedIn}"></c:out></td>
		<td><c:out value="${reservation.checkedOut}"></c:out></td>
		<td><c:out value="${reservation.totalCost}"></c:out></td>
	</tr>	
	</c:forEach>
</table>
</div>
<div class = "resResultPageImage">

</div>
</body>
</html>