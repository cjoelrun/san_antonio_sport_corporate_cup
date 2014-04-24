
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Add Score</title>
</head>
<script language="javascript">
    function submitForm(){
        window.location.href = "/sas_maven_webapp/addScore/"+document.getElementById('score_str').value;
    }
</script>
<body>
For Team ${teamSelected.name} add a score

<input id="score_str" type="text"/>
<input type="button" value="Submit" onclick="submitForm()">
</body>
</html>