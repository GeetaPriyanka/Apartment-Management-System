<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>welcome</title>
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
</head>
<style>
body {
	font: 400 15px/1.8 Lato, sans-serif;
	color: #777;
	background-image:
		url("http://eskipaper.com/images/blurred-3.jpg");
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
	height:200px;
	margin-top: 40px;
	}

.button{
margin-top: 40px;
}

.column-left {
	float: left;
	width: 33%;
	border: 1px solid #e6e6e6;
	box-sizing: border-box;
}

.column-right {
	float: right;
	width: 34%;
	border: 1px solid #e6e6e6;
	box-sizing: border-box;
}

.column-center {
	display: inline-block;
	width: 33%;
	border: 1px solid #e6e6e6;
	box-sizing: border-box;
}
.container1{
text-aligm
}
.panel{
width:600px;
height: 500px;
position:relative;
left: 710px;

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
  .panel-transparent {
        background: none;
    }

    .panel-transparent .panel-heading{
        background: rgba(122, 130, 136, 0.2)!important;
    }

    .panel-transparent .panel-body{
        background: rgba(46, 51, 56, 0.2)!important;
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
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="./welcome">HOME</a></li>
					<li><a href="#contact">Contact</a></li>
					<li><a href="../home">Sign Out</a></li>
				</ul>
			</div>
		</div>
		</nav>
		
		
		<!-- NavBar section ends here -->
		<br>
		<br>
		
		
		<!-- retrieving user details (form starts here) -->
		<div class="row">
			<div class="col-md-10 text-right" style="height: 50px;">
				<h3> Welcome </h3>
			</div>
			<div class="col-md-13" style="height: 50px;">
				<label><h3> ${user.name} <h3>
				</label>
			</div>
		</div>
			<div class="panel panel-deafault panel-transparent">
		<div class="panel-heading">
		<div class="row">
			<div class="col-md-12 text-center" style="height: 50px;">
				<label> <h3> COMPLAINT FORM
				</h3></label>
			</div></div>
		</div>
		
	<div class="panel-body">

		<form:form name="ComplaintForm" method="post"
			onsubmit="putTime(this);" action="complaint.submit"
			modelAttribute="ComplaintBean" commandName="complaint">
			<div class="col-md-12 text-center" style="height: 75px;">

				<label for="type"> <font size="4" color="black">Select
						the complaint type:</font></label> <select name="type">
					<option value="Plumbing">Plumbing</option>
					<option value="Electrical">Electrical</option>
					<option value="Carpentry">Carpentry</option>
					<option value="other">Other</option>
				</select>
</div><div class="col-md-12 text-center">
				<label for="sev"> <font size="4" color="black">Select
						the severity: </font>
				</label>
				<div class="btn-group">
					<label for="severity" class="radio-inline"> <input
						type="radio" name="severity" value="2"> <font size="4"
						color="black"> High</font>
					</label> <label for="severity" class="radio-inline"> <input
						type="radio" name="severity" value="1"> <font size="4"
						color="black"> Medium </font>
					</label> <label for="severity" class="radio-inline"> <input
						type="radio" name="severity" value="0"> <font size="4"
						color="black"> Low </font>
					</label>
				</div>

			</div>
			<div class="col-md-12 text-center" style="height: 150px;">
				<div class="form-group">
				
					<textarea name="description" placeholder="Enter the complaint description here" class="form-control" rows="5"
						id="comment"></textarea>
				</div>
			</div>

			<div class="col-md-offset-3 col-md-6 text-center"
				style="height: 100px;">
				<input type="submit" class="button" name="Submit" value="Submit">
			</div>
		</form:form>
		</div></div>
		<script>
		 var unit=${user.unit} 
		 
		var putDate = function(ComplaintForm) {
  form.date.value = new Date().toString();
  
};

</script>
		<script>
	    function updatesev() {

		  var severity = document.getElementsByName('severity');
		  var sev_value;
		  for(var i = 0; i < rates.length; i++){
		      if(severity[i].checked){
		          sev_value = severity[i].value;
		      }
		      return sev_value;
		  }

		  </script>
		<script type="text/javascript">
	  function validate(ComplaintForm){
	
		  var username = form.username.value;
		  var password = form.password.value;
		  form.username.style.borderColor="#ccc";
		  form.password.style.borderColor="#ccc";
		  var obj1 = form.getElementById('desc');
		  ErrorText= ""; 
		  if ( form.comp.selectedIndex == 0 ) { alert ( "Please select the complaint_type" ); return false; } 
	  	  else if ( ( form.optradio[0].checked == false ) && ( form.optradio[1].checked == false )&&(form.optradio[0].checked == false) ) { alert ( "Please choose severity" ); return false; }
	  	  else if(trimfield(obj1.value) == '') 
		         {      
		              alert("Please Provide complaint description!");
		              obj1.focus();
		              return false;       
		         }
	  	  else
	  		  {
	  		   alert("Your complaint has been submitted");
	  		  form.submit() ;
	  		  }
	  		  } }
	  </script>
	</c:if>
</body>
</html>