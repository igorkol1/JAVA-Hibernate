<%--
  Created by IntelliJ IDEA.
  User: igorkolodziejczyk
  Date: 12/10/2019
  Time: 15:12
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Author List</title>
</head>
<body>
<header>
    <a href="javascript:history.back()">Go Back</a>
</header>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Last name</th>
        <th>Options</th>
    </tr>
    <c:forEach var="author" items="${authors}">
        <tr>
            <th>${author.getFirstName()}</th>
            <th>${author.getLastName()}</th>
            <th>
                <ul>
                    <li><a href="edit/${author.getId()}">Edit</a></li>
                    <li><a href="delete/${author.getId()}">Delete</a></li>
                </ul>
            </th>
        </tr>
    </c:forEach>
</table>
<a href="create">Create new category</a>

</body>
</html>
