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
<form action="/employee?action=create"  method="post">
    <div class="container col-3"></div>
    <div class="container col-6">
        <div class="container mt-3 ">
            <div class="alert alert-primary " role="alert" STYLE="text-align: center">
                <h3>CREATE EMPLOYEE INFORMATION</h3>
            </div>
            <%--Bạn đã cập nhật thành công--%>
            <div>
                <c:if test="${message != null}">
                    <p class="text-success">${message}</p>
                </c:if>
            </div>

            <div class="form-group">
                <label>Name:</label>
                <input type="text" class="form-control" placeholder="Enter name... " name="employee_name">
            </div>
            <div class="form-group">
                <label>Birthday:</label>
                <input type="date" class="form-control" placeholder="Enter birthday" name="employee_birthday">
            </div>
            <div class="form-group">
                <label>ID Card: </label>
                <input type="text" class="form-control" placeholder="Enter id card... " name="employee_id_card">
            </div>
            <div class="form-group">
                <label>Salary: </label>
                <input type="number" class="form-control" placeholder="Enter salary..." name="employee_salary">
            </div>
            <div class="form-group">
                <label>Phone: </label>
                <input type="number" class="form-control" placeholder="Enter phone number..." name="employee_phone">
            </div>
            <div class="form-group">
                <label>Email: </label>
                <input type="email" class="form-control" placeholder="Enter email..." name="employee_email">
            </div>
            <div class="form-group">
                <label>Address: </label>
                <input type="text" class="form-control" placeholder="Enter address... " name="employee_address">
            </div>

            <div class="form-group">
                <label>Position: </label>
                <select name="position_id" class="form-control">
                    <c:forEach var="position" items="${positions}">
                        <option value="${position.positionId}">${position.positionName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Education degree : </label>
                <select name="education_degree_id" class="form-control">
                    <c:forEach var="education" items="${educationDegrees}">
                        <option value="${education.educationDegreeId}">${education.educationName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Division : </label>
                <select name="division_id" class="form-control">
                    <c:forEach var="division" items="${divisions}">
                        <option value="${division.divisionId}">${division.divisionName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Username: </label>
                <input type="text" class="form-control" placeholder="Enter username... " name="username">
            </div>

        </div>
    </div>

    <div class="d-flex justify-content-center col-10">
        <a href="/employee" class="btn btn-secondary" style="margin-left: 200px">Back to list</a>
        <input type="submit" class="btn btn-success" style="margin-left: 174px;width: 100px" value="Create">
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