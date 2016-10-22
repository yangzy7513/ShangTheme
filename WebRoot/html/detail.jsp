<%--
	商品详细信息展示页面
 --%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>详 细 页 面</title>
  	<%@include file="common/link_js.jsp" %>
   	<link rel="stylesheet" type="text/css" href="../css/barrager.css">
  	<script src="../js/jquery.barrager.min.js"></script>
  	<script src="../ajax/sendbarrager.js"></script>
   	<script src="../ajax/detail.js"></script>
 </head>
 
<body style="background-color: #0F9;">
	<%@ include file="common/header.jsp"%>
	<div class="container" style="min-height: 700px">
		<div class="row clearfix">
			<div class="col-md-6 column">
				<div
					style="display: block;float: left;margin-left: 220px;margin-top: 80px">
					<div>
						<img id="phone_Img" src=""  
							style="position: absolute;left: 264px;top:132px;width: 210px;">
						<img src="../images/phone.png" width="260">
					</div>
					<div style="margin-top: -260px;margin-left: 260px">
						<img id="next" src="../images/right.png" width="50"
								onclick="swichImg(this);" style="cursor: pointer;">
						<%-- 追加 onclick id--%>
					</div>
					<div  style="margin-top: -44px;margin-left: -55px">
						<img id="left" src="../images/left.png" width="50" style="cursor: pointer;" onclick="swichImg(this);" >	<%--追加 onclick id --%>
					</div>
				</div>
				<%-- 发送弹幕--%>
				<c:if test="${suser != null}">
				<div style="position: absolute;top:550px;left: 160px;min-width: 500px">
					<div id="bs-example-navbar-collapse-5"
						class="collapse navbar-collapse">
						<form role="search" class="navbar-form navbar-left" onsubmit="return false;">
							<div class="form-group" style="float: left">
								<input name="info" type="text" placeholder="请填写弹幕文字" class="form-control"
									autocomplete="off" style="width: 300px">
							</div>
							<div style="float: left;margin-left: 5px">
								<input class="btn btn-primary" type="reset" autocomplete="off" value="发送弹幕" id="sendbar"/>
							</div>
						</form>
					</div>
				</div>
				</c:if>
			</div>
			<div class="col-md-6 column">
				<div id="message"
					style="display: block;float: left;margin-left: 10px;margin-top: 150px">
					<div class="row">
						<h5 id="headname" class="col-md-4">主 题 简 介</h5>
						<c:if test="${suser != null}">
						<div class="col-md-2 col-md-offset-1">
							<i class="icon-2x" style="color:yellow;cursor: pointer; line-height: 60px;" onclick="doCollection(); "></i>
						</div>
						</c:if>
					</div>
					<br>
					<!--详细介绍-->
					<div>
						<ul style="float: left;text-align: center" id="ulname">
							<li>作 者：</li>
							<li>名 称：</li>
							<li>品牌：</li>
							<li>适配型号：</li>
							<li><i class="icon-cloud-download"></i></li>
							<li>详 细 介 绍：</li>
							
						</ul>
						<ul style="float: right;text-align: left" id="uldata">
							<li id="author"></li>
							<li id="themename"></li>
							<li id="brandname"></li>
							<li id="firmware"></li>
							<li id="downloadnum"></li>
							<li id="abstract" style="font-size: 14px;width:400px;"></li>
						</ul>
					</div>
					
					<div id="default">
					<c:if test="${suser != null}">
						<ul style="margin-top: 240px;"  id="btnstatus">
							<li style="float: left;margin-right: 10px;"><button
									class="btn btn-success" onclick="addShopCard();">加入购物车</button></li>
							<li style="float: left;"><button
									class="btn btn-danger">直接购买</button></li>
							<li style="float: left;margin-right: 20px;"><button
									class="btn btn-info btn-lg btn-block" style="margin-left: 83px;" onclick="download();">
									<i class="icon-cloud-download"></i>下 载</button></li>
						</ul>
					</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="common/footer.jsp"%>
</body>
</html>