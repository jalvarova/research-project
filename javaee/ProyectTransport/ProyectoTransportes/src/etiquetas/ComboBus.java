package etiquetas;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import services.BusService;
import beans.BusDTO;

public class ComboBus extends TagSupport{
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.println("<select name='cboBus'>");
			out.println("<option value='0'>Seleccione</option>");
			BusService servicio = new BusService();
			ArrayList<BusDTO> lista = servicio.listarBuses();

			for (int i = 0; i < lista.size(); i++) {
				BusDTO x = lista.get(i);
				out.println("<option value=" + x.getNroPlaca() + ">"
						+ x.getNroPlaca() + "</option>");
			}
			out.println("</select>");
		} catch (IOException e) {
			throw new JspException("Error Tag Bus: " + e.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}