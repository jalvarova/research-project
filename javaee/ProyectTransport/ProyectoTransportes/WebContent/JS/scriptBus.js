/**
 * 
 */
$(document).ready(function(){
	var tablaB=$('#tablaBus').dataTable( {
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

	$('#tablaBus tr').click(function(event){
		var datos = tablaB.fnGetData( this );
		$('#txtNroPlaca').val(datos[0]);
		$('#txtAnioFabricacion').val(datos[1]);
		$('#txtMarca').val(datos[2]);
		$('#txtNumAsientos').val(datos[3]);
	});
});