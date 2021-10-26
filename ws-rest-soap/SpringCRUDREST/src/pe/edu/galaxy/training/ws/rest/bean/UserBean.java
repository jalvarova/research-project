package pe.edu.galaxy.training.ws.rest.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cliente", namespace = "pe.edu.galaxy.training.ws.rest.cliente")
public class UserBean {

	private String id;
	private String user;
	private String password;
	private String name;

	public UserBean() {
		super();
	}

	@XmlElement
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@XmlElement
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", user=" + user + ", password=" + password
				+ ", name=" + name + "]";
	}

}
