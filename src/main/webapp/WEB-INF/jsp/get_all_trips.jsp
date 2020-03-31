<%--
  Created by IntelliJ IDEA.
  User: gadom
  Date: 10.03.2020
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<h2>All trips:</h2>
<table >
    <tr>
        <th>Country</th>
        <th>City</th>
        <th>First Day</th>
        <th>Last Day</th>
        <th>User ID</th>
        <th>User Email</th>
    </tr>
    <c:forEach items="${trips}" var="listValue">
        <tr>
            <td>${listValue.country}</td>
            <td>${listValue.city}</td>
            <td>${listValue.firstDay}</td>
            <td>${listValue.lastDay}</td>
            <td>${listValue.user.id}</td>
            <td>${listValue.user.username}</td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="/journeyapp_war">Go back to the home page</a>
</body>
</html>
