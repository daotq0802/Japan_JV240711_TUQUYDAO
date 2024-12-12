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
<c:choose>
    <c:when test="${empty students}">
        <p>Danh sách sinh viên rỗng</p>
    </c:when>
    <c:otherwise>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Tên Sinh viên</th>
                <th>Số điện thoại</th>
                <th>Email</th>
                <th>Địa chỉ</th>
                <th>Giới tính</th>
                <th>Lớp</th>
                <th>Ảnh đại diện</th>
                <th>Trạng thái</th>
                <th>Hành động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${students}" var="std">
                <tr>
                    <td>${std.id}</td>
                    <td>${std.name}</td>
                    <td>${std.phone}</td>
                    <td>${std.email}</td>
                    <td>${std.address}</td>
                    <td>${std.sex}</td>
                    <td>${std.class_id}</td>
                    <td>${std.imageURL}</td>
                    <td>${std.status}</td>
                    <td>
                        <form action="/students/deleteStudent" method="get">
                            <input type="hidden" name="id" value="${std.id}">
                            <input type="submit" value="Delete">
                        </form>
                        <form action="/students/initUpdate" method="get">
                            <input type="hidden" name="id" value="${std.id}">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>
<button><a href="/students/initStudent">Thêm mới lớp</a></button>
</body>
</html>
