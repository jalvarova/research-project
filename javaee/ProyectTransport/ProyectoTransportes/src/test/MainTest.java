package test;

import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import beans.RutaDTO;
import services.RutaService;

public class MainTest {

	public static void main(String[] args) {

       int numero = 23233456;
       int numero2 = 3424;
		System.out.println(ValidarDocuemnto(numero).toString());
		System.out.println(ValidarNumeroTelefono(numero2).toString());
		
		TestValidaUsuario testvalidausuario = new TestValidaUsuario();

		testvalidausuario.ValidaAdministrador("APANTIGOSO","123456");
		
		formatoHoras("12:00");
		
	    System.out.println();
		
	}
	public static String ValidarDocuemnto(int numero) {

		String numeroDoc =  Integer.toString(numero);
		
		if (numeroDoc.length() == 8) {
			
			return "DNI";
		}
		if (numeroDoc.length() == 11){return "RUC";}
		
		return "No es Nada";

	}
	
	public static String ValidarNumeroTelefono(int numero2) {

		String tele = Integer.toString(numero2);

		if (tele.length() == 9 || tele.length() == 7) {

			return "TELEFONO";
		}

		return "No es Nada";

	}
	
     public static String formatoHoras(String hora){
		
		DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
	     if (hora != formatoHora.format(hora)) {
		   System.out.println("formato incorrecto");
	    	  return "no es";
	    }
	     System.out.println("formato correcto");
		return "es";
	}
}
