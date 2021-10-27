package services;

import beans.BusDTO;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import interfaces.BusDAO;
import dao.DAOFactory;

public class BusService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	BusDAO objBusDao = fabrica.getBusDAO();
	
	public BusDTO obtenerBus(String codigo){
		return objBusDao.obtenerBus(codigo);
	}
	
	public int registrarBus(String nroPlaca, String anioFabricacion, String marca,
			String numAsientos, String tipServi, int estado, byte[] foto){
		return objBusDao.registrarBus(nroPlaca, anioFabricacion, marca, numAsientos, tipServi, estado, foto);
	}
	
	public int actualizarBus(String nroPlaca, String anioFabricacion, String marca,
			String numAsientos, String tipServi, int estado, byte[] foto){
		return objBusDao.actualizarBus(nroPlaca, anioFabricacion, marca, numAsientos, tipServi, estado, foto);
	}
	
	public int eliminarBus(String nroPlaca){
		return objBusDao.eliminarBus(nroPlaca);
	}
	
	public ArrayList<BusDTO> listarBuses(){
		return objBusDao.listarBuses();
	}
	
	public ImageIcon obtenerFotoBus(String placa) {
		return objBusDao.obtenerFotoBus(placa);
	}
}