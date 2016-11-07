<%--
  Created by IntelliJ IDEA.
  User: Tanya
  Date: 07.11.2016
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form method="post" action="/registration/new">
    <table align="center">
        <tr>
            <td>Login</td>
            <td><input type="text" name="login" required></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" required></td>
        </tr>
        <tr>
            <td>Firstname</td>
            <td><input type="text" name="firstname" required></td>
        </tr>
        <tr>
            <td>Lastname</td>
            <td><input type="text" name="lastname" required></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="email" required></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"></td>
        </tr>
        <tr>
            <td colspan="2">${message}</td>
        </tr>
        <tr>
            <td colspan="2"><a href="/">Авторизоваться</a></td>
        </tr>
    </table>
</form>
</body>
</html>
