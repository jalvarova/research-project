package beans;

public class ChoferDTO extends PersonaDTO{
	private static final long serialVersionUID = 1L;
	private String nroLicencia;
	
	public ChoferDTO(String codigo, String nroLicencia, String nombre, String apePater,
			String apeMater, String tipoDocumento, String nroDocumentoID,
			String sexo, String fecNac, String email, String telefono,
			String ciudad, String foto, int estado) {
		super(codigo, nombre, apePater, apeMater, tipoDocumento, nroDocumentoID, sexo,
				fecNac, email, telefono, ciudad, foto, estado);
		this.nroLicencia=nroLicencia;
	}
	
	public String getNroLicencia() {
		return nroLicencia;
	}

	public void setNroLicencia(String nroLicencia) {
		this.nroLicencia = nroLicencia;
	}
}
