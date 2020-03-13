<%--
  Created by IntelliJ IDEA.
  User: gadom
  Date: 12.03.2020
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<style>
    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 50%;
    }

    td, th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }

    tr:nth-child(even) {
        background-color: #dddddd;
    }
</style>

<body>
<h2>All users:</h2>
<table>
    <tr>
        <th>Login</th>
        <th>Origin Country</th>
        <th>Email</th>
        <th>Trips</th>
    </tr>
    <c:forEach items="${users}" var="listValue">
        <tr>
            <td>${listValue.login}</td>
            <td>${listValue.originCountry}</td>
            <td>${listValue.email}</td>
            <td><a href="get_by_user_id/${listValue.id}">Trips</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
