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
<div align = "right">

<!-- show logged in username if user is logged in -->
<sec:authorize access = 'hasAuthority("user")'>
<h4 style = "text-align:right;">logged in as : <sec:authentication property="principal.username" /></h4>
</sec:authorize>

<!-- Display logout button if user logged in -->
<sec:authorize access = 'hasAuthority("user")'>
<form:form action = "logout" method = "POST" align = "right" class = "logoutBtn">
<input type = "submit" value = "logout"/>
</form:form>
</sec:authorize>
</div>
<!-- Site navigation -->
<div align ="center">
<!-- display unlogged in user navigation -->
<sec:authorize access = "isAnonymous()">
<a href = "/">Home</a>
<a href = "/login">Login</a>
<a href = "/registerUserPage">Register</a>
<a href = "/findRoom">Search Stay</a>
</sec:authorize>

<!-- logged in user navigation control -->
<sec:authorize access = 'hasAuthority("user")'>
<a href= "/findRoom">Search Stay</a>
<a href = "/bookingsList">My Bookings</a>
<a href = "/accountDetails">My Account</a>
</sec:authorize>
</div>

<!-- Current page heading -->
<section>
<h2>Search Results</h2>
</section>

<div align = "center">


<!-- table containing search result -->
<div>
<table class = "userDetailsTable">
<thead>
  <tr>
     <td>Reservation Available</td>
  </tr>
</thead>
	<c:forEach var = "res" items = "${resultList}">
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

<!-- Display message to not logged in or unregistered users -->
<section>
<sec:authorize access = "isAnonymous()">
<i>Please Login or register to complete booking</i>
</sec:authorize>
</section>

<div align = "center">
<sec:authorize access = 'hasAuthority("user")'>
<form:form action = "/bookingProceed" method = "POST" align = "center">
<input type = "submit" value = "proceed"/>
</form:form>
</sec:authorize>
</div>


</div>
<div class = "resResultPageImage">

</div>

</body>
</html>