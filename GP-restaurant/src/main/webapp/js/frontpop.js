/*弹出用户信息*/
function userPopup() {
	$("#userPopup,#popLayer").css("display", "block");
}

/* 关闭用户信息 */
function closeUser() {
	$("#userPopup,#popLayer").css("display", "none");
}
/*弹出密码*/
function pwPopup() {
	$("#pwPopup,#popLayer").css("display", "block");
}
/* 关闭 密码*/
function closePw() {
	$("#pwPopup,#popLayer").css("display", "none");
}

/* 修改密码 */
function updatePw() {
	$.ajax({
		url : '<%=basePath%>/user/updatePw',
		type : "POST",
		data : $('#userPw').serialize(),
		success : function(flag) {
			if (flag == "200") {
				alert("修改成功");
				$("#pw1").val("");
				$("#pw2").val("");
				$("#pw3").val("");
				$("#pwPopup,#popLayer").css("display", "none");
			} else {
				alert("修改失败");
			}
		},
		error : function() {
			alert("修改失败");
		}
	});
}

/* 更新用户信息 */
function updateUser() {
	$.ajax({
		url : '<%=basePath%>/user/updateUserInfo',
		type : "POST",
		data : $('#userInfo').serialize(),
		success : function(flag) {
			if (flag == "200") {
				alert("修改成功");
				$("#userPopup,#popLayer").css("display", "none");
			} else {
				alert("修改失败");
			}
		},
		error : function() {
			alert("修改失败");
		}
	});
};

/**/
$('.blob1').click(function(){
    $('.blobs').toggleClass('open');
})

