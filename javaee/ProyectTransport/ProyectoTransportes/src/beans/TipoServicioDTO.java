package beans;

import java.io.Serializable;

public class TipoServicioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String idTipoServicio,nombreTipoServicio;
	private double tarifa;
	private String descripcion;
	
	public TipoServicioDTO(String idTipoServicio, String nombreTipoServicio,
			double tarifa, String descripcion) {
		super();
		this.idTipoServicio = idTipoServicio;
		this.nombreTipoServicio = nombreTipoServicio;
		this.tarifa = tarifa;
		this.descripcion = descripcion;
	}

	public String getIdTipoServicio() {
		return idTipoServicio;
	}

	public void setIdTipoServicio(String idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
	}

	public String getNombreTipoServicio() {
		return nombreTipoServicio;
	}

	public void setNombreTipoServicio(String nombreTipoServicio) {
		this.nombreTipoServicio = nombreTipoServicio;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}