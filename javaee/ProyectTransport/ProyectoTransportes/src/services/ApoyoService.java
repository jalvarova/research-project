package services;

import java.util.ArrayList;

import beans.BoletoDTO;
import interfaces.ApoyoDAO;
import dao.DAOFactory;

public class ApoyoService {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	ApoyoDAO objApoyo = fabrica.getApoyoDAO();
	
	public ArrayList<BoletoDTO> reportesBoletosProximos(){
		return objApoyo.reportesBoletosProximos();
	}
	public ArrayList<BoletoDTO> reportesBoletosAnteriores(){
		return objApoyo.reportesBoletosAnteriores();
	}
	
	public ArrayList<Integer> getAsientosOcupados(String fecha, String nroPlaca){
		return objApoyo.getAsientosOcupados(fecha, nroPlaca);
	}
}
