package pe.edu.galaxy.training.taller.java.ws.restfull.jersey.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "talleres")
public class LstTaller implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	private List<Taller> talleres= new ArrayList<Taller>();
	
	public LstTaller() {
		super();
	}

	public List<Taller> getTalleres() {
		return talleres;
	}

	public void setTalleres(List<Taller> talleres) {
		this.talleres = talleres;
	}
	
}
