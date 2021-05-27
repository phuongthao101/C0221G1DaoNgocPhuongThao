<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/27/2021
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ứng dụng máy tính</title>
</head>
<body>

<form action="/Calculator" method="get">
    <h1>Simple Calculator</h1>
    <label>First operand</label>
    <input type="number" name="firstNumber"><br>
    <label>Operator</label>
    <select name="operator" id="">
        <option value="+">Addition</option>
        <option value="-">Subtraction</option>
        <option value="*">Multiplication</option>
        <option value="/">Division</option>
    </select>
    <br>
    <label>Second operand:</label>
    <input type="number" name="secondNumber"><br><br>
    <input type="submit" value="Submit">

</form>

</body>
</html>
