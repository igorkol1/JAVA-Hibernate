<%--
  Created by IntelliJ IDEA.
  User: igorkolodziejczyk
  Date: 10/10/2019
  Time: 18:54
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List of propositions</title>
</head>
<body>
<header>
    <ul>
        <li><a href="create">Create new proposition</a></li>
        <li><a href="../book/list">Books</a></li>
        <li><a href="../authors/list">Authors</a></li>
        <li><a href="../publisher/list">Publishers</a></li>
    </ul>
</header>
List of propositions:
<table border="1">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Options</th>
    </tr>
    <c:forEach var="proposition" items="${propositions}">
        <tr>
            <td>${proposition.getTitle()}</td>
            <td>${proposition.getDescription()}</td>
            <td>
                <ul>
                    <li>
                        <a href="edit/${proposition.getId()}">Edit</a>
                    </li>
                    <li>
                        <a href="delete/${proposition.getId()}">Delete</a>
                    </li>
                </ul>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
