<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- User情報を取得 --%>
<%@ page import="model.User"%>
<%-- セッションスコープのインスタンスを取得 --%>
<%
	User loginUser = (User) session.getAttribute("loginUser");
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
		if (loginUser != null) {
	%>
	<p>ログイン成功</p>
	<p>ようこそ<%= loginUser.getName() %>さん</p>
	<p><%= loginUser.getPass() %></p>
	<p><%= loginUser.getAccountId() %></p>
	<p>
		<a href="/matrixGamemkm/StartServlet">ゲーム選択画面へ</a>
	</p>
	<% } else { %>
	<!-- ログイン失敗した場合の出力 -->
	<p>ログイン失敗</p>
	<p>
		<a href="/index.jsp">トップへ戻る</a>
	</p>
	<% } %>

	<!-- ログアウト処理 -->
	<p>
		<a href="/matrixGamemkm/Logout">ログアウト</a>
	</p>
	<p>
		<a href="/matrixGamemkm">トップへ戻る</a>
</main>
</body>
</html>