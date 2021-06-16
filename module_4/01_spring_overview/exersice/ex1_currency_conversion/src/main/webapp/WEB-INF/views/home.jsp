<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/15/2021
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>convertor</title>

    <style>
        div {
            margin: auto;
            text-align: center;
            padding-top: 30px;
            width: 35%;
        }
    </style>
</head>
<body>

    <table border="1">
        <form action="a" method="post">
            <p>RATE</p>
            <label>
                <input type="number" name="rate" value="${rate}" placeholder="Rate">
            </label>
            <br>
            <p>USD</p>
            <label>
                <input type="number" name="usd" value="${usd}" placeholder=" USD">
            </label>
            <br>
            <button type="submit" name="Result">Submit</button><br>
            <p >Result : ${result}</p>

        </form>
    </table>



</form>


</body>
</html>
