/******************************
 * 登录
 * 更新时间：2016/08/21
 * 第一制作人:yangzy
 * 更新内容:
 * 
 *****************************/

$(function(){
	
	//加载页面前先清空输入
	document.getElementById("username").value = "";
	document.getElementById("pWords").value = "";
	var username = null;//初始化用户名
	
	
	$("#btn_logIn").click(function(){
		var username = $("#username").val();
		var password = $("#pWords").val();
		var pagestatus = 1; //判断登录方式1默认为用户名登陆	
		
//		if (checkEmpty(username) || checkEmpty(password)) {
//			//$(".prompt").html("有未输入的框").show().delay(1000).fadeOut(900);
//			alert("有未输入的框");
//			return;
//		}
		
		// change By CC 0904  start
		if (checkEmpty(username)) {
			document.getElementById("username").parentNode.className += " has-error";
			showmsg("<b>您输入的账户为空，请再次输入</b> ");
			return;
		}
		if (checkEmpty(password)) {
			document.getElementById("pWords").parentNode.className += " has-error";
			showmsg("<b>您输入的密码为空，请再次输入</b> ");
			return;
		}else {
			if (password.length<6) {
				var result = confirm("您的密码强度不高，建议您修改密码,是否前往修改密码");
				if (result==true) {
					alert(1);
					window.open("html/reset.jsp");
				}
			}
		}
		// change By CC 0904  end
		
		if (checkphonenum(username)) {
			pagestatus = 2;
		}
		
		//进行登陆
		$.ajax({
			url : 	path+"checklogin.do",
			type : "post",
			data : {
				"loginname" : username,
				"password" : password,
				"pagestatus" : pagestatus
			},
			beforeSend: function () {
				$("#btn_logIn").html("<i class='icon-spinner icon-spin'></i>");
		        $("#btn_logIn").attr({ disabled: "disabled" });
		    },
			dataType : "json",
			success : function(result) {
				$("#btn_logIn").text("Login");
		        $("#btn_logIn").attr("disabled",false);
				if (result.status == 0) {//成功
					if($("#rempwd").attr(':checked')){
						$.cookie("password",password);
					}
					location.reload();
				} else{
					//失败场合
					showmsg("<strong>Warning!</strong> "+result.msg+".请点击<a style='cursor:pointer;' href='html/reset.jsp'>找回密码</a>");
				}
			}
			
		});
		
	});
});
/**
 * 回车触发事件
 * @param obj
 */

function EnterEvent(obj) {
	if (event.keyCode==13) {
		document.getElementById("btn_logIn").click();
	}
}
