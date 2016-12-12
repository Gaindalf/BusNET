<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/uncludes.jsp"%>
<html>
<head>
    <title>Schedule Management</title>
</head>
<body>
<h1>Schedule</h1>
<form:form action="schedule.do" method="POST" commandName="schedule">
<table>
    <tr>
        <td>Id</td>
        <td><form:input path="id" /></td>
    </tr>
    <tr>
        <td>Station Name</td>
        <td><form:input path="stationId" /></td>
    </tr>
    <tr>
        <td>Bus Number</td>
        <td><form:input path="busNumber" /></td>
    </tr>
    <tr>
        <td>Time</td>
        <td><form:input path="time" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" name="action" value="Add" />
            <input type="submit" name="action" value="Edit" />
            <input type="submit" name="action" value="Delete" />
            <input type="submit" name="action" value="Search" />
        </td>
    </tr>
</table>
</form:form>
<br>
<table border="1">
    <th>Id</th>
    <th>Station Name</th>
    <th>Bus Number</th>
    <th>Time</th>
    <c:forEach items="${scheduleList}" var="schedule">
        <tr>
            <td>${schedule.id}</td>
            <td>${schedule.stationId}</td>
            <td>${schedule.busNumber}</td>
            <td>${schedule.time}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
