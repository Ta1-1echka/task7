<%--
  Created by IntelliJ IDEA.
  User: Tanya
  Date: 08.11.2016
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование информации о пользователе</title>
</head>
<body>
<form action="/edit/save" method="post" modelAttribute="user">
    <table align="center">
        <tr>
            <td>Login</td>
            <td><input type="text" value="${user.login}" required></td>
        </tr>
        <tr>
            <td>
                Firstname
            </td>
            <td><input type="text" value="${user.firstname}" required></td>

        </tr>
        <tr>
            <td>
                Lastname
            </td>
            <td>
                <input type="text" value="${user.firstname}" required></td>
            </td>
        </tr>
        <tr>
            <td>
                Email
            </td>
            <td>
                <input type="text" value="${user.email}" required></td>
            </td>

        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Сохранить изменения">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
