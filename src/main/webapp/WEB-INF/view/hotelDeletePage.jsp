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
<link rel = "stylesheet" type = "text/css" href = "/resources/css/utilities.css">
<link rel = "stylesheet" type = "text/css" href = "/resources/css/delete-hotel-page.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Hotel Booking system</title>
</head>
<body>
<!-- Site navigation -->
<div class = "navbar">
	<div class ="container flex">
	<!-- Main heading -->
    <h1 class = "bg-primary">Hotel Booking System</h1>
		<nav>
		<ul>
		<!-- navigation links accessible to both users and admin -->
		<sec:authorize access = 'hasAnyAuthority("user", "admin")'>
				<li><a href = "/userHome">Home</a></li>
		</sec:authorize>
			<!-- navigation links accessible to admin users only -->
			<sec:authorize access = 'hasAuthority("admin")'>
			<li><a href = "/adminRegistrationPage">Add Admin User</a></li>
			<li><a href = "/deleteAdminUserPage">Delete Admin User</a></li>
			<li><a href = "/updateAdminDetails">Update Admin details</a></li>
			<li><a href = "addHotelPage">Add Hotel</a></li>
			<li><a href = "deleteHotelPage">Delete Hotel</a></li>
		</sec:authorize>
			</ul>
		</nav>	
	</div>
</div>
<section class = "delete-hotel">
	<!-- Form to collect new hotel details -->
	<div class= "container text-center">
	<h2>Delete hotel</h2>
		<div class = "delete-hotel-form text-center card-1">
		<form:form action = "deleteHotel" method = "POST" class = "formContainer">
			<div class = "form-control">
			<label>Hotel Email: </label><input type = "email" name = "email" required><br>
			</div>
			<input type = "submit" value = "delete" class = "btn btn-primary">
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