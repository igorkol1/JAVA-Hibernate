<%--
  Created by IntelliJ IDEA.
  User: Z6IKL
  Date: 29.09.2019
  Time: 10:33
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List of books</title>
</head>
<body>
<header>
    <ul>
        <li><a href="create">Create new book</a></li>
        <li><a href="../authors/list">Authors</a></li>
        <li><a href="../publisher/list">Publishers</a></li>
    </ul>
</header>
List of books:
<table border="1">
    <tr>
        <th>Title</th>
        <th>Authors</th>
        <th>Rating</th>
        <th>Publisher</th>
        <th>Description</th>
        <th>Pages</th>
        <th>Options</th>
    </tr>
    <c:forEach var="bookItem" items="${books}">
        <tr>
            <td>${bookItem.getTitle()}</td>
            <td>${bookItem.getAuthors()}</td>
            <td>${bookItem.getRating()}</td>
            <td>${bookItem.getPublisher()}</td>
            <td>${bookItem.getDescription()}</td>
            <td>${bookItem.getPages()}</td>
            <td>
                <ul>
                    <li>
                        <a href="edit/${bookItem.getId()}">Edit</a>
                    </li>
                    <li>
                        <a href="delete/${bookItem.getId()}">Delete</a>
                    </li>
                </ul>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
