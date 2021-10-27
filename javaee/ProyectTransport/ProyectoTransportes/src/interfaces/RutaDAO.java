package interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.MySQLConexion;
import beans.CiudadDTO;
import beans.RutaDTO;

public interface RutaDAO {
	
	public List<RutaDTO> getListadoRutas();
	public boolean validaRuta(String codRuta);
	public ArrayList<RutaDTO> getListadoRutas(CiudadDTO origen);
	
	public RutaDTO getRuta(String codigo);
	
	public RutaDTO getRuta(String origen,String destino);
		
	public int agregarRuta(RutaDTO r);
	
	public int modificarRuta(RutaDTO r);
	
	public int eliminarRuta(String r);
	
	public ArrayList<CiudadDTO> getCiudadesOrigen();
	
	public ArrayList<CiudadDTO> getCiudadesDestino(String codCiudad);
	
	public CiudadDTO getCiudad(String codigo);	
	
	
}