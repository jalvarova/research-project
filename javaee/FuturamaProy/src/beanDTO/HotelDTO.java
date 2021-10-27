package beanDTO;

public class HotelDTO {
	private String cod_hote;
	private String nom_hote;
	private int cod_pack;
	
	public HotelDTO(String cod_hote, String nom_hote,int cod_pack) {
		super();
		this.cod_hote = cod_hote;
		this.nom_hote = nom_hote;
		this.cod_pack = cod_pack;
	}
	public String getCod_hote() {
		return cod_hote;
	}
	public void setCod_hote(String cod_hote) {
		this.cod_hote = cod_hote;
	}
	public String getNom_hote() {
		return nom_hote;
	}
	public void setNom_hote(String nom_hote) {
		this.nom_hote = nom_hote;
	}
	public int getCod_pack() {
		return cod_pack;
	}
	public void setCod_pack(int cod_pack) {
		this.cod_pack = cod_pack;
	}
	
	
}
