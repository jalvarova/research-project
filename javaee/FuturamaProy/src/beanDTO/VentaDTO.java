package beanDTO;

public class VentaDTO {
	private int cod_vent;
	private int cod_ases;
	private int cod_hotel;
	private int cod_hab;
	private String fech_venta;
	private int nAdicionales;
	private double pretotal_hab;
	private String obser_venta;
	private String numIdentificacion_clie;
	
	
	public VentaDTO(int cod_ases, int cod_hotel, int cod_hab,
			 int nAdicionales, double pretotal_hab,
			String obser_venta, String numIdentificacion_clie) {
		
	
		this.cod_ases = cod_ases;
		this.cod_hotel = cod_hotel;
		this.cod_hab = cod_hab;
		
		this.nAdicionales = nAdicionales;
		this.pretotal_hab = pretotal_hab;
		this.obser_venta = obser_venta;
		this.numIdentificacion_clie = numIdentificacion_clie;
	}


	public int getCod_vent() {
		return cod_vent;
	}


	public void setCod_vent(int cod_vent) {
		this.cod_vent = cod_vent;
	}


	public int getCod_ases() {
		return cod_ases;
	}


	public void setCod_ases(int cod_ases) {
		this.cod_ases = cod_ases;
	}


	public int getCod_hotel() {
		return cod_hotel;
	}


	public void setCod_hotel(int cod_hotel) {
		this.cod_hotel = cod_hotel;
	}


	public int getCod_hab() {
		return cod_hab;
	}


	public void setCod_hab(int cod_hab) {
		this.cod_hab = cod_hab;
	}


	public String getFech_venta() {
		return fech_venta;
	}


	public void setFech_venta(String fech_venta) {
		this.fech_venta = fech_venta;
	}


	public int getnAdicionales() {
		return nAdicionales;
	}


	public void setnAdicionales(int nAdicionales) {
		this.nAdicionales = nAdicionales;
	}


	public double getPretotal_hab() {
		return pretotal_hab;
	}


	public void setPretotal_hab(double pretotal_hab) {
		this.pretotal_hab = pretotal_hab;
	}


	public String getObser_venta() {
		return obser_venta;
	}


	public void setObser_venta(String obser_venta) {
		this.obser_venta = obser_venta;
	}


	public String getNumIdentificacion_clie() {
		return numIdentificacion_clie;
	}


	public void setNumIdentificacion_clie(String numIdentificacion_clie) {
		this.numIdentificacion_clie = numIdentificacion_clie;
	}
	
	
	
	
}
