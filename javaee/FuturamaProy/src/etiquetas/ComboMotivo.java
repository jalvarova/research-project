package etiquetas;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import services.EstadoServices;
import services.MotivoService;
import beanDTO.EstadoDTO;
import beanDTO.MotivoDTO;

public class ComboMotivo extends TagSupport  {

	
	private static final long serialVersionUID = 1L;
	@Override
		public int doStartTag() throws JspException {
			try {
				JspWriter out = pageContext.getOut();
				out.println("<option value='0'>Seleccionar</option>");
			 MotivoService servicio = new  MotivoService();
				ArrayList<MotivoDTO> lista = servicio.listaMotivo();

				for (MotivoDTO m : lista) {
					
				out.println("<option value='" + m.getCod_mot() + "'>" + m.getNom_mot() + "</option>");
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
