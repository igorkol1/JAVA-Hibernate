<%--
  Created by IntelliJ IDEA.
  User: Z6IKL
  Date: 29.09.2019
  Time: 14:49
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create author</title>
</head>
<body>
Create new author
<form:form method="post"
           modelAttribute="author">
    First name: <form:input path="firstName" /><br>
    Last name: <form:input path="lastName" /><br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
