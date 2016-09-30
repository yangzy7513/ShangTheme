<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	SuserEntity localuser = (SuserEntity)session.getAttribute("suser");
	if(localuser == null){
		response.sendRedirect("../index.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我 的 收 藏</title>
<%@include file="common/link_js.jsp"%>
<script type="text/javascript" src="../ajax/mycollection.js"></script>
</head>
<body>
	<%@ include file="common/header.jsp"%>
	<div id="wrapper" class="wrapper" style="margin-top:20px;">
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-10 column" style="float: left;">
					<div class="container-fluid section-fluid top top80"
						style="margin-top: -50px;margin-left: 50px;background-color: #fff;border-right: 1px #ddd double;">
						<h3 style="margin-top: 30px;margin-left: 50px">-- 我的收藏 --</h3>
						<section id="portfolio" class="container" style="padding-top: 0px;">
							<ul class="portfolio-items d-f apps">
								<c:forEach items="${usercollec}" var="item" varStatus="status">
								<li class="portfolio-item">
									<div class="item-inner">
										<img src="${pageContext.request.contextPath}/${item.t_picpath.split('&')[0]}" style="width: 223px;">
										<center><h5>${item.t_themename}</h5></center>
										<div class="overlay">
											<a class="preview btn btn-danger" rel="prettyPhoto" target="_blank"
												href="detail.jsp?id=${item.t_id}"><i class="icon-eye-open"></i></a>
										</div>
									</div>
								</li>
							<c:if test="${status.index % 3 == 2 }">
							</ul>
							<ul class="portfolio-items d-f apps">
							</c:if>
								</c:forEach>
							</ul>
						</section>
						<!--/#portfolio-->
					</div>
				</div>
				<div class="col-md-2" style="float: right;">
					<center>
						<h3 style="margin-top: 100px">-- 猜你喜欢 --</h3>
					</center>
					<ul class="portfolio-items d-f apps">
						<li class="portfolio-item">
							<div class="item-inner">
								<img src="../images/portfolio/thumb/5.png" alt="">
								<h5>Lorem ipsum dolor sit amet</h5>
								<div class="overlay">
									<a class="preview btn btn-danger" rel="prettyPhoto"
										href="html/detail.jsp"><i class="icon-eye-open"></i></a>
								</div>
							</div>
						</li>
						<!--/.portfolio-item-->
					</ul>
					<ul class="portfolio-items d-f apps">
						<li class="portfolio-item">
							<div class="item-inner">
								<img src="../images/portfolio/thumb/5.png" alt="">
								<h5>Lorem ipsum dolor sit amet</h5>
								<div class="overlay">
									<a class="preview btn btn-danger" rel="prettyPhoto"
										href="html/detail.jsp"><i class="icon-eye-open"></i></a>
								</div>
							</div>
						</li>
						<!--/.portfolio-item-->
					</ul>
				</div>
			</div>
		</div>

		<%--分页处理 --%>
		<c:if test="${pageCount > 0}">
		<div style="margin-left:35%;margin-top: 50px;">
			<ul class="pagination" style="background: #990033 ;">
				<c:choose>
					<c:when test="${currentPage == 1}">
					<li><a href="../getColBySid.do?pageNo=1">&laquo;</a></li> 
					</c:when>
					<c:otherwise>
					<li><a href="../getColBySid.do?pageNo=${currentPage - 1}">&laquo;</a></li> 
					</c:otherwise>
				</c:choose>
				
				<c:forEach var="i" begin="1" end="${pageCount}">
					<c:choose>
						<c:when test="${currentPage == i}">
							<li class="active"><a href="../getColBySid.do?pageNo=${i}">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="../getColBySid.do?pageNo=${i}">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<c:choose>
					<c:when test="${currentPage == pageCount}">
					<li><a href="../getColBySid.do?pageNo=${currentPage}">&raquo;</a></li> 
					</c:when>
					<c:otherwise>
					<li><a href="../getColBySid.do?pageNo=${currentPage + 1}">&raquo;</a></li> 
					</c:otherwise>
				</c:choose>
				
			</ul>
		</div>
		</c:if>
	</div>
	<%@ include file="common/materialMenu.jsp"%>
	<%-- <%@ include file="common/footer.jsp"%> --%>
</body>
</html>