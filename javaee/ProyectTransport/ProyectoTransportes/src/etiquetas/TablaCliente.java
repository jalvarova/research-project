package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import services.ServicioCliente;

import beans.ClienteDTO;

public class TablaCliente extends TagSupport {
	private static final long serialVersionUID = 1L;
	@Override
	public int doEndTag() throws JspException {
		return 0;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			ArrayList<ClienteDTO> lista = new ArrayList<>();
			JspWriter out = pageContext.getOut(); 
			ServicioCliente ser=new ServicioCliente();
			lista=ser.getlistadoclientes();
			out.println("<table id='tablaCliente' border='1' width='100%' style='background-color: #FFFFFF ' cellpadding='10%'"
					+ " bordercolor='#dddddd'  >");
				out.println("<tr>");
					out.println("<th>Codigo</th>");
					out.println("<th>Nombre</th>");
					out.println("<th>A.Paterno</th>");
					out.println("<th>A.Materno</th>");
					out.println("<th>Tipo Documento</th>");
					out.println("<th>Nro.Documento</th>");
				out.println("</tr>");
							
				for(ClienteDTO c:lista)
				out.println("<tr>"+ "<td>"+c.getCodigo()+"</td>"+"<td>"+c.getNombre()+"</td>"+"<td>"+c.getApePater()+"</td>"
						+"</td>"+"<td>"+c.getApeMater()+"</td>"+"<td>"+c.getTipoDocumento()+"</td>"+"<td>"+c.getNroDocumentoID()+"</td>"+"</tr>");
					
			out.println("</table>");
			
			 } catch (IOException e) {
			 throw new JspException("Error: " + e.getMessage());
			 }
			 return SKIP_BODY;
	}
}