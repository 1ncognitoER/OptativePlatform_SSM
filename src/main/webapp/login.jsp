<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登陆</title>
<link rel="shortcut icon" href="img/logo/icon.ico" />
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/loginAndRegister.css" />
<script type="text/javascript" src="js/jquery-3.2.0.js"></script>
<script type="text/javascript" src="js/jparticle.jquery.js"></script>
<script type="text/javascript" src="js/lizi.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
	<div id="head">
		<div class="h-wrapper clearfix">
			<a href="index.jsp" class="left"><img class="h-logo" src="img/logo/logo.png" /></a>
			<a href="index.jsp" class="h-back left">首页</a>
		</div>
	</div>
	<div id="content">
		<div class="c-wrapper clearfix">
			<form class="c-form right">
				<div class="c-form-div">
					<label class="c-form-label">用户名</label>
					<input type="text" class="c-form-input account" />
				</div>
				<div class="c-form-span acount-span"></div>
				<div class="c-form-div">
					<label class="c-form-label">密码</label>
					<input type="password" class="c-form-input password" />
				</div>
				
				<div class="c-form-a clearfix">
					<a class="left" href="register.jsp">去注册</a>
					<div class="c-form-span password-span right">
						<input class="rb rb-one" type="radio" name="radiobutton" value="1" checked="checked" />用户
						<input class="rb rb-two" type="radio" name="radiobutton" value="0" />管理员
					</div>
				</div>
				<input type="button" value="确认登录" class="c-form-submit login" />
			</form>
		</div>
	</div>
	<div id="tail">
		<div class="t-wrapper">
			<div class="t-copyright">© Copyright 2018 optative.com</div>
			<div>
				<a href="#"><img class="t-img" src="img/index/aboutUs_01.png" /></a>
				<a href="#"><img class="t-img" src="img/index/aboutUs_02.png" /></a>
				<a href="#"><img class="t-img" src="img/index/aboutUs_03.png" /></a>
				<a href="#"><img class="t-img" src="img/index/aboutUs_04.png" /></a>
			</div>
		</div>
	</div>
</body>
</html>