package pe.edu.galaxy.training.ws.rest.mapper;

import org.apache.commons.beanutils.BeanUtils;

public abstract class MapperBeans<T, S> {

	public T transforEntityToBean(T t, S s) throws Exception {
		BeanUtils.copyProperties(t, s);
		return t;

	}

}
