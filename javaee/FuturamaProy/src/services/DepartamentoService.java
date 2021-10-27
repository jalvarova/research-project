package services;

import java.util.List;

import beanDTO.DepartamentoDTO;
import interfaces.ClientesDAO;
import interfaces.DepartamentoDAO;
import dao.DAOFactory;

public class DepartamentoService {
	DAOFactory fabrica = DAOFactory.getDaoFactory(1);
	// instanciar las rutinas usando la fuente
	DepartamentoDAO objDepartamentoDAO=fabrica.getDepeartamentoDAO();
	
public List<DepartamentoDTO> listadoDistrito(String cod_prov){
		
		
		
		return objDepartamentoDAO.listadoDistrito(cod_prov);
		
		
		
	}
	
}
