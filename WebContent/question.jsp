<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String name = (String)request.getAttribute("name");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recommended Foreign Dramas</title>
</head>
<body>

	<h2>${name}さん、こんにちは！</h2><br>
	<h3>次の質問に全て答えてください。</h3>

	Q1.どんな形式のドラマが好き？<br>
		<form action="PointServlet" method="post">
			<input type="radio" name="type" value="one">一話完結もの
			<input type="radio" name="type" value="continue">連続もの
			<input type="radio" name="type" value="none">特にこだわりはない<br><br>

	Q2.次の生き物の中で、一匹だけペットにするとしたらどれ？<br>
			<input type="radio" name="pet" value="dragon">ドラゴン
			<input type="radio" name="pet" value="lizard">トカゲ
			<input type="radio" name="pet" value="owl">フクロウ
			<input type="radio" name="pet" value="rabbit">ウサギ<br><br>

	Q3.そんなにリスクが高くない手術を受けるとしたら、誰に頼む？<br>
			<input type="radio" name="ope" value="skill">薄情でいちいち発言がムカつくけど、腕はトップレベルの天才外科医<br>
			<input type="radio" name="ope" value="kind">腕は標準レベルだが、手術前も手術後も常に患者に寄り添う優しい医者<br>
			<input type="radio" name="ope" value="none">特にこだわりはない<br><br>

	Q4.好きな人に告白してふられちゃった…。何をして気を紛らわす？<br>
			<input type="radio" name="confession" value="eat">とにかく食べる！
			<input type="radio" name="confession" value="friends">友達と遊ぶ
			<input type="radio" name="confession" value="talk">誰かに話を聞いてもらう
			<input type="radio" name="confession" value="alone">１人で抱え込む
			<input type="radio" name="confession" value="hobby">趣味に時間を費やす
			<input type="radio" name="confession" value="positive">過去のことなんか気にせずに、前進！前進!<br><br>

	Q5.アクションシーンはどう？<br>
			<input type="radio" name="action" value="love">めちゃくちゃ好き
			<input type="radio" name="action" value="like">普通に好き
			<input type="radio" name="action" value="dislike">あまり好きではない
			<input type="radio" name="action" value="hate">嫌い
			<input type="radio" name="action" value="none">どれでもない<br><br>

	Q6.１人が好き？<br>
			<input type="radio" name="own" value="alone">１人が好き
			<input type="radio" name="own" value="multiple">誰かと一緒にいたい
			<input type="radio" name="own" value="none">どちらでもない<br><br>

	Q7.ハラハラドキドキはどう？<br>
			<input type="radio" name="excite" value="like">好き！
			<input type="radio" name="excite" value="dislike">別に…<br><br>

	Q8.怖いのは好き？<br>
			<input type="radio" name="fear" value="love">大好き！
			<input type="radio" name="fear" value="like">嫌いではない
			<input type="radio" name="fear" value="hate">無理！<br><br>

		<input type="submit" value="診断！">
	</form>
</body>
</html>