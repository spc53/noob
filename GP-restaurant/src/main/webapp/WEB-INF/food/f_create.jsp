<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/info.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.0/jquery.min.js" charset="utf-8"></script>
</head>
<body>
	<div class="bg">
        <form action="${pageContext.request.contextPath}/food/createfood" method="post" enctype="multipart/form-data">
            <fieldset class="shape">
                <legend>创建新餐饮</legend>
                <div class="img">
                    <img src="" >
                </div>

                <div class="textbox">
                    <label class="inputname">上传图片</label>
                    <input type="file" name="imgUpload" id="imgUpload" class="file">
                    <span class="check-message hidden">文件不是图片类型</span>
                </div>

                <div class="textbox">
                    <label class="inputname">餐饮名</label>
                    <input type="text" name="foodName" id="foodName" class="text">
                    <span class="check-message hidden">不能为空</span>
                </div>

                <div class="textbox">
                    <label class="inputname">种类</label>
                    <select name="kindName" class="select">
                        <option>食品</option>
                        <option>饮料</option>
                    </select>
                </div>

                <div class="textbox">
                    <label class="inputname">主要原料</label>
                    <input type="text" name="mainIngreadient" id="mainIngreadient" class="text">
                    <span class="check-message hidden">不能为空</span>
                </div>

                <div class="textbox">
                    <label class="inputname">单价</label>
                    <input type="text" name="sunitPrice" id="sunitPrice" class="text">
                    <span class="check-message hidden">不能为空</span>
                </div>

                <div class="options">
                    <input type="radio" name="salestatus" checked="checked" value="sale_no">未售完
                    <input type="radio" name="salestatus" value="saled">售完
                </div>

                <input type="submit" value="创建" class="btn"/>
            </fieldset>
        </form>
    </div>    
</body>
</html>