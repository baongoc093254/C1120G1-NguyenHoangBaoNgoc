<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/10/21
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form action="/translate" method="post">
    <input type="text" name="txtSearch" placeholder="Enter your word: "/><br/>
    <input type="submit" id="submit" value="Search"/>
</form>
</body>
</html>
