<%@page import="org.springframework.util.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 	
<title>administrator</title>
<link rel="stylesheet" type="text/css" href="css/admin/login&register.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript" src="ajax/admin/login&register.js"></script>
<script type="text/javascript" src="js/util.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
    <div class="header" >
        <a href="WEB-INF/admin_html/themelist.jsp"><img class="center-block" src="images/logo.png" width="400"></a>
    </div>
    <div class="main">
        <div class="button">
            <button id="btn_logIn" class=" btn-lg btn-link active" onclick="doClick(this)">登 录</button>
            <button id="btn_reg" class=" btn-lg btn-link " onclick="doClick(this)" >注 册</button>
        </div>
        <!--登 录-->
        <div class="part" id="part_1">
            <form class="form-horizontal" action="dologin.do" method="post">
                <div class="form-group">
                    <!--账 号-->
                    <div>
                    <label class="form-label" for="userName">账 号：</label>
                    <input type="text" class="form-control " id="userName" name="userName" placeholder="用户名"
                           style="width: 300px">
                    </div><br><br><br>
                    <!--密 码-->
                    <div>
                    <label class="form-label" for="pWords">密 码：</label>
                    <input type="password" class="form-control " id="pWords" name="pWords" placeholder="请输入密码"
                           style="width: 300px">
                    </div>
                    <!--记住密码-->
                    <div class="remember">
                    <label class="checkbox-label">
                        <input id="remember" class="checkbox-inline" type="checkbox" >记住密码</label>
                    </div>
                    <!--忘记密码？-->
                    <div class="forgot">
                        <label><a href="reSet.html">忘记密码？</a></label>
                    </div>
                    <div>
                    <input class=" btn btn-primary btn-lg btn_logIn" id="logIn" type="submit" value="登 录" onclick="ligin();">
                    </div>
                </div>
            </form>
        </div>
        <div class="part">
            <form class="form-horizontal" style="margin-left: -10px;">
                 <!--账 号-->
                    <div>
                    <label class="form-label" for="r_userName">账 号：</label>
                    <input type="text" class="form-control " id="r_userName" placeholder="用户名"
                           style="width: 300px">
                    </div><br><br><br>
                    <!--密 码-->
                    <div>
                    <label class="form-label" for="r_pWords">密 码：</label>
                    <input type="password" class="form-control " id="r_pWords" placeholder="请输入密码"
                           style="width: 300px">
                    </div>
				<input class=" btn btn-primary btn-part2 btn-lg" id="submit"
					type="button" value="提交" onclick="checkRegForm();" style="margin-left:-40px;"> 
					<input class=" btn btn-default btn-part2 btn-lg" id="reset" type="reset"
					value="重置">
			</form>
        </div>
    </div>
    <div class="footer">

    </div>
</body>
</html>