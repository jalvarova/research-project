package pe.edu.galaxy.training.ws.rest.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="cliente",namespace="pe.edu.galaxy.training.ws.rest.cliente")
public class ClienteBean {
	
	private long 	idCliente;
	private String 	razonSocial;
	private String 	ruc;
	private String 	direccion;
	
	public ClienteBean() {
		super();
	}

	@XmlElement
	public String getRazonSocial() {
		return razonSocial;
	}
	
	@XmlElement
	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@XmlElement
	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	@XmlElement
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "ClienteBean [idCliente=" + idCliente + ", razonSocial=" + razonSocial + ", ruc="
				+ ruc + ", direccion=" + direccion + "]";
	}
	
	
}
