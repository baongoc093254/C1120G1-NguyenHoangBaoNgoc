<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/12/21
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Customer List</title>
</head>
<body>
<h1>Customer List</h1>
<p>
    <a href="/customers?action=create">Create new customer</a>
</p>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items='${requestScope["customers"]}' var="customer">
    <tr>
        <td><a href="/customers?action=view&id=${customer.getId()}">${customer.getName()}</a></td>
        <td>${customer.getEmail()}</td>
        <td>${customer.getAddress()}</td>
        <td><a href="/customers?action=edit&id=${customer.getId()}"><button type="button" class="btn btn-primary">Edit</button></a>
            </td>
        <td><a href="/customers?action=delete&id=${customer.getId()}"><button type="button" class="btn btn-danger btn-lg">Delete</button></a>
        </td>
    </tr>
    </c:forEach>
    </tr>

    </tbody>
</table>


</body>
</html>
