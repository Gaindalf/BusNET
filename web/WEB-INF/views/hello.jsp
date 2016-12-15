<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/uncludes.jsp"%>
<html>
<head>
    <title> Hello World</title>
</head>
<body>
Добро пожаловть${Login}<br>
<a href="/logout">${Exit}</a>
<a href="/reg">${Registration}</a>
${Enter}
${Schedule}
</body>
</html>
