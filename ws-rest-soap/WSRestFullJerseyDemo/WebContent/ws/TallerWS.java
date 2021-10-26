package pe.edu.galaxy.training.taller.java.ws.restfull.jersey.ws;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pe.edu.galaxy.training.taller.java.ws.restfull.jersey.bean.Taller;

@Path("/TallerService")
public class TallerWS {

	 @GET
	   @Path("/talleres")
	   @Produces(MediaType.APPLICATION_XML)
	   public List<Taller> getTalleres(){
		 List<Taller> lstTaller= new ArrayList<Taller>();
		 lstTaller.add(new Taller(1, "Taller 1","Taller 1 - Descripción"));
		 lstTaller.add(new Taller(1, "Taller 2","Taller 2 - Descripción"));
		 lstTaller.add(new Taller(1, "Taller 3","Taller 3 - Descripción"));
	     return lstTaller;
	   }	
}
