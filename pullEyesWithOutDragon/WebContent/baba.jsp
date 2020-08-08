<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pull Eyes WithOut Dragon</title>
<link rel="stylesheet" type="text/css" href="baba/baba.css" />
</head>
<body>
<div id="app">
	<transition-group name="list-complete" tag="div" v-bind:class="cards">
	<img v-bind:src=player1 v-bind:key=1100 class="list-complete-item tmpz">
	<img v-for="(item,index) in obj.obj1" v-bind:key="item"
		class="list-complete-item tmp " v-bind:src="'cards/' + item + '.png'" />

	<img v-bind:src=isono v-bind:key=1500 class="list-complete-item isono">
	<img v-for="(item,index) in obj.dust" v-bind:key="item"
		class="list-complete-item4 tmpx" v-bind:src="'cards/card_red.png'" />
	<br v-bind:key="100">
	<img v-bind:src=player2 v-bind:key=1200 class="list-complete-item tmpz">
	<img v-for="(item,index) in obj.obj2" v-bind:key="item"
		class="list-complete-item2 tmp " v-bind:src="'cards/' + item + '.png'" v-on:click="choice(index)"/>
	<img v-for="(item,index) in objx.objx2" v-bind:key="item"
		class="list-complete-item2 tmp " v-bind:src="'cards/card_red.png'" v-on:click="choice(index)"/>
	<br v-bind:key="120">
	<img v-bind:src=player3 v-bind:key=1300 class="list-complete-item tmpz">
	<img v-for="(item,index) in obj.obj3" v-bind:key="item"
		class=" list-complete-item3 tmp " v-bind:src="'cards/' + item + '.png'" v-on:click="choice3(index)" />
	<img v-for="(item,index) in objx.objx3" v-bind:key="item"
		class="list-complete-item2 tmp " v-bind:src="'cards/card_red.png'" v-on:click="choice3(index)"/>
	<br v-bind:key="130">
	<img v-bind:src=player4 v-bind:key=1400 class="list-complete-item tmpz">
	<img v-for="(item,index) in obj.obj4" v-bind:key="item"
		class="list-complete-item4 tmp " v-bind:src="'cards/' + item + '.png'" v-on:click="choice4(index)" />
	<img v-for="(item,index) in objx.objx4" v-bind:key="item"
		class="list-complete-item2 tmp " v-bind:src="'cards/card_red.png'" v-on:click="choice4(index)"/>

	</transition-group>

	<span v-show="show">
 	<p style ="display : none;">
 		<center><img src="img/a9.png" @click="kakutou" class= "eyes" ></center>
 	</p>
	</span>

</div>
<script src="https://unpkg.com/vue"></script>

<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.14.1/lodash.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://unpkg.com/vue-swal"></script>
<script type="text/javascript" src="baba/baba.js"></script>
</body>
</html>