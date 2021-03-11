<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/11/21
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>
<body>
    <div class="container">
        <h3>Customer List</h3>
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th>Tên</th>
                <th>Ngày Sinh</th>
                <th>Địa Chỉ</th>
                <th></th>
            </tr>
        </thead>
            <tbody>
            <tr>
                <c:forEach items="${customerList}" var="customer">
                <td scope="row">${customer.name}</td>
                <td>${customer.dateOfBirth}</td>
                <td>${customer.address}</td>
                <td>
                        ${customer.image}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
