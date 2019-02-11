<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored ="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Optative</title>
<link rel="shortcut icon" href="img/logo/icon.ico" />
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/index.css" />
<script type="text/javascript" src="js/jquery-3.2.0.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/toPageTop.js"></script>
</head>

<body>
	<div id="operate">
		<img onclick="toTop();" class="toTop" src="img/index/toTOP.png" />
	</div>
	<div id="head">
		<div class="he-wrapper clearfix">
			<img class="he-logo left" src="img/logo/logo.png" />
			<span class="he-word left">Optative</span>
			<ul class="he-info left">
				<c:if test="${userInformation.userName==null || userInformation.userName=='' }">
				<li>您好！请</li>
				<li><a onclick="toLoginPage();">登录</a></li>
				<li>或</li>
				<li><a href="register.jsp">注册</a></li>
				</c:if>
				<c:if test="${userInformation.userName!=null && userInformation.userName!='' }">
				<li>HI!</li>
				<li><a href="personal.jsp" title="个人中心">${userInformation.userName }</a></li>
				<li><a href="logout.do">注销</a></li>
				</c:if>
			</ul>
			<div class="he-search right">
				<input name="search" value="" class="searchBox" type="text" placeholder="搜索">
				<input onclick="searchCars();" class="searchButton" type="button">
			</div>
		</div>
	</div>
	<div id="filter">
		<div class="fi-wrapper">
			<ul class="select">
				<li class="selects select-result">
					<dl>
						<dt>已选条件>></dt>
						<dd class="select-no">暂时没有选择过滤条件</dd>
						<%--<dd class="selected selectA"><a>〈10W</a></dd>--%>
					</dl>
				</li>
				<li class="selects select-list">
					<dl id="select1">
						<dt>价格</dt>
						<dd class="select-all selected">
							<a>全部</a>
						</dd>
						<dd>
							<a>〈10W</a>
						</dd>
						<dd>
							<a>10W-20W</a>
						</dd>
						<dd>
							<a>20W-30W</a>
						</dd>
						<dd>
							<a>30W-50W</a>
						</dd>
						<dd>
							<a>50W-100W</a>
						</dd>
						<dd>
							<a>〉100W</a>
						</dd>
					</dl>
				</li>
				<li class="selects select-list">
					<dl id="select2">
						<dt>级别</dt>
						<dd class="select-all selected">
							<a>全部</a>
						</dd>
						<dd>
							<a>紧凑型</a>
						</dd>
						<dd>
							<a>中型</a>
						</dd>
						<dd>
							<a>大型</a>
						</dd>
						<dd>
							<a>SUV</a>
						</dd>
						<dd>
							<a>MPV</a>
						</dd>
						<dd>
							<a>跑车</a>
						</dd>
					</dl>
				</li>
				<li class="selects select-list">
					<dl id="select3">
						<dt>驱动</dt>
						<dd class="select-all selected">
							<a>全部</a>
						</dd>
						<dd>
							<a>前驱</a>
						</dd>
						<dd>
							<a>后驱</a>
						</dd>
						<dd>
							<a>四驱</a>
						</dd>
					</dl>
				</li>
				<li class="selects select-list">
					<dl id="select4">
						<dt>变速箱</dt>
						<dd class="select-all selected">
							<a>全部</a>
						</dd>
						<dd>
							<a>手动</a>
						</dd>
						<dd>
							<a>自动</a>
						</dd>
						<dd>
							<a>手自一体</a>
						</dd>
						<dd>
							<a>双离合</a>
						</dd>
					</dl>
				</li>
				<li class="selects select-list select-end-list">
					<dl id="select5">
						<dt>发动机</dt>
						<dd class="select-all selected">
							<a>全部</a>
						</dd>
						<dd>
							<a>自然吸气</a>
						</dd>
						<dd>
							<a>涡轮增压</a>
						</dd>
					</dl>
				</li>
			</ul>
		</div>
	</div>
	<div id="content">
		<!-- 没有数据时的样式 加入提示 -->
		<span class="not-info" style="color: orangered;">目前还没有该汽车 推荐如下</span>
		<!-- 有数据时样式 -->
		<div class="co-wrapper"></div>
	</div>
	<div id="tail">
		<div class="ta-wrapper">
			<div class="ta-copyright">© Copyright 2018 optative.com</div>
			<div>
				<a href="#"><img class="ta-img" src="img/index/aboutUs_01.png" /></a>
				<a href="#"><img class="ta-img" src="img/index/aboutUs_02.png" /></a>
				<a href="#"><img class="ta-img" src="img/index/aboutUs_03.png" /></a>
				<a href="#"><img class="ta-img" src="img/index/aboutUs_04.png" /></a>
			</div>
		</div>
	</div>
</body>
</html>