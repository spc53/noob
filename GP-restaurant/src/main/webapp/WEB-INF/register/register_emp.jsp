<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Emp register</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common_l_r.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.0.js"></script>
</head>
<body>
	<div class="login-form">
		<form action="${pageContext.request.contextPath}/user/empRegister" method="post">
            <div class="have-account">
                             已注册？
                <a href="${pageContext.request.contextPath}/user/login">去登录</a>
                <p>${RESGISTERERROR}</p>
            </div>

            <h6>员工注册</h6>
            
            <div class="textbox">
                <label class="inputname">店铺编号</label>
                <input type="text" name="restaurantNumber" placeholder="请填写店铺编号"/>
                <span class="check-message hidden">不能为空</span>
            </div>

            <div class="textbox">
                <label class="inputname">用户名</label>
                <input type="text" name="userName" placeholder="请设置用户名"/>
                <span class="check-message hidden">不能为空</span>
            </div>

            <div class="textbox">
                <label class="inputname">密码</label>
                <input type="password" name="password" placeholder="请设置密码"/>
                <span class="check-message hidden">不能为空</span>
            </div>

            <div class="textbox">
                <label class="inputname">手机号</label>
                <input type="text" name="telephoneNumber" placeholder="可用于找回密码"/>
                <span class="check-message hidden">不能为空</span>
            </div>

            <div class="textbox">
                <label class="inputname">真实姓名</label>
                <input type="text" name="actualName" placeholder="真实姓名"/>
                <span class="check-message hidden">不能为空</span>
            </div>

            <input type="submit" value="注册" class="login-btn" disabled/>
		</form>		
    </div>
    
    <script src="${pageContext.request.contextPath}/js/register_emp.js" charset="utf-8"></script>
</body>
</html>