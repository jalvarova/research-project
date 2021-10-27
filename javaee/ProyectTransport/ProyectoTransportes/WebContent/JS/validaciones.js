

 function soloLetra(e) { // 1
	    tecla = (document.all) ? e.keyCode : e.which; 
	   		if (tecla==8) return true; // backspace
	   		
			patron = /[a-zA-Z]/; //patron--
	 
			te = String.fromCharCode(tecla); 
			return patron.test(te); // prueba de patron
	}	
  
   function soloNumero(e) {
		   tecla = (document.all) ? e.keyCode : e.which; 
	   		if (tecla==8) return true; // backspace
		
			patron = /[0-9]/; //patron--
	 
			te = String.fromCharCode(tecla); 
			return patron.test(te); // prueba de patron
 		 }
	   
   function soloNumLetras(e) { // 1
		    tecla = (document.all) ? e.keyCode : e.which; // 2
		    if (tecla==8) return true; // backspace
		    if(tecla==32) return false; //espacios en blanco
		    patron =/[A-Za-z0-9 ]/; // Acepta números y letras
		    te = String.fromCharCode(tecla); 
		    return patron.test(te); 
		}
	   
	function validarMail(idMail)
	   {
	   	object=document.getElementById(idMail);
	   	valueForm=object.value;

	   	// Patron para el correo
	   	var patron=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
	   	if(valueForm.search(patron)==0)
	   	{
	   		//Mail correcto
	   		object.style.color="#000";
	   		return;
	   	}
	   	//Mail incorrecto
	   	object.style.color="#f00";
	   }
	
	function validarplaca(idplaca)
	   {
	   	object=document.getElementById(idplaca);
	   	valueForm=object.value;

	   	// Patron para el correo
	   var patron=/[A-Z]{3}[-]{1}[0-9]{2}/;
	   	if(valueForm.search(patron)==0)
	   	{
	   		// correcto
	   		object.style.color="#000";
	   		return;
	   	}
	   	// incorrecto
	   	object.style.color="#f00";
	   }