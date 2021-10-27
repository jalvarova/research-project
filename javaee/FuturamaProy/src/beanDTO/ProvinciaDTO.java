package beanDTO;

public class ProvinciaDTO {
private String cod_prov;
private String desc_prov;
public ProvinciaDTO(String cod_prov, String desc_prov) {
	super();
	this.cod_prov = cod_prov;
	this.desc_prov = desc_prov;
}
public String getCod_prov() {
	return cod_prov;
}
public void setCod_prov(String cod_prov) {
	this.cod_prov = cod_prov;
}
public String getDesc_prov() {
	return desc_prov;
}
public void setDesc_prov(String desc_prov) {
	this.desc_prov = desc_prov;
}


}
