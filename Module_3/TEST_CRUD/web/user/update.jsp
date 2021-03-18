<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/17/21
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Information User</title>
</head>
<body>
<h2>Update Information User</h2>
<form method="post" action="/users?action=update">
    <fieldset>
        <legend>Update Information User</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value="${user.getName()}"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="name" value="${user.getEmail()}"></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><input type="text" name="name" value="${user.getCountry()}"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit" name="action" value="update">Submit</button>
                </td>
            </tr>
        </table>
        <a href="/users">Back To User List !</a>
    </fieldset>
</form>
</body>
</html>
