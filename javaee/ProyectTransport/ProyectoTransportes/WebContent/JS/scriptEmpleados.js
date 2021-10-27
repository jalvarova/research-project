
$(document).ready(function(){
	$("#datepicker").datepicker();
	var tablaC=$('#tablaChofer').dataTable( {
		"oLanguage": {
            "sLengthMenu": 'Mostrar <select>'+
        '<option value="5">5</option>'+
        '<option value="10">10</option>'+
        '<option value="15">15</option>'+
        '<option value="20">20</option>'+
        '<option value="25">25</option>'+
        '<option value="-1">Todo</option>'+
        '</select>'
        },
        "bPaginate": true,
        "bLengthChange": true,
        "bFilter": true,
        "bSort": true,
        "bInfo": false,
        "bAutoWidth": true,
        'iDisplayLength': 5,
        "infoEmpty": "No records available",
    } );
	var tablaT=$('#tablaTerramoza').dataTable( {
		"oLanguage": {
            "sLengthMenu": 'Mostrar <select>'+
        '<option value="5">5</option>'+
        '<option value="10">10</option>'+
        '<option value="15">15</option>'+
        '<option value="20">20</option>'+
        '<option value="25">25</option>'+
        '<option value="-1">Todo</option>'+
        '</select>'
        },
        "bPaginate": true,
        "bLengthChange": true,
        "bFilter": true,
        "bSort": true,
        "bInfo": false,
        "bAutoWidth": true,
        'iDisplayLength': 5,
        "infoEmpty": "No records available",
    } );
	
	if ($("#cboTipo").val() == 'Chofer') {
		$("#tablaTerramoza").parents('div.dataTables_wrapper').first().hide();
		$("#tablaChofer").parents('div.dataTables_wrapper').first().show();
		$("#licencia").show();
		$("#txtCodigoC").show();
		$("#txtCodigoT").hide();
		$("#lblCodigoC").show();
		$("#lblCodigoT").hide();
    }
	else if ($("#cboTipo").val() == 'Terramoza') {
		$("#tablaTerramoza").parents('div.dataTables_wrapper').first().show()
		$("#tablaChofer").parents('div.dataTables_wrapper').first().hide();
		$("#licencia").hide();
		$("#txtCodigoC").hide();
		$("#txtCodigoT").show();
		$("#lblCodigoC").hide();
		$("#lblCodigoT").show();
    }
	else{
		$("#tablaTerramoza").parents('div.dataTables_wrapper').hide();
		$("#tablaChofer").parents('div.dataTables_wrapper').hide();
		$("#txtCodigoC").text();
		$("#txtCodigoT").hide();
		$("#lblCodigoC").show();
		$("#lblCodigoT").hide();
	}
	
	$('#cboTipo').change(function(){
		var condicion= $('#cboTipo').val();
		if(condicion =='Chofer'){
			//$("#tablaTerramoza").hide();
			$("#tablaTerramoza").parents('div.dataTables_wrapper').first().hide();
			$("#tablaChofer").parents('div.dataTables_wrapper').first().show();
			$("#licencia").show();
			$("#txtCodigoC").show();
			$("#txtCodigoT").hide();
			$("#lblCodigoC").show();
			$("#lblCodigoT").hide();
		}else if(condicion=='Terramoza'){
			$("#tablaTerramoza").parents('div.dataTables_wrapper').first().show()
			$("#tablaChofer").parents('div.dataTables_wrapper').first().hide();
			$("#licencia").hide();
			$("#txtCodigoC").hide();
			$("#txtCodigoT").show();
			$("#lblCodigoC").hide();
			$("#lblCodigoT").show();
		}else{
			$("#tablaTerramoza").parents('div.dataTables_wrapper').first().hide();
			$("#tablaChofer").parents('div.dataTables_wrapper').first().hide();
			$("#licencia").show();
			$("#txtCodigoC").show();
			$("#txtCodigoT").hide();
			$("#lblCodigoC").show();
			$("#lblCodigoT").hide();
		}	
	});
		$('#tablaChofer tr').click(function(event){
		var datos = tablaC.fnGetData( this );
		$('#txtCodigoC').val(datos[0]);
		$('#txtNombre').val(datos[1]);
		$('#txtApellidoP').val(datos[2]);
		$('#txtApellidoM').val(datos[3]);
		$('#txtTelefono').val(datos[4]);
		//$('#txtNombre').val(datos[5]);
		
	});
	$('#tablaTerramoza tr').click(function(event){
		var datos = tablaT.fnGetData( this );
		$('#txtCodigoT').val(datos[0]);
		$('#txtNombre').val(datos[1]);
		$('#txtApellidoP').val(datos[2]);
		$('#txtApellidoM').val(datos[3]);
		$('#txtTelefono').val(datos[4]);
	});
});