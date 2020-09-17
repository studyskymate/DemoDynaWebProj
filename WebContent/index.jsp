<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> Welcome to JSP</h1>
<form action="${pageContext.request.contextPath}/login" method="post">
 Name----: <input type="text" name="username"><br><br>
 Password: <input type="password" name="password">
 <input type="submit" name="submit" value="Submit">
</form>


</body>
</html>