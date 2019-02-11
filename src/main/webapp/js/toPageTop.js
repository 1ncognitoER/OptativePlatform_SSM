$(function() {
	window.onscroll = function() {
		if(scroll().top > 0) {//窗体滚动的时候 判断页面高度是否大于0
			$('#operate').fadeIn("slow");
		} else {
			$('#operate').fadeOut("slow");
		}
	};
	//获取页面高度
	function scroll() {
		return {
			top: window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0,
			left: window.pageXOffset || document.documentElement.scrollLeft || document.body.scrollLeft || 0
		};
	}
});

/* 回到顶部 */
function toTop() {
	location.href = "#";
}

