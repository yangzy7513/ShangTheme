/**
 * Created by SUPER MAN  on 2016/8/21.
 */

window.onload= initAll;

/**
 *  頁面初期化
 */
function  initAll() {
	
}


/** 切換登錄註冊
 * @param obj
 */
function doClick(obj) {
    if (obj.id=="btn_logIn"){
        document.getElementById("part_1").style.display="";
        obj.className += " active";
        document.getElementById("btn_reg").className = "btn-lg btn-link";
    }else if(obj.id=="btn_reg"){
            document.getElementById("part_1").style.display="none";
        obj.className += " active";
        document.getElementById("btn_logIn").className = "btn-lg btn-link";
    }
    
}



/**
 *  注册表单验证
 *  
 */
function checkRegForm() {
	var user = document.getElementById("r_userName").value;
	var password = document.getElementById("r_pWords").value;
	
	//检查用户名 是否被占用
	checkRegName(user);

	//checkRegPassword();
	
	$.ajax({
		url : path + "doregister.do",
		type : "post" ,
		data : { 
			"user" : user,
			"password" : password
		} ,
		dataType : "json"
	});
}


/** 检查用户名 是否被占用
 * @param r_userName
 */
function checkRegName(user) {
	if (user==null || user=="") {
		alert("用戶名不能為空");
		//document.getElementById("r_userName").focus();
	} else if (!isNaN(user)) {
		alert("不能用純數字作為密碼，至少有一個字母");
		//document.getElementById("r_userName").focus();
	}else{
		$.ajax({
			url : path + "checkname.do",
			type :"post",
			data : {
				"user_name" : user
			},
			dataType : "json",
			success:function(result){
				if (result.status==0) {
					alert(result.msg);
				}
			}
		});
	}
}

