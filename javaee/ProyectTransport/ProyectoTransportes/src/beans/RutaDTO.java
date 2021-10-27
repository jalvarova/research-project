package beans;

import java.io.Serializable;

public class RutaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String codRuta,horaSalida;
	private CiudadDTO ciudadOrigen,ciudadDestino;
	private double tarifa;
	private int estado;
	
	public RutaDTO(){
		
	}
	
	public RutaDTO(String codRuta, CiudadDTO ciudadOrigen, CiudadDTO ciudadDestino,
			 double tarifa,String horaSalida, int estado) {
		super();
		
		this.codRuta = codRuta;
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
		this.horaSalida = horaSalida;
		this.tarifa = tarifa;
		this.estado = estado;
		
	}
	public RutaDTO(String codRuta) {
		this.codRuta = codRuta;
	}

	public String getCodRuta() {
		return codRuta;
	}
	public void setCodRuta(String codRuta) {
		this.codRuta = codRuta;
	}
	public CiudadDTO getCiudadOrigen() {
		return ciudadOrigen;
	}
	public void setCiudadOrigen(CiudadDTO ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}
	public CiudadDTO getCiudadDestino() {
		return ciudadDestino;
	}
	public void setCiudadDestino(CiudadDTO ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	public double getTarifa() {
		return tarifa;
	}
	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
}
