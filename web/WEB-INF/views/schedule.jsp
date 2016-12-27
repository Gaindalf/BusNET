<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/uncludes.jsp" %>
<html>
<head>
    <title>Schedule Management</title>
</head>
<body>
<h1>Schedule</h1><br>
<a href="/logout">Выйти</a><br>
<a href="/">На главную</a><br>
<table>
    <tr>
        <td>
            <form:form action="/schedule.do" method="POST" commandName="schedule">
                <table>
                    <tr>
                        <td>Id</td>
                        <td><form:input path="id"/></td>
                    </tr>
                    <tr>
                        <td>Номер маршрута</td>
                        <td><form:input path="station"/></td>
                    </tr>
                    <tr>
                        <td>Название остановки</td>
                        <td><form:input path="line"/></td>
                    </tr>
                    <tr>
                        <td>Time</td>
                        <td><form:input path="time"/></td>
                    </tr>
                    <tr>
                        <td>Station number</td>
                        <td><form:input path="stationnumber"/></td>
                    </tr>
                    <tr>
                        <td>Direction</td>
                        <td><form:input path="direction"/></td>
                    </tr>
                    <tr>
                        <td>Run Number</td>
                        <td><form:input path="runnumber"/></td>
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
        </td>
        <td width=300>
        </td>
        <td>
            Чтобы Добавить нужно ввести все данные, нужно заполнить все поля кроме Id (назначается автоматически)<br>
            Номер маршрута введён только один (Пересадки не предусмотрены)<br>
            Station number - номер остановки<br>
            Direction - направление. True - вперёд, false - обратно<br>
            Run number - пробег автобуса(Один проезд от начальной до конечной остановки)<br>
            Чтобы выполнить поиск введите Id<br>
            Чтобы внести изменения, нужно найти остановку и изменить её параметры<br>
            Удаляются остановки по Id<br>
        </td>
    </tr>
</table>
<br>
<table border="1">
    <th>Id</th>
    <th>Номер маршрута</th>
    <th>Название остановки</th>
    <th>Time</th>
    <th>Station number</th>
    <th>Direction</th>
    <th>Run Number</th>
    <c:forEach items="${scheduleList}" var="schedule">
        <tr>
            <td>${schedule.id}</td>
            <td>${schedule.line}</td>
            <td>${schedule.station}</td>
            <td>${schedule.time}</td>
            <td>${schedule.stationnumber}</td>
            <td>${schedule.direction}</td>
            <td>${schedule.runnumber}</td>
        </tr>
    </c:forEach>
</table>
<%--<table border="1">--%>
<%--<th>station</th>--%>
<%--<th>Time</th>--%>
<%--<c:forEach items="${scheduleList2}" var="schedule">--%>
<%--<tr>--%>
<%--<td>${schedule.station}</td>--%>
<%--<td>${schedule.time}</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</table>--%>
<br>
</body>
</html>
