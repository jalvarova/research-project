package interfaces;

import java.util.ArrayList;

import beanDTO.VentaDTO;
import beanDTO.VentasADTO;
import beanDTO.VentasRDTO;

public interface VentasDAO {
	public ArrayList<VentasRDTO> ReporteVentas();
	public ArrayList<VentasADTO> VentasxAsesor(String  nom);
	public void registrarVenta(VentaDTO v);
	
}
