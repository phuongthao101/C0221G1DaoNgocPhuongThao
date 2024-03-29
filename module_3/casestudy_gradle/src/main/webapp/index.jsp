<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/3/2021
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<div class="row container-fluid navbar navbar-light bg-light">
    <div class="col-3">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="https://phuongviethcm.com/wp-content/uploads/2019/07/FURAMA.png" alt="" width="80" height="70"
                     class="d-inline-block align-text-top">

            </a>
        </div>
    </div>
    <div class="col-7"></div>
    <div class="col-2">
        <div class="navbar-brand mb-0 h1">
            <p>Đào Ngọc Phương Thảo</p>
        </div>
    </div>

</div>

<%--nav bar--%>

<nav class="navbar navbar-expand-lg  navbar-dark bg-success my-2 px-5 border border-info  sticky-top">
    <a class="navbar-brand mx-5" href="#">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item mr-5">
                <a class="navbar-brand mr-0" href="/employee">Employee <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item  mr-5">
                <a class="navbar-brand mr-0" href="/customer">Customer <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item mr-5 ">
                <a class="navbar-brand mr-0" href="/service">Service <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item mr-5 ">
                <a class="navbar-brand mr-0" href="/contract">Contract <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item mr-5 ">
                <a class="navbar-brand mr-0" href="/contractDetail">ContractDetail <span class="sr-only"></span></a>
            </li>

        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" style="color: white">Search</button>
        </form>
    </div>
</nav>

<!--content-->
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-3 d-flex justify-content-center align-items-center">
            <p style="color: #CBBE73;font-size: 30px"><b>THIS WORLD CLASS RESORT, FURAMA DANANG, REPUTABLE FOR BEING
                A CULINARY RESORT IN VIETNAM</b></p>
        </div>
        <div class="col-lg-6">
            <div>
                <iframe width="600" height="400" src="https://www.youtube.com/watch?v=8S4mnIF8Xes"
                        title="YouTube video player" frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                        allowfullscreen></iframe>
            </div>
        </div>
        <div class="col-lg-3">
            <p>Overlooking the long stretch of wide white sand on Danang Beach, Furama Resort Danang is a gateway to three
                World Heritage Sites of Hoi An (20 minutes), My Son (90 minutes) and Hue (2 hours). The 198 rooms and suites
                plus 70 two to four bedroom pool villas feature tasteful décor, designed with traditional Vietnamese style
                and a touch of French colonial architecture and guarantee the Vietnam’s the most prestigious resort -counting
                royalty, presidents, movie stars and international business leaders among its celebrity guests.

            </p>
        </div>
    </div>
</div>

<p style="color: #CBBE73;font-size: 30px" class="d-flex justify-content-center my-4"><b>CÁC LOẠI PHÒNG</b></p>

<div class="d-flex justify-content-center">
    <p style="width: 50%">All 198 rooms & suites have polished timber floors, natural fabrics, comfortable cane furniture,
        plantation style shutters and ceiling fans. Each room also has its own balcony or spacious terrace providing
        complete privacy and with a superb view of the ocean, the tropical garden or the freshwater swimming lagoon pool.</p>
</div>
<%--footer--%>

<div class="row">
    <div class="container-fluid  d-flex justify-content-center align-items-center bg-success" style="clear: bottom">
        <p>Contact US
            103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son District, Danang City, Vietnam
            Tel.: 84-236-3847 333/888 * Fax: 84-236-3847 666
            Email: reservation@furamavietnam.com * www.furamavietnam.com</p>
    </div>

</div>
<script src="bootraps_min/jquery-3.6.0.min.js"></script>
<script src="bootraps_min/popper.min.js"></script>
<script src="bootraps_min/bootstrap.min.js"></script>
</body>
</html>
