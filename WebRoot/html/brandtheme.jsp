<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<title>详 细 页 面</title>
  	<%@include file="common/link_js.jsp" %>
  	<script src="http://cdn.bootcss.com/stickyfill/1.1.4/stickyfill.min.js"></script>
  	
</head>
<body data-spy="scroll" data-target="#myScrollspy" data-offset="15">
<%@include file="common/header.jsp"%>
<div class="container" style="margin-top:40px  ;background-color:#2196F3;color:#fff;height:500px;" id="er">
	<div class="row" style="padding: 10px 20px;">
		<h1>${brandtheme.brandinfo.b_company }</h1>
  		<h3>成立时间:${brandtheme.brandinfo.b_registetime }</h3>
 		<p>简介:${brandtheme.brandinfo.b_briefintroduce }</p>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<c:forEach items="${brandtheme.themeList }" var="item" varStatus="status">
				<div class="col-md-4">
					<div class="thumbnail" style="background: #66FFFF;">
						<img src="${pageContext.request.contextPath}/${item.t_picpath.split('&')[0]}" width="60%"  height="50px;"/>
						<div class="caption">
							<h3 style="text-align: center;">
								TOP:${status.index+1 }
								${item.t_themename }
							</h3>
							<p style="text-indent: 2em;">
								${item.t_abstract }
							</p>
							<p style="text-align: center;">
								<a class="btn btn-primary" href="../html/detail.jsp?id=${item.t_id }">抢</a> 
							</p>
						</div>
					</div>
				</div>
		      </c:forEach>
			
			</div>
		</div>
	</div>
</div>
</body>

</html>