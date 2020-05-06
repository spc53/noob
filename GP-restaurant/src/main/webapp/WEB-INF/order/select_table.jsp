<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/selecttable.css">
</head>
<body>
	<div id="" class="stbg">
		<div class="sttitle">
        	<span class="title">餐桌选择</span>
        	<div class="return">
        		<a href="${pageContext.request.contextPath }/order/o_cart">
        			<img src="${pageContext.request.contextPath}/images/delete.png" class="returncron">
        		</a>
        	</div>
        </div>
		<div class="stsearch">
			<form action="${pageContext.request.contextPath }/table/selectTable" method="post">
				<div class="stsearchinp">
					<input type="text" name="occupySeatNum" placeholder="请输入人数" value="${OSEATNUM}" class="selectinp"/>
				</div>
				<div class="stsearchbtn">
					<input type="submit" value="查询" class="selectbtn"/>
				</div>
			</form>
		</div>
		<c:if test="${empty requestScope.TABLELIST}">
			没有任何餐桌信息。
		</c:if>
		<c:if test="${!empty requestScope.TABLELIST}">
			<div class="stbody">
				<table class="">
					<tr>
						<th class="one">餐桌号</th>
						<th class="two">座位数</th>
						<th class="three">空座位数</th>
						<th class="four">状态</th>
						<th class="fives">操作</th>
					</tr>
					<c:forEach items="${requestScope.TABLELIST}" var="t">
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
								<a href="${pageContext.request.contextPath }/table/updateStatus?restaurantNumber=${t.restaurantNumber}&tableNumber=${t.tableNumber}&peopleNum=${OSEATNUM}">
									<img src="${pageContext.request.contextPath}/images/提交.png" class="selectcron">
								</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>
	</div>
</body>
</html>