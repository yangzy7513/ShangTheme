/******************************
 * 注册页面
 * 更新时间：2016/08/21
 * 第一制作人:yangzy
 * 更新内容:增加头像验证
 * 
 *****************************/

/**************************************
 * 检查必要的输入框
 *************************************/
function checkInput(){
	getParameter();
	
	if (checkEmpty(username) || checkEmpty(sex) || checkEmpty(birthday) || checkEmpty(password)) {
		alert("有未输入或未选择的框");
		return false;
	}
	if (!checkphonenum(phonenum)) {
		alert("您输入的不是手机号");
		return false;
	}
	
	if (!isequal(password, checkpwd)) {
		alert("密码不一致");
		return false;
	}
	return true;
}

/**************************************
 * 用户名检查
 *************************************/
function checkname(){
	username = $("#re_username").val();
	if (checkEmpty(username)) {
		$("#re_span1").removeClass();
		$("#re_span1").addClass("glyphicon glyphicon-remove form-control-feedback");
		return;
	}
	
	$.ajax({
		url : path+"checkusername.do",
		type : "post",
		data : {
			"username" : username
		},
		dataType : "json",
		success : function(result) {
			if (result.status == 0) {
				$("#re_span1").removeClass();
				$("#re_span1").addClass("glyphicon glyphicon-ok form-control-feedback");
				$("#re_span1").show();
			} else if(result.status == 301){
				$("#re_span1").removeClass();
				$("#re_span1").addClass("glyphicon glyphicon-remove form-control-feedback");
				$("#re_span1").show();
			}
		}
	});
	
	
	
}

/**************************************
 * 密码检查
 *************************************/
function checkpwd(){
	var password = $("#re_password").val();
	var checkpwd = $("#re_checkpwd").val();
	if (isequal(password, checkpwd)) {
		$("#re_span2").removeClass();
		$("#re_span2").addClass("glyphicon glyphicon-ok form-control-feedback");
		$("#re_span2").show();
	} else{
		$("#re_span2").removeClass();
		$("#re_span2").addClass("glyphicon glyphicon-remove form-control-feedback");
		$("#re_span2").show();
	}
}

/**************************************
 * 电话号检查
 *************************************/
function checktel(){
	var phonenum = $("#re_phonenum").val();
	if (checkEmpty(phonenum) | !checkphonenum(phonenum)) {
		$("#re_span3").removeClass();
		$("#re_span3").addClass("glyphicon glyphicon-remove form-control-feedback");
		$("#re_span3").show();
		return;
	}
	
	$.ajax({
		url : path+"phonecheck.do",
		type : "post",
		data : {
			"phonenum" : phonenum
		},
		dataType : "json",
		success : function(result) {
			//手机未注册
			if (result.status == 308) {
				$("#re_span3").removeClass();
				$("#re_span3").addClass("glyphicon glyphicon-ok form-control-feedback");
				$("#re_span3").show();
			} else if(result.status == 0){
				$("#re_span3").removeClass();
				$("#re_span3").addClass("glyphicon glyphicon-remove form-control-feedback");
				$("#re_span3").show();
			}
		}
	});
}


/**************************************
 * 绑定事件
 *************************************/
$(function() {	
	
	//$('#birthday').cxCalendar({format: "YYYYMMDD"});
	
	$("#sub_btn").click(function(){
		
		var username = $("#re_username").val();
		var password = $("#re_password").val();
		var checkpwd = $("#re_checkpwd").val();
		var phonenum = $("#re_phonenum").val();
		
		$.ajax({
			url : path+"register.do",
			type : "post",
			data : {
				"username" : username,
				"password" : password,
				"phonenum":phonenum 
			},
			dataType : "json",
			beforeSend : function(){
				$("#sub_btn").html("注册中...");
				$("#sub_btn").attr("disabled",true);
			},
			success : function(result) {
				$("#sub_btn").text("注册");
				$("#sub_btn").attr("disabled",false);
				if (result.status == 0) {
					showmsg("<strong>Sucess!</strong> "+result.msg+".");
					location.reload();
				} else{
					showmsg("<strong>Warning!</strong> "+result.msg+".");
				}
			}
		});
		
	});
	
});


	
