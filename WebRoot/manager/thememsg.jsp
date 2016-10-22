<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主 題 信 息</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/admin/theme_msg.css">
<link rel="stylesheet" type="text/css" href="../css/admin/demo.css">
<link rel="stylesheet" type="text/css"
	href="../css/admin/dropify.min.css">
<script type="text/javascript" src="../ajax/admin/thememsg.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../ajax/admin/dropify.min.js"></script>
<script type="text/javascript" src="../ajax/admin/ajaxfileupload.js"></script>
<script type="text/javascript" src="../js/util.js"></script>

</head>
<body>
	<div class="header">
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-8 column">
					<div style="margin-left: 70%">
						<h3>主题信息</h3>
					</div>
				</div>
				<div class="col-md-4 column">
					<div style="float:right;margin-top: 12px;">
						<button class="btn btn-info" type="button" id="btn_modify"
							style="background-image: url('images/bg_2.png');"
							onclick="modify();">修改</button>
						&nbsp;&nbsp;&nbsp;
						<button class="btn btn-info" type="submit"
							style="background-image: url('images/bg_2.png');" id="btn_save"
							onclick="save();">保存</button>
						&nbsp;&nbsp;
						<form action="../managerLogOut.do" method="post"
							style="float: right;">
							<button class="btn btn-default" type="submit"
								style="background-image: url('images/bg_2.png');">退 出</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<!-- sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss -->
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-2 column"></div>
			<div class="col-md-9  column">
				<form action="../uploadtheme.do" method="post">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td colspan="2"><b>主题名称:</b>&nbsp;<input type="text"
									name="themeName" style="margin-left:5%;width: 300px;"
									value="${theme.t_themename}"></td>
								<td colspan="2"><b>作者:</b>&nbsp;<input type="text"
									name="author" style="margin-left:5%;width: 330px;"
									value="${theme.t_author}"></td>
							</tr>
							<tr>
								<td><b>價格:</b>&nbsp;<input type="text" name="price"
									style="margin-left: 10%;width: 100px;" value="${theme.t_price}"></td>
								<td><b>折扣:</b>&nbsp;<input type="text" name="discount"
									style="margin-left: 13%;width: 100px;"
									value="${theme.t_discount}"></td>
								<td><b>VIP:</b>&nbsp;<input type="text" name="vip"
									style="margin-left: 13%;width: 100px;" value="${theme.t_vip}"></td>
								<td><b>狀態:</b>&nbsp;<input type="text" name="status"
									style="margin-left: 10%;width: 100px;"
									value="${theme.t_status}"></td>
							</tr>
							<tr>
								<td colspan="2"><b>支持品牌:</b>&nbsp;<input type="text"
									name="brand" style="margin-left:5%;width: 300px;"
									value="${theme.b_id}"></td>
								<td colspan="2"><b>支持型號:</b>&nbsp;<input type="text"
									name="firmware" style="margin-left:5%;width: 300px;"
									value="${theme.t_firmware}"></td>
							</tr>
							<tr id="path">
								<td colspan="2"><b>圖片路徑:</b>&nbsp;<input type="text"
									name="picpath" style="margin-left:5%;width: 300px;"
									value="${theme.t_picpath}"></td>
								<td colspan="2"><b>下載路徑:</b>&nbsp;<input type="text"
									name="downpath" style="margin-left:5%;width: 300px;"
									value="${theme.t_downloadpath}"></td>
							</tr>
							<tr>
								<td colspan="4"><b>主題分類:</b>&nbsp;<input type="text"
									name="category" style="margin-left:2.5%;width: 700px;"
									value="${theme.t_category}"></td>
							</tr>
							<tr id="fileUpload">
								<td colspan="4"><b>文件上傳:</b>&nbsp;<input type="text"
									id="uploadpath" name="upload"
									style="margin-left:2.5%;width: 615px;" value="">&nbsp;
									<button id="upload" class="btn-default" type="button"
										onclick="btn_upload(this);">主題上传</button> <input id="hidden"
									type="file" style="display: none;"></td>
							</tr>
							<tr>
								<td colspan="4"><b>詳細介紹:</b>&nbsp;<input type="text"
									name="introduction" style="margin-left:2.5%;width: 700px;"
									value="${theme.t_abstract}">&nbsp;
							</tr>
							<tr id="photo">
								<td><label for="photo1">photo1</label> <input type="file"
									id="photo1" name="photo" class="dropify" data-height="256" /></td>
								<td><label for="photo2">photo2</label> <input type="file"
									id="photo2" name="photo" class="dropify" data-height="256" /></td>
								<td><label for="photo3">photo3</label> <input type="file"
									id="photo3" name="photo" class="dropify" data-height="256" /></td>
								<td><label for="photo4">photo4</label> <input type="file"
									id="photo4" name="photo" class="dropify" data-height="256" /></td>
							</tr>
							<tr style="display: none;">
								<td>
									<input type="submit" id="sub">
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div class="col-md-2 column"></div>
		</div>
	</div>
	<!------------------------------------------ script ----------------------------------------------------->
	<script>
            $(document).ready(function(){
                // Basic
                $('.dropify').dropify();

                // Used events
                var drEvent = $('#input-file-events').dropify();

                drEvent.on('dropify.beforeClear', function(event, element){
                    return confirm("Do you really want to delete \"" + element.file.name + "\" ?");
                });

                drEvent.on('dropify.afterClear', function(event, element){
                    alert('File deleted');
                });

                drEvent.on('dropify.errors', function(event, element){
                    console.log('Has Errors');
                });

                var drDestroy = $('#input-file-to-destroy').dropify();
                drDestroy = drDestroy.data('dropify');
                $('#toggleDropify').on('click', function(e){
                    e.preventDefault();
                    if (drDestroy.isDropified()) {
                        drDestroy.destroy();
                    } else {
                        drDestroy.init();
                    }
                });
            });
        </script>
</body>
</html>