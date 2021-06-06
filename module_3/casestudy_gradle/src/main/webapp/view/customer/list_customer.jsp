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
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <div class="col-9">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item mr-5">
                    <a class="navbar-brand mr-0" href="/employee">Employee <span class="sr-only"></span></a>
                </li>
                <li class="nav-item  mr-5">
                    <a class="navbar-brand mr-0" href="/customer">Customer <span class="sr-only"></span></a>
                </li>
                <li class="nav-item mr-5 ">
                    <a class="navbar-brand mr-0" href="/service">Service <span class="sr-only"></span></a>
                </li>
                <li class="nav-item mr-5 ">
                    <a class="navbar-brand mr-0" href="/contract">Contract <span class="sr-only"></span></a>
                </li>
            </ul>
        </div>
        <div class="col-3">
            <form action="/customer?action=search " method="post" class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" name="customer_name" type="search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit" style="color: white">Search</button>
            </form>
        </div>

    </div>

</nav>

<div>
    <a class="btn btn-success" href="/customer?action=create">Add new</a>
    <c:if test="${message!=null}">
        <p>${message} </p>
    </c:if>
</div>

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
            <thead>

            <tr class="table-primary">
                <th>Id Customer</th>
                <th>Type Customer</th>
                <th>Customer Name</th>
                <th>Gender</th>
                <th>Birthday</th>
                <th>ID Card</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>Delete</th>
                <th>Edit</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td>${customer.customerId}</td>
                  <c:forEach var="typeCustomer" items="${typeCustomers}">
                      <c:if test="${typeCustomer.customerTypeId == customer.customerTypeId}">
                          <td>${typeCustomer.customerTypeName}</td>
                      </c:if>
                  </c:forEach>
                    <td>${customer.name}</td>
                    <td>${customer.birthday}</td>
                    <td>${customer.gender}</td>
                    <td>${customer.idCard}</td>
                    <td>${customer.phone}</td>
                    <td>${customer.email}</td>
                    <td>${customer.address}</td>

                    <td>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"
                                onclick="sendData('${customer.customerId}','${customer.name}')">
                            Delete
                        </button>
                        <input type="hidden" id="idInput" value="${customer.customerId}">
                    </td>
                    <td>
                        <a href="/customer?action=edit&customer_id=${customer.customerId}">
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                    data-bs-target="#myModal">Edit
                            </button>
                        </a>
                    </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Modal delete -->

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/customer?action=delete" method="post">
                <div class="modal-header">

                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Do you want to delete ??? <span id="customer_name"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                    <button type="submit" class="btn btn-primary">Yes</button>
                    <input type="hidden" id="getData" name="customer_id">
                </div>

            </form>


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


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>

<script>
    function sendData(id,name) {
        document.getElementById("customer_name").innerText=name;
        document.getElementById("getData").value=id;


    }
</script>
</body>
</html>