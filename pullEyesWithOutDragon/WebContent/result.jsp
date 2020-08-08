<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="result.css">
<title>Pull Eyes WithOut Dragon</title>
<link href="https://fonts.googleapis.com/css2?family=Sawarabi+Mincho&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Allura&display=swap" rel="stylesheet">
</head>
<body>

 <video class="pop" src="video/clover.mp4" autoplay loop muted></video>

	<div id="app">
		<div @click.once="kakutou" class= "eyes" ></div>

		<transition-group name="text">
			<div class="oioi" v-for="(item,index) in momo.masege" v-bind:key="item"
			 style = "color:white">{{momo.masege[0]}}</div>
			 <img v-for="(item,index) in momo.masege2" v-bind:key="item"
			class="ioio" v-bind:src="'img2/' + item + '.jpg'" />{momo.masege2[0]}}
			<div class="oioioi" v-for="(item,index) in momo.masege3" v-bind:key="item"
			 style = "color:white">{{momo.masege3[0]}}</div>
			  <img v-for="(item,index) in momo.masege4" v-bind:key="item"
			class="ioio3" v-bind:src="'img2/' + item + '.jpg'" />{{momo.masege4[0]}}
			 <img v-for="(item,index) in momo.masege5" v-bind:key="item"
			class="ioio4" v-bind:src="'img2/' + item + '.jpg'" />{{momo.masege5[0]}}

		</transition-group>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
	<script src="result.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script src="https://unpkg.com/vue-swal"></script>

</body>
</html>