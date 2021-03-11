<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/11/21
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Discount Calculator</title>
</head>
<style>
    .calculator{
        height: 180px;
        width: 230px;
        padding: 10px;
        border: 1px #CCCCCC solid;
        margin: 0;
    }
    .calculator input{
        margin: 5px;
        padding: 5px;
    }
</style>
<body>
<form method="post" action="/discount">
    <h2>Product Discount:</h2>
<table class="calculator">
    <tr>
        <td>Product Description:</td>
        <td><input type="text" name="description" ></td>
    </tr>
    <tr>
        <td>Discount percent:</td>
        <td><input type="text" name="percent"></td>
    </tr>
    <tr>
        <td>Price:</td>
        <td><input type="text" name="price"></td>
    </tr>
    <tr>
        <td colspan="3">
            <button type="submit">Convert</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
