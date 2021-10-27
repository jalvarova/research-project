package beans;

import java.io.Serializable;

public class CiudadDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String codCiudad,nomCiudad;

	public CiudadDTO(String codCiudad, String nomCiudad) {
		super();
		this.codCiudad = codCiudad;
		this.nomCiudad = nomCiudad;
	}

	public CiudadDTO() {
		// TODO Auto-generated constructor stub
	}

	public CiudadDTO(String codCiudad) {
		this.codCiudad = codCiudad;
	}

	public String getCodciudad() {
		return codCiudad;
	}

	public void setCodCiudad(String codCiudad) {
		this.codCiudad = codCiudad;
	}

	public String getNomCiudad() {
		return nomCiudad;
	}

	public void setNomCiudad(String nomCiudad) {
		this.nomCiudad = nomCiudad;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNomCiudad();
	}
}