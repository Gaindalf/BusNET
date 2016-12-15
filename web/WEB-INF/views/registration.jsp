<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/uncludes.jsp"%>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
Заполните, пожалуйста, форму:<br>
<form:form action="users.do" method="POST" commandName="users">
    <table>
        <tr>
            <td>Логин:</td>
            <td><form:input path="login" /></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><form:input type="password" path="password" /></td>
        </tr>
        <tr>
            <td>E-mail:</td>
            <td><form:input path="mail" /></td>
        </tr>
        <tr>
            <td>Имя:</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>Телефон:</td>
            <td><form:input path="phone" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="action" value="Зарегистрироваться">
            </td>
        </tr>
    </table>
</form:form>
<br>
</body>
</html>
