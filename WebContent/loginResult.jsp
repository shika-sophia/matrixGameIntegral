<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- User情報を取得 --%>
<%@ page import="model.User"%>
<%-- セッションスコープのインスタンスを取得 --%>
<%
	User user = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>matrixGame</title>
</head>
<body>


<main>
	<!-- ログイン成功した場合の出力 -->
	<%
		if (user != null) {
	%>
	<p>ログイン成功</p>
	<p>ようこそ<%= user.getName() %>さん</p>
	<p><%= user.getPass() %></p>
	<p><%= user.getAccountId() %></p>
	<p>
		<a href="/matrixGameIntegral/StartServlet">ゲーム選択画面へ</a>
	</p>
	<% } else { %>
	<!-- ログイン失敗した場合の出力 -->
	<p>ログイン失敗</p>
	<p>
		<a href="/matrixGameIntegral/Register">本登録する</a>
	</p>
	<% } %>

	<!-- ログアウト処理 -->
	<p>
		<a href="/matrixGameIntegral/Logout">ログアウト</a>
	</p>
	<p>
		<a href="/index.jsp">トップへ戻る</a>
</main>
</body>
</html>