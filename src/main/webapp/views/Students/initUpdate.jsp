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
  <form action="/students/updateStudent" method="post">
    <input type="hidden" name="id" id="id" value="${student.id}">
    <label for="name">Name</label>
    <input type="text" name="name" id="name" value="${student.name}">
    <label for="phone">Phone</label>
    <input type="text" name="phone" id="phone" value="${student.phone}">
    <label for="email">Email</label>
    <input type="text" name="email" id="email" value="${student.email}">
    <label for="address">Address</label>
    <input type="text" name="address" id="address" value="${student.address}">
    <label for="sex">Giới tính</label>
    <select name="sex" id="sex">
      <option value="1" ${student.sex?"selected":""}>Nam</option>
      <option value="0" ${student.sex?"":"selected"}>Nữ</option>
    </select>
    <input type="submit" value="Update">
    <a href="/students/allStudents">Quay lại</a>
  </form>

  <c:if test="${not empty errorMsg}">
    <p style="color: red">${errorMsg}</p>
  </c:if>
  </body>
</html>
