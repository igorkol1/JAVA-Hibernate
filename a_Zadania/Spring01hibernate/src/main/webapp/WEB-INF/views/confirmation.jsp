<%--
  Created by IntelliJ IDEA.
  User: Z6IKL
  Date: 29.09.2019
  Time: 13:21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
Do you want to delete book: ${book.getTitle()}<br>
<a href="${book.getId()}/yes/">Yes</a>
<a href="#" onclick="history.go(-1)">No</a>
</body>
</html>
