<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/uncludes.jsp" %>
<html>
<head>
    <title>Schedule Management</title>
</head>
<body>
<h1>Schedule</h1><br>
<a href="/logout">Выйти</a><br>
${schedule2}
<form:form action="/schedule/schedule.do" method="POST" commandName="schedule">
    <table>
        <tr>
            <td>Id</td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td>Station Name</td>
            <td><form:input path="station"/></td>
        </tr>
        <tr>
            <td>Bus Number</td>
            <td><form:input path="line"/></td>
        </tr>
        <tr>
            <td>Time</td>
            <td><form:input path="time"/></td>
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
    <th>Station Name</th>
    <th>Bus Number</th>
    <th>Time</th>
    <c:forEach items="${scheduleList}" var="schedule">
        <tr>
            <td>${schedule.id}</td>
            <td>${schedule.station}</td>
            <td>${schedule.line}</td>
            <td>${schedule.time}</td>
        </tr>
    </c:forEach>
</table>
<table border="1">
    <th>station</th>
    <th>Time</th>
    <c:forEach items="${scheduleList2}" var="schedule">
        <tr>
            <td>${schedule.station}</td>
            <td>${schedule.time}</td>
        </tr>
    </c:forEach>
</table>
<table border="1">
    <th>station</th>
    <c:forEach items="${stationList}" var="stations">
        <tr>
            <td>${stations.name}</td>
        </tr>
    </c:forEach>
</table>
<br>
Станция Отправления:<br>
<select name="station">
    <option value="Sloane Square">Sloane Square</option>
    <option value="St. James's Park">St. James's Park</option>
    <option value="Westminster">Westminster</option>
    <option value="Waterloo">Waterloo</option>
    <option value="Southwark">Southwark</option>
    <option value="London Bridge Station">London Bridge Station</option>
</select>
<br>
Станция Назначения:<br>
<select name="station">
    <c:forEach items="${stationList}" var="stations">
        <option value="${stations.name}">${stations.name}</option>
    </c:forEach>
</select>
<br>
<form:form action="/schedule/station.do" method="POST" commandName="schedule">
    <input type="submit" name="action" value="Поиск"/>
</form:form>
</body>
</html>
