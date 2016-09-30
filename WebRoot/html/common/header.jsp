<%--共同导航 --%>
<%@page import="com.shangtheme.client.entity.SuserEntity"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div
	style="position: fixed;margin:auto;left:0; right:0; top:0; bottom:0;max-width:400px;z-index:9999;display: none;"
	id="msg">
	<div class="alert alert-warning alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<span id="msgbody"></span>
	</div>
</div>
<input type="button" id="showmsg" style="display: none;"
	onclick="showmsg();">

<header>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<nav class="navbar navbar-fixed-top padding-d-i">
					<!--NAVBAR -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#navbar-collapse-5">
							<span class="sr-only">Toggle navigation</span>
						</button>
						<a class="navbar-brand"
							href="${pageContext.request.contextPath}">SHANG
							THEME</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="navbar-collapse-5">
						<form class="navbar-form navbar-right" role="form">
							<%
                        		SuserEntity user = (SuserEntity)session.getAttribute("suser");
	                        	if(user != null){
                        	%>
							<div class="btn-group">
								<button type="button" class="btn btn-link dropdown-toggle"
									data-toggle="dropdown" style="top:-12px;">
									<%-- <%=username %> --%>
									<img class="img-circle" src="${pageContext.request.contextPath}/${suser.s_headphoto}"
										id="headPhoto1" style="width: 50px;" />
									<span class="caret"></span>
								</button>
								
								<ul class="dropdown-menu dropdown-menu-inverse" role="menu"
									style="min-width:100%;">
									<li class="active"><a
										href="${pageContext.request.contextPath}/${suser.s_id }/user.html"><i
											class="icon-user"></i>&nbsp;&nbsp;个人信息</a></li>
									<li><a href="${pageContext.request.contextPath}/html/dingdan"><i class="icon-star"></i>&nbsp;&nbsp;我的订单</a></li>
									<li><a href="contact-us.jsp"><i class="icon-phone-sign"></i>&nbsp;&nbsp;投诉建议</a></li>
									<li class="divider"></li>
									<li><a href="${pageContext.request.contextPath}/about-us.jsp"><i class="icon-twitter"></i>&nbsp;&nbsp;关于我们</a></li>
									<li><a href="exit"><i class="icon-off"></i>&nbsp;&nbsp;退出</a></li>
								</ul>
															
							</div>

							<%  }else{ 
                            %>
							<button class="btn btn-primary" data-toggle="modal"
								data-target="#login">登 录</button>
							&nbsp;
							<button class="btn btn-primary" data-toggle="modal"
								data-target="#register">注 册</button>
							<%} %>

						</form>
						<form class="navbar-form navbar-right" action="#" role="search">
							<div class="form-group ">
								<div class="input-group">
									<input class="form-control" id="navbarInput-01" type="search"
										placeholder="Search" onclick ="window.location.href='${pageContext.request.contextPath}/html/search.jsp'"> <span class="input-group-btn">
										<button type="submit" class="btn">
											<span class="fui-search"></span>
										</button>
									</span>
								</div>
							</div>
						</form>
					</div>
				</nav>
				<!-- TERMINA NAVBAR -->
			</div>
		</div>
		<!--row -->
	</div>
	<!-- container header-->
</header>
<br />
<!--END HEADER-->

<%--登录dialog --%>
<div class="modal fade" id="login" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" style="top:100px;">
	<div class="modal-dialog modal-sm" role="document">
		<div class="modal-content" style="width: 600px;margin-left: -100px">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel">登&nbsp;录</h4>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group ">
						<label for="recipient-name" class="control-label">账户:</label> <input
							type="text" class="form-control" id="username"
							placeholder="昵称或手机号" onkeydown="this.parentNode.className = 'form-group';"
							onkeypress="EnterEvent(this);"> 
					</div>
					<div class="form-group">
						<label for="message-text" class="control-label">密码:</label> <input
							type="password" class="form-control" id="pWords"
							placeholder="请输入密码" onkeydown="this.parentNode.className = 'form-group';" 
							onkeypress="EnterEvent(this);">
					</div>
					<div class="checkbox" style="float: left;">
						<label>记住密码 <input type="checkbox" style="left:35px;top: 8px;"
							id="rempwd">
						</label>
					</div>
					<div style="float: right;margin-top: 15px;font-size: 14px;margin-right: 10px;">
						<a href="${pageContext.request.contextPath}/html/reset.jsp">忘记密码？</a>
					</div>
					<br>
				</form>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-info" id="btn_logIn">Login</button>
			</div>
		</div>
	</div>
</div>

<%--注册dialog --%>
<div class="modal fade bs-example-modal-sm" id="register" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" style="top:100px;">
	<div class="modal-dialog modal-sm" role="document">
		<div class="modal-content" style="width: 600px;margin-left: -100px">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h6 class="modal-title" id="myModalLabel">注&nbsp;&nbsp;&nbsp;册</h6>
			</div>
			<form class="form-inline" style="margin-left: 20px;margin-top: 20px">
				<div class="form-group ">
					<label class="control-label" for="re_username">昵&nbsp;&nbsp;称:</label>
					<input type="text" class="form-control " id="re_username"
						aria-describedby="inputSuccess4Status" placeholder="字母与数字组合"
						style="width: 450px;margin-left: 30px" onblur="checkname();">
					<span class="glyphicon glyphicon-ok form-control-feedback"
						id="re_span1" aria-hidden="true" style="display: none;"></span> <span
						id="re_check1" class="sr-only">(success)</span>
				</div>
			</form>
			<form class="form-inline" style="margin-top:10px;margin-left: 20px">
				<div class="form-group ">
					<label class="control-label" for="inputSuccess4">密&nbsp;&nbsp;码:</label>
					<input type="password" class="form-control" id="re_password"
						style="width: 450px;margin-left: 30px"
						aria-describedby="inputSuccess4Status" placeholder="请输入密码">
					<span class="glyphicon glyphicon-ok form-control-feedback"
						aria-hidden="true" style="display: none;"></span> <span
						id="inputSuccess4Status" class="sr-only">(success)</span>
				</div>
			</form>
			<form class="form-inline" style="margin-top:10px;margin-left: 20px">
				<div class="form-group ">
					<label class="control-label" for="inputSuccess4">确&nbsp;&nbsp;认:</label>
					<input type="password" class="form-control" id="re_checkpwd"
						style="width: 450px;margin-left: 30px"
						aria-describedby="inputSuccess4Status" placeholder="请再次输入密码"
						onblur="checkpwd();"> <span
						class="glyphicon glyphicon-ok form-control-feedback" id="re_span2"
						aria-hidden="true" style="display: none;"></span> <span
						id="re_check2" class="sr-only">(success)</span>
				</div>
			</form>
			<form class="form-inline" style="margin:10px 0 20px 20px;">
				<div class="form-group ">
					<label class="control-label" for="inputSuccess4">手&nbsp;&nbsp;机:</label>
					<input type="text" class="form-control" id="re_phonenum"
						style="width: 450px;margin-left: 30px"
						aria-describedby="inputSuccess4Status" style="min-width:15px;"
						placeholder="用于找回密码" onblur="checktel();"> <span
						class="glyphicon glyphicon-ok form-control-feedback"
						aria-hidden="true" id="re_span3" style="display: none;"></span> <span
						id="re_check3" class="sr-only">(success)</span>
				</div>
			</form>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-info" id="sub_btn">Register</button>
			</div>
		</div>
	</div>
</div>


