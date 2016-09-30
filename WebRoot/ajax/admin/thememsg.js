/**
 *  create By CC
 */
window.onload= initAll;

var ary = document.getElementsByTagName("input");
/**
 *  頁面初始化
 */
function initAll() {
	judgeSts();
}

/**
 *  判斷狀態
 */
function judgeSts() {
	var status = GetQueryString("sts");
	if (status == 0) {
		modify();
	} else if(status == 1){
		defaultmsg();
	} else {
		$("input").val("");
		modify();
	}
}

/**
 *  修改按鈕壓下
 */
function modify() {
	for (var i = 0; i < ary.length; i++) {
		ary[i].readOnly=false;
		ary[i].style.border="2px solid #ddd";
		ary[i].autocomplete = "off";
	}
	document.getElementById("photo").style.display = "";
	document.getElementById("btn_save").style.display = "";
	document.getElementById("fileUpload").style.display = "";
	document.getElementById("btn_modify").style.display = "none";
	document.getElementById("path").style.display = "none";
	document.getElementById("btn_modify").style.display = "none";
}
/**
 * 保存按鈕壓下
 */
function save() {
	//ajax 提交数据
	$.ajaxFileUpload({
		url:path+'uploadthemephotos.do',  //用于文件上传的服务器端请求地址
		secureuri: false,         //是否需要安全协议，一般设置为false
		fileElementId:['hidden','photo1','photo2','photo3','photo4'],//文件上传域的ID
		dataType:'json',
		success:function(result){
			if (result.status == 0) {
				document.getElementById("sub").click();
				alert("上传成功");
				defaultmsg();
			}
		}
		});
	
	// 状态设置
	defaultmsg();
}
/**
 *  默認狀態
 */
function defaultmsg() {
	for (var i = 0; i < ary.length; i++) {
		ary[i].readOnly=true;
		ary[i].style.border="none";
	}
	document.getElementById("btn_modify").style.display = "";
	document.getElementById("path").style.display = "";
	document.getElementById("btn_modify").style.display = "";
	document.getElementById("photo").style.display = "none";
	document.getElementById("btn_save").style.display = "none";
	document.getElementById("fileUpload").style.display = "none";
}

/**
 * 上傳按鈕
 */
function btn_upload(obj) {
	document.getElementById("hidden").click();
	document.getElementById("uploadpath").value = document.getElementById("hidden").value;
}

