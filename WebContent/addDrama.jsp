<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add drama</title>
</head>
<body>

<h3>作品の追加</h3>
	<form action="/recommendedDrama/AddDramaServlet?action=second" method="post">
		作品名：<input type="text" name="title"><br>
		カテゴリー：<input type="text" name="category"><br>
		シーズン数：<input type="text" name="season"><br>
		画像ファイル名：<input type="text" name="image">_image.jpg<br>
		キャスト：<input style="width:75%;" type="text" name="casts"><br>
		あらすじファイル名：<input type="text" name="content">_content.txt<br>
		視聴可能サービス：<input type="text" name="services"><br>

		<hr>

<h3>点数</h3>
		<c:forEach items="${questionList}" var="question">
		${question}:
		<select name="${question}">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select><br>
		</c:forEach>

		<input type="submit" value="追加">
	</form>

</body>
</html>