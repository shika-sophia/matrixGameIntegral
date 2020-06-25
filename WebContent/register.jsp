<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User;" %>
<% User user = (User) session.getAttribute("user"); %>

<% String name =""; %>
<% String pass =""; %>
<% String accountId =""; %>

<% if(user != null){ %>
<%   name = user.getName(); %>
<%   pass = user.getPass(); %>
<%   accountId = user.getAccountId(); %>
<% } else { ; }%>

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
<i>＊ 新規会員登録(仮登録) ＊　</i>
  </th>
</tr>
<tr><td>
  <p class="message">本登録のためメールを送信します。</p>
</td></tr>
<tr><td>
<form action="/matrixGameIntegral/RegisterServlet" method="post">
	<p>ユーザー名　：<input type="text" name="name" value="<%= name %>" required></p>
	<p>パスワード　：<input type="password" name="pass" value="<%= pass %>" required></p>
	<p>アカウントＩＤ：<input type="text" name="accountId" value="<%= accountId %>" required></p>
	<p>メールアドレス：<input type="email" name="mail" required></p>
<br>
	<p class="buttan"><input type="submit" value="確認">　　</p>
</form>

</td></tr></table>
</div>

</body>
</html>