package decorator;

import java.io.File;
import org.displaytag.decorator.TableDecorator;
import beans.*;

public class Wrapper extends TableDecorator{
	public String getSeleccionarBus(){
		BusDTO bus = (BusDTO) getCurrentRowObject();
	
		String placa = bus.getNroPlaca();
		String fabri = bus.getAnioFabricacion();
		String marca = bus.getMarca();
		String asientos = bus.getNumAsientos();
		String imgFoto = "images"+File.separator+bus.getRutaFoto();
		
		return "<a href=\"MantenerBus.jsp?placa="+
				placa+"&marca="+marca+"&fabri="+fabri+ "&asientos="+asientos+
				"&imgFoto="+imgFoto+"\">Seleccionar</a>";
	}
	
	public String getSeleccionarCliente() {
		ClienteDTO cli = (ClienteDTO) getCurrentRowObject();

		String cod=cli.getCodigo();
		String nom=cli.getNombre();
		String pat=cli.getApePater();
		String mat=cli.getApeMater();
		String usuario=cli.getUsuario();
		String clave=cli.getClave();
		String fecha=cli.getFecNac();
		String em=cli.getEmail();
		String tel=cli.getTelefono();
		String doc=cli.getNroDocumentoID();
		String imgFoto = "images"+File.separator+cli.getRutaFoto();
	
		return "<a href=\"MantenerCliente.jsp?cod="+cod+"&nom="+nom+"&apep="+pat+
				"&apem="+mat+"&usuario="+usuario+"&clave="+clave+"&fecha="+fecha
				+"&em="+em+"&tel="+tel+"&nrodoc="+doc+"&imgFoto="+imgFoto+"\">Selecciona</a>";
	}
	
	public String getSeleccionarRuta(){
		RutaDTO ruta = (RutaDTO) getCurrentRowObject();
		
		String codRuta = ruta.getCodRuta();
		String horaSalida = ruta.getHoraSalida();
		double tarifa = ruta.getTarifa();
		
		return "<a href=\"MantenerRuta.jsp?codRuta="+codRuta+"&horaSalida="+horaSalida+
				"&tarifa="+tarifa+"\">Seleccionar</a>";
	}
	
	public String getSeleccionarChofer(){
		ChoferDTO ch = (ChoferDTO)getCurrentRowObject();
		
		String tipo ="Chofer";
		String codigo = ch.getCodigo();
		String nombre = ch.getNombre();
		String apePater = ch.getApePater();
		String apeMater = ch.getApeMater();
		String fechaNac = ch.getFecNac();
		String sexo = ch.getSexo();
		String email = ch.getEmail();
		String tel = ch.getTelefono();
		String ciudad = ch.getCiudad();
		String tipoDoc = ch.getTipoDocumento();
		String nroDoc = ch.getNroDocumentoID();
		String licencia = ch.getNroLicencia();
		String imgFoto = "images"+File.separator+ch.getRutaFoto();
		
		return "<a href=\"MantenerEmpleado.jsp?codigoC="+codigo+"&nombre="+nombre+"&apePater="+apePater+
				"&apeMater="+apeMater+"&fechaNac="+fechaNac+"&sexo="+sexo+"&email="+email+"&tel="+tel+
				"&ciudad="+ciudad+"&tipoDoc="+tipoDoc+"&nroDoc="+nroDoc+"&licencia="+licencia+"&tipo="+tipo+
				"&imgFoto="+imgFoto+"\">Selecciona</a>";
	}
	
	public String getSeleccionarTerramoza(){
		TerramozaDTO perso = (TerramozaDTO)getCurrentRowObject();
		
		String tipo ="Terramoza";
		String codigo = perso.getCodigo();
		String nombre = perso.getNombre();
		String apePater = perso.getApePater();
		String apeMater = perso.getApeMater();
		String fechaNac = perso.getFecNac();
		String sexo = perso.getSexo();
		String email = perso.getEmail();
		String tel = perso.getTelefono();
		String ciudad = perso.getCiudad();
		String tipoDoc = perso.getTipoDocumento();
		String nroDoc = perso.getNroDocumentoID();
		String imgFoto = "images"+File.separator+perso.getRutaFoto();
	
		return "<a href=\"MantenerEmpleado.jsp?codigoT="+codigo+"&nombre="+nombre+"&apePater="+apePater+
				"&apeMater="+apeMater+"&fechaNac="+fechaNac+"&sexo="+sexo+"&email="+email+"&tel="+tel+
				"&ciudad="+ciudad+"&tipoDoc="+tipoDoc+"&nroDoc="+nroDoc+"&tipo="+tipo+"&imgFoto="+imgFoto+"\">Selecciona</a>";
	}
	
	public String getSeleccionarRecurso(){
		RecursoDTO rec = (RecursoDTO) getCurrentRowObject();
		String cod = rec.getCodRecurso();
		return "<a href=\"MantenerServicio.jsp?codServicio="+cod+"\">Selecciona</a>";
	}
	
	public String getEliminarCliente(){
		ClienteDTO cli = (ClienteDTO) getCurrentRowObject();
		String c = cli.getCodigo();
		
		return "<a href=\"ProcesarCliente?c="+c+"\"><img src=\"Imagenes/tacho.jpg\"></a>";
	}
	
	public String getEliminarChofer(){
		ChoferDTO chof = (ChoferDTO) getCurrentRowObject();
		String c = chof.getCodigo();
		
		return "<a href=\"ProcesarEmpleado?c="+c+"\"><img src=\"Imagenes/tacho.jpg\"></a>";
	}
	
	public String getEliminarTerramoza(){
		TerramozaDTO terra = (TerramozaDTO) getCurrentRowObject();
		String t = terra.getCodigo();
		
		return "<a href=\"ProcesarEmpleado?t="+t+"\"><img src=\"Imagenes/tacho.jpg\"></a>";
	}
	
	public String getEliminarBus(){
		BusDTO bus = (BusDTO) getCurrentRowObject();
		String b = bus.getNroPlaca();
		
		return "<a href=\"ProcesarBus?b="+b+"\"><img src=\"Imagenes/tacho.jpg\"></a>";
	}
	
	public String getEliminarRuta(){
		RutaDTO ruta = (RutaDTO) getCurrentRowObject();
		String r = ruta.getCodRuta();
		
		return "<a href=\"ProcesarRuta?r="+r+"\"><img src=\"Imagenes/tacho.jpg\"></a>";
	}
	
	public String getEliminarServicio(){
		RecursoDTO rec = (RecursoDTO) getCurrentRowObject();
		String s = rec.getCodRecurso();
		
		return "<a href=\"ProcesarRecursos?s="+s+"\"><img src=\"Imagenes/tacho.jpg\"></a>";
	}
	
	public String getEliminarBoleto(){
		//BoletoDTO bol = (BoletoDTO) getCurrentRowObject();
		int x = getListIndex();
		return "<a href=\"ProcesarBoleto?x="+x+"\"><img src=\"Imagenes/tacho.jpg\"></a>";
	}
}