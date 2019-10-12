<%--
  Created by IntelliJ IDEA.
  User: igorkolodziejczyk
  Date: 12/10/2019
  Time: 11:41
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List of category articles</title>
</head>
<body>
All articles:
<table border="1">
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Created</th>
        <th>Content</th>
    </tr>
    <c:forEach var="article" items="${categoryArticles}">
        <tr>
            <th>${article.getTitle()}</th>
            <th>${article.getAuthor().getFirstName()} ${article.getAuthor().getLastName()}</th>
            <th>${article.getCreated()}</th>
            <th>${article.getContent()}</th>
        </tr>
    </c:forEach>
</table>
<a href="javascript:history.back()">Go Back</a>
</body>
</html>
