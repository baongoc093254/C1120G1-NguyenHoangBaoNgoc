<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/31/21
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Employee</title>
</head>
<body>
<h2>Create New Employee:</h2>
<form:form action="/create" method="post" modelAttribute="employee">
    <fieldset>
        <legend>Create New Employee</legend>
        <table>
            <tr>
                <td>
                    <th><label for="id">ID:</label></th>
                </td>
                <td><form:input path="id"/></td>
            </tr>
            <tr>
                <td>
                    <th><label for="name">Name:</label></th>
                </td>
                <td>
                    <form:input path="name"/>
                </td>
            </tr>
            <tr>
                <td>
                    <th><label for="contactNumber">Contact Number:</label></th>
                </td>
                <td><form:input path="contactNumber"/></td>
            </tr>
            <tr>
                <td><form:button>Create</form:button></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
