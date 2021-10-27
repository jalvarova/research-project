package beanDTO;

public class UsuarioDTO {

	private String usua;
	private String clave;
	private String nombre;
	
	public UsuarioDTO(String usua, String clave) {
		
		this.usua = usua;
		this.clave = clave;
	
	}
	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}
	public String getUsua() {
		return usua;
	}
	public void setUsua(String usua) {
		this.usua = usua;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
