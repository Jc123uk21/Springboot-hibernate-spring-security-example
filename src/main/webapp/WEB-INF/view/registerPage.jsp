<%@ taglib prefix ="form" uri = "http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html>
<html>
<head>
<!-- include css style sheet -->
<link rel = "stylesheet" type = "text/css" href = "/resources/css/utilities.css">
<link rel = "stylesheet" type = "text/css" href = "/resources/css/register.css">
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

<section class = "registration">
	<div class = "container grid text-center">
	
		<div class = "register-form text-center card-1">
			<form:form action = "registerCustomer" modelAttribute = "customer" method= "POST" class = "formContainer">
				<h2>Register</h2>
				<div class = "form-control">
				<label>First Name: </label><form:input path = "firstName" maxlength="50" required = "true"></form:input><br>
				</div>
				<div class = "form-control">
				<label>Last Name: </label><form:input path = "lastName" maxlength="50" required = "true"></form:input><br>
				</div>
				<div class = "form-control">
				<label>Address: </label><form:input path = "address"  maxlength="80" required = "true"></form:input><br>
				</div>
				<div class = "form-control">
				<label>Email: </label><form:input type = "email" path ="email"  required = "true"></form:input><br>
				</div>
				<div class = "form-control">
				<label>Password:</label><form:input type = "password" path = "password" required = "true"></form:input><br>
				</div>
				<div class = "form-control">
				<label>Contact number:</label><form:input type = "tel" path="contactNumber" 
				pattern = "^\s*\(?(020[7,8]{1}\)?[ ]?[1-9]{1}[0-9{2}[ ]?[0-9]{4})|(0[1-8]{1}[0-9]{3}\)?[ ]?[1-9]{1}[0-9]{2}[ ]?[0-9]{3})\s*$"  
  				required = "true"></form:input><br>
  				</div>
				<input type = "submit" value = "register" class = "btn btn-primary"/><br>
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