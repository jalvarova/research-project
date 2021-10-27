package beans;

public class TerramozaDTO extends PersonaDTO {
	private static final long serialVersionUID = 1L;

	public TerramozaDTO(String codigo, String nombre, String apePater, String apeMater,
			String tipoDocumento, String nroDocumentoID, String sexo,
			String fecNac, String email, String telefono,
			String ciudad,String rutaFoto,int estado) {
		super(codigo, nombre, apePater, apeMater, tipoDocumento, nroDocumentoID, sexo,
				fecNac, email, telefono,  ciudad,rutaFoto,estado);

	}
}