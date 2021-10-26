package pe.edu.galaxy.training.ws.rest.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="vehiculo",namespace="pe.edu.galaxy.training.ws.rest.vehiculo")
public class VehiculoBean {

	
	private String id;

	private String licensePlate;

	private String year;

	private String model;

	@XmlElement
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement
	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public VehiculoBean() {
		super();
	}

	@Override
	public String toString() {
		return "VehiculoBean [id=" + id + ", licensePlate=" + licensePlate
				+ ", year=" + year + ", model=" + model + "]";
	}
	
	
	
}
