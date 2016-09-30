<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>忘记密码</title>
    <link rel="stylesheet" type="text/css" href="../css/reSet.css">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <script src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/util.js"></script>
    <script type="text/javascript" src="../js/jquery.cookie.js"></script>
    <script src="../ajax/reSet.js"></script>
</head>
<body>
    <div class="header">
        <img src="../images/logo_3.png" style="width: 200px;float: left;margin-top: 1.5rem;margin-left:10rem;cursor: pointer;" onclick="window.location.href='../index.jsp' ">
        <div class="register">
        <span>还没有账户？</span><a href="register.html" style="font-size: 20px"><b>注册</b></a><span>一个吧！</span>
        </div>
    </div>
    <div class="control-group main">
        <div >
            <div class="target" id="t0"><span>验证手机信息</span></div>
            <div class="target" id="t1"><span>密码重置</span></div>
            <div class="target" id="t2"><span>修改完成</span></div>
        </div>
        <div  id="part_1">
            <form class="form-horizontal">
                <!--手机号-->
                <label class="control-label" for="phoneNum">手机号：</label>
                <input class="controls" type="text" id="phoneNum" name="phoneNum" maxlength="11"><br><br><br>
                <!--验证码-->
                <label class="control-label" for="verification">验证码：</label>
                <input class="controls" type="text" id="verification" name="phoneNum">&nbsp;&nbsp;
                <input type="button" class="btn btn-info" id="btn" value="点击获取验证码" onclick="beforeGetCode();">
                <input type="hidden" id="checkphone" onclick="getCode();"/> 
                <br><br><br><hr>
            </form>
        </div>
        <div id="part_2">
            <form class="form-horizontal">
                <!--密码-->
                <label class="control-label" for="pWords">新密码：</label>
                <input class="controls" type="password" id="pWords" name="pWords"><br><br><br>
                <!--再次输入-->
                <label class="control-label" for="again_pWords">再次输入：</label>
                <input class="controls" type="password" id="again_pWords" name="again_pWords">&nbsp;&nbsp;
                <br><br><br><hr>
            </form>
        </div>
        <div id="part_3">
            <img id="success" class="yeah" src="../img/yeah.png">
            <div class="success"><b id="resok"></b></div>
        </div>
        <input id="next" type="button" value="下一步" class="btn btn-primary btn_next btn-block " onclick="nextStep()"/>
    </div>
</body>
</html>