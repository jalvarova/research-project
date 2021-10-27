package beans;

import java.io.Serializable;

public class BusDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nroPlaca, anioFabricacion,marca,numAsientos,rutaFoto;
	TipoServicioDTO tipServi;
	private int estado;
	
	
	public BusDTO(String nroPlaca, String anioFabricacion, String marca,
			String numAsientos, TipoServicioDTO tipServi, int estado, String rutaFoto) {
		this.nroPlaca = nroPlaca;
		this.anioFabricacion = anioFabricacion;
		this.marca = marca;
		this.numAsientos = numAsientos;
		this.tipServi = tipServi;
		this.estado = estado;
		this.rutaFoto = rutaFoto;
	}

	public String getRutaFoto() {
		return rutaFoto;
	}

	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}

	public String getNroPlaca() {
		return nroPlaca;
	}

	public void setNroPlaca(String nroPlaca) {
		this.nroPlaca = nroPlaca;
	}

	public String getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(String anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNumAsientos() {
		return numAsientos;
	}

	public void setNumAsientos(String numAsientos) {
		this.numAsientos = numAsientos;
	}

	public TipoServicioDTO getTipServi() {
		return tipServi;
	}

	public void setTipServi(TipoServicioDTO tipServi) {
		this.tipServi = tipServi;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}