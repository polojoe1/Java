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
<title>Hi</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	   <h1 class="text-center text-success">Create a Project</h1>
	<form:form class="form-control" action="/projects/add/new"
		method="post" modelAttribute="newProject">

		<p>
			<form:label path="title">Project Title:</form:label>
			<form:errors path="title"></form:errors>
			<form:input path="title"></form:input>
		</p>
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
			<input type="submit" class="btn btn-success" value="add Project" ></input>
		</p>
	</form:form>
</body>
</html>

