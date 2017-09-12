<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>New Question</title>
	<link rel="stylesheet" type="text/css" href="css/newQuestion.css">
</head>
<body>
	<h1>What is your question?</h1>
	<form:form method="POST" action="/questions/new" modelAttribute="Question">
		<form:label path="question">Question:
		<form:errors path="question"/>
		<form:input path="question"/></form:label>
		
		<p>${error}</p>
		<label>Tags:
		<input type="text" name="tagList"/></label>
		
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>