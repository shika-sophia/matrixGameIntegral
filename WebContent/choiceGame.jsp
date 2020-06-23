<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.User" %>
<%@ page import = "model.MatrixBeans" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>

<% User user = (User) session.getAttribute("user"); %>
<% MatrixBeans matrixDB = (MatrixBeans) session.getAttribute("matrixDB"); %>
<% String name = user.getName();%>
<% String saveDateTime = matrixDB.getSaveDateTime(); %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>ゲーム選択画面</title>
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
<i>＊ Game Choice ＊　　</i>
  </th></tr>
<tr><td style="text-align: left; vertical-align: top">
<form action= "/matrixGameIntegral/StartServlet" method="post">
<% if(saveDateTime != null) {%>
<p><input type="submit" name="choiceGame" value="LoadGame">　Saveデータ：<%= name %>さん<br>
　　　　　　　　<%= saveDateTime %></p>
<% } %>
<p><input type="submit" name="choiceGame" value="NewGame">　New Game</p>
</form>
<br>
<br>
<br>
</td></tr></table>
</div>
</body>
</html>