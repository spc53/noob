<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/orderdetailinfo.css">
</head>
<body>
	    <div class="bg">

        <div class="title">
            <div class="font1">${RESINFO.restaurantName}</div>
            <div class="font1">流水号:${NUM}</div>
            <div>
                <table class="font3">
                    <tr>
                        <td>消费人数:</td>
                        <td>${ORDER.peopleNum}</td>
                    </tr>
                    <tr>
                        <td>账单号:</td>
                        <td>${ORDER.orderNumber}</td>
                    </tr>
                    <tr>
                        <td>创建时间:</td>
                        <td>${CTIME}</td>
                    </tr>
                    <tr>
                        <td>创建人:</td>
                        <td>${ORDER.actualName}</td>
                    </tr>
                </table>
            </div>
        </div>

        <div class="body">
            <table class="table font2">
                <tr>
                    <th>餐饮名</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>小计</th>
                </tr>
                <c:forEach items="${ODLIST}" var="od">
                <tr>
                    <td class="td1">${od.foodName}</td>
                    <td class="td2">${od.unitPrice}</td>
                    <td class="td3">${od.quantity}</td>
                    <td class="td4">${od.amount}</td>
                </tr>
                </c:forEach>
            </table>
        </div>

        <div class="total font2">
            	￥${ORDER.totalAmount}
        </div>
        
        <div class="bottom font2">
            <a href="" class="">去支付</a>
            <a href="" class="">稍后支付</a>
            <a href="" class="">打印</a>
        </div>

    </div>
</body>
</html>