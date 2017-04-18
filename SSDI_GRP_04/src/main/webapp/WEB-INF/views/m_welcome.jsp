<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UNCC Apartments</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-aria.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-messages.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.js"></script>
  	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head><style>
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
  letter-spacing: 4px;
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

jQuery(document).ready(function($) {
    $(".clickable-row").click(function() {
        window.location = $(this).data("href");
    });
});
</style>
<body>

<body id="apartment" data-spy="scroll" data-target=".navbar"
  data-offset="50">

  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-header">
          <span class="icon-bar"></span> <span class="icon-bar"></span> <span
            class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#myPage">UNCC Apartments</a>
      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="../app">HOME</a></li>
          <li><a href="#apartment">Available Apartments</a></li>
          <li><a href="login">Login</a></li>
          <li><a href="signup">Sign Up!</a></li>
        </ul>
      </div>
    </div>
  </nav>

<br>
<br>

<c:if test="${!empty otp}">
<p>Generated OTP is : ${otp}</p>
</c:if>

<div class="container text-center">
  <h3>Dashoard</h3>
  <br>
  <div class="row">
    <div class="col-sm-4">
      <p><strong>Available Apartments</strong></p><br>
		<table class="table table-striped table-hover table-users">
    			<thead>
    				<tr>
    					
    				
    					<th class="hidden-phone">&nbsp;&nbsp;&nbsp;&nbsp;Unit</th>
    					<th class="hidden-phone">&nbsp;&nbsp;&nbsp;&nbsp;BHK</th>
    					<th></th>
    				</tr>
    			</thead>

    			<tbody>

						<c:forEach items="${listapartment}" var="apartment">
							<tr class='clickable-row' data-href='url://link-for-first-row/'>
								<td>${apartment.unit}</td>
								<td>${apartment.bhk}BHK</td>
							</tr>
						</c:forEach>
					</tbody>
    		</table>
    </div>
    &nbsp;&nbsp;
&nbsp;&nbsp;    <div class="col-sm-4">
      <p><strong>Complaints that breached SLA</strong></p><br>
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
					<td >${complaintout.type}</td>
					<td >${complaintout.severity}</td>
				    <td >${complaintout.description}</td>	
				    <td >${complaintout.time}</td>		    
					</form></td>
				</tr>
			</c:forEach>
	               </tbody>
    		</table>
      
    </div>
    <div class="col-sm-4">
      <p><strong>Notifications</strong></p><br>
    </div>
  </div>
</div>


</body>
</html>

<%-- 
		<td>
								<div data-role="main" class="ui-content">
									<a href="#myPopup" data-rel="popup"
										class="ui-btn ui-btn-inline ui-corner-all">Allocate
										Apartment</a>

									<div data-role="popup" id="myPopup" class="ui-content"
										style="min-width: 250px;">
										<form:form name="AllocateForm" action="allocate" method="post"
											modelAttribute="allocateBean">
											<h3>Lease Details</h3>
         Lease Start Date:
                <form:input class="form-control" type="date" id="start"
												name="start" path="start" placeholder="Start Date" />
         Lease End Date:       
                <form:input class="form-control" type="date" id="end"
												name="end" path="end" placeholder="End Date" />
											<form:input class="form-control" type="hidden" name="user"
												path="unit" value="${apartment.unit}" />
											<button class="form-control" type="submit" id="submit">Book</button>
										</form:form>
									
									</div>
							</td> --%>