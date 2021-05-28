<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/28/2021
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Chi tiết sản phẩm</h1>
<p>
    <a href="/products">Quay lại danh sách</a>
</p>
<table>
    <tr>
        <td>Id: </td>
        <td>${products.getId()}</td>
    </tr>

    <tr>
        <td>Tên: </td>
        <td>${products.getName()}</td>
    </tr>
    <tr>
        <td>Giá: </td>
        <td>${products.getPrice()}</td>
    </tr>
    <tr>
        <td>Mô tả: </td>
        <td>${products.getDescription()}</td>
    </tr>
    <tr>
        <td>Nhà sản xuất: </td>
        <td>${products.getManufacture()}</td>
    </tr>
</table>
</body>
</html>
