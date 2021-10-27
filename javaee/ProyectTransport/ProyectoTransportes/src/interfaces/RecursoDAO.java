package interfaces;

import java.util.ArrayList;

import beans.RecursoDTO;

public interface RecursoDAO {
	public RecursoDTO getRecurso(String codRuta);
	public ArrayList<RecursoDTO> getRecursos();
	public RecursoDTO obtenerRecurso(String cod);
	public int registrarRecurso(String codRec, String codChofer, String codTerra,
			String codBus, String codRuta, int estado);
	
	public int actualizarRecurso(String codRec, String codChofer, String codTerra,
			String codBus, String codRuta, int estado);
	
	public int eliminarRecurso(String cod);
}