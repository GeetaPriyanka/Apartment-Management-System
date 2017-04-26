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
  font-family: 'oswald', sans-serif;
  margin-bottom: 0;
  background-color: #2d2d30;
  border: 0;
  font-size: 14px !important;
  font-family: verdana;
  opacity: 0.9;
}
.ui-page-theme-a a, html .ui-bar-a a, html .ui-body-a a, html body .ui-group-theme-a a{
text-shadow:0 0 0;
font-weight:normal;
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
  margin-left:40px;
}

</style>
<body>

<body id="apartment" class="ui-bar-a" data-spy="scroll" data-target=".navbar"
  data-offset="50">

  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="#myPage"><img src="<c:url value="/resources/images/23.png"/>"></a>

      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="../app/">HOME</a></li>
          <li><a href="#apartment">Available Apartments</a></li>
          <li><a href="/app/login">Login</a></li>
          <li><a href="signup">Sign Up!</a></li>
          
        </ul>
      </div>
    </div>
  </nav>

<br>
<br>

<div class="container text-center">
  <h3>Our different Layouts</h3>
  <br>
  <div class="row">
    <div class="col-sm-4">
      <p><strong>3 - BHK Augusta</strong></p><br>
      <img src="<c:url value="/resources/images/baltimore.jpg"/>" alt="Random Name" width="255" height="255">
    </div>
    <div class="col-sm-4">
      <p><strong>2 - BHK Davidson</strong></p><br>
      <img src="<c:url value="/resources/images/moremore.jpg"/>" alt="Random Name" width="255" height="255">
    </div>
    <div class="col-sm-4">
      <p><strong>Villa Supreme</strong></p><br>
      <img src="<c:url value="/resources/images/Miltimore.png"/>" alt="Random Name" width="255" height="255">
    </div>
  </div>
</div>
<h3>Your Future Apartment</h3>
<c:if test="${!empty listApartments}">

 <table class="table table-striped table-hover table-users">
    			<thead>
    				<tr>
    					<th class="hidden-phone">Floor Plan</th>
    					<th class="hidden-phone">Unit Number</th>
    					<th></th>
    				</tr>
    			</thead>

    			<tbody>
		<c:forEach items="${listApartments}" var="apartment">
				<tr>
						<td>
							<div id="pageone" data-role="main" class="ui-content">
								<c:if test="${apartment.bhk==2}">
									<div id="pageone" data-role="main" class="ui-content">
										<a href="#myPopup" data-rel="popup" data-position-to="window">
											<img src="<c:url value="/resources/images/moremore.jpg"/>"
											alt="Skaret View" style="width: 200px;">
										</a>

										<div data-role="popup" id="myPopup">
											<a href="#pageone" data-rel="back"
												class="ui-btn ui-corner-all ui-shadow ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right">Close</a><img
												src="<c:url value="/resources/images/moremore.jpg"/>"
												style="width: 800px; height: 400px;" alt="Skaret View">
										</div>
									</div>
								</c:if>
								<c:if test="${apartment.bhk==3}">
									<div id="pageone" data-role="main" class="ui-content">
										<a href="#myPopup" data-rel="popup" data-position-to="window">
											<img src="<c:url value="/resources/images/moremore.jpg"/>"
											alt="Skaret View" style="width: 200px;">
										</a>

										<div data-role="popup" id="myPopup">
											<a href="#pageone" data-rel="back"
												class="ui-btn ui-corner-all ui-shadow ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right">Close</a><img
												src="<c:url value="/resources/images/moremore.jpg"/>"
												style="width: 800px; height: 400px;" alt="Skaret View">
										</div>
									</div>
								</c:if>
						</td>
						<td>${apartment.unit}
						<br><P>Floor Area : ${apartment.area } sq. ft</P>
						<P>Rent From : $${apartment.rent }</P>
						<P>Deposit : $250</P>
						<P>Available : Now</P>
						<P>Bedrooms : ${apartment.bhk}</P>
						<P>Baths : 2</P>
						<p>This is a ${apartment.bhk}BHK apartment perfect for your family.This apartment is currently available.Hurry up! </p>
						</td>	    
				    <td><form name="ComplaintForm" action="/app/complain_res" method="get">
				    <input type="hidden" name="complaint_id" value="${complaintout.complaint_number}">
				    <input type="hidden" name="user" value="${user.email}">
				    
					<!-- <button class="btn mini blue-stripe" type="submit" id="submit">Resolve</button> -->
					</form></td>
				</tr>
			</c:forEach>
	               </tbody>
    		</table>
    		 <div data-role="popup" id="myPopup">
      <p>This is my picture!</p> 
      <a href="#pageone" data-rel="back" class="ui-btn ui-corner-all ui-shadow ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right">Close</a><img src="<c:url value="/resources/images/moremore.jpg"/>" style="width:800px;height:400px;" alt="Skaret View">
    </div>
<%-- 	<table border="1">
		<tr>
			<th width="80">Unit</th>
			<th width="120">rent</th>
			<th width="120">Area</th>
			<th width="120">BHK</th>
		</tr>
		<c:forEach items="${listApartments}" var="apartment">
			<tr>
				<td>${apartment.unit}</td>
				<td>${apartment.rent}</td>
				<td>${apartment.area}</td>
				<td>${apartment.bhk}</td>
			</tr>
		</c:forEach> 
	</table>--%>
</c:if>

 <div id="band" class="main-content-container container totalbusiness-item-start-content">
    <p>
      <em>You live your dream here!</em>
    </p>
    <p>Restricted Pet Breeds:<br>
The following breed restrictions include dogs that are known to be aggressive toward strangers 
and/or children, or to be destructive in indoor environments. Pets that contain a mix of any of the breeds
 listed below are not permitted.<br></p>
 <ul style="list-style-type:circle">
  <li>American Bulldog</li>
  <li>American Pit Bull Terrier</li>
  <li>American Staffordshire Terrier</li>
  <li>Bull Terrier</li>
  <li>Rottweiler</li>
   <li>Staffordshire Bull Terrier</li>
  <li>Chow-Chow</li>
</ul>  
    <br>
  </div>


</body>
</html>