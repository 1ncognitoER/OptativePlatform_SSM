/*
particlesNumber: 100, //粒子的数量
inkDist: 50, //连线完全透明的距离
createLinkDist: 150, //粒子开始连线的距离
linksWidth: 1, //连线的宽度
disableLinks: false, //如果这个参数设置为true，则禁止在粒子之间连线
disableMouse: false, //如果这个参数设置为true，则粒子之间的连线和鼠标互动都被禁止
background: "white", //背景颜色
width: null, //粒子容器的宽度 ,null使用父容器的宽度
height: null, //粒子容器的高度 ,null使用父容器的高度
color: "black", //粒子和连线的颜色
particle:{
	minSize: 2, //粒子的最小尺寸，单位像素
	maxSize: 4, //粒子的最大尺寸，单位像素
	speed: 60 //粒子的动画速度，单位：像素/帧 x 60
}
 */
$(document).ready(function() {
	$("#content").jParticle({
		background:"white",
		color:"black",
		particle:{
			minSize: 4,
			maxSize: 6,
			speed: 30
		}
	});
});