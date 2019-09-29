<%--
  Created by IntelliJ IDEA.
  User: Z6IKL
  Date: 29.09.2019
  Time: 15:25
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Publisher List</title>
</head>
<body>
<header>
    <ul>
        <li><a href="create">Create new publisher</a></li>
        <li><a href="../book/list">Books</a></li>
        <li><a href="../authors/list">Authors</a></li>
    </ul>
</header>
List of publishers:
<table border="1">
    <tr>
        <th>Name</th>
        <th>Options</th>
    </tr>
    <c:forEach var="publisherItem" items="${publishers}">
        <tr>
            <td>${publisherItem.getName()}</td>
            <td>
                <ul>
                    <li>
                        <a href="edit/${publisherItem.getId()}">Edit</a>
                    </li>
                    <li>
                        <a href="delete/${publisherItem.getId()}">Delete</a>
                    </li>
                </ul>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
