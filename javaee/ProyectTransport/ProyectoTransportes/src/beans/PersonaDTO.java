package beans;

import java.io.Serializable;

public class PersonaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected String codigo;
	protected String nombre;
	protected String apePater;
	protected String apeMater;
	protected String tipoDocumento;
	protected String nroDocumentoID;
	protected String sexo;
	protected String fecNac;
	protected String email;
	protected String telefono;
	protected String direccion;
	protected String rutaFoto;
	protected String ciudad;
	protected int estado;
	
	public PersonaDTO(String codigo, String nombre, String apePater, String apeMater,
			String tipoDocumento, String nroDocumentoID, String sexo,
			String fecNac, String email, String telefono,
			String ciudad, String rutaFoto,int estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apePater = apePater;
		this.apeMater = apeMater;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumentoID = nroDocumentoID;
		this.sexo = sexo;
		this.fecNac = fecNac;
		this.email = email;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.rutaFoto = rutaFoto;
		this.estado=estado;
	}
	
	public PersonaDTO(String codigo, String nombre, String apePater,
			String apeMater, String tipoDocumento, String nroDocumentoID) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apePater = apePater;
		this.apeMater = apeMater;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumentoID = nroDocumentoID;
	}	
	
	public PersonaDTO(String codigo) {
		super();
		this.codigo = codigo;
	
	}

	public String getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApePater() {
		return apePater;
	}
	public String getApeMater() {
		return apeMater;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public String getNroDocumentoID() {
		return nroDocumentoID;
	}
	public String getSexo() {
		return sexo;
	}
	public String getFecNac() {
		return fecNac;
	}
	public String getEmail() {
		return email;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getRutaFoto() {
		return rutaFoto;
	}
	public String getCiudad() {
		return ciudad;
	}
//	public void setCodigo(int codigo){
//		this.codigo=codigo;
//	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApePater(String apePater) {
		this.apePater = apePater;
	}
	public void setApeMater(String apeMater) {
		this.apeMater = apeMater;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public void setNroDocumentoID(String nroDocumentoID) {
		this.nroDocumentoID = nroDocumentoID;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void setFecNac(String fecNac) {
		this.fecNac = fecNac;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setFoto(String foto) {
		this.rutaFoto = foto;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}	
	public String getNombreCompleto(){
		return this.nombre+" "+this.apePater+" "+this.apeMater.charAt(0);
	}
}