<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/updateorder.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/commom_update.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.0.js"></script>
</head>
<body>
	<div class="bg">

		<div class="title">
			<span>订单信息一览</span>
		</div>
		
		<div class="search">
			<div class="searchl">
			<form action="${pageContext.request.contextPath}/order/showOrder" method="post">
				<div class="searchdinp">
					<input type="date" name="startDate" placeholder="请输入开始日期" value="${STARTDATE}" class="searchinp"/>
				</div>
				<div class="searchdinp">
					<input type="date" name="endDate" placeholder="请输入结束日期" value="${ENDDATE}" class="searchinp"/>
				</div>
				<div class="searchdinp">
					<input type="text" name="orderNumber" placeholder="请输入订单流水号" value="${ORDERNUMBER}" class="searchinp"/>
				</div>
					<input type="submit" value="查询" class="searchbtn"/>
			</form>
			</div>
			<div class="searchr">
				<a href="${pageContext.request.contextPath}/order/showOrder?condition=payStatus" class="searcha">未支付</a>
				<a href="${pageContext.request.contextPath}/order/showOrder?condition=finishStatus" class="searcha">未完成</a>
				<a href="${pageContext.request.contextPath}/order/showOrder?condition=queuingStatus" class="searcha">排队中</a>
			</div>
		</div>
		
		<c:if test="${empty requestScope.ORDERPAGEMSG}">
			没有任何订单信息。
		</c:if>
		
		<c:if test="${!empty requestScope.ORDERPAGEMSG}">
			<div class="orderbody">
				<table class="">
					<tr>
						<th class="one">订单编号</th>
						<th class="two">桌号</th>
						<th class="three">人数</th>
						<th class="four">创建人</th>
						<th class="fives">总金额</th>
						<th class="six">支付状态</th>
						<th class="seven">完成状态</th>
						<th class="eight">排队状态</th>
						<th class="nine">操作</th>
					</tr>
					<c:forEach items="${requestScope.ORDERPAGEMSG.lists}" var="order">
						<tr>
							<td class="one">${order.orderNumber}</td>
							<td class="two">${order.tableNumber}</td>
							<td class="three">${order.peopleNum}</td>
							<td class="four">${order.actualName}</td>
							<td class="fives">${order.totalAmount}</td>
							<td class="six">
								<c:if test="${order.payStatus eq 1}">
                                                          未支付
                                </c:if>
                                <c:if test="${order.payStatus eq 2}">
                                                          已支付
                                </c:if>
							</td>
							<td class="seven">
								<c:if test="${order.finishStatus eq 1}">
                                                          未完成
                                </c:if>
                                <c:if test="${order.finishStatus eq 2}">
                                                          已完成
                                </c:if>
							</td>
							<td class="eight">
								<c:if test="${order.queuingStatus eq 1}">
                                                          已经就坐
                                </c:if>
                                <c:if test="${order.queuingStatus eq 2}">
                                                          正在排队                          
                                </c:if>
							</td>
							<td class="nine">
								<a
								href="${pageContext.request.contextPath}/order/orderDinfo?orderNumber=${order.orderNumber}&restaurantNumber=${order.restaurantNumber}">
									<img src="${pageContext.request.contextPath}/images/info.png" class="ucorn">
								</a>
								<a
								href="${pageContext.request.contextPath}/order/orderinfo?orderNumber=${order.orderNumber}&restaurantNumber=${order.restaurantNumber}">
									<img src="${pageContext.request.contextPath}/images/修改.png" class="ucorn">
								</a>
								<a
								href="${pageContext.request.contextPath}/order/deleteOrder?orderNumber=${order.orderNumber}&restaurantNumber=${order.restaurantNumber}" >
									<img src="${pageContext.request.contextPath}/images/delete2.png" class="ucorn">
								</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>

		<div class="page">
				<span>第${requestScope.ORDERPAGEMSG.currPage }/${requestScope.ORDERPAGEMSG.totalPage}页</span> 
				<span>总记录数：${requestScope.ORDERPAGEMSG.totalCount }每页显示:${requestScope.ORDERPAGEMSG.pageSize}</span> 
				<span> <c:if test="${requestScope.ORDERPAGEMSG.currPage != 1}">
							<a href="${pageContext.request.contextPath }/order/showOrder?currentPage=1&condition=${CONDITION}&startDate=${STARTDATE}&endDate=${ENDDATE}&orderNumber=${ORDERNUMBER}">[首页]</a>
							<a href="${pageContext.request.contextPath }/order/showOrder?currentPage=${requestScope.ORDERPAGEMSG.currPage-1}&condition=${CONDITION}&startDate=${STARTDATE}&endDate=${ENDDATE}&orderNumber=${ORDERNUMBER}">[上一页]</a>
						</c:if> 
						<c:if test="${requestScope.ORDERPAGEMSG.currPage != requestScope.ORDERPAGEMSG.totalPage}">
							<a href="${pageContext.request.contextPath }/order/showOrder?currentPage=${requestScope.ORDERPAGEMSG.currPage+1}&condition=${CONDITION}&startDate=${STARTDATE}&endDate=${ENDDATE}&orderNumber=${ORDERNUMBER}">[下一页]</a>
							<a href="${pageContext.request.contextPath }/order/showOrder?currentPage=${requestScope.ORDERPAGEMSG.totalPage}&condition=${CONDITION}&startDate=${STARTDATE}&endDate=${ENDDATE}&orderNumber=${ORDERNUMBER}">[尾页]</a>
						</c:if>
				</span>
		</div>

	</div>
</body>
</html>