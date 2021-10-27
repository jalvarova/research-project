package etiquetas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import services.RutaService;
import beans.RutaDTO;

public class ComboRuta extends TagSupport{
	private static final long serialVersionUID = 1L;
	
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.println("<select name='cboRuta'>");
			out.println("<option value='0'>Seleccione</option>");
			RutaService servicio = new RutaService();
			List<RutaDTO> lista = servicio.getListadoRutas();

			for (int i = 0; i < lista.size(); i++) {
				RutaDTO x = lista.get(i);
				out.println("<option value=" + x.getCodRuta() + ">"
						+ x.getCiudadOrigen()+"-"+x.getCiudadDestino() + "</option>");
			}
			out.println("</select>");
		} catch (IOException e) {
			throw new JspException("Error Tag Ruta: " + e.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}