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
<a href="/schedule/bus">${Schedule}</a><br>
<a href="/station">Станции</a><br>
<a href="/create">Создать таблицы в базе данных.</a><br>
</body>
</html>
