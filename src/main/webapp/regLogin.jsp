<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Sikeres regisztráció!</h1>
	<form action="j_security_check" method="post">
		<table>
			<tr>
				<td><h2>Belépés:</h2></td>
			</tr>
			<tr>
				<td>Felhasználó:</td>
				<td><input type="text" name="j_username" value="${username}"/></td>
			</tr>
			<tr>
				<td>Jelszó:</td>
				<td><input type="password" name="j_password" value="${password}"/></td>
			</tr>
		</table>
		<input type="submit" name="submit" value="Belépés">
	</form>
</body>
</html>