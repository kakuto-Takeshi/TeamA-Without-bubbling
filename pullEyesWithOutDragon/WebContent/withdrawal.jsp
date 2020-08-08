<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Account"%>
<%
	Account acc = (Account) session.getAttribute("acc");
	Account acc1 = (Account) request.getAttribute("acc");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pull Eyes WithOut Dragon</title>
<link rel="stylesheet" type="text/css" href="login/login.css">
</head>
<body class="Headline">
	<div class="page">
		<div class="container">
			<canvas id="canvas">Canvas not supported.</canvas>
			<div class="left">
				<div class="login">
					<span class="under">Withdrawal</span>
				</div>
			</div>
			<div class="right">
				<div class="form">

					<form action="/pullEyesWithOutDragon/Withdrawal" method="post">

						<label for="text">User</label>
						<p>
							<%=acc.getName()%>さん退会しますか？
						</p>
						<label for="password">Password</label><input type="password"
							id="password" name="pass"> <br> <input
							type="submit" id="submit" value="Withdrawal">
					</form>
					<%
						if (acc1 != null) {
					%>
					<p id=ng>failed..!</p>
					<p id=ng1><%=acc1.getMsg()%></p>
					<%
						}
					%>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/animejs@3.1.0/lib/anime.min.js"></script>
	<script src="login/login.js" type="text/javascript"></script>
</body>
</html>