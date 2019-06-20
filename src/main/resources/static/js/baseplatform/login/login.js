$(function() {
	/**
	 * EasyUI初始化
	 */
	$("#username").textbox('textbox').focus();
	
	/**
	 * 验证码打开实现
	 */
	var vcTr=$("#vcTr");
	var vcImg=$("#vcImg");
	var if_catcha_available = false;
	
	if(if_catcha_available) {
		$("#captcha").on("click", function() {
			vcTr.show();
			return false;
		}).on("focus", function() {
			vcTr.show();
			return false;
		}).on("keydown", function(event) {
				if(event.which==13){
					$("#loginBtn").click();
					vcTr.show();
				}
		});

		$("#vcImg").hover(function() {
			vcTr.show();
		});
		$(document).click(function() {
			vcTr.hide();
		})
		
		$("#vcTr").on("click", function(event) {
			vcImg.attr("src","getKaptchaImage?r=" + new Date());
			event.stopPropagation();
		});
	}

	
	/*
	 * 登录检测和提交
	 */
	$("#loginBtn").on("click",function(){
		
		if(uiEx.validate("#loginForm")){

			// 是否开启验证码
			if(if_catcha_available) {
				var vc=$("#captcha")
				if(vc.size()!=0){
					// $.post("checkCaptcha","getKaptchaImage="+vc.val(),function(data){
					// 	if(data.statusCode==200){
					// 		$('#loginBtn').linkbutton('disable');
					// 		uiEx.submitForm('#loginForm');
					// 	}else{
					// 		uiEx.msg(data.msg);
					// 			vcImg.attr("src", "getKaptchaImage?r=" + new Date());
					// 			vc.select();
					// 			vc.focus();
					// 	}
					// });
                    		uiEx.submitForm('#loginForm');
                }
			}else{
				$('#loginBtn').linkbutton('disable');
				uiEx.submitForm('#loginForm');
			}
		}
	});
	
	
	$("#captcha").keydown(function(event){
        console.log("监听----"+event.keyCode);
		if(event.keyCode==13){
            uiEx.submitForm('#loginForm');
		}
	});




})