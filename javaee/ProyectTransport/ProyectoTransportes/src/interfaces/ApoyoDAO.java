package interfaces;

import java.util.ArrayList;

import beans.BoletoDTO;

public interface ApoyoDAO {
	public ArrayList<BoletoDTO> reportesBoletosAnteriores();
	
	public ArrayList<BoletoDTO> reportesBoletosProximos();
	
	public ArrayList<Integer> getAsientosOcupados(String fecha,String nroPlaca);
}