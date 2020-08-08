<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Account"%>
<%
	Account acc = (Account) session.getAttribute("acc");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pull Eyes WithOut Dragon</title>
<link rel="stylesheet" type="text/css" href="title/title1.css">
</head>
<body>
	<canvas id="canvas">Canvas not supported.</canvas>
	<h1 class="scream"></h1>
	<section>
		<h1 id="title"></h1>
		<span id="background"></span>
	</section>
	<p id=kakuto> ~KAKUTO GAMES~</p>
	<%
		if (acc == null) {
	%>

	<a href="/pullEyesWithOutDragon/Login" class="button1">LOGIN</a>
	<a href="/pullEyesWithOutDragon/Register" class="button2">NEW ACCOUNT</a>
	<%
		} else {
	%>
	<%
		System.out.println("ログイン中");
	%>
	<p id= login>〘<%=acc.getName()%>'s Logging in〙</p>


	<a href="/pullEyesWithOutDragon/Logout" class="button1">Logout</a>

	<a href="/pullEyesWithOutDragon/Withdrawal" class="button2">Withdrawal</a>

	<a href="/pullEyesWithOutDragon/Baba" class="button3">Game</a>
<a href="/pullEyesWithOutDragon/Change" class="button4">Change registration
							details</a>
	<%
		}
	%>
	<script src="title/title1.js" type="text/javascript"></script>

</body>
</html>