<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>测试</title>
	<%@include file="html/common/link_js.jsp" %>
	<style type="text/css" href="css/font-awesome.min.css"></style>
 	<style type="text/css">
 		.msgcard{
 			background-color:#003333;
 			border:1px solid #456;
 			width:400px;
 			height:100px;
 			border-radius:15px;
 			overflow: hidden;
 			margin-left:225px;
 		}
 		.p{
 			font-size: 14px;
 			color: #fff;
 		}
 		i:HOVER {
		cursor: pointer;
}
 	</style>
  </head>
	
<body>
	<%@include file="html/common/header.jsp" %><br/><br/>
	<form action="downloadtheme.do">
		<input   name="id" value="7" />
		<button type="submit">提交</button>
	</form>	
	
	
	
	
	
</body>

</html>