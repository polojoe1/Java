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
    <title>Ninjas</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>Join our list of Ninjas!</h1>
	<table class="table mb-3">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Location</th>
			</tr>
		</thead>
		<tbody>
			
				<c:forEach var="nin" items="${allNinjas}">
					<tr>
					<td>${nin.firstName }</td>
					<td>${nin.lastName }</td>
					<td>${nin.age }</td>
					<td>${nin.dojo.name }</td>
					</tr>
				</c:forEach>
			
		</tbody>
	</table>
<a href="/" class="btn btn-primary mb-3">back</a>
<form:form class="form-control" action="/ninja" method="post"
		modelAttribute="ninja">
		<p>
			<form:label path="firstName">First Name:</form:label>
			<form:errors path="firstName" />
			<form:input path="firstName" />
		</p>
		<p>
			<form:label path="lastName">Last Name:</form:label>
			<form:errors path="lastName" />
			<form:input path="lastName" />
		</p>
		<p>
			<form:label path="age">Age: </form:label>
			<form:errors path="age" />
			<form:input type="number" path="age" />
		</p>
		<p>
			<form:label path="dojo">Dojo: </form:label>
			<form:select path="dojo" >
				
					<c:forEach var="d" items="${allDojos}">
						<form:option value="${d.id}">${d.name}</form:option>
					</c:forEach>
				
			</form:select>
			
		</p>
		<input type="submit" class="btn btn-success" value="Join!" />
	</form:form>
</body>
</html>

