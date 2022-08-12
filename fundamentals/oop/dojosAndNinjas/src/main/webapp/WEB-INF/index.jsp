<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
    
<meta charset="UTF-8">
<title>Dojos and Ninjas</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	   
	<table class="table mb-3">
		<thead>
			<th><h1>Dojos</h1></th>
		</thead>
		<tbody>
			<c:forEach var="dojo" items="${allDojos }">
				<tr>
					<td><h3><a href="/dojo/${dojo.id}/info">${dojo.name}</a></h3></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="/ninja/new" class="btn btn-success mb-3">Become a Ninja</a>

	<h1>New Dojo</h1>
	<form:form class="form-control" action="/dojo" method="post"
		modelAttribute="dojo">
		<p>
			<form:label path="name">Name:</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<input type="submit" class="btn btn-info" value="Create" />
	</form:form>
</body>
</html>

