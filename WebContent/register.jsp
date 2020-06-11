<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>matrix新規登録画面</title>
</head>
<body>

<main>
<h2>新規会員登録</h2>
<form action="/matrixGamemkm/RegisterServlet" method="post">
	<p>アカウントID：<input type="text" name="	accountId"></p>
	<p>名前：<input type="text" name="name"></p>
	<p>パスワード：<input type="password" name="pass"></p>
	<p><input type="submit" value="確認"></p>
</form>
</main>


</body>
</html>