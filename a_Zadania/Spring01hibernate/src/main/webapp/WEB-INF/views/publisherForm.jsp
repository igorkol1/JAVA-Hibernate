<%--
  Created by IntelliJ IDEA.
  User: Z6IKL
  Date: 29.09.2019
  Time: 15:33
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create publisher</title>
</head>
<body>
Create new author
<form:form method="post"
           modelAttribute="publisher">
    Name: <form:input path="name" /><br>
    <form:errors path="name" /><br>
    NIP: <form:input path="nip" /><br>
    <form:errors path="nip" /><br>
    REGON: <form:input path="regon" /><br>
    <form:errors path="regon" /><br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
