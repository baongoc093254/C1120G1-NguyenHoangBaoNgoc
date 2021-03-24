<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/19/21
  Time: 00:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Customer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../assert/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../assert/fontawesome/css/all.min.css" type="text/css">

</head>
<body onload="myFunction('${message}')">
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
    <a class="navbar-brand" href="home"><i class="fas fa-home"></i></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
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
<!-- body /-->
<div>
    <form method="post">
            <table class="table table-hover">
                <tr>
                    <td>Id:</td>
                    <td><input type="text" name="customer_id" placeholder="Enter ID"></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="customer_name"  placeholder="Enter Full Name"></td>
                </tr>
                <tr>
                    <td>Birth Day:</td>
                    <td><input type="text" name="customer_birthday"  placeholder="yyyy/mm/dd"></td>
                </tr>
                <tr>
                    <td>Gender:</td>
                    <td>
                        <select name="customer_gender" id="customer_gender">
                            <option value="1">Male</option>
                            <option value="2">Female</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Id Card:</td>
                    <td><input type="text" name="customer_id_card"  placeholder="XXXXXXXXX"></td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><input type="text" name="customer_phone"  placeholder="Enter your phone number"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="customer_email"  placeholder="Enter your mail"></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" name="customer_address"  placeholder="Enter your Country"></td>
                </tr>
                <tr>
                    <td>Customer Type:</td>
                    <td>
                        <select id="customer_type_id" name="customer_type_id">
                            <option value="1">Diamond</option>
                            <option value="2">Platinum</option>
                            <option value="3">Gold</option>
                            <option value="4">Silver</option>
                            <option value="5">Member</option>
                        </select>
                    </td>

                </tr>

                <tr>
                    <td colspan="2" align="centre">
                        <button type="submit" name="action" value="create" class="btn btn-success">Save</button>
                    </td>
                </tr>
            </table>
    </form>

</div>



<!-- footer /-->
<div class="jumbotron text-center" style="margin-bottom:0">
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
            <a class="text-white" href="https://mdbootstrap.com/">MDBootstrap.com</a>
        </div>
        <!-- Copyright -->
    </footer>
</div>

</body>
</html>
<%--<div class="modal" tabindex="-1" role="dialog">--%>
<%--    <div class="modal-dialog" role="document">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h5 class="modal-title">Modal title</h5>--%>
<%--                <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                    <span aria-hidden="true">&times;</span>--%>
<%--                </button>--%>
<%--            </div>--%>
<%--            <div class="modal-body">--%>
<%--                <p>Modal body text goes here.</p>--%>

<%--            </div>--%>
<%--            <div class="modal-footer">--%>
<%--                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                <button type="button" class="btn btn-primary">Save changes</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
