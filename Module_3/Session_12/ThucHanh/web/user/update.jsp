<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/16/21
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
<form>
    <fieldset>
        <legend>
            <table>

                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" id="email"></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="country" id="country"></td>
                </tr>
                <tr>
                    <td>
                        <input type="hidden" name="action" value="update">
                        <button type="submit" value="submit">Submit</button>
                    </td>
                </tr>
            </table>
        </legend>
    </fieldset>
</form>

</body>
</html>
