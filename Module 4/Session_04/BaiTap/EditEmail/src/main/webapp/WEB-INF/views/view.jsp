<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/31/21
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>View Infor</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div>
    <form:form action="/create" method="post" modelAttribute="email">
        <table class="table table-hover">
            <thead></thead>
            <tr>
                <td><label>Language:</label></td>
                <td>${email.language}</td>
            </tr>
            <tr>
                <td><label>Page Size:</label></td>
                <td>${email.pageSize}</td>
            </tr>
            <tr>
                <td><label>Spams filter:</label></td>
                <td><c:out value="${email.spamsFilter ? 'Yes' :'No'}"/>
                    </td>
            </tr>
            <tr>
                <td><label>Signature:</label></td>
                <td><form:textarea path="signature"/></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <a href="/"><button type="button" class="btn btn-success">Back</button></a>

                </td>
            </tr>
        </table>

    </form:form>
</div>
</body>
</html>
