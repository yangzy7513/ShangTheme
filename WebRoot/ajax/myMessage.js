/**
 *  create By CC (about personal message)
 */
window.onload= initAll;

var ary = Array("userName","phoneNum","birthday","place","place2");

/*
 * 页面初始化
 */
function initAll() {
	document.getElementById("sex").disabled=true;
	document.getElementById("save").disabled=true;
}

/*
 * 导航button 点击事件 
 */
function checkBtn() {
	
}
/*
 * 修改按钮 点击事件 
 */
function modify_information() {
	for (var i=0;i<ary.length;i++){
		document.getElementById(ary[i]).readOnly=false;
		document.getElementById(ary[i]).style.outline="solid #1abc9c";
	}
	
	document.getElementById("sex").disabled=false;
	document.getElementById("sex").style.outline="solid #1abc9c";
	document.getElementById("save").disabled=false;
}
/*
 * 修改按钮 点击事件 
 */
function btn_save() {
	for (var i=0;i<ary.length;i++){
		document.getElementById(ary[i]).readOnly=true;
		document.getElementById(ary[i]).style.outline="none";
	}
	document.getElementById("sex").disabled=true;
	document.getElementById("sex").style.outline="none";
	document.getElementById("save").disabled=true;
}

//*************Add by yangzy start******************
$(function(){
	var sex = $("[name='sex']").val();
	if(sex=="男"){
		$("#sex option[value='0']").attr("selected",true);
	}else{
		$("#sex option[value='1']").attr("selected",true);
	}
	
	var data = $("#showdata").text();
	var status = data.split("&")[0];
	if(status=="0"){
		showmsg("<strong>yes!</strong>修改成功");
		flag++;
	} else if(status == "306"){
		showmsg("<strong>Sorry!</strong>修改失败，稍后再试");
		flag++;
	}
});

function headsubmit(){

$.ajaxFileUpload({
	url:path+'dofileupload.do',  //用于文件上传的服务器端请求地址
	secureuri: false,         //是否需要安全协议，一般设置为false
	fileElementId:'doc',	  //文件上传域的ID
	dataType:'json',
	success:function(result){
		if (result.status == 0) {
			window.location.reload();
		} else {
			showmsg("<strong>Sorry!</strong>"+result.msg);
		}
	}
	});
}

//修改sex，设置到隐藏sex里
function setValue(){
	var value = $("#sex").find("option:selected").text().trim();
	$("[name='sex']").val(value);
}


//验证图片
function showimg(file){
	 if( !file.value.match( /.jpg|.gif|.png|.bmp/i ) ){
         alert('图片格式无效！');
         return false;
     }
}
//*************Add by yangzy end******************


























