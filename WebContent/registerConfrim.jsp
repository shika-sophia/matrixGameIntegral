<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User user = (User) session.getAttribute("User");
%>
<!-- Userのセッションスコープを獲得 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>matrix登録画面</title>
</head>
<body>


<main>
<h2>登録内容確認</h2>
<ul>
	<li>ユーザーID：<%= user.getAccountId() %></li>
	<li>名前：<%= user.getName() %></li>
	<li>パスワード：<%= user.getPass() %></li>
</ul>

<p>上記の内容で登録しますか？</p>
<ul>
	<li><a href="/matrixGamemkm/RegisterServlet?action=done">登録する</a></li>
	<li><a href="/matrixGamemkm/RegisterServlet">戻る</a></li>
</ul>
</main>

</body>
</html>