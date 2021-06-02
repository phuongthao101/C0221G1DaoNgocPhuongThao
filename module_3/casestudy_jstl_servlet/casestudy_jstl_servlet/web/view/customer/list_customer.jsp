<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/2/2021
  Time: 11:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg  navbar-dark bg-success my-2 px-5 border border-info  sticky-top">
    <a class="navbar-brand mx-5" href="#">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <div class="col-9">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item mr-5">
                    <a class="navbar-brand mr-0" href="#">Employee <span class="sr-only"></span></a>
                </li>
                <li class="nav-item  mr-5">
                    <a class="navbar-brand mr-0" href="/customers">Customer <span class="sr-only"></span></a>
                </li>
                <li class="nav-item mr-5 ">
                    <a class="navbar-brand mr-0" href="#">Service <span class="sr-only"></span></a>
                </li>
                <li class="nav-item mr-5 ">
                    <a class="navbar-brand mr-0" href="#">Contract <span class="sr-only"></span></a>
                </li>
            </ul>
        </div>
        <div class="col-3">
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit" style="color: white">Search</button>
            </form>
        </div>


    </div>
</nav>

<div class="container border pt-5 mt-5 ">

    <div>
        <div class="table-title">
            <div class="row">
                <div class="col-sm-8">
                    <h3>Customer
                        <b>Details</b></h3>
                </div>
            </div>
        </div>

<%--        list table--%>
        <table class="table table-bordered table-striped">
            <thead >

            <tr class="table-primary">
                <th>Id</th>
                <th>Name</th>
                <th>Birthday</th>
                <th>Gender</th>
                <th>ID Card</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>Show</th>
                <th>Edit</th>
                <th>Delete</th>

            </tr>
            </thead>
            <tbody >
            <c:forEach var ="customer" items="${customerList}">
            <tr>
                <td>${customer.customer_id}</td>
                <td>${customer.customer_type_id}</td>
                <td>${customer.customer_name}</td>
                <td>Nam</td>
                <td>123456</td>
                <td>0983123456</td>
                <td>john@gmail.com</td>
                <td>USA</td>
                <td>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">Show</button>
                </td>
                <td>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">Delete</button>
                </td>
                <td>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">Edit</button>
                </td>
            </tr>

            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="modal" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Modal Heading</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Bạn có muốn xóa không???
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" >Yes</button>
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">No</button>
            </div>
        </div>
    </div>
</div>
<nav aria-label="Page navigation example ">
    <ul class="pagination mt-5 justify-content-center">
        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item"><a class="page-link" href="#">Next</a></li>
    </ul>
</nav>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>