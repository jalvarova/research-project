package etiquetas;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import beans.TerramozaDTO;
import services.TerramozaService;

public class ComboTerramoza extends TagSupport{
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.println("<select name='cboTerramoza'>");
			out.println("<option value='0'>Seleccione</option>");
			TerramozaService servicio = new TerramozaService();
			ArrayList<TerramozaDTO> lista = servicio.listaTerramoza();

			for (int i = 0; i < lista.size(); i++) {
				TerramozaDTO x = lista.get(i);
				out.println("<option value=" + x.getCodigo() + ">"
						+ x.getNombre()+" "+x.getApePater() + "</option>");
			}
			out.println("</select>");
		} catch (IOException e) {
			throw new JspException("Error Tag Terramoza: " + e.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}