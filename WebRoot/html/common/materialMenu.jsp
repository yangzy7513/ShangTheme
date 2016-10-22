<%--共同侧边导航 --%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<link href="../css/materialMenu.min.css" rel="stylesheet">
<script type="text/javascript" src="../js/materialMenu.min.js"></script>

<button id="mm-menu-toggle" class="mm-menu-toggle"
	style="z-index: 999999;top:100px;">Toggle Menu</button>
<nav id="mm-menu" class="mm-menu">
	<div class="mm-menu__header">
		<img class="headPhoto img-circle" src="../${suser.s_headphoto}"
			style="margin-left:110px; margin-top:100px; width:80px;"
			id="headPhoto2" />
	</div>
	<ul class="mm-menu__items">
		<li class="mm-menu__item"><a class="mm-menu__link" href="../getmyassets.do?pageNo=1"
			onclick="checkBtn()"> <span class="mm-menu__link-text"> 
			<i class="icon-suitcase"></i>&nbsp;我的资产</span>
		</a></li>
		<li class="mm-menu__item"><a class="mm-menu__link" href="../mycollction"
			onclick="checkBtn()"> <span class="mm-menu__link-text">
			<i class="icon-bookmark"></i>&nbsp;我的收藏</span>
		</a></li>
		<li class="mm-menu__item"><a class="mm-menu__link" href="dingdan"
			onclick="checkBtn()"> <span class="mm-menu__link-text">
			<i class="icon-cog"></i>我的订单</span>
			<%	
				List order = (List)session.getAttribute("order");
				if(order !=null && order.size() > 0){
			%>
			<span class="badge">${order.size()}</span>
			<%} %>
		</a></li>
		<li class="mm-menu__item"><a class="mm-menu__link" href="msg"><span
				class="mm-menu__link-text"><i class="icon-leaf"></i>&nbsp;我的消息
			</span>
		</a></li>
		<li class="mm-menu__item"><a class="mm-menu__link" href="../${suser.s_id }/user.html"
			onclick="checkBtn()"> <span class="mm-menu__link-text">
			<i class="icon-cog"></i>&nbsp;我的资料
			</span>
		</a></li>
		<li class="mm-menu__item"><a class="mm-menu__link" href="reset.jsp"
			onclick="checkBtn()"> <span class="mm-menu__link-text"> <i
					class="icon-plus-sign-alt"> </i> 安全中心
			</span>
		</a></li>
	</ul>
</nav>
<!-- /nav -->
<script>
		var menu = new Menu;

		function iFrameHeight() {
			var ifm = document.getElementById("iframe_a");
			var subWeb = document.frames ? document.frames["iframe_a"].document
					: ifm.contentDocument;
			if (ifm != null && subWeb != null) {

				ifm.height = subWeb.body.scrollHeight;

			}

		}
	</script>