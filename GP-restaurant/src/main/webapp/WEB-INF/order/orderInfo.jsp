<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/orderInfo.css">
</head>
<body>
	<div class="bg">

		<div class="resname font2">${RESINFO.restaurantName}</div>
		
		<div class="rows">
		<c:forEach items="${ORDERDETAILCART}" var="o">
		<div class="row">
			<div class="img">
				<img src="${pageContext.request.contextPath}/uploadFile/img/${o.value.pictureName}" class="img">
			</div>
			<div class="res">
				<div class="name font2">${o.value.foodName}</div>
			</div>
			<div class="quantity font1">x ${o.value.quantity}</div>
			<div class="amount font1">${o.value.amount}</div>
		</div>
		</c:forEach>
		</div>

		<div class="totalamount">
			<div class="ta font1">
				<span class="font2">小计:</span>￥${ORDERCART.totalAmount}
			</div>
		</div>

		<div class="btn font2">
			<a href="" class="">打印</a> <a href="" class="">稍后支付</a> <a href=""
				class="">去支付</a>
		</div>

	</div>
</body>
</html>