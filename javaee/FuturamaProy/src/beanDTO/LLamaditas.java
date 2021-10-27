package beanDTO;

public class LLamaditas {
 
    private	String nom_ases;
    private	String tipo_estado;
    private	String nom_motivo;
    private	String obs_llamda;
    private int num_llamda;
    private	int cod_ases;
	public LLamaditas(String nom_ases, String tipo_estado, String nom_motivo,
			String obs_llamda, int num_llamda, int cod_ases) {
		super();
		this.nom_ases = nom_ases;
		this.tipo_estado = tipo_estado;
		this.nom_motivo = nom_motivo;
		this.obs_llamda = obs_llamda;
		this.num_llamda = num_llamda;
		this.cod_ases = cod_ases;
	}
	public String getNom_ases() {
		return nom_ases;
	}
	public void setNom_ases(String nom_ases) {
		this.nom_ases = nom_ases;
	}
	public String getTipo_estado() {
		return tipo_estado;
	}
	public void setTipo_estado(String tipo_estado) {
		this.tipo_estado = tipo_estado;
	}
	public String getNom_motivo() {
		return nom_motivo;
	}
	public void setNom_motivo(String nom_motivo) {
		this.nom_motivo = nom_motivo;
	}
	public String getObs_llamda() {
		return obs_llamda;
	}
	public void setObs_llamda(String obs_llamda) {
		this.obs_llamda = obs_llamda;
	}
	public int getNum_llamda() {
		return num_llamda;
	}
	public void setNum_llamda(int num_llamda) {
		this.num_llamda = num_llamda;
	}
	public int getCod_ases() {
		return cod_ases;
	}
	public void setCod_ases(int cod_ases) {
		this.cod_ases = cod_ases;
	}
	
	
}
