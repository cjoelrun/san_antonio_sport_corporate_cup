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
    <title>${division.name}</title>
</head>
<body style="background: #0072bc;color: white; font-family: sans-serif">
<table>
<tr>
    <th>Team Name</th>
    <th>Total Score</th>
</tr>
<c:forEach var="score" items="${divisionScores}">
<tr style="text-align: center">
    <td><a href="/sas_maven_webapp/standings/team/${score.team.id}" style="color: navajowhite">${score.team.name}</a></td>
    <td>${score.totalScore}</td>
</tr>
</c:forEach>
</table>
</body>
</html>