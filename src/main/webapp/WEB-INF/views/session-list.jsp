<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Study Sessions</title>
</head>
<body>
<h1>Study Sessions</h1> <br>
<%-- Display each session with its subjectId, duration, and notes--%>
<table>
    <thead>
    <tr>
        <th>Subject ID</th>
        <th>Duration(minutes)</th>
        <th>Notes</th>
    </tr>
    </thead>
    <c:forEach var="session" items="${sessions}">
        <tr>
            <td><a href="sessions/detail">${subjectId}</a></td>
            <td><a href="sessions/detail">${minutes}</a></td>
            <td><a href="sessions/detail">${notes}</a></td>
        </tr>
    </c:forEach>
</table>

<br>
<p><a href="${pageContext.request.contextPath}/sessions/add">Create New Session</a></p> <br>
<p><a href="${pageContext.request.contextPath}/subjects">See All Of Subjects</a></p>
</body>
</html>
