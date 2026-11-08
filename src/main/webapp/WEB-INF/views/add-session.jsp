<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add session</title>
</head>
<body>
<h1>Add Session</h1>
<br>
<form action="${pageContext.request.contextPath}/save" method="post">
<label for="subjectId">Subject ID</label>
    <input type="number" name="subjectId" id="subjectId" required>
    <br>
    <label for="minutes">Duration</label>
    <input type="number" name="minutes" id="minutes" required> <br>

    <label for="notes">Notes</label>
    <input type="text" name="notes" id="notes" required> <br>

    <button>Submit</button>
</form>
</body>
</html>
