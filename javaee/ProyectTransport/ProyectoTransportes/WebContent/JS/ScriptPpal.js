
$(document).ready(function(event){
	var hoy = new Date();
	$(".datepicker").datepicker({ 
		
		dateFormat: "yy/mm/dd" ,
		minDate: hoy});
	$(".fancybox-effects-a").fancybox({
		helpers: {
			title : {
				type : 'outside'
			},
			overlay : {
				speedOut : 0
			}
		}
	});
	$("#login").fancybox({  
        'autoScale'     : false,  
        'transitionIn'  : 'none',  
        'transitionOut' : 'none',  
        'width'         : 500,  
        'height'        : 400,  
        'type'          : 'iframe'  
    });  
	$('#origen').change(function(){

		var ciudad = $('#origen').val();

		$("#destino").load("CargarDestinos",{origen:ciudad});
		
	});
	
	$('#chkSoloIda').click(function(){
		$('#vuelta').toggle();
		if($('#chkSoloIda').prop('checked')==true){
			$('#dtVuelta').removeAttr('required');
		}else{
			$('#dtVuelta').attr('required','');
		}
		
	});

	
});