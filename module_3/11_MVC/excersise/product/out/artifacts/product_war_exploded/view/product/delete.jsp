<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/28/2021
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Xóa sản phẩm</h1>
<p>
    <%--    hiển thị dòng thông báo đã thêm mới thanh công--%>
    <c:if test='${message != null}'>
        <span class="message">${message}</span>
    </c:if>
</p>


<form method="post">

    <fieldset>
        <legend>Thông tin sản phẩm</legend>
        <table>
            <tr>
                <td>Id: </td>
                <td ><input type="text" name="id" id="Id" hidden></td>
            </tr>
            <tr>
                <td>Tên: </td>
                <td><input type="text" name="name" id="name" value="${products.getName()}"></td>
            </tr>
            <tr>
                <td>Giá: </td>
                <td><input type="text" name="price" id="price" value="${products.getPrice()}"></td>
            </tr>
            <tr>
                <td>Mô tả: </td>
                <td><input type="text" name="description" id="describe"value="${products.getDescription()}"></td>
            </tr>
            <tr>
                <td>Nhà sản xuất: </td>
                <td><input type="text" name="manufacture" id="producer"value="${products.getManufacture()}"></td>
            </tr>
            <tr>
                <td>
                    <p>
                    <a href="/products">Quay lại danh sách sản phẩm</a>
                </p>
                </td>
                <td><input type="submit" value="Xóa"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
