<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Questions Dashboard</title>
	<link rel="stylesheet" type="text/css" href="css/showQuestions.css">
</head>
<body>
	<h1>Questions Dashboard</h1>
	<table>
		<tr>
			<th>Question</th>
			<th>Tags</th>
		</tr>
		<c:forEach var="question" items="${questions}">
			<tr>
				<td><a href="/questions/${question.id}">${question.question}</a></td>
				<td>
					<c:forEach var="tag" items="${question.tags}" varStatus="loop">
						${tag.subject}
						<c:if test="${!loop.last}">, </c:if>
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/questions/new">New Question</a>
</body>
</html>