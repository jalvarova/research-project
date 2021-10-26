package pe.edu.galaxy.training.ws.rest.entidad;

import java.io.Serializable;

import javax.persistence.Column;

public class GenericEntity implements Serializable {
	
	private static final long serialVersionUID = -7289847438198313117L;
	
	@Column(name="ESTADO")
	protected String estado;

	public GenericEntity() {
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
