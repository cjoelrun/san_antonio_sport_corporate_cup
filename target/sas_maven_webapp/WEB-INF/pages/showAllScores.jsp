<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pete
  Date: 4/14/14
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Scores</title>
</head>
<body>
<table>
<tr>
    <th>Team Name</th>
    <th>Event Type</th>
    <th>Event Name</th>
    <th>Score</th>
</tr>
<c:forEach var="score" items="${allScores}">
<tr>
    <td>${score.team.name}</td>
    <td>${score.event.eventType.name}</td>
    <td>${score.event.name}</td>
    <td>${score.score}</td>
</tr>
</c:forEach>
    <a href="/sas_maven_webapp/selectEvent">Select Event</a>
</table>
</body>
</html>