<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	SuserEntity localuser = (SuserEntity)session.getAttribute("suser");
	if(localuser == null){
		response.sendRedirect("../index.jsp");
	}
%>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>我 的 资 料</title>
<%@include file="common/link_js.jsp"%>
<link rel="stylesheet" href="../css/myMessage.css">
<%-- JavaScript  --%>
<script type="text/javascript" src="../js/ajaxfileupload.js"></script>
<script type="text/javascript" src="../ajax/myMessage.js"></script>
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<body>
	<%@ include file="common/header.jsp"%>
	<div id="wrapper" class="wrapper" style="margin-top:20px;">
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column right">
					<div id="page-myMessage">
							<div class="form-group">
								<div style="margin-left: 45%">
									<img class="img-circle" src="../${suser.s_headphoto}"
										id="headPhoto1" style="width: 80px" />
									<button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#modifyhead" 
										onclick="return false;">修改头像</button>
								</div>
							</div>
						<form class="form-horizontal form" role="form" action="../updatesuserinfo.do" method="post">
							<div class="form-group">
								<label for="userName" class="col-sm-3 control-label">用户名：</label>
								<div class="col-sm-6">
									<input type="hidden" name="id" value="${suser.s_id}">
									<input type="text" class="form-control input"
										readonly="readonly" name="username"
										style="background-color: #fff;color: #151515;" id="userName"
										value="${suser.s_username }" />
								</div>
							</div>
							<div class="form-group">
								<label for="phoneNum" class="col-sm-3 control-label">手机号：</label>
								<div class="col-sm-6">
									<input type="text" class="form-control input"
										readonly="readonly" name="phonenum"
										style="background-color: #fff;color: #151515;" id="phoneNum"
										value="${suser.s_phonenum.replaceAll('(\\d{3})\\d{4}(\\d{4})','$1****$2') }"  />
								</div>
							</div>
							<div class="form-group">
								<label for="name" class="col-sm-3 control-label">性 别：</label>
								<div class="col-sm-6">
									<select data-toggle="select" id="sex" style="height: 40px;color: #151515;"
										class="form-control select" onchange="setValue();">
										<option value="0">&nbsp;&nbsp;&nbsp;&nbsp;男</option>
										<option value="1">&nbsp;&nbsp;&nbsp;&nbsp;女</option>
									</select>
									<input type="hidden" name="sex" value="${suser.s_sex}"> 
								</div>
							</div>
							<div class="form-group">
								<label for="birthday" class="col-sm-3 control-label">生
									日：</label>
								<div class="col-sm-6">
									<input type="text" class="form-control input" name="birthday"
										style="background-color: #fff;color: #151515;" id="birthday"
										readonly="readonly" value="${suser.s_birthday}"  />
								</div>
							</div>
							<div class="form-group">
								<label for="place" class="col-sm-3 control-label">籍 贯：</label>
								<div class="col-sm-3">
									<input type="text" class="form-control input"
										style="background-color: #fff;color: #151515;" id="place"
										readonly="readonly" placeholder="省（直辖市）" value=""  />
								</div>
								<div class="col-sm-3">
									<input type="text" class="form-control input"
										style="background-color: #fff;color: #151515;" id="place2"
										readonly="readonly" placeholder="市（区）" value=""  />
								</div>
								
							</div>
							<div class="btn-group">
								<div class="col-sm-12" style="margin-left: 20px;">
									<button type="button" id="change" class="btn btn-info"
										style="display:block;width: 200px;float: left;margin-left:320px" onclick="modify_information()">
										<i class="icon-pencil"></i>&nbsp;&nbsp;修改</button>
									<button type="submit" id="save" class="btn btn-info"
										style="display:block;width: 200px;float: right;">
										<i class="icon-save"></i>&nbsp;&nbsp;保存
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%-- modal --%>
	<div class="modal fade" id="modifyhead" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" style="top:100px;">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content" style="width: 600px;margin-left: -100px">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				<h4 class="modal-title" id="exampleModalLabel">上传头像</h4>
				</div>		
				<div class="modal-body">
				<div>
					<div>
						<label for="recipient-name" class="control-label">账户:</label> <input multiple="multiple"
							id="doc" name="doc" type="file" class="form-control" onchange="showimg(this);">
					</div>
					<div class="form-group">
						<img alt="" src="" id="preview"/>
					</div>	
					<div>
						 <span class="help-block">请您上传方形图片（宽高比 1：1）</span> 
					</div>				
				</div>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-info" id="btn_logIn" onclick="headsubmit();">确认</button>
			</div>
				<img src="" id="preview"/>
			</div>
		</div>
		<span id="showdata" style="display: none;">${msg}</span>
	</div>
	
	<%@ include file="common/materialMenu.jsp"%>
	<%@ include file="common/footer.jsp"%>
</body>
</html>