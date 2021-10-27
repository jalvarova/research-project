package beanDTO;

public class PackDTO {
	private String cod_pack;
	private String nom_pack;
	private int cod_camp;
	
	public PackDTO(String cod_pack, String nom_pack, int cod_camp) {
		super();
		this.cod_pack = cod_pack;
		this.nom_pack = nom_pack;
		this.cod_camp = cod_camp;
	}


	public String getCod_pack() {
		return cod_pack;
	}
	public void setCod_pack(String cod_pack) {
		this.cod_pack = cod_pack;
	}
	public String getNom_pack() {
		return nom_pack;
	}
	public void setNom_pack(String nom_pack) {
		this.nom_pack = nom_pack;
	}


	public int getCod_camp() {
		return cod_camp;
	}

	public void setCod_camp(int cod_camp) {
		this.cod_camp = cod_camp;
	}
	
	
	
}
