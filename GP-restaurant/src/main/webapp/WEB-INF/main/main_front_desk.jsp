<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Front Desk main</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/maintop.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/popup.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/frontpop.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.0.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/main/main_top.jsp" %>
    
    <nav class="">
    <div class="blobs">
        <div class="blob blob1"><span>+</span></div>
        <div class="blob blob2"><img src="${pageContext.request.contextPath}/images/food.png" class="mcorn">
            <ul class="mul">       
                <li class="mli"><a href="${pageContext.request.contextPath}/food/showfoodFororder" target="myframe">餐饮一览</a></li>
                <li class="mli"><a href="${pageContext.request.contextPath}/food/f_create" target="myframe">创建餐饮</a></li>
                <li class="mli"><a href="${pageContext.request.contextPath}/food/showfood" target="myframe">修改/删除餐饮</a></li>
            </ul>
        </div>
        <div class="blob blob3"><img src="${pageContext.request.contextPath}/images/order.png" class="mcorn">
            <ul class="mul">
                <li class="mli"><a href="${pageContext.request.contextPath}/order/showOrder" target="myframe">查看/修改/删除订单</a></li>
            </ul>
        </div>
        <div class="blob blob4"><img src="${pageContext.request.contextPath}/images/table.png" class="mcorn">
            <ul class="mul">
                <li class="mli"><a href="${pageContext.request.contextPath}/table/t_create" target="myframe">添加餐桌号</a></li>
                <li class="mli"><a href="${pageContext.request.contextPath}/table/showTable" target="myframe">修改/删除餐桌号</a></li>
                <li class="mli"><a href="${pageContext.request.contextPath}/table/showTableForStatus" target="myframe">查看餐桌号状态</a></li>
            </ul>
        </div>
        <div class="blob blob5"><img src="${pageContext.request.contextPath}/images/total.png" class="mcorn">
            <ul class="mul">
                <li class="mli"><a href="#" target="myframe">月收入</a></li>
            </ul>
        </div>
    </div>
    </nav>
    <article class="article1">
        <iframe name="myframe"
					src="${pageContext.request.contextPath}/user/emptymain" class="iframe1"></iframe>
    </article>
    <article class="articleorder">
        <iframe name="myframe2"
					src="${pageContext.request.contextPath}/order/o_cart" class="iframe2"></iframe>
    </article>
    
    <%@ include file="/WEB-INF/main/main_bottom.jsp" %>
	
	<div id="popLayer"></div>
	<%@ include file="/WEB-INF/popup/userpopup.jsp" %>
	<%@ include file="/WEB-INF/popup/pw.jsp" %>
	
	<script src="${pageContext.request.contextPath}/js/frontpop.js" charset="utf-8"></script>
</body>
</html>