<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common_l_r.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.0.js"></script>
</head>
<body>
	<div class="login-form">
        <h6>账号密码登录</h6>
		<p>${PARAMERROR}</p>
        <p>${LOGINERROR}</p>
		<form action="${pageContext.request.contextPath}/user/loginCheck" method="post">
            <div class="textbox">
                <input type="text" name="userName" placeholder="用户名"/>
                <span class="check-message hidden">不能为空</span>
            </div>

            <div class="textbox">
                <input type="password" name="password" placeholder="密码"/>
                <span class="check-message hidden">不能为空</span>
            </div>
            
            <div class="options">
				<label class="radio">
                <input type="radio" name="maintype" value="Front_desk" checked="checked">
                             前台
                </label>
                <label class="radio">
                <input type="radio" name="maintype" value="Back_kitchen">
                             后厨
                </label>
                <a href="#">忘记密码？</a>
            </div>

			<input type="submit" value="登录" class="login-btn" disabled/>
            <div class="dont-have-account">
                             还没有注册？
                <a href="${pageContext.request.contextPath}/res/register_shop">店铺注册</a>
		        <a href="${pageContext.request.contextPath}/user/register_emp">员工注册</a>
            </div>
        </form>		
    </div>

	<script src="${pageContext.request.contextPath}/js/login.js" charset="utf-8"></script>
</body>
</html>