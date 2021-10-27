package beanDTO;

public class DistritoDTO {
private String cod_dist ;
private String desc_dist;
public DistritoDTO(String cod_dist, String desc_dist) {
	super();
	this.cod_dist = cod_dist;
	this.desc_dist = desc_dist;
}
public String getCod_dist() {
	return cod_dist;
}
public void setCod_dist(String cod_dist) {
	this.cod_dist = cod_dist;
}
public String getDesc_dist() {
	return desc_dist;
}
public void setDesc_dist(String desc_dist) {
	this.desc_dist = desc_dist;
}


}

