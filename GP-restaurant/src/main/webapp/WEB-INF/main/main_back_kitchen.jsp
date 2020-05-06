<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Back Kitchen main</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/maintop.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/popup.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/frontpop.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/back.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.0.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/main/main_top.jsp" %>
    
    <div class="mbtn"><a href="${pageContext.request.contextPath}/order/showBackOrder"><img src="${pageContext.request.contextPath}/images/刷新1.png" class="scorn"></a></div>
    <div class="grid">
        <c:forEach items="${BACKORDER.lists}" var="bo">
        <div class="bg">
            <div class="resname font2">
               	 流水号
            </div>
            <div class="rows">
            	<c:forEach items="${bo.od}" var="d">
            	<div class="row">
                    <div class="res">
                        <div class="name font2">${d.foodName}</div>
                    </div>
                    <div class="quantity font1">x ${d.quantity}</div>
                    <div class="amount font1">${d.amount}</div>
                    <div class="status"><img src="${pageContext.request.contextPath}/images/提交.png" class="ocorn"></div>
                </div>
            	</c:forEach>
            </div>
            <div class="totalamount">
                <div class="ta font1"><span class="font2">小计:</span>￥${bo.totalAmount}</div>
            </div>
        </div>
        </c:forEach>
    </div>
    
   	<%@ include file="/WEB-INF/main/main_bottom.jsp" %>
	
	<div id="popLayer"></div>
	<%@ include file="/WEB-INF/popup/userpopup.jsp" %>
	<%@ include file="/WEB-INF/popup/pw.jsp" %>
	
	<script type="text/javascript" >

	</script>
	
	<script src="${pageContext.request.contextPath}/js/frontpop.js" charset="utf-8"></script>
</body>
</html>