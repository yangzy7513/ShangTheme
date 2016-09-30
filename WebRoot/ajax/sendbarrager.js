/******************************
 * 弹幕功能
 * 更新时间：2016/08/28
 * 第一制作人:yangzy
 * 更新内容:修改为运行期开启监听
 * 
 *****************************/
$(function(){
	
	//设置定时器初始值
	var time = 60,timer;
	
	//检查倒计时是否未执行完
    var timecookie = $.cookie("timecookie");
    if (timecookie > 0) {
		time = timecookie;
		forbid();
	}
	
	//获取当前主题id
	var id = GetQueryString("id");
	if(typeof GoEasy !== 'undefined'){
        var goEasy = new GoEasy({ 
            appkey: '475987c9-e307-4842-89a0-0044306d5694', 
            onConnected:function(){ 
                console.log("Connect to GoEasy success.");
            }, 
            onDisconnected:function(){ 
                showmsg("<strong>Warning!</strong>您的网络已中断.");
            }, 
            onConnectFailed:function(error){ 
            	showmsg("<strong>Warning!</strong>您的网络已中断");
            } 
        }); 
        
    	//订阅channel
        goEasy.subscribe({ 
            channel: 'ShangTheme', 
            onMessage: function(message){ 
                //当有消息推送到channel “ShangTheme”时，控制台会自动打印出推送的消息 
                var data = message.content.split("&amp;");
                if (data[3] == id) {
                	dotantantan(data[0], data[1], data[2]);
				}
            }, 
            onSuccess:function(){ 
                console.log("Subscribe the Channel successfully.");
            }, 
            onFailed: function(error){ 
            	showmsg("<strong>Warning!</strong>您断开了网络");
            } 
        });
        
	};
	
	//回车事件
	$("[name='info']").bind('keypress',function(event){
        if(event.keyCode == "13"){
            $("#sendbar").trigger("click");
        }
    });
	
	//发送弹幕事件
	$("#sendbar").click(function(){
		var headphoto = $("#headPhoto1").attr("src");
		var say =  strfilter($("[name='info']").val());
		$("[name='info']").val("");
		//拼接相关信息发送
		if (!checkEmpty(say)) {
			var msg = headphoto+"&"+say+"&"+'../index.jsp'+"&"+id;
			$.post(path+"/pushmsg.do",{"msg":msg},null,null);
			forbid();
		} 
	});
	
	function  forbid() {
	    document.getElementById("sendbar").setAttribute("disabled",true);
	    time--;
	    $.cookie("timecookie",time);
	    if(time == 0){
	        document.getElementById("sendbar").value="重新发送";
	        document.getElementById("sendbar").removeAttribute("disabled");
	        clearTimeout(timer);
	        time=60;
	        $.cookie("timecookie",null);
	        return true;
	    }
	    timer = setTimeout(forbid,1000);
	    document.getElementById("sendbar").value=time+" 秒后重新发送";
	}
	
	//页面弹幕处理
	function dotantantan(img,info,href){
		var item={
				   img:img, //图片 
				   info:info, //文字 
				   href:href, //链接 
				   close:true, //显示关闭按钮 
				   speed:6, //延迟,单位秒,默认6 
				   // bottom:300, //距离底部高度,单位px,默认随机 
				   color:'#fff', //颜色,默认白色 
				   old_ie_color:'#000000', //ie低版兼容色,不能与网页背景相同,默认黑色 
				 }
		$("body").barrager(item);
	}
	
	
})



