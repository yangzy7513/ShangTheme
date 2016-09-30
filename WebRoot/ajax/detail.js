/**
 * 主题详情
 * create by CC
 */
window.onload = initAll;
window.onresize = change; 
/*
 *  页面初期化
 */
var showpathlist = null;
var vip;
//收藏flag:{0}收藏；{1}未收藏
var collecflag = 1;
function initAll() {
	//获取主题信息并展示
	$.ajax({
		url:path+"gettheme.do",
		type:"post",
		data:{"id":GetQueryString("id")},
		dataType:"json",
		success:function(result){
			var data = result.data;
			//收藏状态
			data['collecstatus'] > 0 ? $('.icon-2x').addClass('icon-star')  :    $('.icon-2x').addClass('icon-star-empty');
			data['collecstatus'] > 0 ? collecflag = 0 :  collecflag = 1;
			document.title = data['t_themename'];
			$('#author').html(data['t_author']);
			$('#themename').html(data['t_themename']);
			$('#brandname').html(data['b_brandname']);
			$('#firmware').html(data['t_firmware']);
			$('#downloadnum').html(data['t_downloadnum']+'次');
			$('#author').html(data['t_author']);
			$('#abstract').html(data['t_abstract']);
			$('#phone_Img').attr("src", "../"+data['pathList'][0]);
			showpathlist = data['pathList'];
			vip = data['t_vip'];
			switch(vip){
				case 0 : 
						 $('#ulname li').eq(4).after("<li>价格:</ul>");
						 $('#uldata li').eq(4).after("<li>$"+parseFloat(data['t_price'])+"</ul>");
						 break;
				case 1 : 
						 $("#headname").append("<span class='badge'>VIP</span>");
						 break;
			}
		}
	});
}

/*==========================================================================================================
 *  隐藏div(页面太小的时候)  
 ===========================================================================================================*/
function change() {
	var width = window.innerWidth;
	if (width < 1000) {
		document.getElementById("message").style.display = "none";

	} else {
		document.getElementById("message").style.display = "block";
	}
}
/*==========================================================================================================
 *  切换图片              
 *  -追加-
 ===========================================================================================================*/
var flg = 0;
function swichImg(obj) {
	// 图片list
	var imgAry = showpathlist;
	// if (flg == imgAry.length) {
	// flg = 0;
	if (obj.id == "next") {
		flg = flg++>imgAry.length-2 ?  0 :  flg;
		obj.src = "../images/right_p.png";
		setTimeout(function() {
			obj.src = "../images/right.png";
		}, 100);
	} else if (obj.id == "left") {
		flg--;
		flg = flg < 0 ?  imgAry.length-1 : flg;
		obj.src = "../images/left_p.png";
		setTimeout(function() {
			obj.src = "../images/left.png";
		}, 100);
	}
	document.getElementById("phone_Img").src = "../" + imgAry[flg];
}

/**
 * 执行收藏 更新:修改收藏功能 ,增加判断收藏flag 2016/9/17 by yangzy
 */
function doCollection() {
	
	$.post(path+"docollection.do",
			{
			"id" : GetQueryString("id"),
			"collecflag" : collecflag
	});
	if (collecflag == 0) {
		$('.icon-2x').removeClass('icon-star').addClass("icon-star-empty");
		collecflag = 1;
	} else if (collecflag == 1) {
		$('.icon-2x').removeClass('icon-star-empty').addClass("icon-star");
		collecflag = 0;
	}
	
	
	/*$.ajax({
		url:path+"docollection.do",
		type:"post",
		data:{
			"id" : GetQueryString("id"),
			"collecflag" : collecflag
		},
		success:function(){
			if (collecflag == 0) {
				$('.icon-2x').removeClass('icon-star').addClass("icon-star-empty");
				collecflag = 1;
			} else if (collecflag == 1) {
				$('.icon-2x').removeClass('icon-star-empty').addClass("icon-star");
				collecflag = 0;
			}
		}
	});	*/
}
/*==========================================================================================================
 *  判断是否显示下载按钮           
 *  
 ===========================================================================================================*/
function showDonloadBtn() {
	$.ajax({
		url:path+"showDownloadBtn.do",
		type:"post",
		data:{
			"id" : GetQueryString("id"),
			"vip": vip
		},
		dataType:"json",
		success:function(result){
			var flg = result.status;
			if (flg==0) {
				document.getElementById("default").style.display="none";
				document.getElementById("download").style.display="block";
			}
		}
	});
	
}

/******************************
 * 加入购物车   by yangzy 
 *****************************/
function addShopCard(){
	$.ajax({
		url:path+"addshopcard.do",
		type:"post",
		data:{
				"id":GetQueryString("id"),
				"vip":vip
			},
		dataType:"json",
		success:function(result){
			if (result.status == 0) {
				window.location.href = "../getorder.do";
			} else{
				showmsg("<strong>Warning!</strong>"+result.msg);
			}
		}
		
	});
}









