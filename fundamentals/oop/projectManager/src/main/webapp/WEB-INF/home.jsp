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
    <title>Welcome</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   Hello sir/ma'am! 
${thisUser.firstName}
	<h3 class="mx-auto">All Projects</h3>
	<a href="/projects/new" class="btn btn-info">+ new project</a>
	<table class="table mb-3">
		<thead>
			<tr>
				<th>Project</th>
				<th>Team Lead</th>
				<th>Due Date</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach var="project" items="${allProjects}">
			<c:if test="${!(thisUser.firstName eq project.teamLead) and !(thisUser.projects.contains(project)) }">
				<tr>
					<td><a href="/projects/info/${project.id}">${project.title}</a></td>
					<td>${project.teamLead}</td>
					<td>${project.dueDate}</td>
					<td><a href="/projects/join/${project.id}">Join team </a></td>
				</tr>
				</c:if>
			</c:forEach>
			
		</tbody>
	</table>
	<h3>Your projects</h3>
	<table class="table">
		<thead>
			<tr>
				<th>Project</th>
				<th>Team Lead</th>
				<th>Due Date</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${thisUser.projects}">
				<tr>
					<td><a href="/projects/info/${p.id}">${p.title}</a></td>
					<td>${p.teamLead}</td>
					<td>${p.dueDate}</td>
					<td> <c:if test="${(thisUser.firstName eq p.teamLead)}"><a href="/projects/edit/${p.id}">edit</a> | <a href="/projects/delete/${p.id }">completed</a></c:if> 
						<c:if test="${!(thisUser.firstName eq p.teamLead)}"><a href="/projects/leave/${p.id}">leave project</a></c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<a href="/logout" class="btn btn-danger">log out</a>
</body>
</html>

