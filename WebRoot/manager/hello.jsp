<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String localuser = (String)session.getAttribute("user");
	if(localuser == null){
		response.sendRedirect("papapa.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>hello world</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/util.js"></script>
<!-- Highcharts -->
<script src="http://cdn.hcharts.cn/highstock/highstock.js"></script>
<script src="../ajax/admin/indexdata.js"></script>
<style>
body {
	color: #888;
}

a {
	color: #888;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12">
				<div class="row clearfix">
					<div class="col-md-12 column">
						<div class="header">
							<div class="container">
								<div class="row clearfix">
									<div class="col-md-8 column">
										<h1>SHANG THEME</h1>
									</div>
									<div class="col-md-4 column">
										<form action="../managerLogOut.do" method="post">
											<input class="btn btn-default" type="submit" value="退 出"
												style="margin-top: 20px;float: right;height: 40px;width: 80px;background-color: #ddd;margin-right: 20px;">
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<hr>
				<div class="jumbotron">
					<%
						String user = (String) session.getAttribute("user");
					%>
					<h1>
						Hello &nbsp;<%=user%></h1>
					<br>
					<ol style="font-size: 18px;">
						<li><a id="themeManager" href="themelist.jsp" onclick="hh();">管理主题</a></li>
						<li><a href="adpublish.jsp">广告发布</a></li>
						<li><a>账单信息</a></li>
					</ol>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div id="datauser" style="min-width:400px;height:400px"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%--================================================================================================= --%>
	<script type="text/javascript">
		function hh() {
			$.post(path + "showtheme.do?pageNum=1");
		}
	</script>
	
</body>
</html>