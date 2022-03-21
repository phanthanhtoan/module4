<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Caculator</title>
</head>
<body>
<h1>Caculator</h1>
<form  action="calculate" method="post">
 <h3>Num 1</h3>
 <input type="text" name="num1">
 <h3>Num 2</h3>
 <input type="text" name="num2"><br>
  <button type="submit" value="add" name="caculator">Addition(+)</button>
  <button type="submit" value="sub" name="caculator">Subtraction(-)</button>
  <button type="submit" value="mul" name="caculator"> Multiplication(X)</button>
  <button type="submit" value="div" name="caculator">Division(/)</button>
 <h3>Resuilt Division: <div style="color: red">${resuilt}</div></h3>
</form>
</body>
</html>