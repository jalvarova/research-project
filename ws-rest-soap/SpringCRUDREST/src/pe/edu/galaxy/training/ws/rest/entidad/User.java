package pe.edu.galaxy.training.ws.rest.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQueries({ @NamedStoredProcedureQuery(name = "user.validateaccess", procedureName = "PKG_USUARIO.SP_VALIDAR_ACCESO", resultClasses = User.class, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "P_CURSOR", type = void.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_USUARIO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_CLAVE", type = String.class)

}) })
@Entity(name = "USUARIO")
public class User extends GenericEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USUARIO_ID")
	private String id;
	@Column(name = "USUARIO")
	private String user;
	@Column(name = "CLAVE")
	private String password;
	@Column(name = "NOMBRE")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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
