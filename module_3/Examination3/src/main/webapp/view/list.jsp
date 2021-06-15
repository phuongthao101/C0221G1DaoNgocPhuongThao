<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/4/2021
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg  navbar-dark bg-success my-2 px-5 border border-info  sticky-top">

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <div class="col-4">
            <div>
                <a class="btn btn-info" href="/product?action=create">Add new</a>
                <c:if test="${message!=null}">
                    <p>${message} </p>
                </c:if>
            </div>
        </div>

        <div class="col-5"></div>
        <div class="col-3">
            <form action="/product?action=search " method="post" class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" name="product_name" type="search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0 " type="submit" style="color: black">Search
                </button>
            </form>
        </div>

    </div>

</nav>
<div class="container border pt-5 mt-5 ">

    <div>
        <div class="table-title">
            <div class="row">
                <div class="col-sm-8">
                    <h3>Product
                        <b>Details</b></h3>
                </div>
            </div>
        </div>

        <%--        list table--%>
        <table class="table table-bordered table-striped">
            <thead>

            <tr class="table-primary">
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Color</th>
                <th>Description</th>
                <th>Category</th>

                <th>Delete</th>
                <th>Edit</th>
                <%--                private  int productId;--%>
                <%--                private String name;--%>
                <%--                private String price;--%>
                <%--                private String color;--%>
                <%--                private String description;--%>
                <%--                private String category;--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.productId}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.quantity}</td>
                    <td>${product.color}</td>
                    <td>${product.description}</td>
                    <td>${product.category}</td>
                    <td>
                        <button type="button" class="btn btn-primary" data-toggle="modal"
                                data-target="#exampleModal"
                                onclick="sendData('${product.productId}','${product.name}')">
                            Delete
                        </button>
                        <input type="hidden" id="idInput" value="${product.productId}">
                    </td>
                    <td>
                        <a href="/product?action=edit&product_id=${product.productId}">
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
            <form action="/product?action=delete" method="post">
                <div class="modal-header">

                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Do you want to delete ??? <span id="product_name"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                    <button type="submit" class="btn btn-primary">Yes</button>
                    <input type="hidden" id="getData" name="product_id">
                </div>

            </form>


        </div>
    </div>
</div>

<script>
    function sendData(id, name) {
        document.getElementById("product_name").innerText = name;
        document.getElementById("getData").value = id;


    }
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>


</body>
</html>

