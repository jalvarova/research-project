package pe.edu.galaxy.training.ws.rest.rest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pe.edu.galaxy.training.ws.rest.bean.VehiculoBean;
import pe.edu.galaxy.training.ws.rest.entidad.Vehiculo;
import pe.edu.galaxy.training.ws.rest.mapper.impl.VehiculoMapperBean;
import pe.edu.galaxy.training.ws.rest.servicio.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.servicio.inf.VehiculoService;

@Path("/vehiculo")
public class VehiculoREST extends SpringBeanAutowiringSupport {

	@Autowired
	private VehiculoMapperBean vehiculoMapperBean;
	@Autowired
	private VehiculoService vehiculoService;

	@GET
	@Path("/listado/{licenseplate}")
	@Produces(MediaType.APPLICATION_JSON)
	public VehiculoBean findByLicensePlate(
			@PathParam("licenseplate") String licensePlate) {
		VehiculoBean vehiculoBean = new VehiculoBean();
		try {

			Vehiculo vehiculo = this.vehiculoService
					.findByLicensePlate(licensePlate);

			try {
				vehiculoBean = vehiculoMapperBean.transforEntityToBean(vehiculo);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (ServiceException e) {

			e.printStackTrace();
		}

		return vehiculoBean;
	}

	@GET
	@Path("/findyear/{year}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<VehiculoBean> findByYear(@PathParam("year") String year) {

		List<VehiculoBean> vehiculos = new ArrayList<>();

		try {
			List<Vehiculo> vehiculoService = this.vehiculoService
					.findByYear(year);
			if (vehiculoService.size() > 0) {
				for (Vehiculo vehiculo : vehiculoService) {
					VehiculoBean vehiculoBean = new VehiculoBean();
					try {
						vehiculoBean = vehiculoMapperBean.transforEntityToBean(vehiculo);
						vehiculos.add(vehiculoBean);
					} catch (Exception e) {
						System.out.println("Error de CopyProperties"
								+ e.getMessage());
						e.printStackTrace();
					}
				}
			} else {
				Set<String> urlAllow = new HashSet<>();
				urlAllow.add("/login");
				System.out.println("Error En el Servidor: " + Response.status(500).allow(urlAllow).toString());
			}
		} catch (ServiceException e) {
			System.out.println("Error de Service" + e.getMessage());
			e.printStackTrace();
		}

		return vehiculos;
	}
}
