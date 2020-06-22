<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String message = (String) request.getAttribute("message"); %>

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
<% if (message != null) {%>
<p class = "message"><%= message %></p>
<% } else if (message == null){  } %>
<br>
<div id="index" align="center">
<table class="index">
<tr>
  <th style="text-align: center; font-size: large;">
<i>＊ 新規会員登録 ＊　　</i>
  </th></tr>
<tr><td>
<form action="/matrixGameIntegral/RegisterServlet" method="post">
	<p>アカウントID：<input type="text" name="accountId"></p>
	<p>ユーザー名　：<input type="text" name="name"></p>
	<p>パスワード　：<input type="password" name="pass"></p>
<br>
	<p class="buttan"><input type="submit" value="確認">　　</p>
</form>

</td></tr></table>
</div>

</body>
</html>