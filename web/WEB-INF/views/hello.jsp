<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/uncludes.jsp"%>
<html>
<head>
    <title> Hello World</title>
</head>
<body>
Добро пожаловть${Login}<br>
<a href="/logout">${Exit}</a><br>
<a href="/reg">${Registration}</a><br>
${Enter}<br>
<a href="/schedule">${Schedule}</a><br>
<a href="/station">Станции</a><br>
<a href="/route">Путь</a><br>
<a href="/insertStationTable">Заполнение таблиц базы данных</a><br><br><br>

Инструкция:<br>
1. Для начала работы пройдите по ссылке "Заполнение таблиц базы данных", чтобы заполнить таблицу данными.<br>
2. Вы можете войти в систему как администратор (ROLE_ADMIN) использовав логин admin1 и пароль admin1.<br>
3. При регистрации нового пользователя будет создан пользователь с обычными правами (ROLE_USER).<br>

</body>
</html>
