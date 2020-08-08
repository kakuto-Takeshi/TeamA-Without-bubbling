<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<%  Account acc=(Account) request.getAttribute("acc"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pull Eyes WithOut Dragon</title>
 <link rel="stylesheet" type="text/css" href="newaccount/newaccount.css">
</head>
<body class = "Headline">
	<div class="page" id="app1">
		<p></p>
		<div class="container">
			<canvas id="canvas">Canvas not supported.</canvas>
			<div class="left">
				<div class="login">
					<span class="under">New <font color="#003333">account</font></span>
				</div>
			</div>
			<div class="right">
				<div class="form">
					<form name="milkyhomes">
						<label for="text">User</label>
						<input type="text" v-model="user" name="name">
						<label for="password">Password</label>
						<input type="password" v-model="password" name="pass">
						<label for="mail">Mail</label>
						<input type="text" v-model="mail" name="mail">
						<label for="phonenumber">PhoneNumber</label>
						<input type="text" v-model="phoneNumber" name="phone">
						<label for="age">Age</label>
						<input type="text" v-model="age" name="age">
						<label for="sex">Sex</label>
						<input type="text" v-model="sex" name="sex">
						<div style="text-align:center">
							<button type="button" @click="touroku" value="Registration" class="btnt">送信</button>
					</form>
				</div>
				<label for="xxx">Do you have a relationship?</label><br>
				<center>
					<button class="hell btnt" @click="alert1">yes</button>
					<button class="hell btnt" @click="goodA">No</button>
				</center>
			</div>
		</div>
	</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.jsdelivr.net/npm/animejs@3.1.0/lib/anime.min.js"></script>
<script src="https://unpkg.com/vue-swal"></script>
<script src="sweetalert2.min.js"></script>
<script src="newaccount/newaccount.js" type="text/javascript"></script>
<script src="newaccount/register.js" type="text/javascript"></script>
</body>
</html>