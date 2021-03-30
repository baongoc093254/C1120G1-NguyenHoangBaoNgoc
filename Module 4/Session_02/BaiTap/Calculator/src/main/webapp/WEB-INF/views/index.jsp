<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/30/21
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form action="/calculator" method="post">
    <table>
        <tr>
            <td>First Number:</td>
            <td><input type="text" name="firstNumber"></td>
        </tr>

        <tr>
            <td>Second Number:</td>
            <td><input type="text" name="secondNumber"></td>
        </tr>
        <tr>
            <td>Operator:</td>
            <td>
                <select name="operator">
                    <option value="+" >Addition(+)</option>
                    <option value="-" name="operator">Subtraction(-)</option>
                    <option value="*" name="operator">Multiplication(*)</option>
                    <option value="/" name="operator">Division(/)</option>
                </select>
<%--                <button type="button"  value="+">Addition(+)</button>--%>
<%--                <button type="button"  value="-">Subtraction(-)</button>--%>
<%--                <button type="button"  value="*">Multiplication(*)</button>--%>
<%--                <button type="button"  value="/">Division(/)</button>--%>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><button type="submit" value="result">Result</button></td>
        </tr>
    </table>

</form>
    <h2>Result : ${result}</h2>
</body>
</html>
