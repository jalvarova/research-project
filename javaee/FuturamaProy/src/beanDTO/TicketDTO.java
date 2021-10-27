package beanDTO;

public class TicketDTO {
private String cod_tick;
private String fecha_tick;
private String nom_completo_ses;
private String correo_ases;
private int num_llamada;
private String nom_camp;
private String nom_hotel;
private String nom_hab;
private String nom_pack;
private double precioTotal_venta;
private String nom_completo_clie;
public TicketDTO(String cod_tick, String fecha_tick, String nom_completo_ses,
		String correo_ases, int num_llamada, String nom_camp, String nom_hotel,
		String nom_hab, String nom_pack, double precioTotal_venta,
		String nom_completo_clie) {
	super();
	this.cod_tick = cod_tick;
	this.fecha_tick = fecha_tick;
	this.nom_completo_ses = nom_completo_ses;
	this.correo_ases = correo_ases;
	this.num_llamada = num_llamada;
	this.nom_camp = nom_camp;
	this.nom_hotel = nom_hotel;
	this.nom_hab = nom_hab;
	this.nom_pack = nom_pack;
	this.precioTotal_venta = precioTotal_venta;
	this.nom_completo_clie = nom_completo_clie;
}
public String getCod_tick() {
	return cod_tick;
}
public void setCod_tick(String cod_tick) {
	this.cod_tick = cod_tick;
}
public String getFecha_tick() {
	return fecha_tick;
}
public void setFecha_tick(String fecha_tick) {
	this.fecha_tick = fecha_tick;
}
public String getNom_completo_ses() {
	return nom_completo_ses;
}
public void setNom_completo_ses(String nom_completo_ses) {
	this.nom_completo_ses = nom_completo_ses;
}
public String getCorreo_ases() {
	return correo_ases;
}
public void setCorreo_ases(String correo_ases) {
	this.correo_ases = correo_ases;
}
public int getNum_llamada() {
	return num_llamada;
}
public void setNum_llamada(int num_llamada) {
	this.num_llamada = num_llamada;
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
public String getNom_hab() {
	return nom_hab;
}
public void setNom_hab(String nom_hab) {
	this.nom_hab = nom_hab;
}
public String getNom_pack() {
	return nom_pack;
}
public void setNom_pack(String nom_pack) {
	this.nom_pack = nom_pack;
}
public double getPrecioTotal_venta() {
	return precioTotal_venta;
}
public void setPrecioTotal_venta(double precioTotal_venta) {
	this.precioTotal_venta = precioTotal_venta;
}
public String getNom_completo_clie() {
	return nom_completo_clie;
}
public void setNom_completo_clie(String nom_completo_clie) {
	this.nom_completo_clie = nom_completo_clie;
}


}
