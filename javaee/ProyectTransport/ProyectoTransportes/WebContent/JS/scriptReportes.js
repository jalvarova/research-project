
$(document).ready(function(){
	
	$('#reporteClientes').dataTable( {
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
	$('#reporteViajes').dataTable( {
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
	$('#reporteRecorrido').dataTable( {
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
	$('#reporteEmpleados').dataTable( {
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
	$('#reporteAsientos').dataTable( {
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
	
	if ($("#cboReporte").val() == 'Reporte de clientes próximos') {
		$("#reporteViajes").parents('div.dataTables_wrapper').first().hide();
		$("#reporteClientes").parents('div.dataTables_wrapper').first().show();
		$("#reporteRecorrido").parents('div.dataTables_wrapper').first().hide();
		$("#reporteEmpleados").parents('div.dataTables_wrapper').first().hide();
		$("#reporteAsientos").parents('div.dataTables_wrapper').first().hide();
    }
	else if ($("#cboReporte").val() == 'Reporte de viajes programados') {
		$("#reporteViajes").parents('div.dataTables_wrapper').first().show();
		$("#reporteClientes").parents('div.dataTables_wrapper').first().hide();
		$("#reporteRecorrido").parents('div.dataTables_wrapper').first().hide();
		$("#reporteEmpleados").parents('div.dataTables_wrapper').first().hide();
		$("#reporteAsientos").parents('div.dataTables_wrapper').first().hide();
    }
	else if ($("cboReporte").val() == 'Reporte de recorrido de buses'){
		$("#reporteViajes").parents('div.dataTables_wrapper').first().hide();
		$("#reporteClientes").parents('div.dataTables_wrapper').first().hide();
		$("#reporteRecorrido").parents('div.dataTables_wrapper').first().show();
		$("#reporteEmpleados").parents('div.dataTables_wrapper').first().hide();
		$("#reporteAsientos").parents('div.dataTables_wrapper').first().hide();
	}
	else if ($("cboReporte").val() == 'Reporte empleados con viaje programado'){
		$("#reporteViajes").parents('div.dataTables_wrapper').first().hide();
		$("#reporteClientes").parents('div.dataTables_wrapper').first().hide();
		$("#reporteRecorrido").parents('div.dataTables_wrapper').first().hide();
		$("#reporteEmpleados").parents('div.dataTables_wrapper').first().show();
		$("#reporteAsientos").parents('div.dataTables_wrapper').first().hide();
	}
	else if ($("cboReporte").val() == 'Reporte de asientos por bus'){
		$("#reporteViajes").parents('div.dataTables_wrapper').first().hide();
		$("#reporteClientes").parents('div.dataTables_wrapper').first().hide();
		$("#reporteRecorrido").parents('div.dataTables_wrapper').first().hide();
		$("#reporteEmpleados").parents('div.dataTables_wrapper').first().hide();
		$("#reporteAsientos").parents('div.dataTables_wrapper').first().show();
	}
	else{
		$("#reporteViajes").parents('div.dataTables_wrapper').hide();
		$("#reporteClientes").parents('div.dataTables_wrapper').hide();
		$("#reporteRecorrido").parents('div.dataTables_wrapper').hide();
		$("#reporteEmpleados").parents('div.dataTables_wrapper').hide();
		$("#reporteAsientos").parents('div.dataTables_wrapper').hide();
	}
	
	$('#cboReporte').change(function(){
		var condicion= $('#cboReporte').val();
		if(condicion =='Reporte de clientes próximos'){
			$("#reporteViajes").parents('div.dataTables_wrapper').first().hide();
			$("#reporteClientes").parents('div.dataTables_wrapper').first().show();
			$("#reporteRecorrido").parents('div.dataTables_wrapper').first().hide();
			$("#reporteEmpleados").parents('div.dataTables_wrapper').first().hide();
			$("#reporteAsientos").parents('div.dataTables_wrapper').first().hide();
		}else if(condicion=='Reporte de viajes programados'){
			$("#reporteViajes").parents('div.dataTables_wrapper').first().show();
			$("#reporteClientes").parents('div.dataTables_wrapper').first().hide();
			$("#reporteRecorrido").parents('div.dataTables_wrapper').first().hide();
			$("#reporteEmpleados").parents('div.dataTables_wrapper').first().hide();
			$("#reporteAsientos").parents('div.dataTables_wrapper').first().hide();
		}else if(condicion=='Reporte de recorrido de buses'){
			$("#reporteViajes").parents('div.dataTables_wrapper').first().hide();
			$("#reporteClientes").parents('div.dataTables_wrapper').first().hide();
			$("#reporteRecorrido").parents('div.dataTables_wrapper').first().show();
			$("#reporteEmpleados").parents('div.dataTables_wrapper').first().hide();
			$("#reporteAsientos").parents('div.dataTables_wrapper').first().hide();
		}else if(condicion=='Reporte empleados con viaje programado'){
			$("#reporteViajes").parents('div.dataTables_wrapper').first().hide();
			$("#reporteClientes").parents('div.dataTables_wrapper').first().hide();
			$("#reporteRecorrido").parents('div.dataTables_wrapper').first().hide();
			$("#reporteEmpleados").parents('div.dataTables_wrapper').first().show();
			$("#reporteAsientos").parents('div.dataTables_wrapper').first().hide();
		}else if(condicion=='Reporte de asientos por bus'){
			$("#reporteViajes").parents('div.dataTables_wrapper').first().hide();
			$("#reporteClientes").parents('div.dataTables_wrapper').first().hide();
			$("#reporteRecorrido").parents('div.dataTables_wrapper').first().hide();
			$("#reporteAsientos").parents('div.dataTables_wrapper').first().show();
			$("#reporteEmpleados").parents('div.dataTables_wrapper').first().hide();
		}
		else{
			$("#reporteViajes").parents('div.dataTables_wrapper').first().hide();
			$("#reporteClientes").parents('div.dataTables_wrapper').first().hide();
			$("#reporteRecorrido").parents('div.dataTables_wrapper').first().hide();
			$("#reporteEmpleados").parents('div.dataTables_wrapper').first().hide();
			$("#reporteAsientos").parents('div.dataTables_wrapper').first().hide();
		}	
	});
	
	
});