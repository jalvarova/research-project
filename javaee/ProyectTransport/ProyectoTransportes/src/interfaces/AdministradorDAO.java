package interfaces;

import beans.AdministradorDTO;

public interface AdministradorDAO {
	public AdministradorDTO validaAdministrador(String admin, String clave);
}
