<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- User情報を取得 --%>
<%@ page import="model.User"%>
<%-- セッションスコープのインスタンスを取得 --%>
<% User user = (User) session.getAttribute("user"); %>

<%
   String message = (String) request.getAttribute("message");
   boolean existAccountId = (boolean) request.getAttribute("existAccountId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerDone</title>
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
<br>
<i>＊ 登録結果 ＊　　</i>
  </th></tr>
<tr><td>
	<!-- 新規登録成功した場合の出力 -->
	<%
		if (existAccountId == false) {
	%>
	<p>ようこそ<%= user.getName() %>さん</p>
	<p><%= user.getPass() %></p>
	<p><%= user.getAccountId() %></p>
<br>
	<p>会員登録が完了しました！</p>
<br>

<br>
	<p>
		<a href="/matrixGameIntegral/StartServlet">ゲーム選択画面へ</a>
	</p>
	<% } else { %>
	<!-- 新規登録失敗した場合の出力 -->
	<p>登録失敗</p>
<p style="text-align: center; color: deeppink;" class = "message"><b><%= message %></b></p>
<br>
	<p>
		<a href="/matrixGameIntegral/RegisterServlet">新規登録へ戻る</a>
	</p>
	<% } %>
<br>
	<!-- ログアウト処理 -->
	<p>
		<a href="/matrixGameIntegral/LogoutServlet">ログアウト</a>
	</p>
<br>
	<p>
		<a href="/matrixGameIntegral">トップへ戻る</a>
	</p>
</td></tr></table>
</div>
</body>
</html>