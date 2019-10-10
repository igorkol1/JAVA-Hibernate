<%--
  Created by IntelliJ IDEA.
  User: Z6IKL
  Date: 29.09.2019
  Time: 09:57
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create book</title>
</head>
<body>
Create new book
<form:form method="post"
           modelAttribute="book">
    Title: <form:input path="title" /><br>
    Authors: <form:select path="authors" items="${authorsList}" itemLabel="lastName" itemValue="id" multiple="true"/><br>
    Rating: <form:input path="rating" /><br>
    Publisher: <form:select path="publisher" items="${publishers}"
                            itemValue="id" itemLabel="name"/><br>
    Description: <form:textarea path="description" /><br>
    Pages: <form:input path="pages" /><br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>




