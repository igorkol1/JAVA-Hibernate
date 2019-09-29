<%--
  Created by IntelliJ IDEA.
  User: Z6IKL
  Date: 28.09.2019
  Time: 15:21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create person</title>
</head>
<body>
Person Form
<form:form method="post"
           modelAttribute="person">
    Login: <form:input path="login" /><br>
    Email: <form:input path="email" /><br>
    Password: <form:password path="password" /><br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
