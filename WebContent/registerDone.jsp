<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- User情報を取得 --%>
<%@ page import="model.User"%>
<%-- セッションスコープのインスタンスを取得 --%>
<%
	User user = (User) session.getAttribute("User");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOCOTSUBU</title>
</head>
<body>

<main>
	<!-- ログイン成功した場合の出力 -->
	<%
		if (user != null) {
	%>
	<p>ようこそ<%= user.getName() %>さん</p>
	<p><%= user.getPass() %></p>
	<p><%= user.getAccountId() %></p>
	<h2>登録完了</h2>
	<p>会員登録が完了しました！</p>
	<p>
		<a href="/matrixGamemkm/StartServlet">ゲーム選択画面へ</a>
	</p>
	<% } else { %>
	<!-- ログイン失敗した場合の出力 -->
	<p>登録失敗</p>
	<p>
		<a href="/matrixGamemkm/register.jsp">新規登録へ戻る</a>
	</p>
	<% } %>

	<!-- ログアウト処理 -->
	<p>
		<a href="/matrixGamemkm/LogoutServlet">ログアウト</a>
	</p>
	<p>
		<a href="/matrixGamemkm">トップへ戻る</a>
</main>


<main>

</main>
</body>
</html>