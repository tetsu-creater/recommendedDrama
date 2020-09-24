<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="la.bean.QuestionBean" %>

<%
	QuestionBean question = (QuestionBean)request.getAttribute("question");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recommended Foreign Drama</title>
</head>
<body>

<h1>おすすめドラマ１～５位です</h1>
<br>
<hr>

<c:forEach items="${question.points}" var="point">
	<h3>第${point.value.rank}位：${point.value.title}</h3><br>
	カテゴリー：${point.value.category}<br>
	シーズン数：${point.value.season}<br>
	<img src="Java_recommendedDrama_file/drama_image/${point.value.photo}"><br>
	出演者：${point.value.casts}<br>
	あらすじ：<object data="Java_recommendedDrama_file/drama_content/${point.value.content}" type="text/plain" height="100%" width="100%"></object><br>
	視聴可能サービス：${point.value.services}<br>
	<hr>
</c:forEach>


</body>
</html>