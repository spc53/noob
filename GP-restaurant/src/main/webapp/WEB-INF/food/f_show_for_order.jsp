<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/orderforfood.css">
</head>
<body>
	<c:if test="${empty requestScope.PAGEMSG}">
        没有任何餐饮信息。
    </c:if>
    <c:if test="${!empty requestScope.PAGEMSG}">
        <div class="grid">
            <c:forEach items="${requestScope.PAGEMSG.lists}" var="f">
				    <div class="column">
                        <div class="img"><img src="${pageContext.request.contextPath}/uploadFile/img/${f.pictureName}" class="image"></div>
                        <div class="info">
                            <div class="name">${f.foodName}</div>
                            <div class="org">主要原料:${f.mainIngreadient}</div>
                            <div class="price">单价:${f.unitPrice}</div>
                            <div class="sale">
                                <c:if test="${f.saleStatus eq 1}">
                                                           未售完
                                </c:if>
                                <c:if test="${f.saleStatus eq 2}">
                                                           已售完
                                </c:if>
                            </div>
                            <div class="insert">
                            	<a href="${pageContext.request.contextPath }/order/putCart?foodNumber=${f.foodNumber}&restaurantNumber=${f.restaurantNumber}" target="myframe2">
                            	<img src="${pageContext.request.contextPath}/images/增加.png" class="corn"></a>
                            </div>
                        </div>
                    </div>
            </c:forEach>
        </div>
        
        <div class="page">
        		<span>第${requestScope.PAGEMSG.currPage }/${requestScope.PAGEMSG.totalPage}页</span> 
				<span>总记录数：${requestScope.PAGEMSG.totalCount }每页显示:${requestScope.PAGEMSG.pageSize}</span> 
				<span> <c:if test="${requestScope.PAGEMSG.currPage != 1}">
							<a href="${pageContext.request.contextPath }/food/showfoodFororder?currentPage=1">[首页]</a>
							<a href="${pageContext.request.contextPath }/food/showfoodFororder?currentPage=${requestScope.PAGEMSG.currPage-1}">[上一页]</a>
						</c:if> 
						<c:if test="${requestScope.PAGEMSG.currPage != requestScope.PAGEMSG.totalPage}">
							<a href="${pageContext.request.contextPath }/food/showfoodFororder?currentPage=${requestScope.PAGEMSG.currPage+1}">[下一页]</a>
							<a href="${pageContext.request.contextPath }/food/showfoodFororder?currentPage=${requestScope.PAGEMSG.totalPage}">[尾页]</a>
						</c:if>
				</span>
        </div>

    </c:if>
</body>
</html>