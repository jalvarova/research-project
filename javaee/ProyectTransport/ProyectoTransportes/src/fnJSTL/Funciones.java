package fnJSTL;

import java.util.List;

import beans.BoletoDTO;

public class Funciones {
	
	public static boolean contains(List<Integer> lista,int o){
		Integer x = new Integer(o);
		return lista.contains(x);
	}
	
	public static boolean tieneAsientosOcupados(List<BoletoDTO> lista,int o){
		for(BoletoDTO bol : lista){
			if(bol.getNroAsiento()==o){
				return true;
			}
		}
		return false;
	}
}
