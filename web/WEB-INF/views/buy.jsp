<%@ include file="/WEB-INF/views/uncludes.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        #content{
            color: red;
        }
    </style>
    <title>Title</title>
</head>
<body>
Вы выбрали:
<br><br>
Станция отправления: ${nameOfTheDepartureStation}<br>
Станция назначения: ${nameOfTheDestinationStation}<br>
Дата отправления: ${Date}<br>
Время отправления: ${Time} <br>
<form:form action="Buy.do" method="GET" commandName="bus">
    <%--<input type="submit" name="action" value="Купить билет"/>--%>
    ${BuyTicket}
</form:form><br>
<dib id="content">
${NotOK}
</dib>
${OK}<br><br>
<a href="/station">Назад</a><br>
<a href="/">на главную</a><br>
</body>
</html>
