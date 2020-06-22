<!--
 /**
 *@title matrix.jsp
 *@author Shika
 *@date First:2020-05-28 Last:2020-06-17
 *@see ColorSevlet.java
 *@see matrixStyle.css

 *@env 推奨実行環境 eclipse 設定 → 一般 → Webブラウザ: Google Chrome
 *@env width=1000px height=800px
 */
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.User" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>

<% List<String> color = (List<String>) application.getAttribute("color"); %>
<% List<String> stoneArea =(List<String>) application.getAttribute("stoneArea"); %>
<% List<String> stoneSelectColor = (List<String>) application.getAttribute("stoneSelectColor"); %>

<% String message = (String) request.getAttribute("message"); %>
<% //boolean flagYesNo = (boolean) request.getAttribute("flagYesNo"); %>

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
<title>matrixGame Main View</title>

<link rel="stylesheet" href="matrixStyle.css">
</head>

<body>
<!-- Upper Section -->
<div id="upper">
<hr color="white" size="5">
<h1><i>＊ Matrix Game ＊　</i></h1>
<hr color="white" size="5">
</div>

<!-- Under Section -->
<!-- Stone Table -->
<div id="under" align="center">
<table class="stone" border="1">
<tr>
  <form action="/matrixGameIntegral/StoneSelectServlet" method="post">
  <td style="border-width: 3px;
      border-color: <%= stoneSelectColor.get(1) %> ">
      <button id="stone" type="submit" name="stoneSelect" value="tri">
          <img src="image/triStoneX.png" width="70" height="70" border="0"
          alt="matrixGame_triStone" style="vertical-align: middle" >
      </button>
  </td>
  <td style="border-width: 3px; border-color: <%= stoneSelectColor.get(2) %>">
      <button id="stone" type="submit" name="stoneSelect" value="twice">
        <img src="image/twiceStone.png" width="35" height="70" border="0"
        alt="matrixGame_twiceStone" style="vertical-align: middle">
      </button>
  </td>
  <td style="border-width: 3px; border-color: <%= stoneSelectColor.get(3) %>">
      <button id="stone" type="submit" name="stoneSelect" value="mono">
        <img src="image/monoStone.png" width="35" height="35" border="0" align="center"
        alt="matrixGame_monoStone" style="vertical-align: middle">
      </button>
  </td>
  </form>
</tr>
</table>

<!-- Message Table -->
<table class="message" border="0">
<tr><td id="message">
<p style="color: hotpink; vertical-align: top"><b><i>＊ Message ＊</i></b></p>
<form action="/matrixGameIntegral/SaveServlet" method="post">
<% if (message != null && !(message.equals(""))) {%>
  <p><%= message %></p>
<% //} else if (flagYesNo == true){ %>
　<input type="submit" name="comfirm" value="YES">　<input type="submit" name="comfirm" value="NO">
<% } else if (message == null){
   ;} %>
</form>
</td></tr></table>
</div>

<!-- Main Section -->
<!-- Table 5×5 Matrix Table -->
<div id="main" align="center">
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
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(1) %>;
        background-color: <%= color.get(1) %>" >
    <button type="submit" name="select" value="1"
        style="
        border-style: none;
        background-color: <%= color.get(1) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(2) %>;
        background-color: <%= color.get(2) %>">
    <button type="submit" name="select" value="2"
        style="
        border-style: none;
        background-color: <%= color.get(2) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(3) %>;
        background-color: <%= color.get(3) %>">
    <button type="submit" name="select" value="3"
        style="
        border-style: none;
        background-color: <%= color.get(3) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(4) %>;
        background-color: <%= color.get(4) %>">
    <button type="submit" name="select" value="4"
        style="
        border-style: none;
        background-color: <%= color.get(4) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(5) %>;
        background-color: <%= color.get(5) %>">
    <button type="submit" name="select" value="5"
        style="
        border-style: none;
        background-color: <%= color.get(5) %>">　</button>
  </td>
</tr>
<tr class="Y2">
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(6) %>;
        background-color: <%= color.get(6) %>">
    <button type="submit" name="select" value="6"
        style="
        border-style: none;
        background-color: <%= color.get(6) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(7) %>;
        background-color: <%= color.get(7) %>">
    <button type="submit" name="select" value="7"
        style="
        border-style: none;
        background-color: <%= color.get(7) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(8) %>;
        background-color: <%= color.get(8) %>">
    <button type="submit" name="select" value="8"
        style="
        border-style: none;
        background-color: <%= color.get(8) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(9) %>;
        background-color: <%= color.get(9) %>">
    <button type="submit" name="select" value="9"
        style="
        border-style: none;
        background-color: <%= color.get(9) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(10) %>;
        background-color: <%= color.get(10) %>">
    <button type="submit" name="select" value="10"
        style="
        border-style: none;
        background-color: <%= color.get(10) %>">　</button>
  </td>
</tr>
<tr class="Y3">
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(11) %>;
        background-color: <%= color.get(11) %>">
    <button type="submit" name="select" value="11"
        style="
        border-style: none;
        background-color: <%= color.get(11) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(12) %>;
        background-color: <%= color.get(12) %>">
    <button type="submit" name="select" value="12"
        style="
        border-style: none;
        background-color: <%= color.get(12) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(13) %>;
        background-color: <%= color.get(13) %>">
    <button type="submit" name="select" value="13"
        style="
        border-style: none;
        background-color: <%= color.get(13) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(14) %>;
        background-color: <%= color.get(14) %>">
    <button type="submit" name="select" value="14"
        style="
        border-style: none;
        background-color: <%= color.get(14) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(15) %>;
        background-color: <%= color.get(15) %>">
    <button type="submit" name="select" value="15"
        style="
        border-style: none;
        background-color: <%= color.get(15) %>">　</button>
  </td>
</tr>
<tr class="Y4">
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(16) %>;
        background-color: <%= color.get(16) %>">
    <button type="submit" name="select" value="16"
        style="
        border-style: none;
        background-color: <%= color.get(16) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(17) %>;
        background-color: <%= color.get(17) %>">
    <button type="submit" name="select" value="17"
        style="
        border-style: none;
        background-color: <%= color.get(17) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(18) %>;
        background-color: <%= color.get(18) %>">
    <button type="submit" name="select" value="18"
        style="
        border-style: none;
        background-color: <%= color.get(18) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(19) %>;
        background-color: <%= color.get(19) %>">
    <button type="submit" name="select" value="19"
        style="
        border-style: none;
        background-color: <%= color.get(19) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(20) %>;
        background-color: <%= color.get(20) %>">
    <button type="submit" name="select" value="20"
        style="
        border-style: none;
        background-color: <%= color.get(20) %>">　</button>
  </td></tr>
<tr class="Y5">
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(21) %>;
        background-color: <%= color.get(21) %>">
    <button type="submit" name="select" value="21"
        style="
        border-style: none;
        background-color: <%= color.get(21) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(22) %>;
        background-color: <%= color.get(22) %>">
    <button type="submit" name="select" value="22"
        style="
        border-style: none;
        background-color: <%= color.get(22) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(23) %>;
        background-color: <%= color.get(23) %>">
    <button type="submit" name="select" value="23"
        style="
        border-style: none;
        background-color: <%= color.get(23) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(24) %>;
        background-color: <%= color.get(24) %>">
    <button type="submit" name="select" value="24"
        style="
        border-style: none;
        background-color: <%= color.get(24) %>">　</button>
  </td>
  <td
    style="
        border-width: 3px;
        border-color: <%= stoneArea.get(25) %>;
        background-color: <%= color.get(25) %>">
    <button type="submit" name="select" value="25"
        style="
        border-style: none;
        background-color: <%= color.get(25) %>">　</button>
  </td>
</tr>
</table>
</form>

<!-- Controler Table -->
<table class="controler" border="0">
<form action="/matrixGameIntegral/StoneMoveServlet" method="post">
<tr>
<th colspan="5" id="userInfo" >
  <p>Name  : <%= user.getName() %></p>
  <p>Point : <%= user.getPoint() %></p>
  <p>Sheet : 001</p>
</th>
</tr>
<tr>
  <td>　</td>
  <td>　</td>
  <td><button id="move" type="submit" name="stoneMove" value="up">▲</button></td>
  <td>　</td>
  <td>　</td>
</tr>
<tr>
  <td><button id="move" type="submit" name="stoneMove" value="turnLeft">⊂</button></td>
  <td><button id="move" type="submit" name="stoneMove" value="left">≪</button></td>
  <td><button id="move" type="submit" name="stoneMove" value="enter"><b>Enter</b></button></td>
  <td><button id="move" type="submit" name="stoneMove" value="right">≫</button></td>
  <td><button id="move" type="submit" name="stoneMove" value="turnRight">⊃</button></td>
</tr>
<tr>
  <td>　</td>
  <td>　</td>
  <td><button id="move" type="submit" name="stoneMove" value="down">▼</button></td>
  <td>　</td>
  <td>　</td>
</tr>
</form>
<tr><td colspan="5">　</td></tr>
<tr>
<td colspan="5">
  <form action="/matrixGameIntegral/SaveServlet" method="get">
    <input id="controle" type="submit" name="controle" value="Reverse">　<input type="submit" name="controle" value="Reset">　<input type="submit" name="controle" value="Save">　<input type="submit" name="controle" value="Logout"></p>
  </form>
</td></tr>
</table>

</div><!-- class="main" 終了 -->

</body>
</html>
