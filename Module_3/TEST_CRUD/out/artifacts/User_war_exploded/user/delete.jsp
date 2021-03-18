<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/17/21
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Delete User</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<form method="post">
    <fieldset>
        <legend>Delete User</legend>
        <table class="table table-hover">
            <tr>
            <td>Name:</td>
            <td><c:out value="${user.getName()}"></c:out></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><c:out value="${user.getEmail()}"></c:out></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><c:out value="${user.getCountry()}"></c:out></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit" value="delete" name="action" class="btn btn-danger">Submit</button>
                </td>
            </tr>
        </table>
    </fieldset>
    <a href="/users">Back To User List !</a>
</form>
</body>
</html>
