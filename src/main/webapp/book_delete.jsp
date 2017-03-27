<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Törölve</title>
</head>
<body>
<form method="post" action="book_delete">
	<table border="1">
		<tr>
			<td>Könyv azonosítója</td>
			<td><input name="id" readonly="readonly" value="${book.id}"/></td>
		</tr>
		<tr>
			<td>Könyv címe</td>
			<td><input name="title" readonly="readonly" value="${book.title}"/></td>
		</tr>
		<tr>
			<td>Könyv szerzője</td>
			<td><input name="author" readonly="readonly" value="${book.author}"/></td>
		</tr>
		<tr>
			<td>Könyv leírása</td>
			<td><input name="description" readonly="readonly" value="${book.description}"/></td>
		</tr>
		<tr>
			<td>Kiadás éve</td>
			<td><input name="pubYear" readonly="readonly" value="${book.pubYear}"/></td>
		</tr>
	</table>
	<h1>Biztosan törölni szeretnéd?</h1>
	<input type="submit" value="Igen" name="igen"/><button><a href="book_list">Nem</a></button>
</form>
</body>
</html>