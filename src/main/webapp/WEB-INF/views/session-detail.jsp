<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>session-detail</title>
</head>
<body>
<h1>session-detail</h1>
<br>
<table>
    <thead>
        <tr>
            <th>Subject ID</th>
            <th>Duration</th>
            <th>Notes</th>
        </tr>
    </thead>
    <tr>
        <td>${session.subjectId}</td>
        <td>${session.minutes}</td>
        <td>${session.notes}</td>
    </tr>
</table>

<hr>
<p><a href="${pageContext.request.contextPath}/sessions">Back Home</a></p>
</body>
</html>
