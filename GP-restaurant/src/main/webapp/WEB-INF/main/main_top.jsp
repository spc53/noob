<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidebar.css">
</head>
<body>
	<header class="bgcolor">
	<div>
		<div class="hleft">
        	${RESINFO.restaurantName}
        </div>
        
        <div class="reslogo"><img src="${pageContext.request.contextPath}/images/餐厅管理.png" class="rescorn"></div>
        
        <div class="sidebar">
        <ul>
            <li><a href="javascript:void(0)" class="" onclick="userPopup()"><img src="${pageContext.request.contextPath}/images/user.png" class="tcorn"></a></li>
            <li><a href="javascript:void(0)" class="" onclick="pwPopup()"><img src="${pageContext.request.contextPath}/images/lock.png" class="tcorn"></a></li>
            <li><a href="${pageContext.request.contextPath}/user/retreatSafely" class=""><img src="${pageContext.request.contextPath}/images/退出.png" class="tcorn"></a></li>
        </ul>
    	</div>

    	<a><img src="${pageContext.request.contextPath}/images/list.png" class="barbtn"></a>

    	<script type="text/javascript">
        	$('.barbtn').on("click",function(){
        		$('.barbtn').toggleClass('barbtnc');
            	$('.sidebar').toggleClass('side');
        	});
    	</script>

	</div>
	</header>
</body>
</html>