<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/31/21
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Employee</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<table class="table">

    <tr>
        <th scope="col">ID</th>
        <td>${employee.id}</td>
    </tr>
    <tr>
        <th scope="col">Name</th>
        <td>${employee.name}</td>
    </tr>
        <th scope="col">Contact Number</th>
        <td>${employee.contactNumber}</td>
    </tr>

</table>
</body>
</html>
