<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>search</title>
<%@include file="common/link_js.jsp"%>
<%-- ----------------------- css -------------------------- --%>
<style>
body {
	background-image: url("../images/bg_2.png");
	overflow: hidden;
}
li{cursor: pointer;margin-top: 5px;}
</style>
</head>
<body>
	<%@ include file="common/header.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<a href="../index.jsp"> <img class="center-block"
					src="../images/logo_4.png">
				</a>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-3 column">
				<div class="btn-group">
					<button data-toggle="dropdown" class="btn btn-info dropdown-toggle"
						type="button" id="btn_brand" >
						手机品牌<span class="caret"></span>
					</button>
					<ul role="menu" class="dropdown-menu" id="brand" style="min-width: 110px;text-align: center;">
						<li onclick="check_dropdown(this);">小米</li>
						<li onclick="check_dropdown(this);">魅族</li>
						<li onclick="check_dropdown(this);">苹果</li>
						<li onclick="check_dropdown(this);">步步高</li>
					</ul>
				</div>
				<div class="btn-group">
					<button data-toggle="dropdown" class="btn btn-info dropdown-toggle"
						id="btn_ClassifiedSearch" type="button">
						分类搜索<span class="caret"></span>
					</button>
					<ul role="menu" class="dropdown-menu" id="ClassifiedSearch" style="min-width: 110px;text-align: center;">
						<li onclick="check_dropdown(this);">扁平</li>
						<li onclick="check_dropdown(this);">炫酷</li>
						<li onclick="check_dropdown(this);">帅哥</li>
						<li onclick="check_dropdown(this);">美女</li>
						<li onclick="check_dropdown(this);">游戏</li>
						<li onclick="check_dropdown(this);">动漫</li>
						<li onclick="check_dropdown(this);">影视</li>
					</ul>
				</div>
			</div>
			<form method="post" role="form" action="../search.do" style="margin-left: -20px;">
				<div class="input-group">
					<input name="str" id="search" class="form-control"
					  onkeydown="check_btn(this);" />
					  <span class="input-group-btn">
						<button type="submit" class="btn btn-default">Search</button>
					  </span>
				</div>
			</form>
		</div>
	</div>
	<div class="row clearfix" style="height: 280px;">
		<div class="col-md-3 column"></div>
		<div class="col-md-6 column">
			<span style="cursor: pointer;">猜 你 喜 欢 <i class="icon-refresh"></i></span><br><br>
			<form>
				<input class="btn btn-sm" name="word" value="帅哥" type="button"
					onclick="transfer(this);" /> <input class="btn btn-sm" name="word"
					value="美女" type="button" onclick="transfer(this);" /> <input
					class="btn  btn-sm" name="word" value="简约" type="button"
					onclick="transfer(this);" /> <input class="btn btn-sm" name="word"
					value="圆角图标" type="button" onclick="transfer(this);" /> <input
					class="btn btn-sm" name="word" value="动漫人物" type="button"
					onclick="transfer(this);" />
			</form>
		</div>
		<div class="col-md-3 column"></div>
	</div>
	<%-- -----------------------script------------------------- --%>
	<script src="../ajax/search.js"></script>
</body>
</html>