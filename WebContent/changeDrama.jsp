<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>change drama</title>
</head>
<body>

	<h3>${drama.title}の作品情報を変更します</h3>
	<form action="/recommendedDrama/ChangeDramaServlet?action=second" method="post">
		タイトル：<input type="text" name="title" value="${drama.title}"><br>
		カテゴリー：<input type="text" name="category" value="${drama.category}"><br>
		シーズン数：<input type="text" name="season" value="${drama.season}"><br>
		キャスト：<input style="width:75%;" type="text" name="cast" value="${drama.casts}"><br>
		視聴可能サービス：<input type="text" name="service" value="${drama.services}">
		<br>

		<hr>

		<br>

	<h3>点数</h3>
		<c:forEach items="${list}" var="list">
		${list.question}:
		<select name="${list.question}">
			<c:choose>
				<c:when test="${list.nowPoint eq 1}">
				<option value="1" selected>1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</c:when>
			<c:when test="${list.nowPoint eq 2}">
				<option value="1">1</option>
				<option value="2" selected>2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</c:when>
			<c:when test="${list.nowPoint eq 3}">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3" selected>3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</c:when>
			<c:when test="${list.nowPoint eq 4}">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4" selected>4</option>
				<option value="5">5</option>
			</c:when>
			<c:when test="${list.nowPoint eq 5}">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5" selected>5</option>
			</c:when>
			</c:choose>
		</select><br>
	</c:forEach>

		<input type="submit" value="変更">
	</form>

</body>
</html>