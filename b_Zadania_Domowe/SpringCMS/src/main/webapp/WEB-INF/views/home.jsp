<%--
  Created by IntelliJ IDEA.
  User: igorkolodziejczyk
  Date: 12/10/2019
  Time: 11:12
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>CMS Home</title>
</head>
<body>
<header>
    <ul>
        <li><a href="category/list">Categories</a> </li>
        <li><a href="author/list">Authors</a> </li>
    </ul>
</header>

Last articles:
<table border="1">
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Created</th>
        <th>Content</th>
    </tr>
    <c:forEach var="article" items="${lastArticles}">
        <tr>
            <th>${article.getTitle()}</th>
            <th>${article.getAuthor().getFirstName()} ${article.getAuthor().getLastName()}</th>
            <th>${article.getCreated()}</th>
            <th>${article.getContent()}</th>
        </tr>
    </c:forEach>
</table>


<br>
All categories:<br>
<c:forEach var="category" items="${categories}">
    <a href="article/list/${category.getId()}">${category.getName()}</a><br>
</c:forEach>
</body>
</html>
