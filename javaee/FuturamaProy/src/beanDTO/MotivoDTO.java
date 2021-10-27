package beanDTO;

public class MotivoDTO {
	private String cod_mot;
	private String nom_mot;
	private int cod_estado;
	public MotivoDTO(String cod_mot, String nom_mot) {
		super();
		this.cod_mot = cod_mot;
		this.nom_mot = nom_mot;
		
	}
	
	public MotivoDTO(String cod_mot, String nom_mot, int cod_estado) {
		super();
		this.cod_mot = cod_mot;
		this.nom_mot = nom_mot;
		this.cod_estado = cod_estado;
	}

	public String getCod_mot() {
		return cod_mot;
	}
	public void setCod_mot(String cod_mot) {
		this.cod_mot = cod_mot;
	}
	public String getNom_mot() {
		return nom_mot;
	}
	public void setNom_mot(String nom_mot) {
		this.nom_mot = nom_mot;
	}

	public int getCod_estado() {
		return cod_estado;
	}

	public void setCod_estado(int cod_estado) {
		this.cod_estado = cod_estado;
	}
	
	
}
