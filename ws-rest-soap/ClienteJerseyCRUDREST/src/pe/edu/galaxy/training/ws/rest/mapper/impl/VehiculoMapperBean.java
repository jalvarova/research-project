package pe.edu.galaxy.training.ws.rest.mapper.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;

import pe.edu.galaxy.training.ws.rest.bean.VehiculoBean;
import pe.edu.galaxy.training.ws.rest.entidad.Vehiculo;
import pe.edu.galaxy.training.ws.rest.mapper.MapperBeans;

@Component
public class VehiculoMapperBean extends MapperBeans<VehiculoBean, Vehiculo> {

	@Override
	public VehiculoBean transforEntityToBean(Vehiculo vehiculo) {
		VehiculoBean vehiculoBean = new VehiculoBean();

		try {
			BeanUtils.copyProperties(vehiculoBean, vehiculo);
		} catch (Exception e) {
			System.out.println("Error de mapper " + e.getLocalizedMessage());
		}
		return vehiculoBean;
	}

}
