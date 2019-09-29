<%--
  Created by IntelliJ IDEA.
  User: Z6IKL
  Date: 29.09.2019
  Time: 09:12
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
Student Form
<form:form method="post"
           modelAttribute="student">
    First name: <form:input path="firstName" /><br>
    Last Name: <form:input path="lastName" /><br>
    Gender: <form:input path="gender" /><br>
    Country: <form:select path="country" items="${countries}" /><br>
    Notes: <form:textarea path="notes" /><br>
    Mailing list: <form:checkbox path="mailingList" /><br>
    Programing skills <form:checkboxes  path="programmingSkills" items="${skills}" /><br>
    Hobbies: <form:checkboxes  path="hobbies" items="${hobbiesList}" /><br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
