<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Question Profile</title>
	<link rel="stylesheet" type="text/css" href="css/showQuestion.css">
</head>
<body>
	<h1>${question.question}</h1>
	<h2>Tags: </h2>
		<c:forEach var="tag" items="${question.tags}">
			${tag.subject}
		</c:forEach>
	<table>
		<tr>
			<th>Answers</th>
		</tr>
		<c:forEach var="answer" items="${question.answers}">
			<tr>
				<td>${answer.answer}</td>
			</tr>
		</c:forEach>
	</table>
	<h2>Add your answer:</h2>
	<form:form method="POST" action="/answers/add/${question.id}" modelAttribute="Answer">
		<form:label path="answer">Answer:
		<form:errors path="answer"/>
		<form:input path="answer"/></form:label>
		
		<input type="submit" value="Answer it!">
	</form:form>
	<a href="/questions">Dashboard</a>
</body>
</html>