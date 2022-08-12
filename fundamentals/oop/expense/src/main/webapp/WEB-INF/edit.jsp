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
<title>Edit</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	   
	<h1>Edit ${expense.name}</h1>
	<a href="/" class="btn btn-info">back</a>
	<form:form action="/expenses/${expense.id}" method="post"
		modelAttribute="expense">
		<input type="hidden" name="_method" value="put">
		<p>
			<form:label path="name">name</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<p>
			<form:label path="vendor">vendor</form:label>
			<form:errors path="vendor" />
			<form:input path="vendor" />
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:errors path="description" />
			<form:textarea path="description" />
		</p>

		<p>
			<form:label path="amount">amount</form:label>
			<form:errors path="amount" />
			<form:input type="text" path="amount" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>

