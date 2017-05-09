<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	  <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>
	  <link rel="stylesheet" href="${animateCSS}">	
	  <link rel="stylesheet" href="${styleCSS }">
	  

	 
	  
	  <!-- CSS Style code -->
 <style type="text/css">
        body {
  font: Lato, sans-serif;
  color: #777;
     background: url(http://www.maac.com/~/media/images/properties/north-carolina/charlotte/colonial-grand-at-university-center/slides/3cg-university-center---clubhouse.ashx) no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}


h3, h4 {
  margin: 10px 0 30px 0;
font-family: "Trebuchet MS", Helvetica, sans-serif;
  font-size: 25px;
  color: #111;
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
.panel{
width:500px;
align:center;
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
p.error{
color:red;
font-size:18px;
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
.btn{min-width:250px;}
</style>
	
<title>Sign up</title>
<script type="text/javascript">
	  function validate(){
		  var x = document.forms["SignupForm"]["firstname"].value;
		    if (x == "") {
		    	alert("FirstName Blank");
		    	return false;
		    }
		    var y = document.forms["SignupForm"]["lastname"].value;
		    if (y == "") {
		    	alert("password Blank");
		    	return false;
		    }
		    var a = document.forms["SignupForm"]["email"].value;
		    var atpos = a.indexOf("@");
	        var dotpos = a.lastIndexOf(".");
		    if (a == "") {
		    	alert("email Blank");
		    	return false;
		    }
		    var z = document.forms["SignupForm"]["password"].value;
		    if (z == "") {
		    	alert("password Blank");
		    	return false;
		    }
		    var o = document.forms["SignupForm"]["otp"].value;
		    if (o == "") {
		    	alert("OTP Blank");
		    	return false;
		    }
	  }
	  </script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar"
  data-offset="50">
<div class="container" >
  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
          data-target="#myNavbar">
          <span class="icon-bar"></span> <span class="icon-bar"></span> <span
            class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="../app"><img src="<c:url value="/resources/images/23.png"/>"></a>
      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="./">HOME</a></li>
          <li><a href="apartment">Available Apartments</a></li>
          <li><a href="./#contact">Contact</a></li>
          <li><a href="login">Login</a></li>
        </ul>
      </div>
    </div>
  </nav>

<br>
<br>
		<div class="col-md-12" style="margin-top:120px">
			<div class="row centered-form">
				<div class="col-md-8 col-md-offset-3">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Sign Up!</h3>
							<c:if test="${!empty SignUpmessage}">
							<p class="error">${SignUpmessage}</p>
						</c:if>
						</div>
						<div class="panel-body">
							<form:form name="SignupForm" method="post"
								onsubmit="return validate();" action="signup.submit"
								modelAttribute="signupBean">

								<div class="row">
									<div class="col-xs-10 col-sm-10 col-md-12">
										<div class="form-group">
											<form:input type="text" id="firstname" name="firstname"
												path="firstname" class="form-control input-sm"
												placeholder="First Name" />
										</div>
									</div>
									<div class="col-xs-10 col-sm-10 col-md-12">
										<div class="form-group">
											<form:input type="text" id="lastname" name="lastname"
												path="lastname" class="form-control input-sm"
												placeholder="Last Name" />
										</div>
									</div>
									<div class="col-xs-10 col-sm-10 col-md-12">
										<div class="form-group">
											<form:input type="text" id="email" name="email" path="email"
												class="form-control input-sm" placeholder="Email Address" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-10 col-sm-10 col-md-12">
										<div class="form-group">
											<form:input type="password" name="password" id="password"
												path="password" class="form-control input-sm"
												placeholder="Password" />
										</div>
									</div>
									<div class="col-xs-10 col-sm-10 col-md-12">
										<div class="form-group">
											<form:input type="text" id="otp" name="otp" path="otp"
												class="form-control input-sm" placeholder="OTP" />
											<p>*One time password provided by Leasing office!</p>
										</div>
									</div>
								</div>

	
								<div class="col-xs-10 col-sm-10 col-md-10">
									<button type="submit" value="Register"
										class="btn btn-info btn-block">Sign Up</button>

								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	
		<script type="text/javascript">
		  document.getElementById('test').innerHTML=" verifying!!";
		</script>
	<script type="text/javascript">
	  function validate11(form){
		  var firstname = form.firstname.value;
		  var lastname = form.lastname.value;
		  var email = form.email.value;
		  var password = form.password.value;
		  var otp = form.otp.value;
		  form.firstname.style.borderColor="#ccc";
		  form.lastname.style.borderColor="#ccc";
		  form.email.style.borderColor="#ccc";
		  form.password.style.borderColor="#ccc";
		  form.otp.style.borderColor="#ccc";
		  if(firstname==""){
		  	//alert("Error!!");
		  	form.firstname.focus();
		  	form.firstname.style.borderColor="red";
		  	form.firstname.style.borderStyle="solid";
		  	document.getElementById('ErrorMessage').innerHTML="firstname Blank!!";
		  	return false;
		  	
		  }
		  else if(lastname==""){
		  	form.lastname.focus();
		  	form.lastname.style.borderColor="red";
		  	form.lastname.style.borderStyle="solid";
		  	document.getElementById('ErrorMessage').innerHTML="lastname Blank!!";
		  	return false;
		  }
		  else if(email==""){
			  	form.email.focus();
			  	form.email.style.borderColor="red";
			  	form.email.style.borderStyle="solid";
			  	document.getElementById('ErrorMessage').innerHTML="email Blank!!";
			  	return false;
			  }
		  else if(password==""){
			  	form.password.focus();
			  	form.password.style.borderColor="red";
			  	form.password.style.borderStyle="solid";
			  	document.getElementById('ErrorMessage').innerHTML="Password Blank!!";
			  	return false;
			  }
		  else if(otp==""){
			  	form.otp.focus();
			  	form.otp.style.borderColor="red";
			  	form.otp.style.borderStyle="solid";
			  	document.getElementById('ErrorMessage').innerHTML="otp Blank!!";
			  	return false;
			  }
		 
	  }
	  </script>
</div>

</body>
</html>