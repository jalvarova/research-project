package beanDTO;

public class HabitacionDTO {
	  private String cod_hab;
	  private String nom_hab;
	  private double preSoles_hab;
	  private double preDolares;
	  private double naSoles_hab;
	  private double naDolares_hab;
	 private double pretotal_hab;
	 private int cod_hotel;
	public HabitacionDTO(String cod_hab, String nom_hab, double preSoles_hab,
			double preDolares, double naSoles_hab, double naDolares_hab,
			double pretotal_hab) {
		super();
		this.cod_hab = cod_hab;
		this.nom_hab = nom_hab;
		this.preSoles_hab = preSoles_hab;
		this.preDolares = preDolares;
		this.naSoles_hab = naSoles_hab;
		this.naDolares_hab = naDolares_hab;
		this.pretotal_hab = pretotal_hab;
	}
	
	public HabitacionDTO(String cod_hab, String nom_hab, double preSoles_hab,
			double preDolares, double naSoles_hab, double naDolares_hab,
			double pretotal_hab, int cod_hotel) {
		super();
		this.cod_hab = cod_hab;
		this.nom_hab = nom_hab;
		this.preSoles_hab = preSoles_hab;
		this.preDolares = preDolares;
		this.naSoles_hab = naSoles_hab;
		this.naDolares_hab = naDolares_hab;
		this.pretotal_hab = pretotal_hab;
		this.cod_hotel = cod_hotel;
	}

	public int getCod_hotel() {
		return cod_hotel;
	}

	public void setCod_hotel(int cod_hotel) {
		this.cod_hotel = cod_hotel;
	}

	public String getCod_hab() {
		return cod_hab;
	}
	public void setCod_hab(String cod_hab) {
		this.cod_hab = cod_hab;
	}
	public String getNom_hab() {
		return nom_hab;
	}
	public void setNom_hab(String nom_hab) {
		this.nom_hab = nom_hab;
	}
	public double getPreSoles_hab() {
		return preSoles_hab;
	}
	public void setPreSoles_hab(double preSoles_hab) {
		this.preSoles_hab = preSoles_hab;
	}
	public double getPreDolares() {
		return preDolares;
	}
	public void setPreDolares(double preDolares) {
		this.preDolares = preDolares;
	}
	public double getNaSoles_hab() {
		return naSoles_hab;
	}
	public void setNaSoles_hab(double naSoles_hab) {
		this.naSoles_hab = naSoles_hab;
	}
	public double getNaDolares_hab() {
		return naDolares_hab;
	}
	public void setNaDolares_hab(double naDolares_hab) {
		this.naDolares_hab = naDolares_hab;
	}
	public double getPretotal_hab() {
		return pretotal_hab;
	}
	public void setPretotal_hab(double pretotal_hab) {
		this.pretotal_hab = pretotal_hab;
	}

	  
}
