<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/updatetable.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/commom_update.css">
</head>
<body>
	
	<div class="bg">
		<div class="title">
			<span>餐桌信息一览</span>
		</div>
		<c:if test="${empty requestScope.TABLEPAGEMSG}">
			没有任何餐桌信息。
		</c:if>
		<c:if test="${!empty requestScope.TABLEPAGEMSG}">
			<div class="tablebody">
				<table class="">
					<tr>
						<th class="one">餐桌号</th>
						<th class="two">座位数</th>
						<th class="three">空座位数</th>
						<th class="four">状态</th>
						<th class="fives">操作</th>
					</tr>
					<c:forEach items="${requestScope.TABLEPAGEMSG.lists}" var="t">
						<tr>
							<td class="one">${t.tableNumber}</td>
							<td class="two">${t.seatNum}</td>
							<td class="three">${t.emptySeatNum}</td>
							<td class="four">
								<c:if test="${t.status eq 1}">
                                                          未坐满
                                </c:if>
                                <c:if test="${t.status eq 2}">
                                                          已满
                                </c:if>
							</td>
							<td class="fives">
								<a href="${pageContext.request.contextPath}/table/tableinfo?tableNumber=${t.tableNumber}&restaurantNumber=${t.restaurantNumber}">
									<img src="${pageContext.request.contextPath}/images/修改.png" class="ucorn">
								</a>
								<a href="${pageContext.request.contextPath}/table/deletetable?tableNumber=${t.tableNumber}&restaurantNumber=${t.restaurantNumber}">
									<img src="${pageContext.request.contextPath}/images/delete2.png" class="ucorn">
								</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>
		
		<div class="page">
				<span>第${requestScope.TABLEPAGEMSG.currPage }/${requestScope.TABLEPAGEMSG.totalPage}页</span> 
				<span>总记录数：${requestScope.TABLEPAGEMSG.totalCount }每页显示:${requestScope.TABLEPAGEMSG.pageSize}</span> 
				<span> <c:if test="${requestScope.TABLEPAGEMSG.currPage != 1}">
							<a href="${pageContext.request.contextPath }/table/showTable?currentPage=1">[首页]</a>
							<a href="${pageContext.request.contextPath }/table/showTable?currentPage=${requestScope.TABLEPAGEMSG.currPage-1}">[上一页]</a>
						</c:if> 
						<c:if test="${requestScope.TABLEPAGEMSG.currPage != requestScope.TABLEPAGEMSG.totalPage}">
							<a href="${pageContext.request.contextPath }/table/showTable?currentPage=${requestScope.TABLEPAGEMSG.currPage+1}">[下一页]</a>
							<a href="${pageContext.request.contextPath }/table/showTable?currentPage=${requestScope.TABLEPAGEMSG.totalPage}">[尾页]</a>
						</c:if>
				</span>
		</div>

	</div>
	
</body>
</html>