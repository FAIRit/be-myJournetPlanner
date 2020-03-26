<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Edit user</h2>

    <spring:url value="/user/users" var="users"/>
    <a href="${users}">User list</a>

    <c:url var="action" value="/user/update"></c:url>

    <form:form method="post" action="${action}" modelAttribute="user">
        <table>
            <tr>
                <td><form:label path="username">Username</form:label></td>
            <td><form:input path="username"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td><form:label path="originCountry">Origin country</form:label></td>
            <td><form:input path="originCountry"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Update User"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
