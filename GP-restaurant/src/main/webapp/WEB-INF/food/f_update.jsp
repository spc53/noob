<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update food</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/updatefood.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/commom_update.css">
</head>
<body>

	<div class="bg">

		<div class="title">
			<span>餐饮一览</span>
		</div>
		
		<c:if test="${empty requestScope.PAGEMSG}">
			没有任何餐饮信息。
		</c:if>
		<c:if test="${!empty requestScope.PAGEMSG}">
			<div class="foodbody">
				<table class="">
					<tr>
						<th class="one">餐饮编号</th>
						<th class="two">餐饮名</th>
						<th class="three">种类</th>
						<th class="four">主要原料</th>
						<th class="fives">单价</th>
						<th class="six">出售状态</th>
						<th class="seven">操作</th>
					</tr>
					<c:forEach items="${requestScope.PAGEMSG.lists}" var="f">
						<tr>
							<td class="one">${f.foodNumber}</td>
							<td class="two">${f.foodName}</td>
							<td class="three">${f.kindName}</td>
							<td class="four">${f.mainIngreadient}</td>
							<td class="fives">${f.unitPrice}</td>
							<td class="six">
								<c:if test="${f.saleStatus eq 1}">
                                                          未售完
                                </c:if>
                                <c:if test="${f.saleStatus eq 2}">
                                                          已售完
                                </c:if>
							</td>
							<td class="seven">
								<a
								href="${pageContext.request.contextPath}/food/foodinfo?foodNumber=${f.foodNumber}&restaurantNumber=${f.restaurantNumber}">
									<img src="${pageContext.request.contextPath}/images/修改.png" class="ucorn">
								</a>
								<a
								href="${pageContext.request.contextPath}/food/deletefood?foodNumber=${f.foodNumber}&restaurantNumber=${f.restaurantNumber}">
									<img src="${pageContext.request.contextPath}/images/delete2.png" class="ucorn">
								</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>

		<div class="page">
				<span>第${requestScope.PAGEMSG.currPage }/${requestScope.PAGEMSG.totalPage}页</span> 
				<span>总记录数：${requestScope.PAGEMSG.totalCount }每页显示:${requestScope.PAGEMSG.pageSize}</span> 
				<span> <c:if test="${requestScope.PAGEMSG.currPage != 1}">
							<a href="${pageContext.request.contextPath }/food/showfood?currentPage=1">[首页]</a>
							<a href="${pageContext.request.contextPath }/food/showfood?currentPage=${requestScope.PAGEMSG.currPage-1}">[上一页]</a>
						</c:if> 
						<c:if test="${requestScope.PAGEMSG.currPage != requestScope.PAGEMSG.totalPage}">
							<a href="${pageContext.request.contextPath }/food/showfood?currentPage=${requestScope.PAGEMSG.currPage+1}">[下一页]</a>
							<a href="${pageContext.request.contextPath }/food/showfood?currentPage=${requestScope.PAGEMSG.totalPage}">[尾页]</a>
						</c:if>
				</span>
		</div>

	</div>

</body>
</html>