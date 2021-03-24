<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/18/21
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <meta charset="UTF-8">
  <title>Furama Resort</title>
  <meta name="viewport" content="width=dth, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="assert/css/bootstrap.min.css" type="text/css">
  <link rel="stylesheet" href="assert/fontawesome/css/all.min.css" type="text/css">
  <style>
    .carousel-inner img {
      width: 100%; /* Set width to 100% */
      margin: fill;
      height:500px;
    }

  </style>

</head>
<body>
<!-- header /-->
<div class="jumbotron text-center" style="margin-bottom:0">
  <h1>Furama Resort</h1>
  <div class="row" >
    <div class="col-sm-3">
      <a href="home">
      <img src="https://nhanlucnganhluat.vn/uploads/images/051D288B/logo/2018-12/Logo-FURAMA-RESORT.jpg" alt="logo" class="img-fluid" width="100" height="200">
      </a>
    </div>
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
      <h3 class="float-right" style="display:inline;">Nguyen Hoang Bao Ngoc</h3>
    </div>


  </div>


</div>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"><i class="fas fa-home"></i></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Employee</a>
      </li>

      <li class="nav-item">
        <a class="nav-link" href="/customer">Customer</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Service</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Contract</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="action" value="search">Search</button>
    </form>
  </div>
</nav>

<!-- body  /-->
<div id="demo" class="carousel slide" data-ride="carousel">

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>

  <!-- The slideshow -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="https://furama-booking.com/wp-content/uploads/2018/09/furama-da-nang-850x638.jpg" alt="Image">


    </div>
    <div class="carousel-item">
      <img src="https://ik.imagekit.io/tvlk/apr-asset/dgXfoyh24ryQLRcGq00cIdKHRmotrWLNlvG-TxlcLxGkiDwaUSggleJNPRgIHCX6/hotel/asset/10021706-1024x683-FIT_AND_TRIM-3063645f42ce029994018dc24e25469a.jpeg?tr=q-40,c-at_max,w-740,h-500&_src=imagekit" alt="Image">

    </div>
    <div class="carousel-item">
      <img src="https://pix10.agoda.net/hotelImages/1603126/-1/4dae861b789ad4af907194fc9f163983.jpg?s=1024x768" alt="Image">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>

</div>


<div class="container" style="margin-top:30px">
  <div class="row">
    <div class="col-sm-4">
      <ul class="nav nav-pills flex-column">
        <li class="nav-item">
          <a class="nav-link active" href="#">Active</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#">Disabled</a>
        </li>
      </ul>
      <hr class="d-sm-none">
    </div>
    <div class="col-sm-8">
      <h2>THIS WORLD CLASS RESORT, FURAMA DANANG, REPUTABLE FOR BEING A CULINARY RESORT IN VIETNAM</h2>
      <h5>Title description, Mar 18, 2021</h5>
      <div class="fakeimg"></div>
      <p>Some text..</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
      <br>
      <h2>TITLE HEADING</h2>
      <h5>Title description, Sep 2, 2017</h5>
      <div class="fakeimg">Fake Image</div>
      <p>Some text..</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
    </div>
  </div>
</div>
<!-- footer /-->
<div class="footer-left" style="margin-bottom:0">
  <footer class="bg-dark text-center text-white">
    <!-- Grid container -->
    <div class="container p-4 pb-0">
      <!-- Section: Social media -->
      <section class="mb-4">
        <!-- Facebook -->
        <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
        ><i class="fab fa-facebook-f"></i
        ></a>

        <!-- Twitter -->
        <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
        ><i class="fab fa-twitter"></i
        ></a>

        <!-- Google -->
        <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
        ><i class="fab fa-google"></i
        ></a>

        <!-- Instagram -->
        <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
        ><i class="fab fa-instagram"></i
        ></a>

        <!-- Linkedin -->
        <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
        ><i class="fab fa-linkedin-in"></i
        ></a>

        <!-- Github -->
        <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
        ><i class="fab fa-github"></i
        ></a>
      </section>
      <!-- Section: Social media -->
    </div>
    <!-- Grid container -->

    <!-- Copyright -->
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
      © 2020 Copyright:
      <a class="text-white" href="https://mdbootstrap.com/">Bao Ngoc</a>
    </div>
    <!-- Copyright -->
  </footer>
</div>
<script src="style/js/jquery.min.js"></script>
<script src="style/js/popper.min.js"></script>
<script src="style/js/bootstrap.min.js"></script>
</body>
</html>
