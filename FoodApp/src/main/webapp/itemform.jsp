<%@page import="com.jsp.foodapp.entities.Item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Item i=(Item)request.getAttribute("itemobj");
%>
<form:form action="additemtofoodorder" modelAttribute="itemobj">
name:<form:input path="name" value="<%=i.getName() %>" readonly="true"/>
type:<form:input path="type" value="<%=i.getType() %>" readonly="true"/>
cost:<form:input path="cost" value="<%=i.getCost() %>" readonly="true"/>
quantity:<form:input path="quantity"/>
<input type="submit">
</form:form>
</body>
</html>