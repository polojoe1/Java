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
<title>Register</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>Book Club!</h1>
	<div class="content">
		<div class="register">
			<h1>Register</h1>			   
			<form:form class="form-control" action="/register" method="post"
				modelAttribute="newUser">
				<p>
					<form:label path="firstName">First Name:</form:label>
					<form:errors class="text-danger" path="firstName" />
					<form:input class="form-control" path="firstName" />
				</p>
				<p>
					<form:label path="lastName">Last Name:</form:label>
					<form:errors class="text-danger" path="lastName" />
					<form:input class="form-control" path="lastName" />
				</p>
				<p>
					<form:label path="email">Email:</form:label>
					<form:errors class="text-danger" path="email" />
					<form:input class="form-control" type="email" path="email" />
				</p>
				<p>
					<form:label path="password">Password:</form:label>
					<form:errors class="text-danger" path="password" />
					<form:input class="form-control" type="password" path="password" />
				</p>
				<p>
					<form:label path="confirm">Password:</form:label>
					<form:errors class="text-danger" path="confirm" />
					<form:input class="form-control" type="password" path="confirm" />
				</p>
				<input type="submit" class="btn btn-info" value="Register" />
			</form:form>
		</div>
		<div class="login">
			<h1 class="mb-3">Log-in</h1>
			<form:form class="form-control" action="/login" method="post"
				modelAttribute="newLogin">
				<p>
					<form:label path="email">Email:</form:label>
					<form:errors class="text-danger" path="email" />
					<form:input class="form-control" type="email" path="email" />
				</p>
				<p>
					<form:label path="password">Password:</form:label>
					<form:errors class="text-danger" path="password" />
					<form:input class="form-control" type="password" path="password" />
				</p>
				<input type="submit" class="btn btn-success" value="log-in" />
			</form:form>
		</div>
	</div>
</body>
</html>

