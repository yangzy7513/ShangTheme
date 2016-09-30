/**
 *  create by CC  09.03
 */

window.onload = initAll;

/*
 * 页面初期化
 */

function initAll() {
	var btn_ary = Array("btn-primary", "btn-info", " btn-warning", "btn-danger");
	var ary_word = document.getElementsByName("word");
	for (var i = 0; i < ary_word.length; i++) {
		var index = Math.floor((Math.random() * btn_ary.length));
		ary_word[i].className += " " + btn_ary[index];
	}
}

function transfer(obj) {
	document.getElementById("search").value += obj.value + "    ";
	obj.disabled = true;
}

function check_dropdown(obj) {
	var id = obj.parentNode.id;
	document.getElementById("search").value += obj.innerHTML + "    ";
	document.getElementById("btn_" + id).disabled = true;
	
}
function check_btn(obj) {
	var value = obj.value.split(" ");
    
    check_word(value);
    check_brand(value);
    check_Classified(value);
}

function check_word(value) {
	var word_ary = document.getElementsByName("word");
	for (var i = 0; i < word_ary.length; i++) {
		word_ary[i].disabled = false;
		for (var j = 0; j < value.length; j++) {
			if (value[j] == " ") {
				break;
			}
			if (value[j] == word_ary[i].value) {
				word_ary[i].disabled = true;
			}
		}
	}

}

function check_brand(value) {
    var ary_brand = Array("小米","魅族","苹果","步步高");
	for (var i = 0; i < ary_brand.length; i++) {
		document.getElementById("btn_brand").disabled = false;
		for (var j = 0; j < value.length; j++) {
			if (value[j]==" ") {
				break;
			}
			if (value[j]==ary_brand[i]) {
				document.getElementById("btn_brand").disabled = true;
				 return false;
			}
		}
	}
}


function check_Classified(value) {
    var ary_Classified = Array("扁平","炫酷","帅哥","美女","游戏","动漫","影视");
    
	for (var i = 0; i < ary_Classified.length; i++) {
		document.getElementById("btn_ClassifiedSearch").disabled = false;
		for (var j = 0; j < value.length; j++) {
			if (value[j]==" ") {
				break;
			}
			if (value[j]==ary_Classified[i]) {
				document.getElementById("btn_ClassifiedSearch").disabled = true;
				 return false;
			}
		}
	}
    
}
