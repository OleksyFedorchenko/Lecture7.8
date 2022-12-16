<%--
  Created by IntelliJ IDEA.
  User: GM
  Date: 16.12.2022
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <style>
        table, th, td {
            border: 1px solid grey;
            text-align: center;
        }

        th, td {
            padding: 10px;
        }
    </style>
    <title>AllUsers</title>
</head>
<body>
<table>
    <thead>
    <th>LOGIN</th>
    <th>NAME</th>
    </thead>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.name}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
