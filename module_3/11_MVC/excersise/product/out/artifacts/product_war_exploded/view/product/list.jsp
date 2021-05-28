<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/28/2021
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách sản phẩm </h1>
<form action="/products?action=search" method="post">
    <input type="text" name="name" placeholder="Tìm sản phẩm" >
    <input type="submit" value="Tìm">
</form>
<p>
    <a href="/products?action=create">Thêm mới sp</a>
</p>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Price</td>
        <td>Describe</td>
        <td>Producer</td>
        <td>Edit</td>
        <td>Delete</td>

    </tr>
    <c:forEach items='${products}' var="product">
        <tr>
            <td><a href="/products?action=view&id=${product.getId()}">${product.getId()}</a></td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getManufacture()}</td>
            <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
<%--            điều hướng cho action của servlet--%>
            <td><a href="/products?action=delete&id=${product.getId()}">delete</a></td>

        </tr>
    </c:forEach>
</table>
    </body>
    </html>
