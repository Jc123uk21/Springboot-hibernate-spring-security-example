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
<!-- configure navigation access for users -->
<sec:authorize access = 'hasAnyAuthority("user", "admin")'>
<a href = "/userHome">Home</a>
</sec:authorize>
<sec:authorize access = 'hasAuthority("admin")'>
<a href = "/adminRegistrationPage">Add Admin User</a>
<a href = "/deleteAdminUserPage">Delete Admin User</a>
<a href = "/updateAdminDetails">Update Admin details</a>
<a href = "addHotelPage">Add Hotel</a>
<a href = "deleteHotelPage">Delete Hotel</a>
</sec:authorize>
</div>
<div>
<!-- add logout button -->
<form:form action = "logout" method = "POST" align = "right" class = "logoutBtn">
<input type = "submit" value = "logout"/>
</form:form>
</div>

<div align = "center">
<h2>Update Administrator Details</h2>
</div>
<!-- Update form -->
<div class = "resSearchForm">
<form:form action = "updateAdministrator" method = "POST" modelAttribute = "administrator" class = "formContainer"><br>
<br>
<form:label path="firstName">First Name :<c:out value = "${administrator.firstName} "/></form:label><br>
<form:input path = "firstName"/><br>
<br>
<form:label path="lastName">Last Name :<c:out value = "${administrator.lastName} "/></form:label><br>
<form:input path = "lastName"/><br>
<br>
<form:label path="email">Email :<c:out value = "${administrator.email} "/></form:label><br>
<form:input path = "email"/><br>
<br>
<form:label path="password">Password/></form:label><br>
<form:input path = "password"/><br>
<br>
<form:label path="contactNumber" type = "number">Contact Number :<c:out value = "${administrator.contactNumber} "/></form:label><br>
<form:input path = "contactNumber"/><br>
<input type = "submit" value = "update">
</form:form>
</div>


</body>
</html>