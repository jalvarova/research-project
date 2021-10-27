package beanDTO;

public class LlamadaDTO {
	
	private String cod_llamada;
	private int num_llam;
	private String obser_llam;
	private int cod_motivo;
	private String numIdentificacion_clie;
	private int cod_ases;
	public LlamadaDTO(String cod_llamada, int num_llam, String obser_llam,
			int cod_motivo, String numIdentificacion_clie) {
		super();
		this.cod_llamada = cod_llamada;
		this.num_llam = num_llam;
		this.obser_llam = obser_llam;
		this.cod_motivo = cod_motivo;
		this.numIdentificacion_clie = numIdentificacion_clie;
	}
	
	public int getCod_ases() {
		return cod_ases;
	}

	public void setCod_ases(int cod_ases) {
		this.cod_ases = cod_ases;
	}

	public String getCod_llamada() {
		return cod_llamada;
	}
	public void setCod_llamada(String cod_llamada) {
		this.cod_llamada = cod_llamada;
	}
	public int getNum_llam() {
		return num_llam;
	}
	public void setNum_llam(int num_llam) {
		this.num_llam = num_llam;
	}
	public String getObser_llam() {
		return obser_llam;
	}
	public void setObser_llam(String obser_llam) {
		this.obser_llam = obser_llam;
	}
	public int getCod_motivo() {
		return cod_motivo;
	}
	public void setCod_motivo(int cod_motivo) {
		this.cod_motivo = cod_motivo;
	}
	public String getNumIdentificacion_clie() {
		return numIdentificacion_clie;
	}
	public void setNumIdentificacion_clie(String numIdentificacion_clie) {
		this.numIdentificacion_clie = numIdentificacion_clie;
	}
	
	
}
