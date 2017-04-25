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
	letter-spacing: 10px;
	font-size: 20px;
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
	width: 100%; /* Set width to 100% */
	margin: auto;
}

.carousel-caption h3 {
	color: #000000 !important;
}

@media ( max-width : 600px) {
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

.otp_back {
	background-color: #FFFFFF;
}

.otp {
	color: #00FF00 !important;
	text-align: center;
	font-size: 30px;
}

#googleMap {
	width: 100%;
	height: 400px;
	-webkit-filter: grayscale(100%);
	filter: grayscale(100%);
}

.navbar {
	font-family: Montserrat, sans-serif;
	margin-bottom: 0;
	background-color: #2d2d30;
	border: 0;
	font-size: 11px !important;
	letter-spacing: 2px;
}

.navbar li a, .navbar .navbar-brand {
	color: #d5d5d5 !important;
}

.navbar-nav li a:hover {
	color: #fff !important;
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

jQuery (document).ready (function($) { $(".clickable-row
	").click(function() { window.location = $(this).data("href");
	
}
);
}
);
</style>
<body>
<body id="apartment" data-spy="scroll" data-target=".navbar"
	data-offset="50">

	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <a class="navbar-brand" href="#myPage">UNCC
				Apartments</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#apartment">Available Apartments</a></li>
				<li><a href="#check_otp" onclick="showotp();">Check OTP</a></li>
				<li><a href="#vacate_apt" onclick="return show();">Vacate Apartment	</a></li>
				<li><a href="../app">Sign Out</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<br>
	<br>
	<c:if test="${!empty otp}">
		<div class="otp_back">
			<p class="otp">${otp}</p>
		</div>

	</c:if>
	<div class="row">
		<div class="col-md-10 text-right">
			<font color="black" size="4"> Welcome, </font>
		</div>
		<div class="col-md-13">
			<label> <font color="black" size="4"> ${user.name} </font>
			</label>
		</div>
	</div>



	<div class="container text-center">
		<h3>Dashoard</h3>
		<br>
									<div class="col-sm-4">
										<p>
											<strong>Available Apartments</strong>
										</p>
										<br>
										<table class="table table-striped table-hover table-users">
											<thead>
												<tr>
												    <th class="hidden-phone">&nbsp;&nbsp;&nbsp;&nbsp;Unit</th>
													<th class="hidden-phone">&nbsp;&nbsp;&nbsp;&nbsp;BHK</th>
													<th></th>
												</tr>

											<tbody>
												<c:forEach items="${listapartment}" var="apartment">
													<tr class='clickable-row'
														data-href='url://link-for-first-row/'>
														<td>${apartment.unit}</td>
														<td>${apartment.bhk}BHK</td>
														<td>
															<div data-role="main" class="ui-content">
																<a href="#myPopup" data-rel="popup"
																	class="ui-btn ui-btn-inline ui-corner-all">Book</a>

																<div data-role="popup" id="myPopup" class="ui-content"
																	style="min-width: 250px;">
																	<div class="panel-body">
																		<h3>Allocate Apartment</h3>

																		<form name="ComplaintForm" action="/app/allocates"
																			method="get">
																			<input type="date" name="start"> <input
																				type="date" name="end"> <input type="hidden"
																				name="unit" value="${apartment.unit}">

																			<button class="btn mini blue-stripe" type="submit"
																				id="submit">Book</button>
																		</form>
																	</div>
																</div>
															</div>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									&nbsp;&nbsp; &nbsp;&nbsp;
									<div class="col-sm-4">
										<p>
											<strong>Complaints that breached SLA</strong>
										</p>
										<br>
										<table class="table table-striped table-hover table-users">
											<thead>
												<tr>
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
														<td>${complaintout.type}</td>
														<td>${complaintout.severity}</td>
														<td>${complaintout.description}</td>
														<td>${complaintout.time}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>

									</div>
									<div class="col-sm-4">
										<p>
											<strong>Notifications</strong>
										</p>
										<br>
									</div>
								</div>
				


							<script type="text/javascript">
								$(document).ready(function() {

									$("#vacate_apt").hide();
									$("#check").hide();
								});
								function show() {
									$(vacate_apt).show();
									return true;
								}
								function showotp(){
									$(check).show();
								}
							</script>
							

	<div id="vacate_apt" class="container text-center">
							<form:form name="vacate" method="post" action="vacate.submit"
								modelAttribute="deleteApartmentBean">
									<div class="form-group">
										<div class="col-md-12 text-center">

											<span class="label" id="description"> <font size="4"
												color="black"> Enter the Unit number</font>
											</span>
										</div>
										<div class="col-md-offset-3 col-md-6 text-center"
											style="height: 75px;">
											<input type="text" class="form-control" name="vacate">
										</div>
									</div>

									<div class="col-md-offset-3 col-md-6 text-center"
										style="height: 75px;">
										<button class="btn btn-sm btn-success" type="submit"
											id="submit">Submit</button>
									</div>
								
							</form:form>
							</div>
							
							<div id="check">
																<div class="col-sm-4">
							
											<p>
											<strong>Unused OTP</strong>
										</p>
										<br>
										<table class="table table-striped table-hover table-users">
											<thead>
												<tr>
													<th class="hidden-phone">OTP</th>
													<th class="hidden-phone">Unit</th>
												</tr>
											</thead>

											<tbody>

												<c:forEach items="${listotp}" var="otp">
													<tr>
														<td>${otp.otp}</td>
														<td>${otp.unit}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										</div>
							</div>
</body>
</html>



























