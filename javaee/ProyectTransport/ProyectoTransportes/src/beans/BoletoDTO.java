package beans;

import java.io.Serializable;

public class BoletoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nroBoleto,fechaEmision,fechaViaje;
	private ClienteDTO cliente;
	private String idPasajero;
	private RecursoDTO recurso;
	private int nroAsiento;
	private double precioSol,precioDolar;
	
	public BoletoDTO(String nroBoleto, String fechaEmision, String fechaViaje,
			String idPasajero,ClienteDTO cliente, RecursoDTO recurso, int nroAsiento,
			double precioSol,double precioDolar) {
		super();
		this.nroBoleto = nroBoleto;
		this.fechaEmision = fechaEmision;
		this.fechaViaje = fechaViaje;
		this.idPasajero= idPasajero;
		this.cliente = cliente;
		this.recurso = recurso;
		this.nroAsiento = nroAsiento;
		this.precioSol = precioSol;
		this.precioDolar = precioDolar;
	}

	public String getNroBoleto() {
		return nroBoleto;
	}

	public void setNroBoleto(String nroBoleto) {
		this.nroBoleto = nroBoleto;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getFechaViaje() {
		return fechaViaje;
	}

	public void setFechaViaje(String fechaViaje) {
		this.fechaViaje = fechaViaje;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public RecursoDTO getRecurso() {
		return recurso;
	}

	public void setRecurso(RecursoDTO recurso) {
		this.recurso = recurso;
	}

	public int getNroAsiento() {
		return nroAsiento;
	}

	public void setNroAsiento(int nroAsiento) {
		this.nroAsiento = nroAsiento;
	}

	public String getIdPasajero() {
		return idPasajero;
	}

	public void setIdPasajero(String idPasajero) {
		this.idPasajero = idPasajero;
	}

	public double getPrecioSol() {
		return precioSol;
	}

	public void setPrecioSol(double precioSol) {
		this.precioSol = precioSol;
	}

	public double getPrecioDolar() {
		return precioDolar;
	}

	public void setPrecioDolar(double precioDolar) {
		this.precioDolar = precioDolar;
	}
	
}
