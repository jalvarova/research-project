package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import services.ServicioCliente;

public class TestRegistroCliente {

	private ServicioCliente servicio = new ServicioCliente();

	public boolean registroCliente(String codigo, String nombre,
			String apePaterno, String apeMaterno, String tipoDocID,
			int nroDocID, String sexo, String email, int telefono,
			String fecha, String codciudad, byte[] foto, int estado,
			String usuario, String clave) {

		boolean result = false;

		String exprnumeros = "[0-9]";
		
		if (servicio.validaRegistroCliente(codigo)) {
			
		if (codigo.length() == 5) {
			if (validarcorreo(email) && validarnombre(nombre)) {

				if (ValidarDocuemnto(nroDocID) == "DNI"
						|| ValidarDocuemnto(nroDocID) == "RUC") {

					if (ValidarNumeroTelefono(telefono) == "TELEFONO") {

						if (validaClave(clave)) {

							int cliente = servicio.registrarCliente(codigo,
									nombre, apePaterno, apeMaterno, tipoDocID,
									nroDocID, sexo, email, telefono, fecha,
									codciudad, foto, estado, usuario, clave);
							
							if (cliente != 0) {

								return true;

							} else {

								return result;

							}
							
							} 
						}
					}
				}
			}
		}
		return result;

	}

	public boolean validaClave(String cadena) {
		
		if (cadena.length() <= 15 && cadena.length() >= 5) {
			return true;
		}
		return false;
	}

	public boolean isNumeric(long cadena) {
		try {
			Long.numberOfTrailingZeros(cadena);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public String ValidarDocuemnto(int numero) {

		String numeroDoc = Integer.toString(numero);

		if (numeroDoc.length() == 8) {

			return "DNI";
		}
		if (numeroDoc.length() == 11) {
			return "RUC";
		}

		return "No es Nada";

	}

	public String ValidarNumeroTelefono(int numero) {

		String tele = Integer.toString(numero);

		if (tele.length() == 9 || tele.length() == 7) {

			return "TELEFONO";
		}

		return "No es Nada";

	}

	public boolean validarnombre(String cadena) {

		boolean exp;
		String exprcadena = "[A-Za-z]";
		Pattern pat = Pattern.compile(exprcadena);
		Matcher mat = pat.matcher(cadena);
		exp = mat.matches();
		if (mat.find()) {
			return true;
		}
		return false;
	}

	public boolean validarcorreo(String cadena) {

		boolean exp;
		String exprcadena = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pat = Pattern.compile(exprcadena);
		Matcher mat = pat.matcher(cadena);

		if (mat.find()) {
			return true;
		}
		return false;
	}

}
