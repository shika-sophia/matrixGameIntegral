<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パズルゲームログイン画面</title>
</head>
<body>
<main>
	<form action="/matrixGamemkm/loginServlet" method="post">
		<p>ユーザー名：<input type="text" name="name"></p>
		<p>パスワード：<input type="password" name="pass"></p>
		<p>アカウントID:<input type="text" name="accountId"></p>
		<p><input type="submit" value="ログイン"></p>
	</form>

	<p><a href="/matrixGamemkm/RegisterServlet">新規登録はこちら</a></p>
</main>

</body>
</html>