/*** 多条件筛选 ***/
$(document).ready(function () {
    //文档加载时查询所有汽车信息
    selectAllCar();
    //条件一点击事件
    $("#select1 dd").click(function () {
        $(this).addClass("selected").siblings().removeClass("selected"); //取消同级元素 其中siblings()同级元素，不包括自身
        if ($(this).hasClass("select-all")) { //判断是否是“全部”条件
            $(".selectA").remove();//已选条件清空同一级别筛选条件
            //获取参数，后台查询
            getData();
        } else {
            var copyThisA = $(this).clone();//复制当前点击的元素 clone() 方法生成被选元素的副本，包含子节点、文本和属性（比如class）
            if ($(".selectA").length > 0) { //检查已选条件中是否存在同级条件  length表示输出选择器选择元素的数目
                $(".selectA a").html($(this).find("a").text());//将已选条件的文本修改成当前选中的条件
            } else {
                $(".select-result dl").append(copyThisA.attr("class", "selected selectA"));//attr()表示重新设置class，原class会被覆盖
            }
            //获取参数，后台查询
            getData();
        }
    });
    //条件二点击事件
    $("#select2 dd").click(function () {
        $(this).addClass("selected").siblings().removeClass("selected");
        if ($(this).hasClass("select-all")) {
            $(".selectB").remove();
            //获取参数，后台查询
            getData();
        } else {
            var copyThisB = $(this).clone();
            if ($(".selectB").length > 0) {
                $(".selectB a").html($(this).find("a").text());
            } else {
                $(".select-result dl").append(copyThisB.attr("class", "selected selectB"));
            }
            //获取参数，后台查询
            getData();
        }
    });
    //条件三点击事件
    $("#select3 dd").click(function () {
        $(this).addClass("selected").siblings().removeClass("selected");
        if ($(this).hasClass("select-all")) {
            $(".selectC").remove();
            //获取参数，后台查询
            getData();
        } else {
            var copyThisC = $(this).clone();
            if ($(".selectC").length > 0) {
                $(".selectC a").html($(this).find("a").text());
            } else {
                $(".select-result dl").append(copyThisC.attr("class", "selected selectC"));
            }
            //获取参数，后台查询
            getData();
        }
    });
    //条件四点击事件
    $("#select4 dd").click(function () {
        $(this).addClass("selected").siblings().removeClass("selected");
        if ($(this).hasClass("select-all")) {
            $(".selectD").remove();
            //获取参数，后台查询
            getData();
        } else {
            var copyThisD = $(this).clone();
            if ($(".selectD").length > 0) {
                $(".selectD a").html($(this).find("a").text());
            } else {
                $(".select-result dl").append(copyThisD.attr("class", "selected selectD"));
            }
            //获取参数，后台查询
            getData();
        }
    });
    //条件五点击事件
    $("#select5 dd").click(function () {
        $(this).addClass("selected").siblings().removeClass("selected");
        if ($(this).hasClass("select-all")) {
            $(".selectE").remove();
            //获取参数，后台查询
            getData();
        } else {
            var copyThisE = $(this).clone();
            if ($(".selectE").length > 0) {
                $(".selectE a").html($(this).find("a").text());
            } else {
                $(".select-result dl").append(copyThisE.attr("class", "selected selectE"));
            }
            //获取参数，后台查询
            getData();
        }
    });

});

/* 获取参数，后台查询 */
function getData() {
    if ($(".select-result dd").length > 1) {
        $(".select-no").hide();
        //获取条件参数
        var price = $('.selectA').find("a").text();
        var level = $('.selectB').find("a").text();
        var driveMode = $('.selectC').find("a").text();
        var gearbox = $('.selectD').find("a").text();
        var intake = $('.selectE').find("a").text();
        //根据条件查询
        $.ajax()
        $.ajax({
            url: "selectCar.do",
            type: "POST",
            data: {"price": price, "level": level, "driveMode": driveMode, "gearbox": gearbox, "intake": intake},
            dataType: "json",
            success: function (dataBack) {
                $('.co-wrapper').empty();
                if (dataBack != '') {//有数据返回
                    $(".not-info").css("display", "none");//有数据时隐藏消息提示
                    $.each(dataBack, function (i, n) {//i表示数据集元素序号，n表示每个元素
                        var va = "<div class='co-information clearfix'><div class='co-logo left'><img src=\""
                            + n.imgLogo.imgPath + "\" /> <span class='co-word'>"
                            + n.carBrand + "</span></div><div class='co-info left'><span class='info-brand'>"
                            + n.carBrand + "</span><span class='info-name' onclick='toDetail("
                            + n.carId + ");'>"
                            + n.carName + "</span><span class='info-price'>报价：<span class='info-inner-price'>"
                            + n.carPrice + "万+</span></span>	<span class='info-detail' ><span onclick='toDetail("
                            + n.carId + ");' class='info-inner-detail'>详情</span><span onclick='toCollection("
                            + n.carId + ");' class='info-inner-compare'>加入关注</span></span></div></div>";
                        $('.co-wrapper').append(va);
                    });
                } else {//没有数据返回时,查询所有车辆信息作为推荐
                    $(".not-info").css("display", "block");//没有数据时的消息提示
                    selectAllCar();
                }
            }
        });
    } else {
        $(".select-no").show();
        //参数为空，查询所有车辆
        selectAllCar();
    }
}

//查询所有汽车信息
function selectAllCar() {
    $.ajax({
        url: "selectAllCar.do",
        type: "POST",
        dataType: "json",
        success: function (dataBack) {
            $('.co-wrapper').empty();
            $.each(dataBack, function (i, n) {
                var va = "<div class='co-information clearfix'><div class='co-logo left'><img src=\""
                    + n.imgLogo.imgPath + "\" /> <span class='co-word'>"
                    + n.carBrand + "</span></div><div class='co-info left'><span class='info-brand'>"
                    + n.carBrand + "</span><span class='info-name' onclick='toDetail("
                    + n.carId + ");'>"
                    + n.carName + "</span><span class='info-price'>报价：<span class='info-inner-price'>"
                    + n.carPrice + "万+</span></span>	<span class='info-detail' ><span onclick='toDetail("
                    + n.carId + ");' class='info-inner-detail'>详情</span><span onclick='toCollection("
                    + n.carId + ");' class='info-inner-compare'>加入关注</span></span></div></div>";
                $('.co-wrapper').append(va);
            });
        }
    });
}


/*** 搜索功能 ***/
function searchCars() {
    var carName = $('.searchBox').val();
    if (carName != '') {
        $.ajax({
            url: "searchCar.do",
            type: "POST",
            data: {"carName": carName},
            dataType: "json",
            success: function (dataBack) {
                $('.co-wrapper').empty();
                if (dataBack != '') {//有数据返回
                    $(".not-info").css("display", "none");//有数据时隐藏消息提示
                    $.each(dataBack, function (i, n) {
                        var va = "<div class='co-information clearfix'><div class='co-logo left'><img src=\""
                            + n.imgLogo.imgPath + "\" /> <span class='co-word'>"
                            + n.carBrand + "</span></div><div class='co-info left'><span class='info-brand'>"
                            + n.carBrand + "</span><span class='info-name' onclick='toDetail("
                            + n.carId + ");'>"
                            + n.carName + "</span><span class='info-price'>报价：<span class='info-inner-price'>"
                            + n.carPrice + "万+</span></span>	<span class='info-detail' ><span onclick='toDetail("
                            + n.carId + ");' class='info-inner-detail'>详情</span><span onclick='toCollection("
                            + n.carId + ");' class='info-inner-compare'>加入关注</span></span></div></div>";
                        $('.co-wrapper').append(va);
                    });
                }
                // else {//没有数据返回时,查询所有车辆信息作为推荐
                //     $(".not-info").css("display", "block");//没有数据时的消息提示
                //     selectAllCar();
                // }
            },
            error: function () {
                $(".not-info").css("display", "block");//没有数据时的消息提示
                selectAllCar();
            }
        });
    } else {
        $(".not-info").css("display", "block");//没有数据时的消息提示
    }
}


/*** 进入详情页 ***/
//点击时进入详情
function toDetail(obj) {
    window.open("selectCarById.do?carId=" + obj, true - URL);
}

//加入比较
function toCollection(obj) {
    //AJAX操作进后台查看是否登录
    $.ajax({
        url: "collection.do",
        type: "POST",
        data: {"carid": obj},
        dataType: "text",
        success: function (dataBack) {
            if (dataBack == '1') {//存在用户登录数据
                alert("成功添加关注");
            } else {//不存在用户登录数据
                alert("请先登录");
            }
        }
    });
}

/*** 去登录 ***/
function toLoginPage() {
    var u = window.location.href;//获取当前页面的URL信息
    window.location.href = "login.jsp?urlBack=" + u;
}

