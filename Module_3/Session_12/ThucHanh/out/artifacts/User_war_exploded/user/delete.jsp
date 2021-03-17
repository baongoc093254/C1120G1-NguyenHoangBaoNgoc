<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/15/21
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete User</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form method="post">
    <h2>Delete User</h2>
    <fieldset>
        <%--        Tag <fieldset> được dùng để nhóm các thành phần bên trong <form> một cách hợp lý.--%>
        <%--        Tag <fieldset> tạo đường bao ngoài bao quanh các thành phần trong <form>.--%>
        <legend>User information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["user"].getName()}</td>
            </tr>
            <tr>
                <td>Email: </td>
                <td>${requestScope["user"].getEmail()}</td>
            </tr>
            <tr>
                <td>Address: </td>
                <td>${requestScope["user"].getCountry()}</td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" name="action" value="delete">
                    <button type="submit" value="submit">Submit</button></td>
            </tr>
        </table>
    </fieldset>


</form>
</body>
</html>
