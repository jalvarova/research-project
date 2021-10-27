package etiquetas;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import services.TipoDocumentoService;
import beans.TipoDocumentoDTO;

public class ComboDocumento extends TagSupport{
	private static final long serialVersionUID = 1L;
	
	public int doStartTag() throws JspException {
		JspWriter out=null;
		try {
			 out = pageContext.getOut();
			 out.println("<select name='cboTipoDocumento'>");
			 out.println("<option value=\"0\">--Seleccione--</option>");
			 TipoDocumentoService servicios = new TipoDocumentoService();
			 ArrayList<TipoDocumentoDTO> lista = servicios.listarTipoDocumento();
			 
			 for (int i = 0; i<lista.size(); i++){
				 TipoDocumentoDTO x = lista.get(i);
				 out.println("<option value="+x.getIdTipoDocumento()+">" + x.getNombreTipoDocumento()+"</option>");
			 }
			 out.println("</select>");

		} catch (IOException e) {
		throw new JspException("Error: " + e.getMessage());
		}
		return SKIP_BODY;
		}
		public int doEndTag() throws JspException {
		// acciones al finalizar la etiqueta
		return EVAL_PAGE;
		}
}
