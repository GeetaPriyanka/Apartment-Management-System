<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style type="text/css">
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


</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <a class="navbar-brand" href="#myPage"><img
				src="<c:url value="/resources/images/23.png"/>"></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">

		</div>
	</div>
	</nav>
	
<c:if test="${!empty unit}">
	 <div id="band" class="container text-center">
				<p class="otp">Booking for unit ${unit}</p>
				
				<form name="ComplaintForm" action="/app/allocates"
												method="get">
											 <div class="row col-xs-10 col-sm-10 col-md-12">
											 <p><b>Start Date </b></p><input type="date" name="start"> 
											 <br/>
											 <p><b>End Date </b></p><input type="date"
													name="end"> </div>
													<br/>
													<div class="col-xs-10 col-sm-10 col-md-12">
													<input type="hidden" name="unit"
													value="${unit}">
 </div>
												<button class="btn mini blue-stripe" type="submit"
													id="submit">Book</button>
											</form>
	</div>
	</c:if>
	
</body>
</html>