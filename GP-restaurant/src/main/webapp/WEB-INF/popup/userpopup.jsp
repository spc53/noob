<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="userPopup" class="popBox popSize1">
		<div class="popTitle">个人信息</div>
		<form method="post" id="userInfo">
		<div class="textbox">
        	<label class="inputname">用户名</label>
            <input type="text" name="userName" value="${USERINFO.userName}" readonly="readonly" class="marinp1"/>
            <span class="check-message hidden check1">不能为空</span>
        </div>
        <div class="textbox">
        	<label class="inputname">真实姓名</label>
            <input type="text" name="actualName" value="${USERINFO.actualName}" class="marinp1"/>
            <span class="check-message hidden check1">不能为空</span>
        </div>
        <div class="textbox">
        	<label class="inputname">性别</label>
            <input type="text" name="sex" value="${USERINFO.sex}" class="marinp1"/>
        </div>
        <div class="textbox">
        	<label class="inputname">电话号码</label>
            <input type="text" name="telephoneNumber" value="${USERINFO.telephoneNumber}" class="marinp1"/>
            <span class="check-message hidden check1">不能为空</span>
        </div>
        <div class="textbox">
        	<label class="inputname">邮箱</label>
            <input type="text" name="mailbox" value="${USERINFO.mailbox}" class="marinp1"/>
        </div>
		<input type="button" class="popbtn poppos1" onclick="updateUser()" value="修改" />
		<input type="button" class="popbtn poppos1" onclick="closeUser()" value="关闭" />
		</form>
	</div>
</body>
</html>