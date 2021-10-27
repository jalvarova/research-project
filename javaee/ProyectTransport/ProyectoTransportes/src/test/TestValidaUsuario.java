package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import beans.AdministradorDTO;
import beans.ClienteDTO;
import services.AdministradorService;
import services.ClienteService;

public class TestValidaUsuario {

	public boolean ValidaAdministrador(String usuario, String clave) {

		boolean result = false;
		boolean usuarioCorrecto = false;
		AdministradorService administradorService = new AdministradorService();
		AdministradorDTO admis = administradorService.validaAdministrador(
				usuario, clave);
		
		
		
			if (validarLetras(usuario)) {
				
				if (!usuario.isEmpty() && !clave.isEmpty()) {
					 
					if (clave.length() >= 4 && clave.length() <= 8) {
						
				if (admis != null ) {
					//if (usuario == admis.getUsuario() && clave.equals(admis.getClave())) {

					return true;

				//}
				}
			}
		}
			}
		return result;

	}
	public boolean validarLetras(String cadena) {

		boolean exp;
		String exprcadena = "[A-Z]";
		Pattern pat = Pattern.compile(exprcadena);
		Matcher mat = pat.matcher(cadena);

		if (mat.find()) {
			return true;
		}
		return false;
	}
}
