package services;

import interfaces.TipoDocumentoDAO;
import java.util.ArrayList;
import beans.TipoDocumentoDTO;
import dao.DAOFactory;

public class TipoDocumentoService {
	
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	TipoDocumentoDAO objCiudad = fabrica.getTipoDocumentoDAO();
	
	public ArrayList<TipoDocumentoDTO> listarTipoDocumento(){
		return objCiudad.listarTipoDocumento();
	}
}