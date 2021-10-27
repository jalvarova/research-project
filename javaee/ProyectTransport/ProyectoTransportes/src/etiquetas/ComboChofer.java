package etiquetas;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import services.ChoferService;
import beans.ChoferDTO;

public class ComboChofer extends TagSupport{
	private static final long serialVersionUID = 1L;
	
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.println("<select name='cboChofer'>");
			out.println("<option value='0'>Seleccione</option>");
			ChoferService servicio = new ChoferService();
			ArrayList<ChoferDTO> lista = servicio.listaChofer();

			for (int i = 0; i < lista.size(); i++) {
				ChoferDTO x = lista.get(i);
				out.println("<option value=" + x.getCodigo() + ">"
						+ x.getNombre()+" "+x.getApePater() + "</option>");
			}
			out.println("</select>");
		} catch (IOException e) {
			throw new JspException("Error Tag Chofer: " + e.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}