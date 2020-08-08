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
<link rel="stylesheet" type="text/css" href="newaccount/newaccount.css">
</head>
<body class="Headline">
	<div class="page">
		<p></p>
		<div class="container">
			<canvas id="canvas">Canvas not supported.</canvas>
			<div class="left">
				<div class="login">
					<span class="under">Change <font color="#003333">registration
							details</font></span>
				</div>
			</div>
			<div class="right">
				<div class="form">
					<form action="/pullEyesWithOutDragon/Change" method="post">
						<label for="text">User</label> <input type="text" id="User"
							name="name" <%if (acc != null && acc.getName() != null) {%>
							value="<%=acc.getName()%><%}%>"><br> <label
							for="password">Password</label> <input type="password"
							id="password" name="pass"
							<%if (acc != null && acc.getPass() != null) {%>
							value="<%=acc.getPass()%><%}%>"><br> <label
							for="mail">Mail</label> <input type="email" id="mail" name="mail"
							<%if (acc != null && acc.getMail() != null) {%>
							value="<%=acc.getMail()%><%}%>"><br> <label
							for="phonenumber">PhoneNumber</label> <input type="text"
							id="phoneNumber" name="phone"
							<%if (acc != null && acc.getPhone() != null) {%>
							value="<%=acc.getPhone()%><%}%>"><br> <label
							for="age">Age</label> <input type="text" id="age" name="age"
							<%if (acc != null && acc.getAge() != null) {%>
							value="<%=acc.getAge()%><%}%>"><br> <label for="sex">Sex</label>
						<input type="radio" id="sex" name="sex" value="man">男 <input
							type="radio" id="sex" name="sex" value="woman">女<br>

						<p>

							<input type="submit" id="submit" value="Registration">
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
	<script src="newaccount/newaccount.js" type="text/javascript"></script>
</body>
</html>