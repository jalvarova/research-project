package beanDTO;

public class CampanaDTO {
	private String cod_camp;
	private String nom_camp;

	public CampanaDTO(String cod_camp, String nom_camp) {
		super();
		this.cod_camp = cod_camp;
		this.nom_camp = nom_camp;
	}

	public String getCod_camp() {
		return cod_camp;
	}

	public void setCod_camp(String cod_camp) {
		this.cod_camp = cod_camp;
	}

	public String getNom_camp() {
		return nom_camp;
	}

	public void setNom_camp(String nom_camp) {
		this.nom_camp = nom_camp;
	}

}
