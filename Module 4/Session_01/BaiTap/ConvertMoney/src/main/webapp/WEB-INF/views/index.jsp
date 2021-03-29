<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/29/21
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/usd">

        <label for="usd">Usd:</label>
        <input type="text" name="usd" id="usd" placeholder="USD" value="${usd}">
        <label for="rate">Rate:</label>
        <input type="text" name="rate" id="rate" placeholder="1 USD = ? VND" value="${rate}">
        <input type="submit" value="Converter"><br>
        <p>RESULT : ${result}</p>

    </form>
</body>
</html>
