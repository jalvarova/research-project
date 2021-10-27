package beans;

public class Ciudad {
	private String codciudad,nomCiudad;

	public Ciudad(String codciudad, String nomCiudad) {
		super();
		this.codciudad = codciudad;
		this.nomCiudad = nomCiudad;
	}

	public String getCodciudad() {
		return codciudad;
	}

	public void setCodciudad(String codciudad) {
		this.codciudad = codciudad;
	}

	public String getNomCiudad() {
		return nomCiudad;
	}

	public void setNomCiudad(String nomCiudad) {
		this.nomCiudad = nomCiudad;
	}
	
}
