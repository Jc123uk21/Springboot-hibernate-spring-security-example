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
<link rel = "stylesheet" type = "text/css" href = "/resources/css/user-home.css">
<!-- JavaScript files -->
 <script src="<c:url value="/resources/js/mainJs.js" />"></script>
<!-- set view to device capabilities -->
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
		
		<!-- navigation links accessible to users only -->
		<sec:authorize access = 'hasAuthority("user")'>
			<li><a href= "/findRoom">Search Stay</a></li>
			<li><a href = "/bookingsList">My Bookings</a></li>
			<li><a href = "/accountDetails">My Account</a></li>
		</sec:authorize>
			<sec:authorize access = 'hasAuthority("user")'>
			<li> <div class="account-dropdown">
					<button class="dropbtn"><img src ="/resources/images/user.png"></img></button>
    					<div class="dropdown-content">
      						<div class = "logout">
     						 <form:form action = "logout" method = "POST">
     						 <input type = "submit" value = "logout" class = "logoutBtn">
     						 </form:form>
     						 </div>
    					</div>
 				</div>
 			</li>
 			</sec:authorize>
		</ul>
		</nav>	
	</div>
</div>
<!-- Main section to display information according to the logged in user role -->

<section class ="main-section">
<div class = "container grid">
	<!-- Show users latest booking deals -->
	<sec:authorize access ='hasAuthority("user")'>
		<div class = "card-1 text-center py-1">
			<header class = "small">Beach Villas</header>
			<img src = "/resources/images/beach-villas.jpg" alt = "beach villa image"/>
			<p>7 Nights £2200 per person</p>
			<button type="button" class="collapsible">More Details</button>
			<div class="content">
 			 <p>7 Nights all-inclusive </p><hr>
 			 <p>Max-Capacity: 5</p><hr>
 			 <p>Free breakfast, lunch and dinner at any of the hotel 3 dinning facilities</p><hr>
 			 <p>Free local branded alcohol, soft-drinks and snacks from snack bar</p><hr>
 			 <p>free selective Water sports</p><hr>
 			 <p>Villa Safety deposit box</p><hr>
 			 <p>free wifi</p><hr>
 			 <p>Daily room service</p><hr>
 			 <p>2 free visits to the hotel's Spa facility</p><hr>
 			 <p>£2200 per person</p><hr>
			</div>
		</div>	
		<div class = "card-1 text-center py-1">
			<header class = "small">Superior Sea-view</header>
			<img src = "resources/images/super-sea-view.jpg" alt = "sea view image"/>
			<p>7 Nights £1600 per person</p>
			<button type="button" class="collapsible">More Details</button>
			<div class="content">
 			 <p>7 Nights all-inclusive </p><hr>
 			 <p>Max-Capacity: 3</p><hr>
 			 <p>Free breakfast, lunch and dinner at any of the hotel 3 dinning facilities</p><hr>
 			 <p>Free local branded alcohol, soft-drinks and snacks from snack bar</p><hr>
 			 <p>free selective Water sports</p><hr>
 			 <p>Safety deposit box</p><hr>
 			 <p>free wifi</p><hr>
 			 <p>Daily room service</p><hr>
 			 <p>1 free visit to the hotel's Spa facility</p><hr>
 			 <p>£1600 per person</p><hr>
 			 
			</div>			
		</div>
		<div class = "card-1 text-center py-1">
			<header class = "small">Sea view</header>
			<img src = "/resources/images/sea-view.jpg" alt = "sea view image">
			<p>7 Nights £1200 per person</p>
			<button type="button" class="collapsible">More Details</button>
			<div class="content">
 			 <p>7 Nights all-inclusive </p><hr>
 			 <p>Max-Capacity: 3</p><hr>
 			 <p>Free breakfast, lunch and dinner at any of the hotel 3 dinning facilities</p><hr>
 			 <p>Free local branded alcohol, soft-drinks and snacks from snack bar</p><hr>
 			 <p>free selective Water sports</p><hr>
 			 <p>Safety deposit box</p><hr>
 			 <p>free wifi</p><hr>
 			 <p>Room service</p><hr>
 			 <p>£1200 per person</p><hr>
			</div>			
		</div>
		<div class = "card-1 text-center py-1">
			<header class = "small">Standard view</header>
			<img  src = "/resources/images/doubleRoomPic.jpg" alt = "pool view image"/>
			<p>7 Nights £950 per person"</p>
			<button type="button" class="collapsible">More Details</button>
			<div class="content">
 			 <p>7 Nights all-inclusive </p><hr>
 			 <p>Max-Capacity: 3</p><hr>
 			 <p>Free breakfast, lunch and dinner at any of the hotel 3 dinning facilities</p><hr>
 			 <p>Free local branded alcohol, soft-drinks and snacks from snack bar</p><hr>
 			 <p>free selective Water sports</p><hr>
 			 <p>Safety deposit box</p><hr>
 			 <p>free wifi</p><hr>
 			 <p>Room service</p><hr>
 			 <p>£950 per person</p><hr>
 			 </p>
			</div>			
		</div>	
		
		<script>
		var coll = document.getElementsByClassName("collapsible");
		var i;

		for (i = 0; i < coll.length; i++) {
		  coll[i].addEventListener("click", function() {
		    this.classList.toggle("active");
		    var content = this.nextElementSibling;
		    if (content.style.maxHeight){
		      content.style.maxHeight = null;
		    } else {
		      content.style.maxHeight = content.scrollHeight + "px";
		    }
		  });
		}
		
		</script>	
	</sec:authorize>
	
	<!-- Show admin users latest system changes -->
	<sec:authorize access = 'hasAuthority("admin")'>
		<div class = "admin-news card-1">
		<header>Latest System Changes</header>
		<p>Details of latest system updates and operational changes are shown here</p>
		</div>
	</sec:authorize>	
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
			<a href = "/our-twitter"><img src = "/resources/images/twitter.png" alt = "twitter icon"></img></a>
			<a href = "/ourFacebook"><img src = "/resources/images/facebook.png" alt = "facebook icon"></img></a>
			<a href = "/ourInstagram"><img src ="/resources/images/instagram.png" alt = "instagram icon"></img></a>
		</div>
	</div>
</footer>
</body>
</html>