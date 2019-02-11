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
<script type="text/javascript" src="js/jquery-3.2.0.js"></script>
<link rel="stylesheet" href="css/detail.css" />
<script type="text/javascript" src="js/detail.js"></script>
<script type="text/javascript" src="js/toPageTop.js"></script>
</head>

<body>

	<div id="operate">
		<img onclick="toTop();" class="toTop" src="img/index/toTOP.png" />
	</div>

	<div id="addCompare" class="clearfix">
		<div class="readyCompareOpe left">
			<div class="bn brands-select">
				<select name="brands" class="inner-select brands-inner-select">
				</select>
			</div>
			<div class="bn names-select">
				<select name="names" class="inner-select names-inner-select">
				</select>
			</div>
		</div>
		<div class="startCompareOpe left">
			<span>开始对比</span>
		</div>
	</div>

	<div id="head">
		<div class="he-wrapper clearfix">
			<img class="he-logo left" src="img/logo/logo.png" /> <span
				class="he-word left">Optative</span>
			<ul class="he-info right">
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
		</div>
	</div>

	<div id="content">
		<div class="c-wrapp">
			<div class="c-titl">
				<ul>
					<li class="nav-paremeter">参数配置</li>
					<li class="nav-image">实拍图片</li>
				</ul>
			</div>
			<div class="co-parameter">
				<!-- 左侧信息标题 -->
				<div class="co-title-information">

					<div class="tab-es-title table-1">
						<span class="co-compare">添加对比</span>
					</div>
					<div class="tab-es-title">
						<span class="INFO info-price">厂商指导价（万）</span>
					</div>
					<div class="tab-es-title tab-e">
						<span class="INFO info-brand">厂商</span>
					</div>
					<div class="tab-es-title">
						<span class="INFO info-name">车名</span>
					</div>
					<div class="tab-es-title">
						<span class="INFO info-level">级别</span>
					</div>
					<div class="tab-es-title tab-e">
						<span class="INFO info-engine">引擎</span>
					</div>
					<div class="tab-es-title">
						<span class="INFO info-intake">进气形式</span>
					</div>
					<div class="tab-es-title">
						<span class="INFO info-torque">最大扭矩（N·m）</span>
					</div>
					<div class="tab-es-title">
						<span class="INFO info-fuelModel">燃料型号</span>
					</div>
					<div class="tab-es-title tab-e">
						<span class="INFO info-gearbox">变速箱</span>
					</div>
					<div class="tab-es-title">
						<span class="INFO info-driveMode">驱动方式</span>
					</div>
					<div class="tab-es-title tab-e">
						<span class="INFO info-length">长（mm）</span>
					</div>
					<div class="tab-es-title">
						<span class="INFO info-width">宽（mm）</span>
					</div>
					<div class="tab-es-title">
						<span class="INFO info-height">高（mm）</span>
					</div>
					<div class="tab-es-title">
						<span class="INFO info-wheelbase">轴距（mm）</span>
					</div>
					<div class="tab-es-title tab-e">
						<span class="INFO info-speed">最高车速（km/h）</span>
					</div>
					<div class="tab-es-title">
						<span class="INFO info-fuelConsumption">综合油耗（L/100km）</span>
					</div>
					<div class="tab-es-title">
						<span class="INFO info-warranty">整车质保</span>
					</div>
				</div>
				<!-- 右部详细信息和对比性息 -->

				<div class="co-all-information">
				
					<c:if test="${carDetail != null }">
					<div class="co-information co-information${carDetail.carId }">
						<div class="tab-es table-2">
							<div class="co-logo clearfix">
								<img class="info-logo left" src="${carDetail.imgLogo.imgPath }" />
								<span class="info-names left">${carDetail.carBrand }</span>
							</div>
							<i id="${carDetail.carId }" class="co-clear">移除</i>
						</div>
						<div class="tab-es">
							<span class="INFO info-price">${carDetail.carPrice }万</span>
						</div>
						<div class="tab-es tab-e">
							<span class="INFO info-brand">${carDetail.carBrand }</span>
						</div>
						<div class="tab-es">
							<span class="INFO info-name">${carDetail.carName }</span>
						</div>
						<div class="tab-es">
							<span class="INFO info-level">${carDetail.carLevel }</span>
						</div>
						<div class="tab-es tab-e">
							<span class="INFO info-engine">${carDetail.carEngine }</span>
						</div>
						<div class="tab-es">
							<span class="INFO info-intake">${carDetail.carIntake }</span>
						</div>
						<div class="tab-es">
							<span class="INFO info-torque">${carDetail.carTorque }</span>
						</div>
						<div class="tab-es">
							<span class="INFO info-fuelModel">${carDetail.carFuelModel }</span>
						</div>
						<div class="tab-es tab-e">
							<span class="INFO info-gearbox">${carDetail.carGearbox }</span>
						</div>
						<div class="tab-es">
							<span class="INFO info-driveMode">${carDetail.carDriveMode }</span>
						</div>
						<div class="tab-es tab-e">
							<span class="INFO info-length">${carDetail.carLength }</span>
						</div>
						<div class="tab-es">
							<span class="INFO info-width">${carDetail.carWidth }</span>
						</div>
						<div class="tab-es">
							<span class="INFO info-height">${carDetail.carHeight }</span>
						</div>
						<div class="tab-es">
							<span class="INFO info-wheelbase">${carDetail.carWheelbase }</span>
						</div>
						<div class="tab-es tab-e">
							<span class="INFO info-speed">${carDetail.carSpeed }</span>
						</div>
						<div class="tab-es">
							<span class="INFO info-fuelConsumption">${carDetail.carFuelConsumption }</span>
						</div>
						<div class="tab-es">
							<span class="INFO info-warranty">${carDetail.carWarranty }</span>
						</div>
					</div>
					</c:if>

				</div>

			</div>
			<div class="co-image">
					
					<!-- <div class="co-images clearfix">
						<div class="information-wrapper left">
							<div class="car-information">
								<div class="car-info">
									<span class="car-name" onclick="">奥迪Q3</span>
									<span class="car-price">报价：<span class="info-inner-price">23.42万+</span></span>
									<span class="car-engine">1.4T 涡轮增压</span>
									<span class="car-driveMode">前置前驱</span>
									<span class="car-gearbox">6挡双离合</span>
								</div>
							</div>
						</div>
						<div class="image-wrapper image-wrapper${Car.carId} left clearfix">
							<img class="left" src="img/carLogo/aodi.png" />
							<img class="left" src="img/logo/logo.png" />
							<img class="left" src="img/personal/avatar.png" />
							<img class="left" src="img/index/aboutUs_01.png" />
							<img class="left" src="img/index/aboutUs_02.png" />
						</div>
					</div> -->
					
			</div>
			
		</div>
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