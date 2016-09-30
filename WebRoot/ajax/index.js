/**
 * create By  CC  0906
 */

window.ready = initAll();

//初期化获取新品推荐数据
function initAll() {
	$.post(path+"doRecommendation.do");
}