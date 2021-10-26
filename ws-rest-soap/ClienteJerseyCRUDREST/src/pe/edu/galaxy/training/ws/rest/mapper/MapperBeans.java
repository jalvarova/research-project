package pe.edu.galaxy.training.ws.rest.mapper;

public abstract class MapperBeans<T,S> {

	public abstract T transforEntityToBean(S s);
}
