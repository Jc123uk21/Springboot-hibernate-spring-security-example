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
<link rel = "stylesheet" type = "text/css" href = "/resources/css/utilities.css">
<!-- set view properties to adjust to the device rendering the view -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Hotel Booking System</title>
</head>
<body>
<!-- Site navigation -->
<div class = "navbar">
	<div class ="container flex">
	<!-- Main heading -->
    <h1 class = "bg-primary">Hotel Booking System</h1>
		<nav>
		<ul>
		<li><a href = "/">Home</a></li>
		<li><a href = "/registerUserPage">Register</a></li>
		<li><a href = "/findRoom">Search stay</a></li>
		<li><a href = "/our-hotels">Our Hotels</a></li>
		</ul>
		</nav>	
	</div>
</div>

<!-- information section -->
<section class="information-home ">
	<div class =  "container grid">
		<div class ="information-text" >
			<!-- Welcome paragraph -->
			<p class ="medium py-1">
			Welcome to the hotel booking system
			</p>
			<a href = "/our-hotels" class="btn btn-dark">Read more</a>
		</div>
		
	<div class = "information-login text-center card-1">
		<h2>Login</h2>
		<!-- test login credentials and return error message if incorrect -->
			<c:if test="${param.error != null}">
				<i>Invalid email or password, please re-enter login details</i>
			</c:if>

			<!-- test user has logged out ok  -->
			<c:if test="${param.logout != null}">
				<i>Logged out successfully</i>
			</c:if>
			<!-- create spring form to collect login details -->
			<form:form  action = "/process-login" method = "POST" class = "formContainer">
				<div class = "form-control">
					<label for ="eamil">Email: </label><input type = "email"  name = "username" required/><br>
				</div>
				<div class = "form-control">
					<label for = "password">Password: </label><input type = "password"  name = "password" required/><br>
				</div>
				<input type = "submit" value = "Login" class = "btn btn-primary"/><br>
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
