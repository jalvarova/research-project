package pe.edu.galaxy.training.ws.rest.rest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.galaxy.training.ws.rest.bean.VehiculoBean;
import pe.edu.galaxy.training.ws.rest.entidad.Vehiculo;
import pe.edu.galaxy.training.ws.rest.mapper.impl.VehiculoMapperBean;
import pe.edu.galaxy.training.ws.rest.servicio.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.servicio.inf.VehiculoService;

@Controller
@RequestMapping("/vehiculo")
public class VehiculoREST {

	@Autowired
	private VehiculoMapperBean vehiculoMapperBean;
	@Autowired
	private VehiculoService vehiculoService;

	@RequestMapping(value = "/listado/{licenseplate}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public VehiculoBean findByLicensePlate(
			@PathVariable("licenseplate") String licensePlate) {
		VehiculoBean vehiculoBean = new VehiculoBean();
		try {

			Vehiculo vehiculo = this.vehiculoService
					.findByLicensePlate(licensePlate);

			try {
				vehiculoBean = vehiculoMapperBean.transforEntityToBean(vehiculoBean,vehiculo);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (ServiceException e) {

			e.printStackTrace();
		}

		return vehiculoBean;
	}

	@RequestMapping(value = "/findyear", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody List<VehiculoBean> findByYear(
			@RequestParam("year") String year) {

		List<VehiculoBean> vehiculos = new ArrayList<>();

		try {
			List<Vehiculo> vehiculoService = this.vehiculoService
					.findByYear(year);
			if (vehiculoService.size() > 0) {
				for (Vehiculo vehiculo : vehiculoService) {
					VehiculoBean vehiculoBean = new VehiculoBean();
					try {
						vehiculoBean = vehiculoMapperBean.transforEntityToBean(
								vehiculoBean, vehiculo);
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
				System.out.println("Error En el Servidor: "
						+ Response.status(500).allow(urlAllow).toString());
			}
		} catch (ServiceException e) {
			System.out.println("Error de Service" + e.getMessage());
			e.printStackTrace();
		}

		return vehiculos;
	}
}
