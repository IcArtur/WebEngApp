<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>registrazione</title>
</head>
<body>

<div align="center">

	<form action="RegistrationServlet" method="post">
	
		User name : <input type="text" name="user" required="required">
		
		password : <input type="password" name="password" required="required">
		
		email : <input type="text" name="email" required="required">
		
		<input type="submit" value="REGISTER">
		
		
	
	</form>


</div>

</body>
</html>