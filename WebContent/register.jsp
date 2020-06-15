<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String message = (String) request.getAttribute("message"); %>
<!DOCTYPE html>
<html>
<head>
<style>
.class{
    color: red;
}
</style>
<meta charset="UTF-8">
<title>matrix新規登録画面</title>
</head>
<body>
<p class = "message"><%= message %></p>
<main>
<h2>新規会員登録</h2>
<form action="/matrixGameIntegral/RegisterServlet" method="post">
	<p>アカウントID：<input type="text" name="	accountId"></p>
	<p>名前：<input type="text" name="name"></p>
	<p>パスワード：<input type="password" name="pass"></p>
	<p><input type="submit" value="確認"></p>
</form>
</main>


</body>
</html>