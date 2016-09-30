<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>尚 主 题 | 首 页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<%-- 样式表  --%>
 <%@include file="common/link_js.jsp" %>
<body>
   	<%-------------------------------- header start -------------------------------%>
	<%@ include file="common/header.jsp" %>
	<%-------------------------------- header end ---------------------------------%>
	<%-------------------------------- main end ---------------------------------%>
    <div class="container-fluid section-fluid top top80" style="margin-top: 10px;margin-left: 50px">
        <p>您搜索的是
        	<span>
        	<ul>
        	<c:choose>
        		<c:when test="${search.size()>0}">
        			<c:forEach items="${search}" var="item">
        				<li><a href="detail.jsp?id=${item.tid}">${item.title}
        				</a></li>
        			</c:forEach>
        	</ul>
        		</c:when>
        		<c:otherwise>
        			<p>很抱歉，未能找到相关信息$_$</p>
        		</c:otherwise>
        	</c:choose>
        	</span>
        </p>
        <br/>
        <br/>
        <p>您可能想要的是<span>**</span></p>
        <section id="portfolio" class="container" style="padding-top: 10px;">
            <ul class="portfolio-items d-f apps">
                <li class="portfolio-item">
                    <div class="item-inner">
                        <img src="../images/portfolio/thumb/item1.jpg" alt="">
                        <h5 id="headname">Lorem ipsum dolor sit amet</h5>
                        <div class="overlay">
                            <a class="preview btn btn-danger"  rel="prettyPhoto"><i class="icon-eye-open"></i></a>
                        </div>
                    </div>
                </li><!--/.portfolio-item-->
                <li class="portfolio-item joomla bootstrap">
                    <div class="item-inner">
                        <img src="../images/portfolio/thumb/item2.jpg" alt="">
                        <h5>Lorem ipsum dolor sit amet</h5>
                        <div class="overlay">
                            <a class="preview btn btn-danger"  rel="prettyPhoto"><i class="icon-eye-open"></i></a>
                        </div>
                    </div>
                </li><!--/.portfolio-item-->
                <li class="portfolio-item bootstrap wordpress">
                    <div class="item-inner">
                        <img src="../images/portfolio/thumb/item3.jpg" alt="">
                        <h5>Lorem ipsum dolor sit amet</h5>
                        <div class="overlay">
                            <a class="preview btn btn-danger"  rel="prettyPhoto"><i class="icon-eye-open"></i></a>
                        </div>
                    </div>
                </li><!--/.portfolio-item-->
            </ul>
            <ul class="portfolio-items d-f apps">
                <li class="portfolio-item joomla wordpress">
                    <div class="item-inner">
                        <img src="../images/portfolio/thumb/item4.jpg" alt="">
                        <h5>Lorem ipsum dolor sit amet</h5>
                        <div class="overlay">
                            <a class="preview btn btn-danger"  rel="prettyPhoto"><i class="icon-eye-open"></i></a>
                        </div>
                    </div>
                </li><!--/.portfolio-item-->
                <li class="portfolio-item joomla html">
                    <div class="item-inner">
                        <img src="../images/portfolio/thumb/item5.jpg" alt="">
                        <h5>Lorem ipsum dolor sit amet</h5>
                        <div class="overlay">
                            <a class="preview btn btn-danger"  rel="prettyPhoto"><i class="icon-eye-open"></i></a>
                        </div>
                    </div>
                </li><!--/.portfolio-item-->
                <li class="portfolio-item wordpress html">
                    <div class="item-inner">
                        <img src="../images/portfolio/thumb/item6.jpg" alt="">
                        <h5>Lorem ipsum dolor sit amet</h5>
                        <div class="overlay">
                            <a class="preview btn btn-danger"  rel="prettyPhoto"><i class="icon-eye-open"></i></a>
                        </div>
                    </div>
                </li><!--/.portfolio-item-->
            </ul>
        </section><!--/#portfolio-->
    </div><br><br><br>
<!--******************************************************************************************-->
    <%@ include file="common/footer.jsp" %>
</body>
</html>