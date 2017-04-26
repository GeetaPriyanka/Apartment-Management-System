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
<title>Staff Home Page</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
body {
  font: 400 15px/1.8 Lato, sans-serif;
  color: #777;
}

h3, h4 {
  margin: 10px 0 30px 0;
  letter-spacing: 1px;
  font-size: 20px;
  color: #111;
   text-align: center;
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

</style>
<script>
     var time = new Date().getTime();

     function refresh() {
         if(new Date().getTime() - time >= 10000) 
             window.location.reload(true);
         else 
             setTimeout(refresh, 10000);
     }

     setTimeout(refresh, 10000);
</script>
<body>


<div class="container">
  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
          data-target="#myNavbar">
          <span class="icon-bar"></span> <span class="icon-bar"></span> <span
            class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#myPage">UNCC Apartments</a>
      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav navbar-right">
                  <li><a href="pastReq">Past Resolved Requests</a></li>
          		  <li><a href="../">Sign Out</a></li>
        </ul>
      </div>
    </div>
  </nav>
</div>
<br>
<br>
 <h3>All Pending Request</h3>
                   <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                            <h3 id="myModalLabel">Delete</h3>
                        </div>
                        <div class="modal-body">
                            <p></p>
                        </div>
                        <div class="modal-footer">
                            <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                            <button data-dismiss="modal" class="btn red" id="btnYes">Confirm</button>
                        </div>
   </div><table class="table table-striped table-hover table-users">
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
					<td >${complaintout.complaint_number}</td>
					<td >${complaintout.unit}</td>
					<td >${complaintout.type}</td>
					<td >${complaintout.severity}</td>
				    <td >${complaintout.description}</td>	
				    <td >${complaintout.time}</td>		    
				    <td><form name="ComplaintForm" action="/app/complain_res" method="get">
				    <input type="hidden" name="complaint_id" value="${complaintout.complaint_number}">
				    <input type="hidden" name="user" value="${user.email}">
				    
					<button class="btn mini blue-stripe" type="submit" id="submit">Resolve</button>
					</form></td>
				</tr>
			</c:forEach>
	               </tbody>
    		</table>
</body>
</html>