
<%--
  Created by IntelliJ IDEA.
  User: igorkolodziejczyk
  Date: 12/10/2019
  Time: 12:12
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Category Form</title>
</head>
<body>
<header>
    <a href="javascript:history.back()">Go Back</a>
</header>
${category.getId()}
<form:form method="post"
           modelAttribute="category">
    Name: <form:input path="name" /><br>
    Description: <form:textarea path="description"/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>
