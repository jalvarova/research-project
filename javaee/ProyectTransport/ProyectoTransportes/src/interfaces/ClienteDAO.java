package interfaces;

import java.util.ArrayList;







import beans.ClienteDTO;

public interface ClienteDAO {
	public ClienteDTO validaCliente(String user, String clave);
	public ArrayList<ClienteDTO> getlistadoclientes(); 
	public int eliminarCliente(String cod);
	public int registrarCliente(String codigo, String nombre, String apePaterno, String apeMaterno, 
						String tipoDocID, int nroDocID, String sexo,String email, int telefono,String fecha, 
						String codciudad,byte[] foto, int estado,String usuario,String clave );
	public int actualizarCliente(String codigo, String nombre, String apePaterno, String apeMaterno, 
			String tipoDocID, int nroDocID, String sexo,String email, int telefono,String fecha, 
			String codciudad,byte[] foto, int estado, String clave );
	public ClienteDTO obtenerCliente(String cod);
	
	
	public boolean validaRegistroCliente(String codCliente) ;
}
