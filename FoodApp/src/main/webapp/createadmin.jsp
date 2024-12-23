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
<form:form action="saveadmin" modelAttribute="admin">
 enter name:<form:input path="name"/>
 enter email:<form:input path="email"/>
 enter password:<form:input type="password" path="password"/>
 <input type="submit">
</form:form>
</body>
</html>