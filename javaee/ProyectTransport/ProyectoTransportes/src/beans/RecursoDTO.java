package beans;

import java.io.Serializable;

public class RecursoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String codRecurso;
	private ChoferDTO chofer;
	private TerramozaDTO terramoza;
	private BusDTO bus;
	private RutaDTO ruta;
	private int estado;
	public RecursoDTO(String codRecurso, ChoferDTO chofer, TerramozaDTO terramoza,
			BusDTO bus, RutaDTO ruta, int estado) {
		super();
		this.codRecurso = codRecurso;
		this.chofer = chofer;
		this.terramoza = terramoza;
		this.bus = bus;
		this.ruta = ruta;
		this.estado = estado;
	}
	public String getCodRecurso() {
		return codRecurso;
	}
	public void setCodRecurso(String codRecurso) {
		this.codRecurso = codRecurso;
	}
	public ChoferDTO getChofer() {
		return chofer;
	}
	public void setChofer(ChoferDTO chofer) {
		this.chofer = chofer;
	}
	public TerramozaDTO getTerramoza() {
		return terramoza;
	}
	public void setTerramoza(TerramozaDTO terramoza) {
		this.terramoza = terramoza;
	}
	public BusDTO getBus() {
		return bus;
	}
	public void setBus(BusDTO bus) {
		this.bus = bus;
	}
	public RutaDTO getRuta() {
		return ruta;
	}
	public void setRuta(RutaDTO ruta) {
		this.ruta = ruta;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
}
