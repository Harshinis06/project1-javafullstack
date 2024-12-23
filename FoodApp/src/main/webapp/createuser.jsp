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
<form:form action="createuser" modelAttribute="users">
Enter Name:<form:input path="name"/>
Enter Mail:<form:input path="email"/>
Enter Password:<form:input type="password" path="password"/>
Enter Mobile:<form:input path="mobilenumber"/>
<input type="submit">
</form:form>
</body>
</html>