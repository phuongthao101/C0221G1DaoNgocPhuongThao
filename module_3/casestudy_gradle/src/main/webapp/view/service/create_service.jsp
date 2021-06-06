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
<form action="/service?action=create"  method="post">
    <div class="container col-3"></div>
    <div class="container col-6">
        <div class="container mt-3 ">
            <div class="alert alert-primary " role="alert" STYLE="text-align: center">
                <h3>CREATE SERVICE INFORMATION</h3>
            </div>
            <%--Bạn đã cập nhật thành công--%>
            <div>
                <c:if test="${message != null}">
                    <p class="text-success">${message}</p>
                </c:if>
            </div>
            <div class="form-group">
                <label>Service Type: </label>
                <select  name="service_type_id" class="form-control" onchange="changeData(this.value)">
                    <c:forEach var="serviceType" items="${serviceTypes}">
                        <option value="${serviceType.serviceTypeId}">${serviceType.serviceTypeName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="name"> Service Name</label>
                <input type="text" class="form-control" id="name" name="service_name" aria-describedby="name" >

            </div>

            <div class="form-group">
                <label>Area:</label>
                <input type="number" class="form-control" name="service_area" placeholder="Enter area... ">
            </div>

            <div class="form-group">
                <label>Cost:</label>
                <input type="text" class="form-control" name="service_cost" placeholder="Enter cost... ">
            </div>
            <div class="form-group">
                <label>Max People:</label>
                <input type="number" class="form-control" name="service_max_people"
                       placeholder="Enter max people... ">
            </div>

            <div class="form-group">
                <label>Rent Type: </label>
                <select  name="rent_type_id" class="form-control">
                    <c:forEach var="rentType" items="${rentTypes}">
                        <option value="${rentType.rentTypeId}">${rentType.rentTypeName}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group ">
                <label for="example-date-input" >Birthday</label>
                <input class="form-control" type="date" value="2011-08-19" id="example-date-input" name="customer_birthday"  >

            </div>


            <div id="standard_room" class="form-group" >
                <label>Standard room:</label>
                <input type="text" class="form-control" name="standard_room" >
            </div>
            <div id="description_other_convenience" class="form-group">
                <label>Description other convenience:</label>
                <input type="text" class="form-control" name="description_other_convenience" >
            </div>
            <div id="pool_area" class="form-group">
                <label>Pool area:</label>
                <input type="number" class="form-control" name="pool_area" >
            </div>
            <div id="number_of_floors" class="form-group">
                <label>Number of floors:</label>
                <input type="number" class="form-control" name="number_of_floors" >
            </div>

        </div>
    </div>

    <div class="d-flex justify-content-center col-10">
        <a href="/service" class="btn btn-secondary" style="margin-left: 200px">Back to list</a>
        <input type="submit" class="btn btn-success" style="margin-left: 174px;width: 100px" value="Create">
    </div>

</form>

<script>
    function changeData(id) {
        document.getElementById("standard_room").style.display="block";
        document.getElementById("description_other_convenience").style.display="block";
        document.getElementById("number_of_floors").style.display="block";
        document.getElementById("pool_area").style.display="block";
        if (id==2){
            document.getElementById("pool_area").style.display="none";

        }
        if (id==3){
            document.getElementById("standard_room").style.display="none";
            document.getElementById("description_other_convenience").style.display="none";
            document.getElementById("number_of_floors").style.display="none";
            document.getElementById("pool_area").style.display="none";

        }

    }
</script>

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