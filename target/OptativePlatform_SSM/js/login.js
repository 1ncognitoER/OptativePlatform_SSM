/** *文档加载时加载的方法** */
$(function() {
    /* 登录点击事件 */
    $('.login').click(function() {

        var isManage = $("input[name='radiobutton']:checked").val();//获取单选的值
        if (isManage == "0") {//管理员用户
            login("management.jsp")
        } else {//普通用户
            var condition = GetQueryString("urlBack");// 获取登录后返回页面的标识
            if (condition == null) {// 跳转到index
                condition = "index.jsp";
                login(condition);
            } else {// 跳转到原来页面
                login(condition);
            }
        }
    });
});

/* 用户登录 */
function login(obj) {
    var account = $('.account').val();// 获取用户名
    var password = $('.password').val();// 获取用户密码
    var userclass = $("input[name='radiobutton']:checked").val();//获取用户类型
    $.ajax({
        url : "login.do",
        type : "POST",
        data : {
            "username" : account,
            "password" : password,
            "userclass" : userclass
        },
        dataType : "text",
        success : function(dataBack) {
            if (dataBack == "1") {// 登录成功
                $('.acount-span').html("");
                window.location.href = obj;//回到页面
            } else {// 登录失败
                $('.acount-span').html("<span>请核查用户名、密码或用户类别</span>");
            }
        },
        error : function() {
            alert("ajax error");
        }
    });
}

/* 获取地址栏参数的方法 */
function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
        return unescape(r[2]);
    return null;
}
