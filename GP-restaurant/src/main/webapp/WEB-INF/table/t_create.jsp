<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/info.css">
</head>
<body>
	<div class="bg">
        <form action="${pageContext.request.contextPath}/table/createTable" method="post">
            <fieldset class="shape">
                <legend>创建新餐桌</legend>

                <div class="textbox">
                    <label class="inputname">餐桌号</label>
                    <input type="text" name="tableNumber" id="tableNumber" class="text">
                    <span class="check-message hidden">不能为空</span>
                </div>

                <div class="textbox">
                    <label class="inputname">座位数</label>
                    <input type="text" name="seatNum" id="seatNum" class="text">
                    <span class="check-message hidden">不能为空</span>
                </div>

                <input type="submit" value="创建" class="btn"/>
            </fieldset>
        </form>
    </div>    
</body>
</html>