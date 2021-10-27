package beans;

import java.io.Serializable;

public class TipoDocumentoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idTipoDocumento;
	private String nombreTipoDocumento;
	
	public TipoDocumentoDTO(int idTipoDocumento, String nombreTipoDocumento) {
		super();
		this.idTipoDocumento = idTipoDocumento;
		this.nombreTipoDocumento = nombreTipoDocumento;
	}
	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public String getNombreTipoDocumento() {
		return nombreTipoDocumento;
	}
	public void setNombreTipoDocumento(String nombreTipoDocumento) {
		this.nombreTipoDocumento = nombreTipoDocumento;
	}
}