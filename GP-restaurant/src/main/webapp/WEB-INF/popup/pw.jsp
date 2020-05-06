<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="pwPopup" class="popBox popSize2">
		<div class="popTitle">修改密码</div>
		<form method="post" id="userPw">
		<input type="text" name="userName" value="${USERINFO.userName}" style="display:none;"/>
		<div class="textbox">
            <input id="pw1" type="password" name="orgPassword" placeholder="请输入原始密码" class="marinp2"/>
            <span class="check-message hidden check2">不能为空</span>
        </div>
        <div class="textbox">
            <input id="pw2" type="password" name="password" placeholder="请设置密码" class="marinp2"/>
            <span class="check-message hidden check2">不能为空</span>
        </div>
        <div class="textbox">
            <input id="pw3" type="password" name="aPassword" placeholder="再次确认密码" class="marinp2"/>
            <span class="check-message hidden check2">不能为空</span>
        </div>
		<input type="button" class="popbtn poppos2" onclick="updatePw()" value="修改" />
		<input type="button" class="popbtn poppos2" onclick="closePw()" value="关闭" />
		</form>
	</div>
</body>
</html>