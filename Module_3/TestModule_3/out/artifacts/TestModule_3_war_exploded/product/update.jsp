<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/22/21
  Time: 09:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Update information Customer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../assert/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../assert/fontawesome/css/all.min.css" type="text/css">
</head>
<body>
<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>Furama Resort</h1>
    <div class="row" >
        <div class="col-auto col-sm-5 col-lg-6 d-flex align-items-center">
            <a href="home">
            <img src="https://nhanlucnganhluat.vn/uploads/images/051D288B/logo/2018-12/Logo-FURAMA-RESORT.jpg" alt="logo" class="img-fluid" width="100" height="200">
            </a>
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
            <tr hidden>
                <td>Id:</td>
                <td><input type="text" name="customer_id"  value="${customer.getCustomer_id()}"></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="customer_name"  value="${customer.getCustomer_name()}"></td>
            </tr>
            <tr>
                <td>Birth Day:</td>
                <td><input type="text" name="customer_birthday"  value="${customer.getCustomer_birthday()}"></td>
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
                <td><input type="text" name="customer_id_card"  value="${customer.getCustomer_id_card()}"></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="text" name="customer_phone"  value="${customer.getCustomer_phone()}"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="customer_email"  value="${customer.getCustomer_email()}"></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="customer_address"  value="${customer.getCustomer_address()}"></td>
            </tr>
            <tr>
                <td>Customer Type:</td>
                <select>
                    <option value="1">Diamond</option>
                    <option value="2">Platinum</option>
                    <option value="3">Gold</option>
                    <option value="4">Silver</option>
                    <option value="5">Member</option>
                </select>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <button type="submit" name="action" value="update" class="btn btn-success">Save</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
