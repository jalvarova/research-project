package pe.edu.galaxy.training.ws.rest.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQueries(
		{
				@NamedStoredProcedureQuery(
					name="cliente.listar", 
					procedureName="PKG_CLIENTE.SP_LISTAR",
					resultClasses= Cliente.class,
					parameters={
								@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_CURSOR", type=void.class )
						}					
				),
				@NamedStoredProcedureQuery(
						name="cliente.listarXRazonSocial", 
						procedureName="PKG_CLIENTE.SP_LISTAR_X_RZ",
						resultClasses= Cliente.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,name="P_RAZON_SOCIAL", type=String.class )
							}					
					),
					@NamedStoredProcedureQuery(
							name="cliente.buscarXRuc", 
							procedureName="PKG_CLIENTE.SP_BUSCAR_X_RUC",
							resultClasses= Cliente.class,
							parameters={
										@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_CURSOR", type=void.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN,name="P_RUC", type=String.class )
								}					
						),
					@NamedStoredProcedureQuery(
							name="cliente.insertar", 
							procedureName="PKG_CLIENTE.SP_INSERTAR",
							parameters={
										@StoredProcedureParameter(mode=ParameterMode.OUT,name="P_CLIENTE_ID", type=Long.class ),
										@StoredProcedureParameter(mode=ParameterMode.IN,name="P_RAZON_SOCIAL", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,name="P_RUC", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,name="P_DIRECCION", type=String.class),
										
								}					
						),
						@NamedStoredProcedureQuery(
								name="cliente.actualizar", 
								procedureName="PKG_CLIENTE.SP_ACTUALIZAR",
								parameters={
											@StoredProcedureParameter(mode=ParameterMode.IN,name="P_CLIENTE_ID", type=Long.class ),
											@StoredProcedureParameter(mode=ParameterMode.IN,name="P_RAZON_SOCIAL", type=String.class),
											@StoredProcedureParameter(mode=ParameterMode.IN,name="P_RUC", type=String.class),
											@StoredProcedureParameter(mode=ParameterMode.IN,name="P_DIRECCION", type=String.class),
											
									}					
							),
							@NamedStoredProcedureQuery(
									name="cliente.eliminar", 
									procedureName="PKG_CLIENTE.SP_ELIMINAR",
									parameters={
												@StoredProcedureParameter(mode=ParameterMode.IN,name="P_CLIENTE_ID", type=Long.class )
												
									}					
							),
							@NamedStoredProcedureQuery(
										name="cliente.validarRUC", 
										procedureName="PKG_CLIENTE.SP_VALIDAR_RUC",
										parameters={
													@StoredProcedureParameter(mode=ParameterMode.OUT,name="P_RET", type=Integer.class ),
													@StoredProcedureParameter(mode=ParameterMode.IN,name="P_CLIENTE_ID", type=Long.class),
													@StoredProcedureParameter(mode=ParameterMode.IN,name="P_RUC", type=String.class)
													
										}					
							)
		}
		)

@Entity
public class Cliente extends GenericEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CLIENTE_ID")
	private Long idCliente;

	@Column(name="RAZON_SOCIAL")
	private String razonSocial;

	@Column(name="RUC")
	private String ruc;

	@Column(name="DIRECCION")
	private String direccion;


	public Cliente() {
		this.setEstado("1");
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "ClienteBean [idCliente=" + idCliente + ", razonSocial="
				+ razonSocial + ", ruc=" + ruc + ", direccion=" + direccion
				+ "]";
	}
	
	
	

}
