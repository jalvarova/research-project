package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import services.RutaService;
import beans.RutaDTO;

public class TestModificaRuta {

	// private RutaDTO ruta = new RutaDTO();

	public boolean modificarRuta(RutaDTO ruta) {

		RutaService service = new RutaService();

		if (service.validaRuta(ruta.getCodRuta())) {

			// if (isNumeric(String.valueOf(ruta.getTarifa()))) {
			if (ruta.getCiudadDestino().getCodciudad() != ruta
					.getCiudadOrigen().getCodciudad()) {

				if (formatoHoras(ruta.getHoraSalida())) {
					if (Habilitado(ruta.getEstado()) == "habilitado" || Habilitado(ruta.getEstado())== "deshabilitado") {

						int rutas = service.modificarRuta(ruta);
						if (rutas != 0) {
							return true;
						}

					}
				}
				// }
			}
		}
		return false;

	}

	public boolean isNumeric(String decimales) {

		try {
			Double.parseDouble(decimales);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean formatoHoras(String hora) {

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		sdf.setLenient(false);
		try {
			sdf.parse(hora);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static String Habilitado(int estado) {

		if (estado == 1) {
			System.out.println("Codigo Habilitado");
			return "habilitado";
		}
		System.out.println("Codigo deshabilitado");
		return "deshabilitado";
	}
}
