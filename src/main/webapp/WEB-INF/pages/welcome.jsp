<%--
  Created by IntelliJ IDEA.
  User: Tanya
  Date: 07.11.2016
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome page</title>
</head>
<body>
<form  modelAttribute="user">
    <table>
        <tr>
            <td>Login</td>
            <td>${user.login}</td>
        </tr>
        <tr>
            <td>
                Firstname
            </td>
            <td>
                ${user.firstname}
            </td>
        </tr>
        <tr>
            <td>
                Lastname
            </td>
            <td>
                ${user.lastname}
            </td>
        </tr>
        <tr>
            <td>
                Email
            </td>
            <td>
                ${user.email}
            </td>
        </tr>
    </table>
</form>
</body>
</html>
