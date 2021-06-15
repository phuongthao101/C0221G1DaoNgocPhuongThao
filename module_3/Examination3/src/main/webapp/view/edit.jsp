<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/2/2021
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<form action="/product?action=edit&product_id=${product.productId}"  method="post">
    <div class="container col-4"></div>
    <div class="container col-4">
        <div class="container mt-3 ">
            <div class="alert alert-primary " role="alert" STYLE="text-align: center">
                <h3>UPDATE PRODUCT INFORMATION</h3>
            </div>
            <%--Bạn đã cập nhật thành công--%>
            <div>
                <c:if test="${message != null}">
                    <p class="text-success">${message}</p>
                </c:if>
            </div>

<%--            product_name ,--%>
<%--            price ,--%>
<%--            quantity ,--%>
<%--            color , `description`,--%>
<%--            category--%>
            <div class="form-group">
            <label>ID:</label>
            <input type="text" class="form-control"  name="product_id" readonly value="${product.productId}">
        </div>

            <div class="form-group">
                <label>Name:</label>
                <input type="text" class="form-control"  name="product_name"  value="${product.name}">
            </div>
            <div class="form-group">
                <label>Price:</label>
                <input type="number" class="form-control"  name="price"value="${product.price}">
            </div>
            <div class="form-group">
                <label>Quantity: </label>
                <input type="text" class="form-control"  name="quantity" value="${product.quantity}">
            </div>
            <div class="form-group">
                <label>Color:</label>
                <input type="text" class="form-control"  name="color"  value="${product.color}">
            </div>
            <div class="form-group">

                <label>Description: </label>
                <input type="number" class="form-control"  name="description" value="${product.description}">
            </div>
            <div>
                <label for="validationDefault04">Category</label>
                <select class="custom-select" id="validationDefault04" name="category" required>
                    <option selected disabled value="">Choose...</option>
                    <option>Phone</option>
                    <option>Television</option>
                    <option>Other</option>
                </select>
            </div>


        </div>
    </div>

    <div class="d-flex justify-content-center col-10">
        <a href="/product" class="btn btn-secondary" style="margin-left: 200px">Back to list</a>
        <input type="submit" class="btn btn-success" style="margin-left: 174px;width: 100px" value="Edit">
    </div>
    <div class="container col-4">
    </div>
</form>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
        integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
        crossorigin="anonymous"></script>
</body>
</html>