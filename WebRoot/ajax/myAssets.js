/**
 *  create By CC 0907
 */
window.onload = initAll;


/*
 * 系统初期化
 */
function initAll() {
	
	//查询资产
	$.post(path+"getmyassets.do?pageNo=1");
	
}