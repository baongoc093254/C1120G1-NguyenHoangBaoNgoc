<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/17/21
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View user</title>
</head>
<body>
<fieldset>
    <legend>View Information User</legend>
    <table>
        <tr>
            <td>Name:</td>
            <td>${user.getName()}</td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>${user.getEmail()}</td>
        </tr>
        <tr>
            <td>Country:</td>
            <td>${user.getCountry()}</td>
        </tr>
    </table>
</fieldset>
<p>
    <a href="/users">Back to user list !</a>
</p>
</body>
</html>
