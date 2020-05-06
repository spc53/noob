$(".textbox input").focusout(function() {
	if ($(this).val() == "") {
		$(this).siblings().removeClass("hidden");
		$(this).css("background", "#87ceeb");
	} else {
		$(this).siblings(".check-message").addClass("hidden");
		$(this).css("background", "#00bfff");
	}
})

$(".textbox input").keyup(
		function() {
			var inputs = $(".textbox input");
			if (inputs[0].value != "" && inputs[1].value != ""
					&& inputs[2].value != "" && inputs[3].value != ""
					&& inputs[4].value != "" && inputs[5].value != ""
					&& inputs[6].value != "" ) {
				$(".login-btn").attr("disabled", false);
				$(".login-btn").addClass("active");
			} else {
				$(".login-btn").attr("disabled", true);
				$(".login-btn").removeClass("active");
			}
		})