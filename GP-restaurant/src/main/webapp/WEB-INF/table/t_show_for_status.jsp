<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/tablestatus.css">
</head>
<body>
	<c:if test="${empty requestScope.TABLEPAGEMSG}">
        没有任何餐饮信息。
    </c:if>
    <c:if test="${!empty requestScope.TABLEPAGEMSG}">
        <div class="grid">
            <c:forEach items="${requestScope.TABLEPAGEMSG.lists}" var="t">
                <div class="column"  
                title="总座位数：${t.seatNum}
				空余座位数：${t.emptySeatNum}">
					<div class="tableup">
						<span>${t.tableNumber}</span>
					</div>
                    <div class="tablebot">
						<img src="${pageContext.request.contextPath}/images/餐桌.png" class="tcorn">
					</div>
                </div>
            </c:forEach>
        </div> 
        <div class="page">
		<span>第${requestScope.TABLEPAGEMSG.currPage }/${requestScope.TABLEPAGEMSG.totalPage}页</span> 
		<span>总记录数：${requestScope.TABLEPAGEMSG.totalCount }每页显示:${requestScope.TABLEPAGEMSG.pageSize}</span> 
		<span> <c:if test="${requestScope.TABLEPAGEMSG.currPage != 1}">
				<a href="${pageContext.request.contextPath }/table/showTableForStatus?currentPage=1">[首页]</a>
				<a href="${pageContext.request.contextPath }/table/showTableForStatus?currentPage=${requestScope.TABLEPAGEMSG.currPage-1}">[上一页]</a>
				</c:if> 
				<c:if test="${requestScope.TABLEPAGEMSG.currPage != requestScope.TABLEPAGEMSG.totalPage}">
				<a href="${pageContext.request.contextPath }/table/showTableForStatus?currentPage=${requestScope.TABLEPAGEMSG.currPage+1}">[下一页]</a>
				<a href="${pageContext.request.contextPath }/table/showTableForStatus?currentPage=${requestScope.TABLEPAGEMSG.totalPage}">[尾页]</a>
			</c:if>
		</span>
	</div>
    </c:if>

</body>
</html>