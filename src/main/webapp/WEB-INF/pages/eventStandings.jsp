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
    <title>${event.name}</title>
</head>
<body style="background: #0072bc;color: white; font-family: sans-serif">
<h2>${event.name} Result</h2>
<table>
<tr>
    <th>Team Name</th>
    <th>Score</th>
</tr>
<c:forEach var="score" items="${eventScores}">
<tr style="text-align: center">
    <td>${score.team.name}</td>
    <td>${score.score}</td>
</tr>
</c:forEach>
<tr>
    <td><a href="/sas_maven_webapp/standings/division/${division.id}" style="color: navajowhite">D ${division.id} Standings</a></td>
</tr>

</table>
</body>
</html>