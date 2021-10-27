package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beanDTO.EstadoDTO;
import services.EstadoServices;

public class ComboEstado extends TagSupport {
	private static final long serialVersionUID = 1L;
@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.println("<option value='0'>Seleccionar</option>");
			EstadoServices servicio = new EstadoServices();
			ArrayList<EstadoDTO> lista = servicio. ListaEstado();

			for (EstadoDTO e : lista) {
				
			out.println("<option value='" + e.getCod_estado() + "'>" + e.getTipo_estado() + "</option>");
		}
			
		} catch (Exception e) {
			throw new JspException("Error Tag Combo: " + e.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

}
