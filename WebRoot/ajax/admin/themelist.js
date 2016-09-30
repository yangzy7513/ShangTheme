/**
 *  create by CC
 */

// 获取所有主题的checkbox
var checkboxAry = document.getElementsByName("theme");

/**
 * 页面初期化
 */
window.onload = function() {
	$.post(path + "showtheme.do?pageNum=1");
};

/** 全选实现
 * @param obj
 */
function selectAll(obj) {
	for (var i = 0; i < checkboxAry.length; i++) {
		if (obj.checked) {
			checkboxAry[i].checked = true;
		} else {
			checkboxAry[i].checked = false;
		}
	}
}

/**
 * 全选功能补充
 */
function selected() {
	var flg = 0;
	for (var i = 0; i < checkboxAry.length; i++) {
		if (checkboxAry[i].checked) {
			flg++;
		}
	}
	if (flg == checkboxAry.length) {
		document.getElementById("selectAll").checked = true;
	} else {
		document.getElementById("selectAll").checked = false;
	}
}


/** 
 * 显示主题详细信息
 * 
 * @param obj
 */
function showDetail(obj) {
	var id = obj;
	$.ajax({
		url  : path + "showdetail.do",
		type : "post",
		data : {
			t_id : id
		},
		dataType : "json",
		success : function(result) {
			if (result.status == 0) {
				window.open("thememsg.jsp?sts=1");
			}
		}
	});
}

/**
 * 处理主题（上架 下架 删除）
 * 
 * @param obj
 */
function dealTheme(obj) {
	var flg = false;
	var theme = new Array();
	for (var i = 0; i < checkboxAry.length; i++) {
		if (checkboxAry[i].checked) {
			flg = true;
			theme.push(checkboxAry[i].id);
		}
	}
	theme = theme + "";
	if (flg == true) {
		// 删除主题情况发送请求
		$.ajax({
			url : path + "dealtheme.do",
			type : "post",
			data : {
				themeId : theme,
				buttonId : obj.id
			},
			dataType : "json",
			success : function(result) {
				alert(result.msg);
				window.location.reload();
			}
		});
	} else {
		alert("请至少选择一个主题");
	}
}

