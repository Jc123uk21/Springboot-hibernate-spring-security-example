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
<link rel = "stylesheet" type = "text/css" href = "/resources/css/utilities.css">
<link rel = "stylesheet" type = "text/css" href = "/resources/css/search-room.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Hotel Booking System</title>
</head>
<body>

<!-- Site navigation -->
<div class = "navbar">
	<div class ="container flex">
	<!-- Main heading -->
    <h1 class = "bg-primary">Hotel Booking System</h1>
    
	<sec:authorize access = 'hasAnyAuthority("user")'>
	<div align = "right">
	<!-- show logout button to only logged in users -->
		<form:form action = "logout" method = "POST" align = "right" class = "logoutBtn">
			<input type = "submit" value = "logout"/>
		</form:form>
	</div>
	</sec:authorize>

	<!-- Anonymous user navigation -->
	<sec:authorize access = "isAnonymous">
	<nav>
		<ul>
			<li><a href = "/">Home</a></li>
			<li><a href = "/registerUserPage">Register</a></li>
			<li><a href = "/findRoom">Search stay</a></li>
			<li><a href = "/our-hotels">Our Hotels</a></li>
		</ul>
	</nav>	
	</sec:authorize>
	
	<!-- navigation for logged in users -->
	<sec:authorize access = 'hasAuthority("user")'>
		<nav>
			<ul>
				<li><a href = "/userHome">User Home</a></li>
				<li><a href = "/findRoom">Search Stay</a></li>
				<li><a href = "/bookingsList">My Bookings</a></li>
				<li><a href = "/accountDetails">My Account</a></li>
			</ul>
		</nav>
	</sec:authorize>
	</div>
</div>	

<!-- search-room-->
<section class = "search-room">
	<div class = "container grid text-center">
		<!-- search form -->
		<div class = "search-form card-1">
		<header>Find Room</header>
		<form:form action = "/getAvailability"  method = "POST" modelAttribute= "reservation" class = "formContainer">
			<!-- search form heading -->
			<h3>Required Room</h3>
			<!-- drop menu for room type selection -->
			<div class = "room-dropdown">
					<form:label path="room.roomType">Room Type: </form:label>
					<form:select path="room.roomType" required = "true">
					<form:option value = "familyRoom" label = "Family"/>
					<form:option value = "kingSize" label = "KingSize"/>
					<form:option value = "double" label = "Double"/>
					<form:option value = "single" label = "Single"/>
					</form:select><br>
			</div>
			<!-- input fields to select required stay dates -->
			<br>
			<h3>Required Dates</h3>
			<div class = "form-control">
			<label>Start Date: </label><form:input path = "startDate"  type = "date" required = "true"/><br>
			</div>
			<div class = "form-control">
			<label>End Date: </label><form:input path = "endDate" type = "date" required = "true"/><br>
			</div>
			<input type = "submit" value = "confirm" class = "btn btn-primary">
			</form:form>
		</div>
	</div>
</section>

<!--footer-->
<footer class = "footer bg-primary py-5">
	<div class= "container grid-3">
		<nav>
			<ul>
				<li><a href = "/privacy-statement">Privacy Statement</a></li>
				<li><a href ="/contact-us">Contact-Us</a></li>
				<li><a href = "/support">Support</a></li>
			</ul>
		</nav>
			
		<div>
			<h1>HotelBookingsSystem Copyright &copy; 2022</h1>
		</div>
			
		<div class = "socials">
			<a href = "/our-twitter"><img src = "/resources/images/twitter.png" alt = ""></img></a>
			<a href = "/ourFacebook"><img src = "/resources/images/facebook.png" alt = ""></img></a>
			<a href = "/ourInstagram"><img src ="/resources/images/instagram.png" alt = ""></img></a>
		</div>
	</div>
</footer>

</body>
</html>