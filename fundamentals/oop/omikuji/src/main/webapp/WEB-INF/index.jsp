<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<h1>Send an Omikuji</h1>
	<div class="content">
		<form class="form-control mb-2" action="/info" method="post">
			<label for="number">Pick any number from 5 to 25</label>
			<input class="mb-2" name="number" type="number" />
			
			<label for="city">Enter the name of any city</label>
			<input class="mb-2" name="city" type="text" />
			
			<label for="name">Enter a first and last name</label>
			<input class="mb-2" name="name" type="text" />
			
			<label for="hobby">Enter a hobby</label>
			<input class="mb-2" name="hobby" type="text" />
			
			<label for="animal">Enter any living thing</label>
			<input class="mb-2" name="animal" type="text" />
			
			<label for="nice">Say something nice to someone:</label>
			<textarea name="nice" id="" cols="30" rows="5"></textarea>
			
			<input type="submit" value="send" class="mx-auto btn btn-success" />
		</form>
	</div>
</body>
</html>