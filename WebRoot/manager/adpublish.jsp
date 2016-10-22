<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE >
<html>
  <head>
    <base href="<%=basePath%>">
    <title>信息广告发布平台</title>
    <%@include file="../html/common/link_js.jsp"%>
    <script type="text/javascript" src="ajax/admin/ajaxfileupload.js"></script>
    <script type="text/javascript">
  	function uploadAdPic(){
  		
  		 $.ajaxFileUpload({
			url:path+'uploadadpic.do',  //用于文件上传的服务器端请求地址
			secureuri: false,         //是否需要安全协议，一般设置为false
			fileElementId:['a','b','c'],//文件上传域的ID
			dataType:'json',
			data:{
				'href1' :  $("#href1").val(),
  				'href2' :  $("#href2").val(),
  				'href3' :  $("#href3").val() 
			},			
			success:function(result){
				if (result.status == 0) {
					alert("上传成功");
				}
			}
		}); 
  	}
  		
  </script>
  </head>
  
  <body>
  
    <div class="container-fluid">
    <div class="row">
    	<div class="form-group">
    		<label>File input</label>
    		<input type="file" id="a"><input type="text" id="href1"/>
    		<input type="file" id="b"><input type="text" id="href2"/>
    		<input type="file" id="c"><input type="text" id="href3"/>
    		<p class="help-block">Example block-level help text here.</p>
  		</div>
    </div>
	<button onclick="uploadAdPic();">上传</button>
  </body>
  
  
</html>
