<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/15/21
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Manager Users</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h1>User Manager</h1>
<p>
    <a href="/users?action=create"><button name="action" value="create">Create New User</button></a>
</p>

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Country</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>

    </tr>
    </thead>
    <c:forEach items="${userList}" var="user">
    <tr>
        <td><c:out value="${user.getId()}"></c:out> </td>
        <td><c:out value="${user.getName()}"></c:out></td>
        <td><c:out value="${user.getEmail()}"></c:out></td>
        <td><c:out value="${user.getCountry()}"></c:out></td>
        <td><a href="/users?action=edit&id=${user.getId()}"><button type="button" class="btn btn-primary">Edit</button></a></td>
        <td><a href="/users?action=delete&id=${user.getId()}"><button type="button" class="btn btn-primary">Delete</button></a></td>
    </tr>
    </c:forEach>
    </tr>


</table>
</body>
</html>
