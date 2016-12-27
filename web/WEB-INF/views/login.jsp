<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/uncludes.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Авторизация </title>
</head>
<body>
<c:if test="${param.logout != null}">
<div>
    Invalid username and password.
</div>
</c:if>
<c:if test="${param.error != null}">
<div>
    You have been logged out.
</div>
</c:if>
<form th:action="@{/login}" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div><br>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Войти"/></div>
</form>
<br>
Ещё не зарегистрированы? Тогда вам <a href="/reg">сюда</a>.
</body>
</html>
