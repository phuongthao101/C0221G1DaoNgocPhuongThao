<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/16/2021
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<h1>Calculator</h1>
  <form action="/calculator" method="post">
    <input type="number" name="num1" placeholder="input number">
    <input type="number" name="num2" placeholder="input number"></br></br>

    <div>
      <button type="submit" value="+" name="calculator">Addition</button>
      <button type="submit" value="-" name="calculator">Subtraction</button>
      <button type="submit" value="*" name="calculator">Multiplication</button>
      <button type="submit" value="/" name="calculator">Division</button>
      </br></br>
      <span>Result ${result}</span>
    </div>

  </form>
  </body>
</html>
