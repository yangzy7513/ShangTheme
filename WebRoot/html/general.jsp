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
<title>站内消息</title>
<%@include file="common/link_js.jsp"%>
<style type="text/css">
	.msg{
		cursor:pointer;
		animation:twinkle 5s infinite;
	}
	@keyframes twinkle
	{
		from {color:#000;}
		to {color:red;}
	}
	@-webkit-keyframes twinkle
	{
		from {color:#000;}
		to {color:red;}
	}
</style>
<script type="text/javascript" src="../ajax/general.js"></script>
</head>
<body>
	<%@ include file="common/header.jsp"%>
	<div style="height:80px;"></div>
	<div id="wrapper" class="wrapper" style="margin-top:20px;">
		<div class="container">
	      <div class="col-sm-10">
		      <div class="span10">
			   <div class="panel panel-primary">
                 <div class="panel-heading">
                   <h3 class="panel-title">收件箱</h3>
                 </div>
                 <div class="panel-body">
                 <c:forEach items="${letter}" var="item" varStatus="status">
                 	<h4>
                 		<!-- 判断是否为新消息 -->
                 		<c:if test="${item.status == 0 }">
                 	    <span class="badge">新</span>
                 	    </c:if> ${item.msgtitle}
                       <a style="display: inline;" data-toggle="collapse" data-parent="#accordion" href="#col${status.index}">
					     <i class="icon-double-angle-right" onclick="changetoread(${item.msg_id});"></i>
				       </a>
				       <a style="float: right; margin-left:10px; "><i class="icon-trash" style="cursor:pointer;"></i></a>
				       <span style="float: right; color: #000;">来自:${item.sendname}&nbsp;&nbsp;${item.totime}</span>
				    </h4>
                    <div id="col${status.index}" class="panel-collapse collapse out">
			           <div class="panel-body">
				        ${item.msgcontent}
			           </div>
		            </div>
		           </c:forEach>
		         </div>
			  </div>
		   </div>
	    </div>
      </div>
	</div>
	<%@ include file="common/materialMenu.jsp"%>
	<%-- <%@ include file="common/footer.jsp"%> --%>
</body>
</html>