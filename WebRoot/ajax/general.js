/**
 * 站内信
 * create by yangzy
 */

$(function(){
	
	var intervalID = window.setInterval(function(){	
		//每隔一段时间获取最新消息
		$.ajax({
			url:path+"checknewletter.do",
			type:"post",
			dataType:"json",
			success:function(result) {
				if (result.status == 313) {
					$('h3').append("<a class='msg col-sm-offset-9' href=../getletter.do>"+result.msg+"</a>");
					clearInterval(intervalID);
				}
			}
		});
	}, 5000);
});

function changetoread(id){
	$.post(path+"changetoread.do",{"msgid": id},null,null);
}
