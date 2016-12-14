<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/uncludes.jsp"%>
<html>
<head>
    <title> Hello World</title>
</head>
<body>
Добро пожаловть${Name}<br>
<a href="/logout">${Exit}</a>
<a href="/reg">${Registration}</a>
${Enter}

<table border="1">
    <th>Name</th>
    <c:forEach items="${usersList}" var="users">
        <tr>
            <td>${users.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
