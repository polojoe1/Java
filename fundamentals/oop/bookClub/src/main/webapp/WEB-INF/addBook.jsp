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
<title>Tacos</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	   
	<h1>Add a Book</h1>
	
	<div class="login">
	<form:form class="form-control d-flex flex-column"
		action="/books/add/new" method="post" modelAttribute="newBook">
		<form:label path="title">Title: </form:label>
		<form:errors class="text-danger" path="title"></form:errors>
		<form:input path="title" />
		
		<form:hidden path="user" value="${user_id}"/>
		<form:label path="author">Author </form:label>
		<form:errors class="text-danger" path="author"></form:errors>
		<form:input path="author" />

		<form:label path="description">Description: </form:label>
		<form:errors class="text-danger" path="description"></form:errors>
		<form:textarea class="mb-2" path="description" />

		<input class="mx-auto" type="submit" />
	</form:form>
	</div>
	<a href="/home" class="btn btn-warning">back</a>
</body>
</html>

