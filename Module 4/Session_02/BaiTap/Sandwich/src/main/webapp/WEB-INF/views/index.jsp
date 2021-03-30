<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/30/21
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SandWich Condiments</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


</head>
<body>

<form action="/save" method="post">
    <h1 class="text-center">Sandwich Condiment: </h1>

<%--            <div class="custom-control custom-checkbox">--%>
<%--                <input type="checkbox" name="condiment1" id="condiment1" value="Lettuce">--%>
<%--                <label for="condiment1">Lettuce</label>--%>
<%--            </div>--%>
<%--            <div class="input-group-text">--%>
<%--                <input type="checkbox" name="condiment1" id="condiment2" value="Tomato">--%>
<%--                <label for="condiment1">Tomato</label>--%>
<%--            </div>--%>
<%--            <div class="input-group-text">--%>
<%--                <input type="checkbox" name="condiment1" id="condiment3" value="Mustard">--%>
<%--                <label for="condiment1">Mustard</label>--%>
<%--            </div>--%>
<%--            <div class="input-group-text">--%>
<%--                <input type="checkbox" name="condiment1" id="condiment4" value="Sprouts">--%>
<%--                <label for="condiment1">Sprouts</label>--%>
<%--            </div>--%>

    <div class="custom-control custom-checkbox" align="center">
        <input type="checkbox" class="custom-control-input" id="condiment1" name="condiment" value="Lettuce">
        <label class="custom-control-label" for="condiment1">Lettuce</label>
    </div>

    <div class="custom-control custom-checkbox " align="center">
        <input type="checkbox" class="custom-control-input" id="condiment2" name="condiment" value="Tomato">
        <label class="custom-control-label" for="condiment2">Tomato</label>
    </div>

    <div class="custom-control custom-checkbox " align="center">
        <input type="checkbox" class="custom-control-input" id="condiment3" name="condiment" value="Mustard">
        <label class="custom-control-label" for="condiment3">Mustard</label>
    </div>

    <div class="custom-control custom-checkbox " align="center">
        <input type="checkbox" class="custom-control-input" id="condiment4" name="condiment" value="Sprouts">
        <label class="custom-control-label" for="condiment4">Sprouts</label>
    </div>

    <div align="center">
        <button type="submit" class="btn btn-success"  value="save">Success</button>
    </div>

</form>

</body>
</html>
