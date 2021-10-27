package beans;

public class AdministradorDTO extends PersonaDTO{
	private static final long serialVersionUID = 1L;
	
	private String usuario; 
    private String clave; 
 
    
    
	public AdministradorDTO(String codigo, String usuario, String clave, String nombre, String apePater,
			String apeMater, String tipoDocumento, String nroDocumentoID,
			String sexo, String fecNac, String email, String telefono,
			String ciudad, String rutaFoto, int estado) {
		super(codigo, nombre, apePater, apeMater, tipoDocumento, nroDocumentoID, sexo,
				fecNac, email, telefono, ciudad, rutaFoto, estado);
		this.usuario = usuario;
		this.clave = clave;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
}