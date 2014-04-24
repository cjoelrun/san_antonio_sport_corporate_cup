<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Select Division To Score</title>
</head>
<input type="hidden" id="selectedDivisionId" value="1"/>
<script language="javascript">
    function setDivisionId(sel) {
        document.getElementById('selectedDivisionId').value = sel.value
    }

    function submitForm(){
        window.location.href = "/sas_maven_webapp/setDivision/"+document.getElementById('selectedDivisionId').value;
    }
</script>
<body>
Event :
<select id="divisionId" onchange="setDivisionId(this)">
    <c:forEach var="division" items="${divisions}">
        <option value="${division.id}">${division.name}</option>
    </c:forEach>
</select>
<input type="button" value="select" onclick="submitForm()">
</body>

</html>