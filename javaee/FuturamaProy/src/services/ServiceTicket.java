package services;


import interfaces.TicketDAO;
import dao.DAOFactory;
import beanDTO.TicketDTO;

public class ServiceTicket {
	
	//creacion de la fuente de datos usada
private DAOFactory fabrica = DAOFactory.getDaoFactory(1);
// instanciar las rutinas usando la fuente
private TicketDAO objTicketDAO=fabrica.getTicketDAO();

	public TicketDTO MostrarTicket(TicketDTO ti){
		return objTicketDAO.MostrarTicket(ti);
		
		
	}
}
