<%--
  Created by IntelliJ IDEA.
  User: igorkolodziejczyk
  Date: 12/10/2019
  Time: 12:12
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Category List</title>
</head>
<body>
<header>
    <a href="javascript:history.back()">Go Back</a>
</header>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Options</th>
    </tr>
    <c:forEach var="category" items="${categories}">
        <tr>
            <th>${category.getName()}</th>
            <th>${category.getDescription()}</th>
            <th>
                <ul>
                    <li><a href="*/article/list/${category.getId()}">Go to articles</a></li>
                    <li><a href="edit/${category.getId()}">Edit</a></li>
                    <li><a href="delete/${category.getId()}">Delete</a></li>
                </ul>
            </th>
        </tr>
    </c:forEach>
</table>
<a href="create">Create new category</a>
</body>
</html>
