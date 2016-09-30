<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>404 Error</title>
    <style>
        body {
            padding: 0;
            margin: 0;
            background-color: #5d5f78 ;
            font-family: "楷体" "黑体";
            font-size: 1em;
        }
        #img1 {
            width: 35%;
            position: absolute;
            top: 6%;
            left: 10%;
        }
        #img2 {
            width: 36%;
            position: absolute;
            bottom: 0;
            right: 15%;
        }
        div {
            width: auto;
            position: absolute;
            bottom: 10%;
            left: 15%;
        }
        a:link {color: white;}
        a:hover {color: blue;}

    </style>
</head>
<body style="color: wheat">
    <img id="img1" src="<%=request.getContextPath() %>/images/error.png">
    <img id="img2" src="<%=request.getContextPath() %>/images/pangzi.png">
    <div>
        <p style="font-size: 1em">没有找到您想要的网页 可能存在一下原因</p>
        <ul>
            <li>地址存在错误或已过期</li>
            <li>网络连接超时</li>
            <li>服务器发生异常</li>
            <li>你电脑有毛病</li>
        </ul>
        <a href="javascript:history.back(-1)" style="margin-left:25px; font-size: 1em; text-decoration-line: none"> 点击返回上一页 </a>
    </div>
</body>
</html>