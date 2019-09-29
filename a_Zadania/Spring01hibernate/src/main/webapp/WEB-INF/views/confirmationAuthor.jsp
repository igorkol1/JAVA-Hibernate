<%--
  Created by IntelliJ IDEA.
  User: Z6IKL
  Date: 29.09.2019
  Time: 15:18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
Do you want to delete author: ${author.getFirstName()} ${author.getLastName()}<br>
<a href="${author.getId()}/yes/">Yes</a>
<a href="#" onclick="history.go(-1)">No</a>
</body>
</html>
