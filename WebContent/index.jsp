<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パズルゲームログイン画面</title>
<link rel="stylesheet" href="indexStyle.css">
</head>
<body>
<!-- Upper Section -->
<div id="upper">
<hr color="white" size="5">
<h1><i>＊ Matrix Game ＊　</i></h1>
<hr color="white" size="5">
</div>
<br>
<br>
<br>
<div id="index" align="center">
<table class="index">
<tr>
  <th style="text-align: center; font-size: large;">
<i>＊ L o g i n ＊　　</i>
  </th></tr>
<tr><td>
	<form action="/matrixGameIntegral/LoginServlet" method="post">
		<p>ユーザー名　：<input type="text" name="name"></p>
		<p>パスワード　：<input type="password" name="pass"></p>
		<p>アカウントID：<input type="text" name="accountId"></p>

		<p class="buttan"><input type="submit" value="ログイン">　</p>
	</form>
<br>
<br>
<br>
	<p><a href="/matrixGameIntegral/RegisterServlet">新規登録は こちら</a></p>
</td></tr></table>
</div>
</body>
</html>