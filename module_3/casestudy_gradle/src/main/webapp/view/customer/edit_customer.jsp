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
<form action="/customer?action=edit"  method="post">
    <div class="container col-3"></div>
    <div class="container col-6">
        <div class="container mt-3 ">
            <div class="alert alert-primary " role="alert" STYLE="text-align: center">
                <h3>UPDATE CUSTOMER INFORMATION</h3>
            </div>
<%--Bạn đã cập nhật thành công--%>
            <div>
                <c:if test="${message != null}">
                    <p class="text-success">${message}</p>
                </c:if>
            </div>

            <div class="form-group">
                <label for="numberId">ID Customer</label>
                <input type="number" class="form-control" id="numberId" name="customer_id" aria-describedby="numberId" readonly value="${customer.customerId}">

            </div>
            <div class="form-group">

               <select name="type_customer_id">
                    <c:forEach var="type" items="${customerTypes}">
                        <option value="${type.customerTypeId}" ${type.customerTypeId==customer.customerTypeId?"selected":""}>${type.customerTypeName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="name"> Customer Name</label>
                <input type="text" class="form-control" id="name" name="customer_name" aria-describedby="name" value="${customer.name}">

            </div>

            <div>
                <label for="validationDefault04">Gender</label>
                <select class="custom-select" id="validationDefault04" name="customer_gender" required>
                <option selected disabled value="">Choose...</option>
                <option>Male</option>
                <option>Female</option>
                <option>Other</option>
            </select>
            </div>

            <div class="form-group ">
                <label for="example-date-input" >Birthday</label>
                <input class="form-control" type="date" value="2011-08-19" id="example-date-input" name="customer_birthday"  value="${customer.birthday}">

            </div>

            <div class="form-group">
                <label for="numberId">Id Card</label>
                <input type="number" class="form-control" id="idCard" aria-describedby="idCard" name="customer_id_card" value="${customer.idCard}">

            </div>
            <div class="form-group">
                <label for="numberId">Phone Number</label>
                <input type="number" class="form-control" id="phone" aria-describedby="phone" name="customer_phone" value="${customer.phone}">

            </div>
            <div class="form-group ">
                <label for="inputEmail4">Email</label>
                <input type="email" class="form-control" id="inputEmail4" name="customer_email"  value="${customer.email}">
            </div>
            <div class="form-group">
                <label for="inputAddress">Address</label>
                <input type="text" class="form-control" id="inputAddress" name="customer_address" value="${customer.address}">
            </div>


        </div>
    </div>

    <div class="d-flex ">
        <a href="/customer" class="btn btn-secondary" style="margin-left: 200px">Back to list</a>
        <input type="submit" class="btn btn-success" style="margin-left: 174px;width: 100px" value="Submit">
    </div>
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