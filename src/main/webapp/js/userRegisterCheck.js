var accountFlag = false;// 用户名通过条件
var passwordFlag = false;// 密码通过条件
var repasswordFlag = false;// 密码匹配通过条件

/*** 文档加载时自动加载的方法 ***/
$(function(){
	/*注册时用户名重复验证*/
	$('.account').blur( function () {// 当元素失去焦点时发生
		var account = $('.account').val();
		if (account != '') {
			$.ajax({
				url : "searchUserByName.do",
				type : "POST",
				data : { "username" : account },
				dataType : "text",
				success : function(dataBack) {
					if (dataBack == "1") {
						$('.acount-span').html("<span>该用户名已存在</span>");
						accountFlag = false;
					} else {
						$('.acount-span').html("<span>用户名可用</span>");
						accountFlag = true;
					}
				},
				error : function() {
				}
			});
		} else {
			$('.acount-span').html("<span>用户名不能为空</span>");
			accountFlag = false;
		}
	});
	/*注册密码长度及非空验证*/
	$('.password').blur( function() {
		var password = $('.password').val();
		var maxChars = 18;// 最大字符数
		var num = getByteLen(password);//计算字符数量
		var curr = maxChars - num;//剩余的字符数量
		if (curr == maxChars) {
			$('.password-span').html("<span>密码不能为空</span>");
			passwordFlag = false;
		} else if (curr >= 0) {
			if (num < 6) {
				$('.password-span').html("<span>复杂度太低</span>");
				passwordFlag = true;
			} else if (num < 11) {
				$('.password-span').html("<span>较安全</span>");
				passwordFlag = true;
			} else {
				$('.password-span').html("<span>安全</span>");
				passwordFlag = true;
			}
		} else {
			$('.password-span').html("<span>密码不能超过18位</span>");
			passwordFlag = false;
		}
	});
	/*验证两次密码是否相同*/
	$('.repassword').blur( function() {
		var password = $('.password').val();
		var repassword = $('.repassword').val();
		if (password == repassword) {
			$('.repassword-span').html("");
			repasswordFlag = true;
		} else {
			$('.repassword-span').html("<span>两次输入的密码不匹配</span>");
			repasswordFlag = false;
		}
	});
	
});

/*是否注册判定*/
function isSubmit(){
	if(accountFlag==true && passwordFlag==true && repasswordFlag==true){
		// 用户账号密码及重复密码全部正确，允许注册
		return true;
	} else {
		// 任意条件不符合，不允许注册
		return false;
	}
}

/*计算字符串长度（汉字算两个字符，字母数字算一个）*/
function getByteLen(val) {
	var len = 0;
	for (var i = 0; i < val.length; i++) {
		var a = val.charAt(i);
		if (a > 127 || a == 94) {
			len += 2;
		} else {
			len += 1;
		}
	}
	return len;
}

