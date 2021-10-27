package beanDTO;

public class VentasADTO {

	private  int cod_ases; 
	private String nom_ases; 
	private String fecha_venta; 
	private String obser_venta; 	
	private String nom_pack;  
	private String nom_camp; 
	private String nom_hotel;
	private String estado_ases;
	public VentasADTO(int cod_ases, String nom_ases, String fecha_venta,
			String obser_venta, String nom_pack, String nom_camp,
			String nom_hotel, String estado_ases) {
		super();
		this.cod_ases = cod_ases;
		this.nom_ases = nom_ases;
		this.fecha_venta = fecha_venta;
		this.obser_venta = obser_venta;
		this.nom_pack = nom_pack;
		this.nom_camp = nom_camp;
		this.nom_hotel = nom_hotel;
		this.estado_ases = estado_ases;
	}
	public int getCod_ases() {
		return cod_ases;
	}
	public void setCod_ases(int cod_ases) {
		this.cod_ases = cod_ases;
	}
	public String getNom_ases() {
		return nom_ases;
	}
	public void setNom_ases(String nom_ases) {
		this.nom_ases = nom_ases;
	}
	public String getFecha_venta() {
		return fecha_venta;
	}
	public void setFecha_venta(String fecha_venta) {
		this.fecha_venta = fecha_venta;
	}
	public String getObser_venta() {
		return obser_venta;
	}
	public void setObser_venta(String obser_venta) {
		this.obser_venta = obser_venta;
	}
	public String getNom_pack() {
		return nom_pack;
	}
	public void setNom_pack(String nom_pack) {
		this.nom_pack = nom_pack;
	}
	public String getNom_camp() {
		return nom_camp;
	}
	public void setNom_camp(String nom_camp) {
		this.nom_camp = nom_camp;
	}
	public String getNom_hotel() {
		return nom_hotel;
	}
	public void setNom_hotel(String nom_hotel) {
		this.nom_hotel = nom_hotel;
	}
	public String getEstado_ases() {
		return estado_ases;
	}
	public void setEstado_ases(String estado_ases) {
		this.estado_ases = estado_ases;
	}
	
}
