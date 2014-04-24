<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Select Event To Score</title>
</head>
<input type="hidden" id="selectedEventId" value="1"/>
<script language="javascript">
    function setEventId(sel) {
        document.getElementById('selectedEventId').value = sel.value
    }

    function submitForm(){
        window.location.href = "/sas_maven_webapp/setEvent/"+document.getElementById('selectedEventId').value;
    }
</script>
<body>
Event :
<select id="eventId" path="eventId" onchange="setEventId(this)">
    <c:forEach var="event" items="${events}">
        <option value="${event.id}">${event.name}</option>
    </c:forEach>
</select>
<input type="button" value="select" onclick="submitForm()">
</body>
</html>