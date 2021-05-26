<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/26/2021
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<form method="post" action="/calculate">
  <h2>Product Discount Calculator</h2>
  <input type="text" name="ProductDescription" size="30"  placeholder="Product Description" />
  <input type="text" name="ListPrice" size="30"  placeholder="List Price" />
  <input type="text" name="DiscountPercent" size="30"  placeholder="Discount Percent" />
  <input type = "submit" id = "submit" value = "Amount"/>

</form>
  </body>
</html>
