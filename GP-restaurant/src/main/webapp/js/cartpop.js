/*选择餐桌*/
function selectTablePopup() {
	$.ajax({
		url : '<%=basePath%>table/selectTable',
		type : "POST",
		data : null,
		success : function(flag) {
			if (flag == "success") {
				$("#selectTablePopup,#popLayer").css("display", "block");
			} else {
				alert("失败1");
			}
		},
		error : function() {
			alert("失败2");
		}
	});
}
