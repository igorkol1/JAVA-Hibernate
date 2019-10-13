<%--
  Created by IntelliJ IDEA.
  User: igorkolodziejczyk
  Date: 12/10/2019
  Time: 15:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Authors Form</title>
</head>
<body>
<form:form method="post"
           modelAttribute="author">
    Name: <form:input path="firstName" /><br>
    Last name: <form:input path="lastName"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
