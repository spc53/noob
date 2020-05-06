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
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cart.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/popup.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.0.js"></script>
</head>
<body>
	<div class="cart">
	    <div class="bg">
        	<span class="title">已选餐饮</span>
            <a href="${pageContext.request.contextPath}/order/clearMap" class="clear">清除</a>
        </div>
        	
		<c:if test="${empty FOODCART}">
			没有添加餐饮信息。
		</c:if>
		<c:if test="${!empty FOODCART}">
			<div class="cartbody">
			<c:forEach items="${FOODCART}" var="f">
            	<div class="row">
                	<div class="name">${f.value.foodName}</div>
                    <div class="amount">${f.value.amount}</div>
                    <div class="quantity">
                    	<a href="${pageContext.request.contextPath }/order/deleteCart?foodNumber=${f.value.foodNumber}&restaurantNumber=${f.value.restaurantNumber}">
                    		<img src="${pageContext.request.contextPath}/images/减少.png" class="corn">
                    	</a>
                        <span>${f.value.quantity}</span>
                        <a href="${pageContext.request.contextPath }/order/putCart?foodNumber=${f.value.foodNumber}&restaurantNumber=${f.value.restaurantNumber}">
                        	<img src="${pageContext.request.contextPath}/images/增加.png" class="corn">
                        </a>
                    </div>
                </div>
			</c:forEach>
			</div>
			
			<div class="cartbtn">
            	<a href="${pageContext.request.contextPath }/table/selectTable" class="">
            		<img src="${pageContext.request.contextPath}/images/餐桌.png" class="tablecron">
            	</a>
            	<div class="tablenum">${TABLENUMBER}</div>
            </div>
			
		    <div class="cartbtn">
            	<a href="${pageContext.request.contextPath}/order/createOrder?tableNumber=${TABLENUMBER}&peopleNum=${POPNUM}" class="abtn">生成订单</a>
            </div>
		</c:if>
	</div>
	
</body>
</html>