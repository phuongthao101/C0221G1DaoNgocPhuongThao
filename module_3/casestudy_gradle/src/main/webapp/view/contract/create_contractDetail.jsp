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
<form action="/contractDetail?action=create"  method="post">
    <div class="container col-3"></div>
    <div class="container col-6">
        <div class="container mt-3 ">
            <div class="alert alert-primary " role="alert" STYLE="text-align: center">
                <h3>CREATE CONTRACT DETAIL INFORMATION</h3>
            </div>
            <%--Bạn đã cập nhật thành công--%>
            <div>
                <c:if test="${message != null}">
                    <p class="text-success">${message}</p>
                </c:if>
            </div>
            <label class="col-sm-4 col-form-label">Contract id</label>
            <div class="col-sm-8">
                <select class="form-control" name="contract_id" >
                    <c:forEach items="${contracts}" var="contract">
                        <option value="${contract.contractId}">${contract.contractId}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>ATTACH SERVICE NAME: </label>
                <select class="form-control" name="attach_service_id">
                    <c:forEach var="attach" items="${attachServices}">
                        <option value="${attach.attachServiceId}">${attach.attachServiceName}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label > QUANTITY</label>
                <input type="text" class="form-control"  name="quantity" aria-describedby="quantity" >

            </div>

    </div>

    <div class="d-flex justify-content-center col-10">
        <a href="/index.jsp" class="btn btn-secondary" style="margin-left: 200px">Back to home</a>
        <input type="submit" class="btn btn-success" style="margin-left: 174px;width: 100px" value="Create">
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
