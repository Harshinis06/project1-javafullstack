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
<form:form action="savefoodorder" modelAttribute="foodorders">
enter name:<form:input type="text" path="name"/>
enter mobilenumber:<form:input type="number" path="mobilenumber"/>
<input type="submit">
</form:form>
</body>
</html>