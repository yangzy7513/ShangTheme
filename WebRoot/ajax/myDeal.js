/**
 * 订单详情页
 * create by CC 08.31
 */

$(function(){
	//$("body").css("background-color", "#"+Math.random()*899+100) ;
	$.post(path+"getorder.do",null,null,null,null);
});

var checkName = document.getElementsByName("checkbox");

function selectAll(obj) {
	var sum = 0;
	if(obj.checked==true){
		for(var i = 0;i < checkName.length;i++){
			checkName[i].checked=true;
			sum += parseFloat($(checkName[i]).parent().parent().children(
			'td').eq(6).html().replace(/[^\d.]/g, '').trim());
		}
	}else {
		for(var j = 0;j < checkName.length;j++){
			checkName[j].checked=false;
		}
	}
	showsum(sum);
}

/**************modify by yangzy****************/
function check_selectAll() {
	var sum = 0;
	var flag = 0;
	for (var i = 0; i < checkName.length; i++) {
		if (checkName[i].checked) {
			sum += parseFloat($(checkName[i]).parent().parent().children(
					'td').eq(6).html().replace(/[^\d.]/g, '').trim());
			flag++;
		}
	}
	if (flag == checkName.length) {
		document.getElementById("seceltAll").checked=true;
	} else{
		document.getElementById("seceltAll").checked=false;
	}
	
	showsum(sum);
}
/**********************************************/

/********add by yangzy***********/
function o_del(id){
	if (confirm("喵~ 亲要删除这个主题吗?")) {
		$.ajax({
			url : 	path+"delsingleorder.do",
			type : "post",
			data : {
				"id" : id,
			},
			dataType : "json",
			success:function(result){
				if (result.status == 0) {
					window.location.href = "../getorder.do";
				}else{
					alert(result.msg);
				}
			}
			
		});
	}
}

//动态tfoot
function showsum(sum){
	$('tfoot').remove();
	$("#suborder").attr("disabled",true);
	if (sum > 0) {
		var $html = $(
				'<tfoot>'+
				'	<tr>'+
				'		<td colspan="5"></td>'+	
				'		<td colspan="2"><b>您的交易金额:</b></td>'+
				'		<td>￥'+sum+'元</td>'+
				'	</tr>'+
				'</tfoot>'
		);
		$('tbody').after($html);
		$("#suborder").attr("disabled",false);
	}
}
/********************************/
