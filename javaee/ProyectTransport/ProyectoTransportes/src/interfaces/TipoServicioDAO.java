package interfaces;

import java.util.ArrayList;

import beans.TipoServicioDTO;

public interface TipoServicioDAO {
	
	public ArrayList<TipoServicioDTO> getTipoServicio();
	
	public TipoServicioDTO getTipoServicio(String id);
	
}
