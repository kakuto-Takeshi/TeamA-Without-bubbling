<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Account"%>
<%
	Account acc = (Account) request.getAttribute("acc");
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
					<span class="under">Login</span>
				</div>
			</div>
			<div class="right">
				<div class="form">
					<form action="/pullEyesWithOutDragon/Login" method="post">
						<label for="text">User</label> <input type="text" name="user"
							<%if (acc != null && acc.getName() != null) {%>
							value="<%=acc.getName()%><%}%>"> <label for="password">Password</label>
						<input type="password" name="pass"
							<%if (acc != null && acc.getPass() != null) {%>
							value="<%=acc.getPass()%><%}%>"> <input type="submit"
							id="submit" value="Submit">
					</form>
				</div>
				<%
					if (acc != null) {
				%>
				<p id=ng>failed..!</p>
				<p id=ng1><%=acc.getMsg()%></p>
				<%
					}
				%>
				<a href="/pullEyesWithOutDragon/Register" class="button">NewAccount</a>


			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/animejs@3.1.0/lib/anime.min.js"></script>
	<script src="login/login.js" type="text/javascript"></script>
</body>
</html>