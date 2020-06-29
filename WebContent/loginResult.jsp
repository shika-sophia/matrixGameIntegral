<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%@ page import="model.User" %>
<% User user = (User) session.getAttribute("user"); %>
<% boolean isLogin = (boolean) request.getAttribute("isLogin");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginResult</title>
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
<br>
<div id="index" align="center">
<table class="index">
<tr>
  <th style="text-align: center; font-size: large;">
<i>＊ Login Result ＊　　</i>
  </th></tr>
<tr><td>
  <!-- ログイン成功した場合の出力 -->
  <%
  if (isLogin) {
  %>
  <p>ログイン成功</p>
  <p>ようこそ<%= user.getName() %>さん</p>
  <p><%= user.getPass() %></p>
  <p><%= user.getAccountId() %></p>
  <p><%= user.getMail() %></p>
<br>
<br>
  <p>
    <a href="/matrixGameIntegral/StartServlet">ゲーム選択画面へ</a>
  </p>
  <% } else { %>
  <!-- ログイン失敗した場合の出力 -->
  <p>ログイン失敗</p>
<br>
<br>
  <p>
    <a href="/matrixGameIntegral/RegisterServlet">本登録する</a>
  </p>
  <% } %>

  <p>
    <a href="/matrixGameIntegral/LogoutServlet">ログアウト</a>
  </p>
  <p>
    <a href="index.jsp">トップへ戻る</a>
    </p>
</td></tr></table>
</div>
</body>
</html>