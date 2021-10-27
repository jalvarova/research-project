package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AdministradorDTO;
import beans.ClienteDTO;

@WebFilter("/UsuarioLogueado")
public class UsuarioLogueado implements Filter {
	
	@SuppressWarnings("unused")
	private FilterConfig filterConfig = null;
	
	public void destroy() {
		filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String url = req.getServletPath();
					
		if(!url.equals("/Logueo.jsp")&&!url.equals("/logueando")&&!url.equals("/error.jsp")&&!url.equals("/Principal.jsp")&&!url.equals("/RegistroCliente.jsp")&&!url.equals("/Destinos.jsp")&&!url.equals("/LaEmpresa.jsp")&&!url.equals("/Promociones.jsp")){
			HttpSession sesion = req.getSession();
			AdministradorDTO admin = (AdministradorDTO) sesion.getAttribute("datosconsesion");
			ClienteDTO cli = (ClienteDTO) sesion.getAttribute("sesioncliente");
			if(admin == null && cli == null){
				res.sendRedirect("error.jsp");
			}
		}
		System.out.println("Todo Ok con el Filtro - Filtrando..");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//this.filterConfig = fConfig;;
	}
}