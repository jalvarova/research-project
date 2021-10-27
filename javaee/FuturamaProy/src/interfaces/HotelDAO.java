package interfaces;

import java.util.List;

import beanDTO.HotelDTO;

public interface HotelDAO {
	public List<HotelDTO> listaHotele(int cod_Hotel);
}
