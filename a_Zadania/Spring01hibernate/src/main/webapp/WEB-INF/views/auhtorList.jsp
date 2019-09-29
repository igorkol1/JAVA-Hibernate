<%--
  Created by IntelliJ IDEA.
  User: Z6IKL
  Date: 29.09.2019
  Time: 14:38
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List of authors</title>
</head>
<body>
<header>
    <ul>
        <li><a href="create">Create new author</a></li>
        <li><a href="../book/list">Books</a></li>
        <li><a href="../publisher/list">Publishers</a></li>
    </ul>
</header>
List of books:
<table border="1">
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Options</th>
    </tr>
    <c:forEach var="authorItem" items="${authors}">
        <tr>
            <td>${authorItem.getFirstName()}</td>
            <td>${authorItem.getLastName()}</td>
            <td>
                <ul>
                    <li>
                        <a href="edit/${authorItem.getId()}">Edit</a>
                    </li>
                    <li>
                        <a href="delete/${authorItem.getId()}">Delete</a>
                    </li>
                </ul>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
