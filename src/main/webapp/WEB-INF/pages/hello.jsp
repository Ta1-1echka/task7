<%--
  Created by IntelliJ IDEA.
  User: Tanya
  Date: 07.11.2016
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form method="post" action="/login">
    <p>Login: <input type="text" name="login"></p>
    <p>Password: <input type="text" name="password"></p>
    <input type="submit">
    <p>${message}</p>
</form>
</body>
</html>
