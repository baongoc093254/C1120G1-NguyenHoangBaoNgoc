<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/15/21
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New User</title>
</head>
<body>
<form method="post" action="/users">
    <h2>Create New User</h2>
    <fieldset>
        <%--        Tag <fieldset> được dùng để nhóm các thành phần bên trong <form> một cách hợp lý.--%>
        <%--        Tag <fieldset> tạo đường bao ngoài bao quanh các thành phần trong <form>.--%>
        <legend>User information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" id="email"></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><input type="text" name="country" id="country"></td>
            </tr>
            <tr>
                <td>
                <input type="hidden" name="action" value="create">
                <button type="submit" value="submit">Submit</button></td>
            </tr>
        </table>
    </fieldset>
    <p><a href="/users">Back to user list</a><p>
</form>
</body>
</html>
