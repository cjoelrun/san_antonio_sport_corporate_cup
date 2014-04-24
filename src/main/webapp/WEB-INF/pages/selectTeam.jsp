<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Select Team To Score</title>
</head>
<input type="hidden" id="selectedTeamId" value="-1"/>
<script language="javascript">
    function setTeamId(sel) {
        document.getElementById('selectedTeamId').value = sel.value
    }

    function submitForm(){
        window.location.href = "/sas_maven_webapp/setTeam/"+document.getElementById('selectedTeamId').value;
    }
</script>
<body>
Event :
<select id="teamId" onchange="setTeamId(this)">
    <%boolean firstTeam = true;%>
    <c:forEach var="team" items="${teams}">
        <% if(firstTeam){
           firstTeam = false;%>
           <script>document.getElementById("selectedTeamId").value = "${team.id}"</script>
        <%
        }%>
        <option value="${team.id}">${team.name}</option>
    </c:forEach>
</select>
<input type="button" value="select" onclick="submitForm()">
</body>
</html>