/**
 * 
 */
$(document).ready(function(){
	$('#pnlPasajero *').attr('disabled',true);
	var precioActualSol = $('#preSol').text();
	var precioActualDolar = $('#preDolar').text();
	$('.tablaAsientos td:not(.aVacio):not(.asientoOcupado)').click(function(){
		var asiento = $(this).text().trim();
		var precioNuevoSol=0,precioNuevoDolar=0;
		
		if(asiento>12)	{
			precioNuevoSol=(1.10*precioActualSol).toFixed(2);
			precioNuevoDolar=(1.10*precioActualDolar).toFixed(2);
		}else{
			precioNuevoSol=(1.20*precioActualSol).toFixed(2);
			precioNuevoDolar=(1.20*precioActualDolar).toFixed(2);
		}
		
		$(this).toggleClass("asientoSeleccionado");
		$('.tablaAsientos td').not(this).removeClass("asientoSeleccionado");
		if ($(this).hasClass('asientoSeleccionado')){
			
			$('#pnlPasajero *').attr('disabled',false);
			$('#txtAsiento').val(asiento);
			$('#txtPrecioSol').val(precioNuevoSol);
			$('#txtPrecioDolar').val(precioNuevoDolar);
		}
		else{
			$('#pnlPasajero *').attr('disabled',true);
			$('#txtAsiento').val('');
			$('#txtPrecioSol').val('');
			$('#txtPrecioDolar').val('');
		}
	});

	$('#btnContinuar').click(function(){
		$('#datosBoleto').css('display','block');
		
	});
});

