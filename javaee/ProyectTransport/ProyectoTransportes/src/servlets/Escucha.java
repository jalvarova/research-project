package servlets;

import java.util.ArrayList;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import beans.BoletoDTO;

@WebListener
public class Escucha implements HttpSessionListener {
    public Escucha() {
 
    }
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	System.out.println("Escuchando sesion"+
         arg0.getSession().getId());
    	ArrayList<BoletoDTO> lista = new ArrayList<BoletoDTO>();
    	arg0.getSession().setAttribute("carrito", lista);
    	
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	arg0.getSession().removeAttribute("carrito");
    }
}