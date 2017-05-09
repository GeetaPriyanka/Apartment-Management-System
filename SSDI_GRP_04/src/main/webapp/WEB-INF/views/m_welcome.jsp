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
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<style>
body {
	font: 400 15px/1.8 Lato, sans-serif;
	color: #777;
}

.ui-page-theme-a a, html .ui-bar-a a, html .ui-body-a a, html body .ui-group-theme-a a
	{
	text-shadow: 0 0 0;
	font-weight: normal;
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
	border: 10px transparent;
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
	border: 1px #333;
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

.otp_back {
	background-color: #FFFFFF;
}

.
navbar.affix {
	position: fixed;
	top: 0;
	width: 100%;
	z-index: 10;
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
	font-family: 'oswald', sans-serif;
	margin-bottom: 0;
	background-color: #2d2d30;
	border: 0;
	font-size: 14px;
	font-family: verdana;
	opacity: 0.9;
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

jQuery (document ).ready (function ($) { $(".clickable-row
	 ").click (function() {window .location = $(this).data("href");
	
}
);
}
);
</style>


<body>
<body id="apartment" class="ui-bar-a" data-spy="scroll-spy"
	data-target=".navbar" data-offset="50">

	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <a class="navbar-brand" href="#myPage"><img
				src="<c:url value="/resources/images/23.png"/>"></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#apartment">Available Apartments</a></li>
				<li><a href="#check" onclick="showotp();">Check OTP</a></li>
				<li><a href="#vacate_apt" onclick="show();">Vacate
						Apartment </a></li>
				<li><a href="../app/login">Sign Out</a></li>


			</ul>
		</div>
	</div>
	</nav>
	<script>
function refreshPage(){
    window.location.reload();
} 
</script>
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
		<h3>Dashboard</h3>
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
						<tr class='clickable-row' data-href='url://link-for-first-row/'>
							<td>${apartment.unit}</td>
							<td>${apartment.bhk}BHK</td>
							<td>
<!-- 								<div data-role="main" class="ui-content"> -->
<!-- 									<a href="#myPopup" data-rel="popup" -->
<!-- 										class="ui-btn ui-btn-inline ui-corner-all">Book</a> -->

<!-- 									<div data-role="popup" id="myPopup" class="ui-content" -->
<!-- 										style="min-width: 250px;"> -->
<!-- 										<div class="panel-body"> -->
<!-- 											<h3>Allocate Apartment</h3> -->

											<form name="ComplaintForm" action="/app/book"
												method="get">
												<%-- <input type="date" name="start"> <input type="date"
													name="end"> --%><input type="hidden" name="unit"
													value="${apartment.unit}">
 
												<button class="btn mini blue-stripe" type="submit"
													id="submit">Book</button>
											</form>
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
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
				<strong>Lease Aproval Request</strong>
			</p>
			<br>
			<table class="table table-striped table-hover table-users">
				<tbody>
					<c:forEach items="${leaseRequests}" var="leaseReq">
						<tr>
							<td>${leaseReq.unit}</td>
							<td>${leaseReq.extension_period}</td>
							<form name="LeaseRequestViewForm"
								action="/app/leaseApproval?name=${leaseReq.email}&unit=${leaseReq.unit}&month=${leaseReq.extension_period}&type=accept"
								method="POST">
							<td><button class="btn mini blue-stripe" type="submit"
									id="approve" value="${leaseReq.email}">Approve</button></td>
							</form>
							<form name="LeaseRequestViewForm"
								action="/app/leaseApproval?name=${leaseReq.email}&unit=${leaseReq.unit}&month=${leaseReq.extension_period}&type=reject"
								method="POST">
								<td><button class="btn mini blue-stripe" type="submit"
										id="reject" value="${leaseReq.email}">Reject</button></td>
							</form>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>



	<script type="text/javascript">
							 
							 	
							

							//$('window').scrollUp(function(){ $(#div).show() });

								$(document).ready(function() {

									$("#vacate_apt").hide();
									$("#check").hide();
								});
								function show() {
									$(vacate_apt).show();
									$('#vacate_apt').get(0).scrollIntoView()
								}
								function showotp(){
									$(check).show();
									$('#check').get(0).scrollIntoView()
								}
								function checkIt() {
									  if (confirm('Are you really sure you want to delete this apartment?')) {
										  vacate.submit();
									  }
									}
							</script>

	
	<div id="vacate_apt" class="container text-center">
		<form:form name="vacate" method="post" action="vacate.submit"
			modelAttribute="deleteApartmentBean">
			<div class="form-group">
				<div class="col-md-12 text-center">

					<div class="col-md-offset-3 col-md-6 text-center">
						<label for="type"> <font size="4" color="black">Select the Apartment Number:</font></label> 
					</div>
					<select name="vacate">
					    <c:forEach items="${occ_apartment}" var="apt">
							<option value="${apt.unit}">${apt.unit}</option>
						</c:forEach>
				   </select>
			</div>
			</div>
			<div class="col-md-offset-3 col-md-6 text-center"
				style="height: 75px;">
				<button class="btn btn-sm btn-success" type="submit" id="submit"  onclick="return checkIt()">Submit</button>
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



























