/**
 * create By  CC  0906
 */

//初期化获取新品推荐数据

$(document).ready(function () {
	$.ajax({
		url:path+"doRecommendation.do",
		async: false,
		type:"get"
	});
	
	
})