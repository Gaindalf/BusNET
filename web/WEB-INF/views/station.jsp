<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/uncludes.jsp" %>
<html>
<head>
    <style>
        #content {
            color: red;
        }
    </style>
    <title>Title</title>
</head>
<body>
<a href="/">На главную</a><br>
<br>
<table>
    <tr>
        <td>
            Станция Отправления:<br>
            <form:form action="stationFrom.do" method="GET" commandName="station">
                <form:select name="name" path="name" itemValue="name">
                    <c:forEach items="${stationList}" var="station">
                        <option value="${station.name}">${station.name}</option>
                    </c:forEach>
                </form:select><br><br>
                Станция Назначения:<br>
                <form:select name="name" path="name" itemValue="name">
                    <c:forEach items="${stationList}" var="station">
                        <option value="${station.name}">${station.name}</option>
                    </c:forEach>
                </form:select>
                <br>
                <br>
                <input type="submit" name="action" value="Выбрать"/>
            </form:form>
        </td>
        <td width=300>
        </td>
        <td>
            На данной странице можно выбрать станцию отправления и назначения<br>
            Если выбрать сегодняшнюю дату и время, которое уже прошло, то будет ошибка<br>
            Если попробовать купить билет на тот же самый маршрут, то будет ошибка<br>
            Сам билет покупается на следующей странице<br>
            Если мест в автобусе нет (Их ровно 30), то на следующей странице будет ошибка<br>
            (Чтобы увидеть ошибку выберите станцию назначения London Bridge Station, завтрашнюю дату и время 9:00.<br>
            Ошибка будет на следующей странице)<br>
        </td>
    </tr>
</table>
<br><br>
Откуда: ${nameOfTheDepartureStation}<br>
Куда: ${nameOfTheDestinationStation}<br><br>
${Message}
<table>
    <tr>
        <td valign="top">
            <table>
                <th>Станция</th>
                <th>Время</th>
                <c:forEach items="${directionList}" var="schedule">
                    <tr>
                        <td>${schedule.station}</td>
                        <td>${schedule.time}</td>
                    </tr>
                </c:forEach>
            </table>
        </td>
        <td valign="top">
            <table>
                <th>Выбрать Дату:</th>
                <tr>
                    <td valign="top">
                        <form:form action="stationDate.do" method="GET" commandName="bus">
                            <form:select name="date" path="date">
                                <option value="${today}">${today}</option>
                                <option value="${tomorrow}">${tomorrow}</option>
                                <option value="${tomorrow_1}">${tomorrow_1}</option>
                                <option value="${tomorrow_2}">${tomorrow_2}</option>
                                <option value="${tomorrow_3}">${tomorrow_3}</option>
                            </form:select>
                            <br><br>
                            ${ButtonDate}
                            <br>
                            ${YourChoiceDate}
                        </form:form>
                    </td>
                </tr>
            </table>
        </td>
        <td valign="top">
            <table>
                <th>Выбрать Время:</th>
                <tr>
                    <td valign="top">
                        <form:form action="stationTime.do" method="GET" commandName="bus">
                            <form:select name="time" path="time">
                                <c:forEach items="${TimeList}" var="schedule">
                                    <option value="${schedule.time}">${schedule.time}</option>
                                </c:forEach>
                            </form:select>
                            <br><br>
                            ${ButtonTime}
                            <br>
                            ${YourChoiceTime}
                        </form:form>
                    </td>
                </tr>
            </table>
        </td>
        <td valign="top">
            <table>
                <th>${Buy}</th>
                <tr>
                    <td>
                        <form:form action="stationBuy.do" method="GET" commandName="bus">
                            ${BuyTicket}
                            <div id="content">
                                    ${AlreadyBuy}
                            </div>
                        </form:form>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<br>
<br><br>
</body>
</html>
