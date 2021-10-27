package interfaces;

import java.util.List;

import beanDTO.HabitacionDTO;



public interface HabitacionDAO {

	List<HabitacionDTO> listaHabitacione(int cod_hab);
	
}
