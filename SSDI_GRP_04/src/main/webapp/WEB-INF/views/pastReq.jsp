<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UNCC Apartments</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-aria.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-messages.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script
	src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<style>
body {
	font: 400 15px/1.8 Lato, sans-serif;
	color: #777;
}

h3, h4 {
	margin: 10px 0 30px 0;
	font-family: "Trebuchet MS", Helvetica, sans-serif;
	font-size: 25px;
	color: #111;
}

.container {
	padding: 80px 120px;
}

.person {
	border: 10px solid transparent;
	margin-bottom: 25px;
	width: 80%;
	height: 80%;
	opacity: 0.7;
}

.person:hover {
	border-color: #f1f1f1;
}

.carousel-inner img {
	-webkit-filter: grayscale(0%);
	width: 120%; /* Set width to 100% */
	margin: auto;
}

.carousel-caption h3 {
	color: #000000 !important;
}

@media ( max-width : 700px) {
	.carousel-caption {
		display: none;
		/* Hide the carousel text when the screen is less than 600 pixels wide */
	}
}

.bg-1 {
	background: #2d2d30;
	color: #bdbdbd;
}

.bg-1 h3 {
	color: #fff;
}

.bg-1 p {
	font-style: italic;
}

.list-group-item:first-child {
	border-top-right-radius: 0;
	border-top-left-radius: 0;
}

.list-group-item:last-child {
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.thumbnail {
	padding: 0 0 15px 0;
	border: none;
	border-radius: 0;
}

.thumbnail p {
	margin-top: 15px;
	color: #555;
}

.btn {
	padding: 10px 20px;
	background-color: #333;
	color: #f1f1f1;
	border-radius: 0;
	transition: .2s;
}

.btn:hover, .btn:focus {
	border: 1px solid #333;
	background-color: #fff;
	color: #000;
}

.modal-header, h4, .close {
	background-color: #333;
	color: #fff !important;
	text-align: center;
	font-size: 30px;
}

.modal-header, .modal-body {
	padding: 40px 50px;
}

.nav-tabs li a {
	color: #777;
}

#googleMap {
	width: 100%;
	height: 400px;
	-webkit-filter: grayscale(100%);
	filter: grayscale(100%);
}

.navbar {
	font-family: 'oswald', sans-serif;
	margin-bottom: 0;
	background-color: #2d2d30;
	border: 0;
	font-size: 14px !important;
	font-family: verdana;
	opacity: 0.9;
}

.navbar li a, .navbar .navbar-brand {
	color: #d5d5d5 !important;
}

.navbar-nav li a:hover {
	color: #fff !important;
	background-color: black;
}

.
navbar.affix {
	position: fixed;
	top: 0;
	width: 100%;
	z-index: 10;
}

.navbar-nav li.active a {
	color: #fff !important;
	background-color: #29292c !important;
}

.navbar-default .navbar-toggle {
	border-color: transparent;
}

footer {
	background-color: #2d2d30;
	color: #f5f5f5;
	padding: 32px;
}

footer a {
	color: #f5f5f5;
}

footer a:hover {
	color: #777;
	text-decoration: none;
}

.form-control {
	border-radius: 0;
}

textarea {
	resize: none;
}

.navbar-default .navbar-brand {
	display: flex;
	align-items: center;
	padding: 5px;
}

.navbar-brand img {
	height: 500%;
	margin-right: 40px;
	margin-left: 40px;
}

.footer-bottom {
	background-color: black;
	min-height: 50px;
	width: 100%;
}

.copyright {
	color: #fff;
	line-height: 10px;
	min-height: 30px;
	padding: 3px 0;
}

.design {
	color: #fff;
	line-height: 10px;
	min-height: 30px;
	padding: 7px 0;
	text-align: right;
}

.design a {
	color: #fff;
}

.carousel-control {
	top: 40%;
}
</style>
<body>
<body id="apartment" data-spy="scroll" data-target=".navbar"
	data-offset="50">

	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#myPage"><img
				src="<c:url value="/resources/images/23.png"/>"></a>

		</div>
	</div>
	</nav>

	<br>
	<br>


	<h3>Past Complaints</h3>
	<c:if test="${!empty listcomplaints}">

		<table class="table table-striped table-hover table-users">
			<thead>
				<tr>

					<th class="hidden-phone">Request Number</th>
					<th class="hidden-phone">Unit</th>
					<th class="hidden-phone">Type</th>
					<th class="hidden-phone">Severity</th>
					<th class="hidden-phone">Description</th>
					<th class="hidden-phone">Time</th>
					<th></th>
				</tr>
			</thead>

			<tbody>

				<c:forEach items="${listcomplaints}" var="complaintout">
					<tr>
						<td>${complaintout.complaint_number}</td>
						<td>${complaintout.unit}</td>
						<td>${complaintout.type}</td>
						<td>${complaintout.severity}</td>
						<td>${complaintout.description}</td>
						<td>${complaintout.time}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>




</body>
</html>