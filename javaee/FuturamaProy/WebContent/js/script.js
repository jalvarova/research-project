$(document).on("ready", function() {
	$("#header").sticky({
		topSpacing : 0
	});
	$("#demo").click(function() {
		$(this).hide(500)
	});
	$("a.ancla").click(function(e) {
		e.preventDefault();
		enlace = $(this).attr("href");
		$("html, body").animate({
			scrollTop : $(enlace).offset().top
		}, 500)
	});
	$(".banner").unslider({
		speed : 500,
		delay : 3e3,
		complete : function() {
		},
		keys : true,
		dots : true,
		fluid : true
	});
	$(".verMasSlide", ".btnSoluciones").hover(function() {
		$(this).fadeOut(100);
		$(this).fadeIn(500)
	});
	$(".btnSoluciones").hover(function() {
	})
})