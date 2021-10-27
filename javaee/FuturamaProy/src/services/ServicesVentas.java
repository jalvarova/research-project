package services;

import java.util.ArrayList;

import beanDTO.VentaDTO;
import beanDTO.VentasADTO;
import beanDTO.VentasRDTO;
import interfaces.VentasDAO;
import dao.DAOFactory;

public class ServicesVentas {

	private DAOFactory fabrica = DAOFactory.getDaoFactory(1);
	// instanciar las rutinas usando la fuente
	private VentasDAO objVentasDAO=fabrica.getVentasDAO();
	
	public ArrayList<VentasRDTO> ReporteVentas(){
		
		return objVentasDAO.ReporteVentas();
		
	}
	public ArrayList<VentasADTO> VentasxAsesor (String  nom){
		return  objVentasDAO.VentasxAsesor(nom);
	}
	
	public void registrarVenta(VentaDTO v){
		objVentasDAO.registrarVenta(v);
	}
}
