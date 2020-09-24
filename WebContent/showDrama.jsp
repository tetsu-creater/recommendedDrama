<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show drama</title>
</head>
<body>

	現在データベースに登録されているドラマ一覧
	<table border="1">
	<tr><td>No</td><td>作品名</td><td>カテゴリー</td><td>シーズン数</td><td>キャスト<td>視聴可能サービス</tr>

	<c:forEach items="${dramas}" var="drama">
		<tr><td>${drama.no}</td><td>${drama.title}</td><td>${drama.category}</td><td>${drama.season}</td><td>${drama.casts}</td><td>${drama.services}</td></tr>
	</c:forEach>
	</table>
	<br>

	<hr>

	<h3>ドラマ情報の変更</h3>
	<form action="/recommendedDrama/ChangeDramaServlet?action=first" method="post">
		変更したい作品名を選択してください<br>
		<select name="drama_change">
			<c:forEach items="${dramas}" var="drama">
				<option value="${drama.code}">${drama.title}</option>
			</c:forEach>
		</select>
		<input type="submit" value="変更画面へ">
	</form><br>

	<hr>

	<h3>作品の削除</h3>
	<form action="/recommendedDrama/DeleteDramaServlet" method="post">
		削除したい作品を選んでください<br>
		<select name="drama_delete">
			<c:forEach items="${dramas}" var="drama">
				<option value="${drama.code}">${drama.title}</option>
			</c:forEach>
		</select>
		<input type="submit" value="削除">
	</form><br>

	<hr>

	<h3>作品の追加</h3>
	<form action="/recommendedDrama/AddDramaServlet?action=first" method="post">

		<input type="submit" value="作品を追加する">
	</form>

</body>
</html>