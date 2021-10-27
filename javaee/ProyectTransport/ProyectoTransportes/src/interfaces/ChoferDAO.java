package interfaces;

import java.util.ArrayList;

import beans.ChoferDTO;

public interface ChoferDAO{
	
	public ChoferDTO obtenerChofer(String codigo);
	
	public int registrarChofer(String codigo, String nroLicencia, String nombre, String apePater,
			String apeMater, String tipoDocumento, String nroDocumentoID,
			String sexo, String fecNac, String email, String telefono,
			String ciudad, byte[] foto, int estado);
	
	public int actualizaChofer(String codigo, String nroLicencia, String nombre, String apePater,
			String apeMater, String tipoDocumento, String nroDocumentoID,
			String sexo, String fecNac, String email, String telefono,
			String ciudad, byte[] foto, int estado);
	
	public int eliminarChofer(String codigo);
	
	public ArrayList<ChoferDTO> listaChofer();
}