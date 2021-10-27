
$(document).ready(function(event){

	var tablaR=$('#tablaRecursos').dataTable( {
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

	
});