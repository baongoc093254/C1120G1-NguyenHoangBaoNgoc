<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/12/21
  Time: 00:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
    <form action="/calculator" method="post">
        <table>
            <tr>
                <td>First Number: </td>
                <td>
                    <input type="text" name="firstNumber">
                </td>
            </tr>
            <tr>
                <td>Second Number: </td>
                <td>
                    <input type="text" name="secondNumber">
                </td>
            </tr>
            <tr>
                <td>Operator: </td>
                <td>
                    <select name="operator">
                        <option>+</option>
                        <option >-</option>
                        <option >*</option>
                        <option >/</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit">Compute</button>
                </td>
            </tr>

        </table>
    </form>
</body>
</html>
