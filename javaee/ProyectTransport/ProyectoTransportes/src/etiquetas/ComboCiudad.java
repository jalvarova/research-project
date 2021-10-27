package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import services.CiudadService;
import beans.CiudadDTO;

public class ComboCiudad extends TagSupport {
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.println("<select name='cboCiudad'>");
			out.println("<option value='0'>Seleccione</option>");
			CiudadService servicios = new CiudadService();
			ArrayList<CiudadDTO> lista = servicios.listarCiudad();

			for (int i = 0; i < lista.size(); i++) {
				CiudadDTO x = lista.get(i);
				out.println("<option value=" + x.getCodciudad() + ">"
						+ x.getNomCiudad() + "</option>");
			}
			out.println("</select>");
		} catch (IOException e) {
			throw new JspException("Error: " + e.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}
