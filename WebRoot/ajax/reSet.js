/**
 * Created by cc on 2016/8/17.
 */
window.onload = initAll;

//设置定时器初始值
var time = 30,timer;
//下一步flag
var flg = 0;
/***********************************************************************************************************************
    页面初始化
 ***********************************************************************************************************************/
function initAll () {
    document.getElementById("t0").style.backgroundImage="url(../images/target_active.png)";
    document.getElementById("part_2").style.display="none";
    document.getElementById("part_3").style.display="none";
    $("#verification").val("");
    
    //检查倒计时是否未执行完
    var timecookie = $.cookie("timecookie");
    if (timecookie > 0) {
		time = timecookie;
		forbid();
	}
}
/***********************************************************************************************************************
    获取验证码按钮
 ***********************************************************************************************************************/
function beforeGetCode(){
	var phonenum = $("#phoneNum").val();
	if (!checkphonenum(phonenum)) {
		alert("未输入手机号或非法手机号");
		return false;
	}
	
	$.post("../phonecheck.do",{'phonenum' : phonenum},null,"json").done(function(result){
		if (result.status == 0) {
			$("#checkphone").trigger("click");
		}
		if (result.status == 308) {
			alert(result.msg);
		}
	});
}

function getCode(){
	var phonenum = $("#phoneNum").val();
	$.post("../getauthcode.do",{'phonenum' : phonenum},null,"json");
	forbid();
}

function  forbid() {
	    document.getElementById("btn").setAttribute("disabled", true);
	    time--;
	    $.cookie("timecookie", time);
	    if (time == 0) {
	    	document.getElementById("btn").value = "重新获取验证码";
	    	document.getElementById("btn").removeAttribute("disabled");
	    	clearTimeout(timer);
	    	time = 60;
	    	$.cookie("timecookie", null);s
	    	return true;
	    }
	    timer = setTimeout(forbid, 1000);
	    document.getElementById("btn").value = time + " 秒后重新获取";
}
/*******************************************************************************
 * 下一步按钮处理
 ******************************************************************************/
function  nextStep() {
    var idAry = new Array("part_1","part_2","part_3");
    var ispass = false;
    //第一画面
	if (flg == 0) {
		if(!checkPhone()){
			return false;
		}
		if (checkEmpty($("#verification").val())) {
			alert("未输入验证码");
			return false;
		}
		$.ajax({
			url : "../checkAuthCode.do",
			type : "post",
			async:false,
			data : {
				"code" : $("#verification").val()
			},
			dataType : "json"
		}).done(function(result){
			if (result.status == 0) {
				$.cookie("phonenum",$("#phoneNum").val());
				ispass = true;
			}else {
				alert(result.msg);
				ispass = false;
			}
			
		});
	}
    
	//第二画面的flag
    if(flg ==1){
    	var newPwd = $("#pWords").val();
    	var again_pWords = $("#again_pWords").val();
    	if (!isequal(newPwd, again_pWords)) {
			alert("密码不一致");
			$("#pWords").val("");
			$("#again_pWords").val("");
			return false;
		}
    	$.ajax({
    		url : "../resetpwd.do",
			type : "post",
			async:false,
			data : {
				"phonenum" : $.cookie("phonenum"),
				"newPwd" : newPwd
			},
			dataType : "json",
			success:function(result){
				if (result.status == 0) {
					ispass = true;
				}else {
					alert(result.msg);
					ispass = false;
				}
			}
    	});
	}
    
    if (!ispass) {
		return;
	}
    
    flg++;
    if(flg>2){
        return;
    }
    if(flg==2){
        document.getElementById("next").style.display="none";
        var i = 5;
        var intervalID = window.setInterval(function(){
        	 $("#resok").html("密码修改成功! "+i+"秒后跳回登录页");  
        	 i--;
        	 if (i == 0 ) {
				window.location.href = "logIn.jsp";
				clearInterval(intervalID);
			}
        }, 1000)
    }
    for(var i=0;i<=idAry.length;i++){
        if(i==flg){
            document.getElementById(idAry[i]).style.display="";
            document.getElementById("t"+i).style.backgroundImage="url(../images/target_active.png)";
        }else {
            document.getElementById(idAry[i]).style.display="none";
            document.getElementById("t"+i).style.backgroundImage="url(../images/target.png)";
        }
    }
}



function checkPhone(){
  var phone = document.getElementById("phoneNum").value;
  if(!(/^1[3|4|5|7|8]\d{9}$/.test(phone))){
	  alert("手机号码有误，请重填");
      return false;
  	}
   return true;
}