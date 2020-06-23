<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<style>
.message {
    color: deeppink;
    text-align: center;
    font-weight: bold;
}
</style>
<meta charset="UTF-8">
<title>matrix新規登録画面</title>
</head>

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
<div id="index" align="center">
<table class="index">
<tr>
  <th style="text-align: center; font-size: large;">
<i>＊ 新規会員登録 ＊　　</i>
  </th></tr>
<tr><td>
<form action="/matrixGameIntegral/RegisterServlet" method="post">
	<p>ユーザー名　：<input type="text" name="name" required></p>
	<p>パスワード　：<input type="password" name="pass" required></p>
	<p>アカウントID：<input type="text" name="accountId" required></p>
<br>
	<p class="buttan"><input type="submit" value="確認">　　</p>
</form>

</td></tr></table>
</div>

</body>
</html>