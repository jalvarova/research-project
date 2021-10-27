package beanDTO;

public class EstadoDTO {
private int cod_estado;
private String tipo_estado;
public EstadoDTO(int cod_estado, String tipo_estado) {
	super();
	this.cod_estado = cod_estado;
	this.tipo_estado = tipo_estado;
}
public int getCod_estado() {
	return cod_estado;
}
public void setCod_estado(int cod_estado) {
	this.cod_estado = cod_estado;
}
public String getTipo_estado() {
	return tipo_estado;
}
public void setTipo_estado(String tipo_estado) {
	this.tipo_estado = tipo_estado;
}

}
