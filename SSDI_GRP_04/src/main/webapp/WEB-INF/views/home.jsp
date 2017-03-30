<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
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

</style>
<body>
<body id="myPage" data-spy="scroll" data-target=".navbar"
  data-offset="50">

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
          <li><a href="#myPage">HOME</a></li>
          <li><a href="apartment">Available Apartments</a></li>
          <li><a href="#contact">Contact</a></li>
          <li><a href="login">Login</a></li>
          <li><a href="signup">Sign Up!</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active" height="400">
        <img
          src="http://www.everyaptmapped.org/apartments/charlotte,north+carolina,nc/vista+park/vista+park+apartments+photo.jpg"
          alt="New York" width="1200" height="350">
        <div class="carousel-caption">
          <h3>UNCC Apartments</h3>
          <p>We offer the best amenities in Charlotte,NC.</p>
        </div>
      </div>

      <div class="item">
        <img
          src="https://inhabitat.com/nyc/wp-content/blogs.dir/2/files/2015/12/Heres-What-NYCs-first-micro-apartments-will-look-like-on-the-inside-Living-Area.jpg"
          alt="Chicago" width="1200" height="350">
        <div class="carousel-caption">
          <h3>Apartment</h3>
          <p>Fully Furnished Apartments, ready to move in!</p>
        </div>
      </div>

      <div class="item">
        <img
          src="http://liveashford.com/file/2016/01/Ashford-Green-Apartments-Exterior-Lake-700x400.jpg"
          alt="LHHH" width="1200" height="350">
        <div class="carousel-caption">
          <h3>Serene View</h3>
          <p>Apartments with beautiful views,all ready for you to move
            in!</p>
        </div>
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button"
      data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
      aria-hidden="true"></span> <span class="sr-only">Previous</span>
    </a> <a class="right carousel-control" href="#myCarousel" role="button"
      data-slide="next"> <span
      class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>

  <!-- More Information About the University -->
  <div id="band" class="container text-center">
    <h3>THE UNCC Apartments</h3>
    <p>
      <em>You live your dream here!</em>
    </p>
    <p>Ashford Green offers a wide variety of floor plans, from cozy one-bedroom apartments to spacious three-bedroom townhomes with attached garages. Each unit surrounds a central clubhouse with a stylish resort-style swimming pool with a generous sundeck. Other amenities include a fitness center, sports court, children's playground, and a BBQ grill/picnic area.<br>

Ashford Green is situated directly across from University of North Carolina's Charlotte Campus and is a short distance to other great locations like The Shoppes at University Place, Northlake Mall, and endless fine-dining options. Many of these great locations convene in Charlotte's Historic Arts District known as "NoDa".Here you'll find one-of-a-kind art collections, lively performance venues, and unique full service restaurants.<br>

With such breathtaking views, Ashford Green is the ideal off-campus apartments near UNC Charlotte.<br></p>
    <br>
  </div>

  <!-- Container (Contact Section) -->
  <div id="contact" class="container">
    <h3 class="text-center">Contact Us</h3>
    <p class="text-center">
      <em>Want to stay in our Appartments?</em>
    </p>

    <div class="row">
      <div class="col-md-4">
        <p>Contact Details</p>
        <p>
          <span class="glyphicon glyphicon-map-marker"></span>Charlotte, NC
        </p>
        <p>
          <span class="glyphicon glyphicon-phone"></span>Phone: +00
          1515151515
        </p>
        <p>
          <span class="glyphicon glyphicon-envelope"></span>Email:
          hhundiwala@gmail.com
        </p>
      </div>
      <div class="col-md-8">
        <div class="row">
          <div class="col-sm-6 form-group">
            <input class="form-control" id="name" name="name"
              placeholder="Name" type="text" required>
          </div>
          <div class="col-sm-6 form-group">
            <input class="form-control" id="email" name="email"
              placeholder="Email" type="email" required>
          </div>
        </div>
        <textarea class="form-control" id="comments" name="comments"
          placeholder="Comment" rows="5"></textarea>
        <br>
        <div class="row">
          <div class="col-md-12 form-group">
            <button class="btn pull-right" type="submit">Send</button>
          </div>
        </div>
      </div>
    </div>
    <br>
  </div>

</body>
</html>
