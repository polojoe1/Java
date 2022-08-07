<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>I love me</title>
</head>
<body>
	<h1>Customer name: <c:out value="${name}"></c:out></h1>
	<h3>Item name: <c:out value="${item}"></c:out></h3>
	<h3>Price: $<c:out value="${price}"></c:out></h3>
	<h3>Description: <c:out value="${description}"></c:out></h3>
	<h3>Vendor: <c:out value="${vendor}"></c:out></h3>
</body>
</html>