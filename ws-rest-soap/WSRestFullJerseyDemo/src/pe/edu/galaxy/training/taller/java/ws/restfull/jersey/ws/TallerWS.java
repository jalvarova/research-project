package pe.edu.galaxy.training.taller.java.ws.restfull.jersey.ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pe.edu.galaxy.training.taller.java.ws.restfull.jersey.bean.LstTaller;
import pe.edu.galaxy.training.taller.java.ws.restfull.jersey.bean.Taller;

@WebServlet(name = "Jersey RESTful Application", urlPatterns = "/rest/*")
@Path("/tallerService")
public class TallerWS {

	private static List<Taller> lstTaller = new ArrayList<Taller>();

	static {
		lstTaller.add(new Taller(1, "Taller 1", "Taller 1 - Descripción"));
		lstTaller.add(new Taller(2, "Taller 2", "Taller 2 - Descripción"));
		lstTaller.add(new Taller(3, "Taller 3", "Taller 3 - Descripción"));

	}

	@GET
	@Path("/talleresXML")
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Taller> getTalleres() {

		return lstTaller;
	}

	@GET
	@Path("/taller/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Taller getTaller(@PathParam("id") String id) {

		return lstTaller.get(Integer.parseInt(id));
	}

	@GET
	@Path("/talleresJSON")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Taller> getTalleresJSON(@QueryParam("id") String id) {

		System.out.println("Id : " + id);
		return lstTaller;
	}

	@PUT
	@Path("/talleres")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response insert(@FormParam("nombre") String nombre, @FormParam("descripcion") String descripcion,
			@Context HttpServletResponse servletResponse) throws IOException {

		Taller taller = new Taller(1,nombre,descripcion);

		System.out.println(servletResponse.getContentType() + "/" + servletResponse.getStatus());
		
		return Response
				.status(200)
				.entity(taller)
				.build();
	}

	@POST
	@Path("/talleres")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Taller taller) throws IOException {
		
		 return Response
				.status(200)
				.entity(taller)
				.build();
	}

	@DELETE
	@Path("/talleres/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String deleteUser(@PathParam("id") int id) {
		System.out.println("id " + id);
		return "";
	}

	@OPTIONS
	@Path("/talleres")
	@Produces(MediaType.APPLICATION_XML)
	public String getSupportedOperations() {
		return "<operations>GET, PUT, POST, DELETE</operations>";
	}

}
