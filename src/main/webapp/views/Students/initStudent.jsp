<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tqdao
  Date: 12/12/2024
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="students" action="${pageContext.request.contextPath}/students/createStudent" method="post">
    <form:label path="name">Tên sinh viên:</form:label>
    <form:input path="name"/><br>
    <form:errors path="name" cssClass="error"/><br>
    <form:label path="phone">Số ĐT</form:label>
    <form:input path="phone"/><br>
    <form:errors path="phone" cssClass="error"/><br>
    <form:label path="email">Email: </form:label>
    <form:input path="email"/><br>
    <form:errors path="email" cssClass="error"/><br>
    <form:label path="address">Địa chỉ</form:label>
    <form:input path="address"/><br>
    <form:errors path="address" cssClass="error"/><br>
    <form:label path="sex">Giới tính</form:label>
    <select name="sex" id="sex">
        <option value="0">Nữ</option>
        <option value="1">Nam</option>
    </select>
    <form:errors path="sex" cssClass="error"/><br>
    <form:label path="class_id">Lớp học: </form:label>
    <form:select path="class_id">
        <c:forEach items="${classes}" var="cls">
            <form:option value="${cls.id}"></form:option>
        </c:forEach>
    </form:select>
    <input type="submit" value="Thêm mới"/>
</form:form>

<c:if test="${not empty errorMsg}">
    <p style="color: red">${errorMsg}</p>
</c:if>
</body>
</html>
