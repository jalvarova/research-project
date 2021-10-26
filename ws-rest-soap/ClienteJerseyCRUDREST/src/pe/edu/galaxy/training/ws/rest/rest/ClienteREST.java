package pe.edu.galaxy.training.ws.rest.rest;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import pe.edu.galaxy.training.ws.rest.bean.ClienteBean;
import pe.edu.galaxy.training.ws.rest.entidad.Cliente;
import pe.edu.galaxy.training.ws.rest.servicio.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.servicio.inf.ClienteService;

@Path("/clienteServiceREST")
public class ClienteREST extends SpringBeanAutowiringSupport{
	
	@Autowired
	private ClienteService clienteService;

	@GET
	@Path("/listado")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteBean> getClientes() {
		List<ClienteBean> lstCliente = new ArrayList<ClienteBean>();
		
		try {
			
			List<Cliente> lst= this.getClienteService().findByLikeObject(new Cliente());
					
			for (Cliente cliente : lst) {
				ClienteBean clienteBean = new ClienteBean(); 
				try {
					BeanUtils.copyProperties(clienteBean, cliente);
					lstCliente.add(clienteBean);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		
		return lstCliente;
	}

	@GET
	@Path("/listado/{razonSocial}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteBean> getClientesXRazonSocial(@PathParam("razonSocial")String razonSocial) {	
		System.out.println(razonSocial);
List<ClienteBean> lstCliente = new ArrayList<ClienteBean>();
		
		try {
			
			List<Cliente> lst= this.getClienteService().listarXRazonSocial(razonSocial);
					
			for (Cliente cliente : lst) {
				ClienteBean clienteBean = new ClienteBean(); 
				try {
					BeanUtils.copyProperties(clienteBean, cliente);
					lstCliente.add(clienteBean);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		
		return lstCliente;
	}

	@GET
	@Path("/listadoQueryParam")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteBean> getClientesXRazonSocialQP(@QueryParam("razonSocial")String razonSocial) {	
		System.out.println("QueryParam "+razonSocial);
		List<ClienteBean> lstCliente = new ArrayList<ClienteBean>();
		
		try {
			
			List<Cliente> lst= this.getClienteService().listarXRazonSocial(razonSocial);
					
			for (Cliente cliente : lst) {
				ClienteBean clienteBean = new ClienteBean(); 
				try {
					BeanUtils.copyProperties(clienteBean, cliente);
					lstCliente.add(clienteBean);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		
		return lstCliente;
	}
	
	@POST
	@Path("/agregarPathParam/{razonSocial}/{ruc}/{direccion}")
	public String agregarPathParam(
			@PathParam("razonSocial")String razonSocial,
			@PathParam("ruc")String ruc,
			@PathParam("direccion")String direccion) {
		
		ClienteBean clienteBean= new ClienteBean();
		clienteBean.setRazonSocial(razonSocial);
		clienteBean.setRuc(ruc);
		clienteBean.setDireccion(direccion);
		
		Cliente cliente= new Cliente(); 
		try {
			BeanUtils.copyProperties(cliente, clienteBean);
			this.getClienteService().insert(cliente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	@POST
	@Path("/agregarFormUrlencoded")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String agregarFormUrlencoded(
			@FormParam("razonSocial")String razonSocial,
			@FormParam("ruc")String ruc,
			@FormParam("direccion")String direccion) {
		
		System.out.println(razonSocial);
		System.out.println(ruc);
		System.out.println(direccion);
		
		return null;
	}
	
	@POST
	@Path("/agregarFormData")
	public String agregarFormData(
			@FormParam("razonSocial")String razonSocial,
			@FormParam("ruc")String ruc,
			@FormParam("direccion")String direccion) {
		
		System.out.println(razonSocial);
		System.out.println(ruc);
		System.out.println(direccion);
		
		return null;
	}


	@POST
	@Path("/agregarRequestBody")
	@Consumes(MediaType.APPLICATION_JSON)
	public Object agregarRequestBody(ClienteBean clienteBean){
		Cliente cliente= new Cliente(); 
		try {
			BeanUtils.copyProperties(cliente, clienteBean);
			
			if(this.getClienteService().validarRUC(cliente)){
				return "{\"ret\":\"El ruc "+ clienteBean.getRuc()+" ya existe\"}";
			}
			
			
			this.getClienteService().insert(cliente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	@PUT
	@Path("/actualizarRequestBody")
	@Consumes(MediaType.APPLICATION_JSON)
	public Cliente actualizarRequestBody(ClienteBean clienteBean){
		Cliente cliente= new Cliente(); 
		try {
			BeanUtils.copyProperties(cliente, clienteBean);
			this.getClienteService().update(cliente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String delete(@PathParam("id")String id){
		Cliente cliente= new Cliente();
		cliente.setIdCliente(Long.valueOf(id));
		boolean sw=false;
		try {
			sw=this.getClienteService().delete(cliente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(sw);
	}
	
	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
}
