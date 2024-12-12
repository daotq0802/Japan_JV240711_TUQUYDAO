<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tqdao
  Date: 12/12/2024
  Time: 9:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
<form:form modelAttribute="classes" action="${pageContext.request.contextPath}/classes/createClass" method="post">
    <form:label path="name">Tên lớp: </form:label>
    <form:input path="name"/><br>
    <form:errors path="name" cssClass="error"/><br>
    <form:label path="majors">Chuyên ngành</form:label>
    <form:input path="majors"/><br>
    <form:errors path="majors" cssClass="error"/><br>
    <input type="submit" value="Thêm mới"/>
</form:form>

<c:if test="${not empty errorMsg}">
    <p style="color: red">${errorMsg}</p>
</c:if>
</body>
</html>
