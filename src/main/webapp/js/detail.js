var showAndHideFlag = true;
/*** 文档自动加载的方法 ***/
$(function() {
	/* 导航栏点击事件 */
	//参数点击事件
	$('.nav-paremeter').click(function() {
		//改变参数相关样式
		$('.nav-image').css({
			color: "white",
			background: "orangered"
		});
		$('#addCompare').fadeIn("slow");//对比模块淡出
		$('.co-image').empty();//清空图片数据
		$('.co-image').css("display", "none");
		//改变图片相关样式
		$('.nav-paremeter').css({
			color: "orangered",
			background: "white"
		});
		$('.co-parameter').css("display", "block");
	});
	//实拍图片点击事件
	$('.nav-image').click(function() {
		//改变参数相关样式
		$('.nav-paremeter').css({
			color: "white",
			background: "orangered"
		});
		$('#addCompare').fadeOut("slow");//对比模块淡出
		$('.co-parameter').css("display", "none");
		//改变图片相关样式
		$('.nav-image').css({
			color: "orangered",
			background: "white"
		});
		//从详情页获取id信息
//		$('.co-information').each(function(i,n){
//			var va1 = n.find("span");
//			alert(n.find("i").attr("id"));
//		});
		var temps = document.getElementsByClassName("co-information");//获取所有元素
		for(var i=0; i<temps.length; i++){//遍历temps伪数组
			var carid = temps[i].firstElementChild.lastElementChild.id;
			//利用carid进行异步查询并append追加
			$.ajax({
				url : "searchCarImagesDetail.do",
				type : "post",
				data : {"carid" : carid},
				dataType : "json",
				success : function(dataBack) {
					$.each(dataBack, function(x, n) {// 填充内容
						$('.co-image').append("<div class='co-images clearfix'><div class='information-wrapper left'><div class='car-information'><div class='car-info'><span class='car-name'>"
								+n.carName+"</span><span class='car-price'>报价：<span class='info-inner-price'>"
								+n.carPrice+"万+</span></span><span class='car-engine'>"
								+n.carEngine+" "
								+n.carIntake+"</span><span class='car-driveMode'>"
								+n.carDriveMode+"</span>	<span class='car-gearbox'>"
								+n.carGearbox+"</span></div></div></div><div class='image-wrapper image-wrapper"
								+n.carId+" left clearfix'></div></div>");
						if (n.imgList != '') {//图片非空
							$.each(n.imgList, function(y, v){
								$('.image-wrapper'+n.carId).append("<img class='left' src=\""
										+v.imgPath+"\" />");
							});
						} else {
							$('.image-wrapper'+n.carId).append("<span class='haveNotImg'>抱歉该款汽车还没有配图</span>");
						}
					});
				},
				error : function() {}
			});
		}
		//展现图片模块
		$('.co-image').css("display", "block");
	});

	/* 添加对比 */
	//展开信息输入栏
	$('.co-compare').click(function() {
		if (showAndHideFlag) {
			//查询出所有品牌
			$.ajax({
				url : "selectAllBrand.do",
				type : "post",
				dataType : "json",
				success : function(dataBack) {
					$('.brands-inner-select').empty();// 清空内容
					$('.brands-inner-select').append("<option value='SELECT' selected='selected'>选择品牌</option>");
					$.each(dataBack, function(i, n) {// 填充内容
						$('.brands-inner-select').append("<option value=\"" + n.carBrand + "\">"
								+ n.carBrand + "</option>");
					});
				},
				error : function() {}
			});
			//模块淡入
			$('.readyCompareOpe').fadeIn("slow");
			$('#addCompare').fadeIn("slow");
			showAndHideFlag = false;
		} else {
			//模块淡出
			$('#addCompare').fadeOut("slow");
			showAndHideFlag = true;
		}
	});
	//品牌栏改变事件
	$('.brands-inner-select').change(function() {
		var brands = $('.brands-inner-select').val();
		if(brands != 'SELECT') {
			//根据品牌查询出该品牌所有车名
			$.ajax({
				url : "selectCarNameByBrand.do",
				type : "post",
				data : {"brand" : brands},
				dataType : "json",
				success : function(dataBack) {
					$('.names-inner-select').empty();// 清空内容
					$('.names-inner-select').append("<option value='SELECT' selected='selected'>选择车名</option>");
					$.each(dataBack, function(i, n) {// 填充内容
						$('.names-inner-select').append("<option value=\"" + n.carId + "\">"
												+ n.carName + "</option>");
					});
				},
				error : function() {}
			});
			$('.startCompareOpe').fadeOut("slow");//隐藏开始对比按钮
		} else {
			$('.names-inner-select').empty();// 清空名称内容
			$('.startCompareOpe').fadeOut("slow");//隐藏开始对比按钮
		}
	});
	//名称栏改变事件
	$('.names-inner-select').change(function() {
		var names = $('.names-inner-select').val();
		if(names != 'SELECT') {
			$('.startCompareOpe').fadeIn("slow");//展开开始对比按钮
		} else {
			$('.startCompareOpe').fadeOut("slow");//隐藏开始对比按钮
		}
	});
	//加入对比功能
	$('.startCompareOpe span').click(function(){
		//获取车辆id参数
		var carid = $('.names-inner-select').val();
		//根据品牌查询出该品牌所有车名
		$.ajax({
			url : "addToCompare.do",
			type : "post",
			data : {"carid" : carid},
			dataType : "json",
			success : function(dataBack) {
//				$('.names-inner-select').empty();// 清空内容
				$('.co-all-information').append("<div class=\"co-information co-information"
						+dataBack.carId+"\"><div class='tab-es table-2'><div class='co-logo clearfix'><img class='info-logo left' src=\""
						+dataBack.imgLogo.imgPath+"\" /><span class='info-names left'>"
						+dataBack.carBrand+"</span></div><i id=\""
						+dataBack.carId+"\" class='co-clear'>移除</i>	</div><div class='tab-es'><span class='INFO info-price'>"
						+dataBack.carPrice+"万</span></div><div class='tab-es tab-e'><span class='INFO info-brand'>"
						+dataBack.carBrand+"</span></div><div class='tab-es'><span class='INFO info-name'>"
						+dataBack.carName+"</span></div><div class='tab-es'><span class='INFO info-level'>"
						+dataBack.carLevel+"</span></div><div class='tab-es tab-e'><span class='INFO info-engine'>"
						+dataBack.carEngine+"</span></div><div class='tab-es'><span class='INFO info-intake'>"
						+dataBack.carIntake+"</span></div><div class='tab-es'><span class='INFO info-torque'>"
						+dataBack.carTorque+"</span></div><div class='tab-es'><span class='INFO info-fuelModel'>"
						+dataBack.carFuelModel+"</span></div><div class='tab-es tab-e'><span class='INFO info-gearbox'>"
						+dataBack.carGearbox+"</span></div><div class='tab-es'><span class='INFO info-driveMode'>"
						+dataBack.carDriveMode+"</span></div><div class='tab-es tab-e'><span class='INFO info-length'>"
						+dataBack.carLength+"</span></div><div class='tab-es'><span class='INFO info-width'>"
						+dataBack.carWidth+"</span></div><div class='tab-es'><span class='INFO info-height'>"
						+dataBack.carHeight+"</span></div><div class='tab-es'><span class='INFO info-wheelbase'>"
						+dataBack.carWheelbase+"</span></div><div class='tab-es tab-e'><span class='INFO info-speed'>"
						+dataBack.carSpeed+"</span></div><div class='tab-es'><span class='INFO info-fuelConsumption'>"
						+dataBack.carFuelConsumption+"</span></div><div class='tab-es'><span class='INFO info-warranty'>"
						+dataBack.carWarranty+"</span></div></div>");
			},
			error : function() {}
		});
	});
	
	/* 移除车辆信息 */
	$('.co-all-information').on('click', 'i', function() {
		var rear = $(this).attr("id");
		$(".co-information"+rear).remove();
	});
	
});

/*** 去登录 ***/
function toLoginPage() {
	var u = window.location.href;//获取当前页面的URL信息
	window.location.href = "login.jsp?urlBack="+u;
}

