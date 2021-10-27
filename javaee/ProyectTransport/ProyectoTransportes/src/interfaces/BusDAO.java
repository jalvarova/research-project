package interfaces;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import beans.BusDTO;

public interface BusDAO {
	
	public BusDTO obtenerBus(String codigo);
	
	public int registrarBus(String nroPlaca, String anioFabricacion, String marca,
			String numAsientos, String tipServi, int estado, byte[] foto);
	
	public int actualizarBus(String nroPlaca, String anioFabricacion, String marca,
			String numAsientos, String tipServi, int estado, byte[] foto);
	
	public int eliminarBus(String nroPlaca);
	
	public ArrayList<BusDTO> listarBuses();
	
	public ImageIcon obtenerFotoBus(String placa);
}
