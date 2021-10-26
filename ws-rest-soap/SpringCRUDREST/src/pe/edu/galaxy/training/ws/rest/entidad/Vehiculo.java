package pe.edu.galaxy.training.ws.rest.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "vehiculo.findByPlaca", procedureName = "PKG_VEHICULO.SP_LISTAR_X_PLACA", resultClasses = Vehiculo.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "P_CURSOR", type = void.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_PLACA", type = String.class)

		}),
		@NamedStoredProcedureQuery(name = "vehiculo.findByYear", procedureName = "PKG_VEHICULO.SP_LISTAR_X_ANO", resultClasses = Vehiculo.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "P_CURSOR", type = void.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ANIO", type = String.class)

		}) })
@Entity(name = "VEHICULO")
public class Vehiculo extends GenericEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "VEHICULO_ID")
	private String id;
	@Column(name = "PLACA")
	private String licensePlate;
	@Column(name = "ANO")
	private String year;
	@Column(name = "MODELO")
	private String model;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", licensePlate=" + licensePlate
				+ ", year=" + year + ", model=" + model + "]";
	}

}
