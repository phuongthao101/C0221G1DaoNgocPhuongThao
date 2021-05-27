<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/26/2021
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <style>
        div{
            width: 600px;
            height: 500px;
            border: 1px solid black;
            text-align: center;
            box-shadow: 1px 1px 5px 5px #3bb7ff;
        }
        table{
            border;
        }
        table td{
            padding: 10px 30px;
        }
        table tr{
            border-bottom: 1px solid black;
        }
        img{
            width :40px;
            height:40px;
        }
    </style>
</head>
<body>
<%--tạo table danh sách--%>

<div>
    <h1>Danh sách khách hàng</h1>
    <table>
        <tr>
            <th>Tên</th>
            <th>Ngày Sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>
        <c:forEach items="${customers}" var="customer" >
            <tr>
                <td>${customer.name}</td>
                <td>${customer.birth} </td>
                <td>${customer.address}</td>
                <td><img height="100px "  src="${customer.image} " alt=""></td>
            </tr>
        </c:forEach>
    </table>

</div>

</body>
</html>
