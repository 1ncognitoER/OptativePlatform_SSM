<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored ="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
<link rel="shortcut icon" href="img/logo/icon.ico" />
<link rel="stylesheet" href="css/base.css" />
<script type="text/javascript" src="js/jquery-3.2.0.js"></script>
<link rel="stylesheet" href="css/personal.css" />
<script type="text/javascript" src="js/personal.js"></script>
</head>

<body>
	<div id="head">
		<div class="he-wrapper clearfix">
			<img onclick="backToIndex();" class="he-logo left" src="img/logo/logo.png" title="返回首页" />
			<span onclick="backToIndex();" class="he-word left" title="返回首页">Optative</span>
			<c:if test="${userInformation.userName!=null && userInformation.userName!='' }">
			<span onclick="logout();" class="he-word he-words right">退出用户</span>
			</c:if>
		</div>
	</div>
	<div id="personal">
		<div class="per-wrapper">
			<!-- 用户信息 -->
			<div class="clearfix">
				<div class="per per-info left">
					<span class="per-username">${userInformation.userName }</span>
					<span class="per-operate">我的关注</span>
				</div>
				<div class="per per-img left">
					<img class="per-inner-img" src="img/personal/avatar.png" />
				</div>
			</div>

		</div>
	</div>

	<!-- 汽车信息 -->
	<div id="collection"></div>
	
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