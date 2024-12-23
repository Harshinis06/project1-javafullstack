<%@page import="com.jsp.foodapp.entities.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Product> products1=(List)request.getAttribute("productslist"); %>
<table cellpadding="20px" border=1>
  <th>id</th>
  <th>name</th>
  <th>type</th>
  <th>cost</th>
  <th>additem</th>
  
    <%
  for(Product p:products1){
	  %>
	 <tr>
	 <td><%=p.getId() %></td>
	 <td><%=p.getName() %></td>
	 <td><%=p.getType() %></td>
	 <td><%=p.getCost() %></td>
	 <td><a href="additem?id=<%=p.getId() %>">add</a></td>

	 </tr>
  <%} %>
 </table>
 <h1>
 <a href="submitfoodorder">submitfoodorder</a>
 </h1>
</body>
</html>