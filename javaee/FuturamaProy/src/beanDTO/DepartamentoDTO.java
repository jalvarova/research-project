package beanDTO;

public class DepartamentoDTO {
	
	private String cod_dpt;
	private String desc_dpt;
	public DepartamentoDTO(String cod_dpt, String desc_dpt) {
		super();
		this.cod_dpt = cod_dpt;
		this.desc_dpt = desc_dpt;
	}
	public String getCod_dpt() {
		return cod_dpt;
	}
	public void setCod_dpt(String cod_dpt) {
		this.cod_dpt = cod_dpt;
	}
	public String getDesc_dpt() {
		return desc_dpt;
	}
	public void setDesc_dpt(String desc_dpt) {
		this.desc_dpt = desc_dpt;
	}
	
	
}
