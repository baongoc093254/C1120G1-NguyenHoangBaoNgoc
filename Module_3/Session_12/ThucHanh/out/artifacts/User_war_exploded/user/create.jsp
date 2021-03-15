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
    <div class="form-group row">
        <label for="name" >Name:</label>
        <input type="text" class="col-sm-3 col-form-label"  id="name" name="name" placeholder="Enter your name">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">Email:</label>
        <input type="text" class="col-sm-3 col-form-label" name="email" id="exampleInputEmail1" placeholder="Enter your email">
    </div>
    <div class="form-group">
        <label for="country">Country: </label>
        <input type="text" class="col-sm-3 col-form-label" id="country" name="email" style="display: inline">
    </div>
    <input type="hidden" name="action" value="create">
    <button type="submit" value="Create" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
