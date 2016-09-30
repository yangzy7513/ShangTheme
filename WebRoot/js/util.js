/******************************
 * 全局工具js
 * 更新时间：2016/08/21
 * 第一制作人:yangzy
 * 更新内容:修改为运行期开启监听
 * 
 *****************************/

//项目路径获取
var path = "/ShangTheme/"

//验证是否为手机号
function checkphonenum(x){
	var patt = /^1[3,5,8]\d{9}/;
	if (patt.test(x)) {
		return true;
	}
	return false;
}

//检测两个元素是否相等
function isequal(a,b){
	if (a == b) {
		return true;
	} else{
		return false;
	}
}

//生成验证码
function vercode(id){
	var chars = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
	var res = "";
     for(var i = 0; i < 4 ; i ++) {
         var uid = Math.ceil(Math.random()*35);
         res += chars[uid];
     }
     document.getElementById(id).innerHTML = res;
}

//检查是否为空
function checkEmpty(x){
	if (x == "null") {
		return true;
	}
	var patt = /\d*/;
	if(patt.test(x)){
		if (x == "") {
			return true;
		}
		return false;
	}else {
		if (x=="") {
			return true;
		}
		return false;
	}
}

//导航共同弹出消息
function showmsg(msghtml){
	$("#msgbody").html(msghtml);
	$("#msg").slideDown("slow").delay(3000).slideUp("slow"); 
}

//过滤敏感词汇
function strfilter(str){
	var forbiddenArray = ['&','&amp','草','骚逼','sb','SB','贱','犊子','傻逼','瞎','肏','逼','乳房','滚','卧槽'];
	
	for (var  i= 0; i < forbiddenArray.length; i++) {
		
		//全局替换
		var reg = new RegExp(forbiddenArray[i],"g");
		
		if(str.indexOf(forbiddenArray[i])!=-1){  
			var result = str.replace(reg,"*");
			return result;
		}
	}
	//不含敏感词汇直接返回
	return str;
	
}

//获取URL参数
function GetQueryString(name){
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
     
}


