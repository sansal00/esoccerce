$(document).ready(function() {
	$(".dropdown").click(function() {
		if($(this).hasClass("toggled")) {
			$(this).removeClass("toggled");
			$(this).parent().children("ul").slideUp();
		} else {
			$(".dropdown").parent().children("ul").slideUp();
			$(this).addClass("toggled");
			$(this).parent().children("ul").slideDown();
		}
	});
	$(".menu-button").click(function() {
		if($(".page-nav").is(':visible')) {
			$(".page-nav").fadeOut(500);
			$('.container').animate({ marginLeft: '0px'}, 500);
		} else {
			$(".page-nav").fadeIn(500);
			$('.container').animate({ marginLeft: '250px'}, 500);
		}
	});
});