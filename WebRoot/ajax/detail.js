/**
 * 主题详情
 * create by CC
 * --修复左右切换显示空白画面的问题 -yangzy 2016/10/14
 */
window.onload = initAll;
window.onresize = change; 
/*
 *  页面初期化
 */
var showpathlist = null;
var vip;
var themeflag;
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
			showpathlist = data['pathList'];
			var reg = /^(\S)+(.)(jpg|png){1}$/;
			for (var i = 0; i < showpathlist.length; i++) {
				if (!reg.test(showpathlist[i]) || typeof(showpathlist[i]) == "undefined" ) {
					showpathlist.splice(i, 1);
					i = i-1;
				}
			}
			$('#phone_Img').attr("src", "../"+showpathlist[0]);
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
			var buystatus =   data['t_price'] == 0&&vip == 0 ? 1:  data['buystatus'];
			themeflag = data['t_price'] == 0&&vip == 0  ?  0 : 1 ;
			switch (buystatus) {
				//未购买
				case 0:
							$("#btnstatus li").eq(2).hide();
							break;
				case 1:
							$("#btnstatus li").eq(0).hide();
							$("#btnstatus li").eq(1).hide();
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
	
	if (obj.id == "next") {
		if (++flg >  showpathlist.length-1) flg = 0;
		
		obj.src = "../images/right_p.png";
		setTimeout(function() {
			obj.src = "../images/right.png";
		}, 100);
	} else if (obj.id == "left") {
		if (--flg <  0) flg = showpathlist.length-1;
		obj.src = "../images/left_p.png";
		setTimeout(function() {
			obj.src = "../images/left.png";
		}, 100);
	}
	document.getElementById("phone_Img").src = "../" + showpathlist[flg];
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
/*function showDonloadBtn() {
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
}*/

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

/******************************
 * 主题下载   by yangzy 
 *****************************/
function download() {
	var form = $('<form>');
	form.attr('style','display:none');
	form.attr('action', path+'downloadtheme.do');
	var input = $('<input>');
	input.attr('type','hidden');
	input.attr('name','id');
	input.attr('value',GetQueryString("id"));
	var input2 = $('<input>');
	input2.attr('type','hidden');
	input2.attr('name','flag');
	input2.attr('value',themeflag);
	$('body').append(form);
	form.append(input);
	form.append(input2);
	form.submit();
	
}






