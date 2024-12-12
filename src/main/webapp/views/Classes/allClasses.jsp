<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tqdao
  Date: 12/12/2024
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${empty classes}">
        <p>Danh sách lớp rỗng</p>
    </c:when>
    <c:otherwise>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Tên Lớp</th>
                <th>Chuyên ngành</th>
                <th>Hành động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${classes}" var="cls">
                <tr>
                    <td>${cls.id}</td>
                    <td>${cls.name}</td>
                    <td>${cls.majors}</td>
                    <td>
                        <form action="/classes/deleteClass" method="get">
                            <input type="hidden" name="id" value="${cls.id}">
                            <input type="submit" value="Delete">
                        </form>
                        <form action="/classes/initUpdate" method="get">
                            <input type="hidden" name="id" value="${cls.id}">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>
<button><a href="/classes/initClass">Thêm mới lớp</a></button>
</body>
</html>
