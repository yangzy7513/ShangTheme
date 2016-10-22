<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>尚 主 题 | 首 页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<%@include file="html/common/link_js.jsp"%>

<%-- JavaScript  --%>
<script type="text/javascript" src="ajax/index.js"></script>
</head>
<body>
	<%@include file="html/common/header.jsp"%>
	<!--END HEADER-->
	<!-- ************************** Slider ***************************************-->
	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel" style="margin-top: 40px;">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<c:forEach items="${homeinfo.adList}" var="item" varStatus="status">
			<div class="item ${status.index == 0 ? 'active' : ''} ">
				<a href="http://${item.ad_href }" target="_blank"><img src="http://localhost:8080${pageContext.request.contextPath}/${ item.picpath}"></a>
			</div>
			</c:forEach>
		</div>

		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span class="sr-only">Next</span>
		</a>
	</div>
	<hr>
	<!--*******************************End Slider************************************* -->
	<!--*******************************start modal************************************* -->
	<div class="container-fluid section-fluid top top80"
		style="margin-top: -80px;margin-left: 50px;background-color: #fff;">
		<h5 style="margin-left: 30px;">* 新 品 推 荐 *</h5>
		<section id="portfolio" class="container" style="padding-top: 20px;">
			<ul class="portfolio-items d-f apps">
				<c:forEach items="${homeinfo.themresult}" var="item" varStatus="status">
					<li class="portfolio-item">
						<div class="item-inner">
							<img src="${pageContext.request.contextPath}/${item.t_picpath.split('&')[0]}"
								style="width: 264px;">
							<center>
								<h5>${item.t_themename}<span class="badge">新</span></h5>
							</center>
							<div class="overlay">
								<a class="preview btn btn-danger" rel="prettyPhoto"
								 	target="_blank" href="html/detail.jsp?id=${item.t_id}">
									<i class="icon-eye-open" target="_blank"></i></a>
							</div>
						</div>
					</li>
					<c:if test="${status.index % 4 == 3 }">
			</ul>
			<ul class="portfolio-items d-f apps">
				</c:if>
				</c:forEach>
			</ul>
		</section>
		<!--/#portfolio-->
	</div>
	<br>
	<br>
	<br>
	<%@ include file="html/common/footer.jsp"%>
</body>
</html>