<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Food Info</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/info.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.0/jquery.min.js" charset="utf-8"></script>
</head>
<body>

	<div class="">
        <form action="${pageContext.request.contextPath}/food/updatefood" method="post" enctype="multipart/form-data">
            <fieldset class="shape">
                <legend>修改餐饮信息</legend>
                <input type="hidden" name="restaurantNumber" value="${FOODINFO.restaurantNumber}">
                <input type="hidden" name="foodNumber" value="${FOODINFO.foodNumber}">
                <div class="img">
                    <img src="${pageContext.request.contextPath}/uploadFile/img/${FOODINFO.pictureName}" class="image">
                </div>

                <div class="textbox">
                    <label class="inputname">上传图片</label>
                    <input type="file" name="imgUpload" id="imgUpload" class="file">
                    <span class="check-message hidden">文件不是图片类型</span>
                </div>

                <div class="textbox">
                    <label class="inputname">餐饮名</label>
                    <input type="text" name="foodName" id="foodName" class="text" value="${FOODINFO.foodName}">
                    <span class="check-message hidden">不能为空</span>
                </div>

                <div class="textbox">
                    <label class="inputname">种类</label>
                    <select name="kindName" class="select">
                        <option <c:if test="${FOODINFO.kindName eq '食品'}"> selected="selected" </c:if>>食品</option>
                        <option <c:if test="${FOODINFO.kindName eq '饮料'}"> selected="selected" </c:if>>饮料</option>
                    </select>
                </div>

                <div class="textbox">
                    <label class="inputname">主要原料</label>
                    <input type="text" name="mainIngreadient" id="mainIngreadient" class="text" value="${FOODINFO.mainIngreadient}">
                    <span class="check-message hidden">不能为空</span>
                </div>

                <div class="textbox">
                    <label class="inputname">单价</label>
                    <input type="text" name="sunitPrice" id="unitPrice" class="text" value="${FOODINFO.unitPrice}">
                    <span class="check-message hidden">不能为空</span>
                </div>

                <div class="options">
                    <input type="radio" name="salestatus" value="sale_no" <c:if test="${FOODINFO.saleStatus eq 1}"> checked="checked" </c:if> >未售完
                    <input type="radio" name="salestatus" value="saled"	  <c:if test="${FOODINFO.saleStatus eq 2}"> checked="checked" </c:if> >售完
                </div>

                <input type="submit" value="修改" class="btn"/>
            </fieldset>
        </form>
    </div>    
</body>
</html>