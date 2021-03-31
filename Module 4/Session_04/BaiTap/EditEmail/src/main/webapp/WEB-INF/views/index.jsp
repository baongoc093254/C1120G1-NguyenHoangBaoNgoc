<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/31/21
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
    <h2>Settings</h2>
    <div>
    <form:form action="/create" method="post" modelAttribute="email">
    <table class="table table-hover">
        <thead></thead>
        <tr>
            <td><label for="language">Language:</label></td>
            <td><form:select path="language" items="${languageList}"/></td>
        </tr>
        <tr>
            <td><label for="pageSize">Page Size:</label></td>
            <td><form:select path="pageSize" items="${pageSizeList}"/></td>
        </tr>
        <tr>
            <td><label>Spams filter:</label></td>
            <td><form:checkbox path="spamsFilter"/>
            <label>Enable spams filter</label></td>
        </tr>
        <tr>
            <td><label for="signature">Signature:</label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:button>Update</form:button>

            <form:button>Cancel</form:button></td>
        </tr>
    </table>

    </form:form>
    </div>
</body>
</html>
