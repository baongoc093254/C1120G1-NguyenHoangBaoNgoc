<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/30/21
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>List Condiment:</h1>
    <ul>
        <c:forEach var="condiment" items="${condimentList}">
            <li>
                <c:out value="${condiment}"></c:out>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
