package interfaces;

import java.util.ArrayList;

import beans.TerramozaDTO;

public interface TerramozaDAO {
	
	public TerramozaDTO obtenerTerramoza(String codigo);
	
	public int registrarTerramoza(String codigo, String nombre, String apePater, String apeMater,
			String tipoDocumento, String nroDocumentoID, String sexo,
			String fecNac, String email, String telefono,
			String ciudad,byte[] foto,int estado);
	
	public int actualizaTerramoza(String codigo, String nombre, String apePater, String apeMater,
			String tipoDocumento, String nroDocumentoID, String sexo,
			String fecNac, String email, String telefono,
			String ciudad,byte[] foto,int estado);
	
	public int eliminarTerramoza(String codigo);
	
	public ArrayList<TerramozaDTO> listaTerramoza();
}