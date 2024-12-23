<%@page import="com.jsp.foodapp.entities.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Product p=(Product) request.getAttribute("productdata"); %>
<form action="updateproducts" method="post">
enter id:<input type="number" name="id" value=<%= p.getId()%> readonly="true"><br>
enter name:<input type="text" name="name" value=<%= p.getName() %>>
enter type:<input type="text" name="type" value=<%= p.getType() %>>
enter cost:<input type="number" name="cost" value=<%= p.getCost() %>>
<input type="submit">
</form>
</body>
</html>