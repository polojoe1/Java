<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>fruit store</title>
</head>
<body>
	<h1 class="header">Fruit Store</h1>
	<div class="content">
		<table class="table">
			<tr>
				<th>Name</th>
				<th>Price</th>			
			</tr>
			
				<c:forEach var="fruit" items="${fruits}">
					<tr>
						<td><c:out value="${fruit.name}"></c:out></td>
						<td>$<c:out value="${fruit.price}"></c:out></td>
					</tr>
				</c:forEach>
			
		
		</table>
	</div>
	<h5>Joseph Coats Production</h5>
</body>
</html>