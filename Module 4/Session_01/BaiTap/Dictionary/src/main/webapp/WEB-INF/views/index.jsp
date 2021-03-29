<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/29/21
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<form action="/dictionary" method="post">
    <h1>Dictionary</h1>
    <div class="form-group">
    <label for="keyword">
        Enter Key Word:
    </label>
    <input type="text" class="form-control" name="key" placeholder="Enter key word" id="keyword">
    </div>
    <div>
        <button type="submit" class="btn btn-primary">Search</button>
    </div>

</form>
</body>
</html>
