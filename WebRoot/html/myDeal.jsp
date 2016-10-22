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
<title>我 的 订 单</title>
<%@include file="common/link_js.jsp"%>
<style type="text/css">
tr>td>a{
	color: #666;
	cursor: pointer;
}
</style>
</head>

<body>
	<%@ include file="common/header.jsp"%>
	<c:choose>
		<c:when test="${order.size() != 0}">
		<div id="wrapper" class="wrapper" style="width: 800px;margin: 150px auto;">
		<div style="border-top: #999 double;border-bottom: #999 double;">
			<input type="checkbox" id="seceltAll" style="margin: 5px 8px" onclick="selectAll(this);">
			<label for="seceltAll" style="margin: 5px 0px">全选	</label>
		</div>
		<table class="table table-hover" style="border-bottom: #999 solid;">
			<thead>
				<tr style="text-align: left;">
					<th></th>
					<th>主题名称</th>
					<th>作者</th>
					<th>品牌</th>
					<th>主题类型</th>
					<th>适配机型</th>
					<th>价格</th>
					<th>操作</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${order}" var="item">
				<tr >
					<td><input type="checkbox" name="checkbox" onclick="check_selectAll();"></td>
					<td><a href="detail.jsp?id=${item.t_id}" target="_blank">${item.t_themename}</a></td>
					<td><a }>${item.t_author}</a></td>
					<td><a href="../brand/${item.b_enname}">${item.b_brandname}</a></td>
					<td><span>炫酷</span></td>
					<td><span>${item.t_firmware}</span></td>
					<td>￥${item.t_price}元</td>
					<td><i class="icon-trash" style="cursor: pointer;" onclick="o_del(${item.t_id});"></i></td>
				</tr>
				</c:forEach>
			</tbody>
			
		</table>
		<button class="btn btn-primary" style="float: right;" id="suborder" disabled="disabled">提交订单</button>
		</div>
		</c:when>
		<%--返回无数据情况 --%>
		<c:otherwise>
		<div id="wrapper" class="wrapper" style="margin-top:20px;">
			<img src="../images/order.gif" width="400px" style="float: right;margin-right: 100px;margin-top: 190px;">
			<img src="../images/order.png" width="300px" style="float: right;margin-right: 20px;margin-top: 140px;">
		</div>
		</c:otherwise>
	</c:choose>
	
	<script type="text/javascript" src="../ajax/myDeal.js"></script>
	<%@ include file="common/materialMenu.jsp"%>
	<%-- <%@ include file="common/footer.jsp"%> --%>
</body>
</html>