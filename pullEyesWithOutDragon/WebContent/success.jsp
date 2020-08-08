<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pull Eyes WithOut Dragon</title>
<link rel="stylesheet" type="text/css" href="ok/ok.css">
</head>
<body>
	<div class="page">
<p></p>
  <div class="container">
   <canvas id="canvas">Canvas not supported.</canvas>
    <div class="left">
      <div class="login">
      <span class="under"> Login <font color="#808000">successful!</font></span>
      </div>
    </div>
    <div class="right">

      <div class="form">
        <label for="text">
        You have successfully logged in!
        Let's have fun and play the game!
        </label>
        <form action="/pullEyesWithOutDragon/Baba">
       <input type="submit" id="submit" value="Start">
       </form>
      </div>
    </div>
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/animejs@3.1.0/lib/anime.min.js"></script>
<script src="ok/ok.js" type="text/javascript"></script>
</body>
</html>