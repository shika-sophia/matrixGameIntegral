<!--
 /**
 *@title matrix.jsp
 *@author Shika
 *@date First:2020-05-28 Last:2020-06-05
 *@see ColorSevlet.java
 *@see matrixStyle.css

 *@env 推奨実行環境 eclipse 設定 → 一般 → Webブラウザ: Google Chrome
 *@env width=1000px height=800px
 */
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.User" %>
<%@ page import = "model.MatrixBeans"  %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>

<% List<String> color = (List<String>) application.getAttribute("color");%>

<% String message = (String) request.getAttribute("message"); %>
<% User user = (User) session.getAttribute("user"); %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--
  <script type="text/javascript">
  window.open("http://localhost:8080/matrixGameIntegral/ColorServlet","Matrix Game","width=1000px,heigt=800px");
  </script>
 -->
<title>matrixGame View</title>

<link rel="stylesheet" href="matrixStyle.css">
</head>

<body>
<!-- Upper Section -->
<div id="upper">
<hr color="white" size="5">
<h1><i>＊ Matrix Game ＊　</i></h1>
<hr color="white" size="5">
</div>

<!-- Main Section -->
<div id="main" align="center">
<!-- Table 5×5 Matrix Table -->
<form id="select" action="/matrixGameIntegral/ColorServlet" method="post">
<table class="matrix" border="1">

<colgroup>
  <col span="1" class="X1">
  <col span="1" class="X2">
  <col span="1" class="X3">
  <col span="1" class="X4">
  <col span="1" class="X5">
</colgroup>

<tr class="Y1">
  <td style="background-color: <%= color.get(1) %>">
    <button type="submit" name="select" value="1" style="background-color: <%= color.get(1) %>">１</button></td>
  <td style="background-color: <%= color.get(2) %>">
    <button type="submit" name="select" value="2">２</button></td>
  <td style="background-color: <%= color.get(3) %>">
    <button type="submit" name="select" value="3">３</button></td>
  <td style="background-color: <%= color.get(4) %>">
    <button type="submit" name="select" value="4">４</button></td>
  <td style="background-color: <%= color.get(5) %>">
    <button type="submit" name="select" value="5">５</button></td>
</tr>
<tr class="Y2">
  <td style="background-color: <%= color.get(6) %>">
    <button type="submit" name="select" value="6">６</button></td>
  <td style="background-color: <%= color.get(7) %>">
    <button type="submit" name="select" value="7">７</button></td>
  <td style="background-color: <%= color.get(8) %>">
    <button type="submit" name="select" value="8">８</button></td>
  <td style="background-color: <%= color.get(9) %>">
    <button type="submit" name="select" value="9">９</button></td>
  <td style="background-color: <%= color.get(10) %>">
    <button type="submit" name="select" value="10">10</button></td>
</tr>
<tr class="Y3">
  <td style="background-color: <%= color.get(11) %>">
    <button type="submit" name="select" value="11">11</button></td>
  <td style="background-color: <%= color.get(12) %>">
    <button type="submit" name="select" value="12">12</button></td>
  <td style="background-color: <%= color.get(13) %>">
    <button type="submit" name="select" value="13">13</button></td>
  <td style="background-color: <%= color.get(14) %>">
    <button type="submit" name="select" value="14">14</button></td>
  <td style="background-color: <%= color.get(15) %>">
    <button type="submit" name="select" value="15">15</button></td>
</tr>
<tr class="Y4">
  <td style="background-color: <%= color.get(16) %>">
    <button type="submit" name="select" value="16">16</button></td>
  <td style="background-color: <%= color.get(17) %>">
    <button type="submit" name="select" value="17">17</button></td>
  <td style="background-color: <%= color.get(18) %>">
    <button type="submit" name="select" value="18">18</button></td>
  <td style="background-color: <%= color.get(19) %>">
    <button type="submit" name="select" value="19">19</button></td>
  <td style="background-color: <%= color.get(20) %>">
    <button type="submit" name="select" value="20">20</button></td>
</tr>
<tr class="Y5">
  <td style="background-color: <%= color.get(21) %>">
    <button type="submit" name="select" value="21">21</button></td>
  <td style="background-color: <%= color.get(22) %>">
    <button type="submit" name="select" value="22">22</button></td>
  <td style="background-color: <%= color.get(23) %>">
    <button type="submit" name="select" value="23">23</button></td>
  <td style="background-color: <%= color.get(24) %>">
    <button type="submit" name="select" value="24">24</button></td>
  <td style="background-color: <%= color.get(25) %>">
    <button type="submit" name="select" value="25">25</button></td>
</tr>
</table>
</form>

<!-- Controler Table -->

<table class="controler" border="0">
<form action="/matrixGameIntegral/ControlerServlet" method="post">
<tr>
<th colspan="5" id="userInfo" >
  <p>User Name : <%= user.getName() %></p>
  <p>Point : <%= user.getPoint() %></p>
  <p>Lank : E</p>
</th>
</tr>
<tr>
  <td>　</td>
  <td>　</td>
  <td><button type="submit" name="cross" value="up">▲</button></td>
  <td>　</td>
  <td>　</td>
</tr>
<tr>
  <td>　</td>
  <td><button type="submit" name="cross" value="left">≪</button></td>
  <td>　</td>
  <td><button type="submit" name="cross" value="right">≫</button></td>
  <td>　</td>
</tr>
<tr>
  <td>　</td>
  <td>　</td>
  <td><button type="submit" name="cross" value="down">▼</button></td>
  <td>　</td>
  <td>　</td>
</tr>
</form>
<tr><td colspan="5">　</td></tr>
<tr>
<td colspan="5">
  <form action="/matrixGameIntegral/SaveServlet" method="get">
    <input type="submit" name="controle" value="Reset">　<input type="submit" name="contorole" value="Save">　<input type="submit" name="controle" value="Logout"></p>
  </form>
</td></tr>
</table>

</div><!-- class="main" 終了 -->

<!-- Under Section -->
<div id="under" align="center">
<table class="stone" border="1">
<tr>
  <td><%//= stoneImage %></td>
  <td><%//= stoneImage %></td>
  <td><%//= stoneImage %></td>
</tr>
</table>

<table class="message" border="0">
<tr><td id="message">
<p style="color: hotpink;"><b><i>＊ Message ＊</i></b></p>
<form action="/matrixGameIntegral/SaveServlet" method="post">
  <p><%= message %></p>

<% if (message != null) {%>
　<input type="submit" name="comfirm" value="YES">　<input type="submit" name="comfirm" value="NO">
<% } %>
</form>

</td></tr></table>
</div>
</body>
</html>
