<%--
  Created by IntelliJ IDEA.
  User: tqdao
  Date: 12/12/2024
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/classes/updateClass" method="post">
    <input type="hidden" name="id" id="id" value="${classes.id}">
    <label for="name">Tên lớp: </label>
    <input type="text" name="name" id="name" value="${classes.name}">
    <label for="majors">Chuyên ngành: </label>
    <input type="text" name="majors" id="majors" value="${classes.majors}">
    <input type="submit" value="Update">
    <a href="/classes/allClasses">Quay lại</a>
</form>

<c:if test="${not empty errorMsg}">
    <p style="color: red">${errorMsg}</p>
</c:if>
</body>
</html>
