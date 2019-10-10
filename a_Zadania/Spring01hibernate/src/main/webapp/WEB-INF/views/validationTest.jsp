<%--
  Created by IntelliJ IDEA.
  User: igorkolodziejczyk
  Date: 10/10/2019
  Time: 07:52
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Validation Test</title>
</head>
<body>
Book validation test: <br>
<c:forEach var="bookValidationResponse" items="${bookValidationResponses}">
    ${bookValidationResponse.getFieldKey()} : ${bookValidationResponse.getMessage()} <br>
</c:forEach>
</body>
</html>
