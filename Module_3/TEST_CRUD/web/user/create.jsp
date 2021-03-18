<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/17/21
  Time: 08:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New User</title>
</head>
<body>
<h2>Create New User</h2>
<form method="post">
    <fieldset>
        <legend>Create New User</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" id="name"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" id="email"></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><input type="text" id="country"></td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" name="action" value="create">
                    <button type="submit" value="submit">Submit</button>
                </td>
            </tr>
        </table>
    </fieldset>
    <p><a href="/users">Back to user list !</a></p>
</form>

</body>
</html>
