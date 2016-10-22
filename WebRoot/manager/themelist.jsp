<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Theme List</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/admin/themelist.css">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/util.js"></script>
<script type="text/javascript" src="../ajax/admin/themelist.js"></script>
</head>
<body>
	<div class="header">
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-10 column">
					<div class="navigation"
						style="float: left;display: block;margin-top: 5px;margin-left: 32%">
						<ul class="nav nav-pills">
							<li><a href="thememsg.jsp?sts=3"><b>新增主题</b></a></li>
							<li><a id="delete" onclick="dealTheme(this);"><b>删除主题</b></a></li>
							<li><a id="upStore" onclick="dealTheme(this);"><b>上架主题</b></a></li>
							<li><a id="downStore" onclick="dealTheme(this);"><b>下架主题</b></a></li>
							
						</ul>
					</div>
				</div>
				<div class="col-md-2 column">
					<div style="float:right;margin-top: 22px;">
						<form action="../managerLogOut.do" method="post">
							<input class="btn btn-info" type="submit" value="退 出">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%-- .................................................................. --%>
	<div>
		<div style="margin-top: 20px;">
				<div style="display: block;">
					<input type="button" class="btn btn-info" style="float: right;display: inline-block;margin-top: -2px;margin-right: 200px;" value="Search">
					<input class="form-control" type="text" style="margin-bottom: 20px;float: right;width: 300px;margin-right: 5px;">
				</div>
		</div>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 ">
					<table class="table table-hover">
						<thead>
							<tr>
								<th><input type="checkbox" id="selectAll" onclick="selectAll(this);"></th>
								<th>主题名称</th>
								<th>主题状态</th>
								<th>单价</th>
								<th>作者</th>
								<th>作者分成</th>
								<th>销量</th>
								<th>纯利润</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${themeList}" var="item">
							<tr class="info">
								<td><input type="checkbox" name="theme" onclick="selected();" id="${item.t_id}"></td>
								<td><a onclick="showDetail(${item.t_id})">${item.t_themename}</a></td>
								<td>${item.t_status == 0 ? '正常':'下架'  }</td>
								<td>${item.t_price}</td>
								<td>${item.t_author}</td>
								<td>${item.proportion}</td>
								<td>${item.t_downloadnum}</td>
								<td>${item.profit}</td>
								<td><input type="button" value="更新" onclick="showDetail(${item.t_id});"></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div><br><br><br><br>
	<%-- --------------------------- 分页 ----------------------------------- --%>
	<div>
		<nav class="navbar navbar-default navbar-fixed-bottom" style="background-color: #fff;height: 60px;">
			<center><ul class="pagination pagination-lg" style="position: relative;bottom: 20px;">
				<c:choose>
					<c:when test="${pageNum == 1}">
					<li class="disabled"><a href="../showtheme.do?pageNum=1">&laquo;</a></li> 
					</c:when>
					<c:otherwise>
					<li><a href="../showtheme.do?pageNum=${pageNum - 1}">&laquo;</a></li> 
					</c:otherwise>
				</c:choose>
				<c:forEach var="i" begin="1" end="${pageCount}">
					<c:choose>
						<c:when test="${pageNum == i}">
							<li class="active"><a  href="../showtheme.do?pageNum=${i}">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="../showtheme.do?pageNum=${i}">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${pageNum == pageCount}">
					<li class="disabled"><a>&raquo;</a></li> 
					</c:when>
					<c:otherwise>
					<li><a href="../showtheme.do?pageNum=${pageNum + 1}">&raquo;</a></li> 
					</c:otherwise>
				</c:choose>
			</ul></center>
		</nav>
	</div>
</body>
</html>