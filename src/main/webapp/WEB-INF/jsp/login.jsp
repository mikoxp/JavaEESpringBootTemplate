<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="pl">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--<link href="<c:url value="bower_components/bootstrap/dist/css/bootstrap.css"/>"--%>
          <%--rel="stylesheet" type="text/css">--%>

</head>
<body>
<body>

<span>${error}</span>

<form action="login" method="POST">
    <input type="text" name="username" placeholder="Nazwa użytkownika"/>
    <input type="password" name="password" placeholder="Hasło"/>
    <input type="submit" name="submit" value="Zaloguj"/>
</form>
</body>

</html>



