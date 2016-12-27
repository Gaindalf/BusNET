<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/uncludes.jsp" %>
<html>
<head>
    <title>Staton Management</title>
</head>
<body>
<h1>Станции</h1><br>
<a href="/">На главную</a><br>
<form:form action="/addStation.do" method="POST" commandName="stations">
    <table>
        <tr>
            <td>Id</td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="action" value="Add"/>
                <input type="submit" name="action" value="Edit"/>
                <input type="submit" name="action" value="Delete"/>
                <input type="submit" name="action" value="Search"/>
            </td>
        </tr>
    </table>
</form:form>
<br>
<table border="1">
    <th>Id</th>
    <th>Name</th>
    <c:forEach items="${stationsList}" var="stations">
        <tr>
            <td>${stations.id}</td>
            <td>${stations.name}</td>
        </tr>
    </c:forEach>
</table>
<br>
</body>
</html>
