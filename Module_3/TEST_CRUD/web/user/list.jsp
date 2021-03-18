<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/17/21
  Time: 08:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
          integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
          crossorigin="anonymous">
</head>

<body>
<h1>User Management</h1>

<nav class="navbar navbar-light bg-light justify-content-between">
    <a href="/users?action=create"><button class="btn btn-success" name="action" value="create">Create New User</button></a>
    <a class="navbar-brand"></a>
    <form class="form-inline">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
</nav>
<%--<p>--%>
<%--    <a href="/users?action=create"><button class="btn btn-success" name="action" value="create">Create New User</button></a>--%>
<%--</p>--%>

        <table class="table table-dark">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <th scope="col">Country</th>
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${userList}" var="user">
            <tr>
                <td><c:out value="${user.getId()}"></c:out></td>
                <td><a href="/users?action=view&id=${user.getId()}"><c:out value="${user.getName()}"></c:out></a></td>
                <td><c:out value="${user.getEmail()}"></c:out></td>
                <td><c:out value="${user.getCountry()}"></c:out></td>
                <td><a href="/users?action=update&id=${user.getId()}"><button type="button" class="btn btn-warning"><i class="fas fa-user-edit"></i></button></a></td>
                <td><a href="/users?action=delete&id=${user.getId()}"><button type="button" class="btn btn-danger"><i class="fas fa-user-slash"></i></button></a></td>
            </tr>
            </c:forEach>

            </tbody>
        </table>

</body>
</html>
