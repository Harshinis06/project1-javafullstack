<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${a}
<form action="validateuser" method="post">
Enter Email<input type="text" name="email">
Enter password<input type="password" name="password">
<input type="submit">
</form>
</body>
</html>