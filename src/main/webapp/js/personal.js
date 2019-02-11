/*** 返回首页 ***/
function backToIndex(){
	window.location.href="index.jsp";
}

/*** 用户注销 ***/
function logout(){
	window.location.href="logout.do";
}

/*** 文档自动加载方法 ***/
var flag = true;
$(function(){
	
	//展现收藏动画
	$('.per').click(function() {
		if (flag) {
			$('.per-img').animate({ top: '-100px', paddingTop: '50px', paddingBottom: '50px'},"slow");
			$('.per-info').animate({ top: '100px'},"slow",function(){
				flag = false;
				$('.t-wrapper').css("background-color","lavender");
				searchAllcollection();
				$('#collection').fadeIn("slow");
			});
		} else {
			$('.per-img').animate({ top: '0px', paddingTop: '150px', paddingBottom: '150px'},"slow");
			$('.per-info').animate({ top: '200px'},"slow",function(){
				flag = true;
				$('.t-wrapper').css("background-color","white");
				$('#collection').fadeOut("slow");
			});
		}
	});
	
});

/***查询用户所有所有收藏***/
function searchAllcollection(){
	$.ajax({
		url : "searchUserCollection.do",
		type : "post",
		dataType : "json",
		success : function(dataBack) {
			if (dataBack.userId == -1) {//没有用户登录
				$('#collection').empty();
				$('#collection').append("<a href='login.jsp' class='collec-tip'>去登录</a>");
			} else if( dataBack.userId == 0) {//没有收藏
				$('#collection').empty();
				$('#collection').append("<a href='index.jsp' class='collec-tip'>还没有关注 立刻去关注</a>");
			} else {//展现收藏数据
				$('#collection').empty();// 清空内容
				$.each(dataBack.carList, function(i, n) {// 填充内容
					$('#collection').append("<div class='co-information"
							+n.carId+" co-information clearfix'><div class='co-logo left'><img src=\""
							+n.imgLogo.imgPath+"\" /><span class='co-word'>"
							+n.carBrand+"</span></div><div class='co-info left'><span class='info-name'>"
							+n.carName+"</span><span class='info-price'>报价：<span class='info-inner-price'>"
							+n.carPrice+"万+</span></span><span class='info-detail' onclick='toCarDetail("
							+n.carId+");'>详情</span><span class='info-unsubscribe' onclick='unsubscribe("
							+n.carId+");'>取消关注</span></div></div>");
				});
			}
		},
		error : function() {}
	});
}
/***查看详情***/
function toCarDetail(obj) {
	window.open("selectCarById.do?carId="+obj,true - URL);
}

/***取消关注***/
function unsubscribe(obj) {
	$.ajax({
		url:"unsubscribe.do",
		type:"POST",
		data:{"carid":obj},
		dataType:"text",
		success:function(dataBack){
			if (dataBack=='1') {//成功取消关注
				$('.co-information'+obj).remove();
			} else {//取消关注失败
				alert("取消关注失败");
			}
		}
	});
}



