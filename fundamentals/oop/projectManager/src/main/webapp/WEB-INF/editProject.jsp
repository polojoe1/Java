<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <h1 class="text-center text-success">Edit a Project</h1>
	<form:form class="form-control" action="/projects/edit/${Myproject.id}"
		method="post" modelAttribute="Myproject">
		<input type="hidden" name="_method" value="put">
		<form:hidden path="users" value="${user_id}" />
		<p>
			<form:label path="title">Project Title:</form:label>
			<form:errors path="title"></form:errors>
			<form:input path="title"></form:input>
		</p>
		<form:hidden path="id"/>
		<form:hidden path="teamLead" value="${user.firstName}"/>
		<p>
			<form:label path="description">Project Description:</form:label>
			<form:errors path="description"></form:errors>
			<form:input path="description"></form:input>
		</p>

		<p>
			<form:label path="dueDate">Project Due Date:</form:label>
			<form:errors path="dueDate"></form:errors>
			<form:input type="date" path="dueDate"></form:input>
		</p>
		<p>
			<input type="submit" class="btn btn-warning" value="edit Project" ></input>
		</p>
	</form:form>
</body>
</html>

