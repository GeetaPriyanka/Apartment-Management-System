<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>welcome</title>
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
.btn{
    margin: 4px;
    box-shadow: 1px 1px 5px #888888;
    
}
p.message{
color:green;
font-size:18px;
  text-align: center;

}

.column-left{ float: left; width: 33%;
    border: 1px solid #e6e6e6;
    box-sizing: border-box;}
.column-right{ float: right; width: 34%; 
    border: 1px solid #e6e6e6;
    box-sizing: border-box;}
.column-center{ display: inline-block; width: 33%;  
    border: 1px solid #e6e6e6;
    box-sizing: border-box;}

.myButton{
    background:url(./images/request.png) no-repeat;
    cursor:pointer;
    border:none;
    width:200px;
    height:200px;
}

.myButton:active {
     background:url(./images/but2.png) no-repeat;
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
<body id="myPage" data-spy="scroll" data-target=".navbar"
  data-offset="50">
<c:if test="${!empty user}">
  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
          data-target="#myNavbar">
          <span class="icon-bar"></span> <span class="icon-bar"></span> <span
            class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#myPage"><img src="<c:url value="/resources/images/23.png"/>"></a>
      </div>
      
      <script type="text/javascript">
      function hide(){
    	  $("#renew_lease").hide();
      }
      function hide1(){
    	  $("1").hide();
      }

  
      </script>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#myPage" onclick="hide()">HOME</a></li>
           <li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-fw fa-bell-o"></i>Profile</span></a>
					<ul class="dropdown-menu" role="menu">
					<h4><li><a href="#">${user.name}</a></li></h4>	
						<li><a href="#">${user.name}</a></li>
						<li><a href="#">Apt #${user.unit}</a></li>
						<li><a href="#">Javascript</a></li>
					</ul>
				</li>
            <li><a href="../app/login">Sign Out</a></li>
        </ul>
      </div>
    </div>
  </nav>
  <br>
  <br>
  <!-- retrieving user details -->
  
<div class="row">
<div class="col-md-11 text-right" style="margin-right:10px;" > <h3> Welcome, ${user.name}</h3></div>
</div>
<div class="row">
<div class="col-md-5"> <font  size="4">Your Unit number : ${user.unit} </font>
</div>
 
 <div class="col-md-4 ">
  <font  size="4"    > Lease start:${user.lease_start} </font>  </div>
   <div class="col-md-3 pull-right ">    
   <font  size="4"> Lease end :${user.lease_end} </font>  
 </div> 
 <c:if test="${!empty result}">
							<p class="message">${result}</p>
						</c:if>
 </div>
<%--  <h5>Welcome ${user.name},${user.lease_start},${user.lease_end},${user.unit},${user.email} </h5> --%>
 <br>
		<div class="container text-center" id="nter">
			<div class="row">
				<div class="col-sm-6">
					<p>
						<strong><font  size="4">Maintenance Request</font></strong>
					</p>
					<br>
					<form name="ComplaintForm" action="complaint" method="post">
					<input type="image" src="<c:url value="/resources/images/request.png"/>" width="60%" />
					</form>
						<br>
					<p> Have a problem in your apartment?<br><br> Log a maintenance request here and get it resolved within 2 days. </p>
				</div>
				<script type="text/javascript">
				$(document).ready(function(){
					
						
					   $("#renew_lease").hide();
					
				});
				function show(){
					$(renew_lease).show();
				}
				</script>
				<div class="col-sm-6" >
					<p>
						<strong><font  size="4">Renew Lease</font></strong>
					</p>
					<br> <a href = "#renew_lease">
					<input type="image"  src="<c:url value="/resources/images/ren.png"/>" width="60%" onclick="show();hide1()"/></a>
						<br>
							<p> Like our Apartments?<br><br> Extend your stay by lodging Lease renewal request. </p>
				</div>
			</div>
		</div>
		
	</c:if>
	
		<form:form name="RenewLeaseForm" method="post" action="renewlease"
			modelAttribute="RenewLeaseBean" onsubmit="putTime(this)" commandName="renewleasereq">
	 <div id="renew_lease" class="container text-center">
    <h3>Want to Renew Lease?</h3>
    <p>
      <em>You live your dream here!</em>
    </p>
              		<div class="btn-group">
					<label for="renewlease" class="radio-inline"> <input
						type="radio" name="extension_period" value="3"> <font size="4"
						color="black"> 3 Months</font>
						
					</label> <label for="renewlease" class="radio-inline"> <input
						type="radio" name="extension_period" value="9"> <font size="4"
						color="black"> 9 Months </font>
					</label> <label for="renewlease" class="radio-inline"> <input
						type="radio" name="extension_period" value="12"> <font size="4"
						color="black"> 12 Months </font>
					</label>
				</div>
                        <div style="padding:20px;" >
                         <button type="submit" name=" class="btn btn-hot text-uppercase text-center" >Request</a></button></div>
  </div></form:form>
<script>
function submitForm() {
    document.getElementById("envselection").submit();
}
</script>
</body>
</html>