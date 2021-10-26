package pe.edu.galaxy.training.ws.rest.rest;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestHeader;

import pe.edu.galaxy.training.ws.rest.authorization.AuthorizationManager;
import pe.edu.galaxy.training.ws.rest.bean.ClienteBean;
import pe.edu.galaxy.training.ws.rest.entidad.Cliente;
import pe.edu.galaxy.training.ws.rest.mapper.impl.ClienteMapperBean;
import pe.edu.galaxy.training.ws.rest.servicio.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.servicio.inf.ClienteService;
import pe.edu.galaxy.training.ws.rest.util.Base64Converter;
import sun.misc.BASE64Decoder;

@Controller
@RequestMapping("/clienteServiceREST")
public class ClienteREST {

	@Autowired
	private ClienteMapperBean clienteMapperBean;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private AuthorizationManager authorizationManager;

	@RequestMapping(value = "/listado", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<ClienteBean> getClientes() throws Exception {
		List<ClienteBean> lstCliente = new ArrayList<ClienteBean>();
		try {
			List<Cliente> lst = this.getClienteService().findByLikeObject(
					new Cliente());
			for (Cliente cliente : lst) {
				ClienteBean clienteBean = new ClienteBean();
				clienteBean = clienteMapperBean.transforEntityToBean(
						clienteBean, cliente);

				lstCliente.add(clienteBean);

			}

		} catch (ServiceException e) {

			e.printStackTrace();
		}

		return lstCliente;
	}

	@RequestMapping(value = "/listadoAuth", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Object getClientesAuth(
			@RequestHeader("Authorization") String credentials)
			throws Exception {
		
		System.out.println("auth " + credentials);
		String[] auth = Base64Converter.parseBase64binary(credentials);
		if (!authorizationManager.validateUser(auth[0], auth[1])) {
			return "{\"ret\":\"Usuario no autorizado\"}";
		}

		List<ClienteBean> lstCliente = new ArrayList<ClienteBean>();
		try {
			List<Cliente> lst = this.getClienteService().findByLikeObject(
					new Cliente());
			for (Cliente cliente : lst) {
				ClienteBean clienteBean = new ClienteBean();
				clienteBean = clienteMapperBean.transforEntityToBean(
						clienteBean, cliente);
				lstCliente.add(clienteBean);
			}

		} catch (ServiceException e) {

			e.printStackTrace();
		}

		return lstCliente;
	}

	@RequestMapping(value = "/listado/{razonSocial}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<ClienteBean> getClientesXRazonSocial(
			@PathVariable("razonSocial") String razonSocial) {
		System.out.println(razonSocial);
		List<ClienteBean> lstCliente = new ArrayList<ClienteBean>();

		try {

			List<Cliente> lst = this.getClienteService().listarXRazonSocial(
					razonSocial);

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

	@RequestMapping(value = "/buscarXRuc", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody ClienteBean buscarXRuc(@RequestParam("ruc") String ruc) {

		ClienteBean clienteBean = new ClienteBean();

		try {
			Cliente prmCliente = new Cliente();
			prmCliente.setRuc(ruc);
			Cliente cliente = this.getClienteService().buscarXRuc(prmCliente);

			try {
				BeanUtils.copyProperties(clienteBean, cliente);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (ServiceException e) {

			e.printStackTrace();
		}

		return clienteBean;
	}

	@RequestMapping(value = "/listadoQueryParam", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody List<ClienteBean> getClientesXRazonSocialQP(
			@RequestParam("razonSocial") String razonSocial) {
		System.out.println("QueryParam " + razonSocial);
		List<ClienteBean> lstCliente = new ArrayList<ClienteBean>();

		try {

			List<Cliente> lst = this.getClienteService().listarXRazonSocial(
					razonSocial);

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

	@RequestMapping(value = "/agregarPathParam/{razonSocial}/{ruc}/{direccion}", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody Cliente agregarPathParam(
			@PathVariable("razonSocial") String razonSocial,
			@PathVariable("ruc") String ruc,
			@PathVariable("direccion") String direccion) {

		ClienteBean clienteBean = new ClienteBean();
		clienteBean.setRazonSocial(razonSocial);
		clienteBean.setRuc(ruc);
		clienteBean.setDireccion(direccion);

		Cliente cliente = new Cliente();
		try {
			BeanUtils.copyProperties(cliente, clienteBean);
			this.getClienteService().insert(cliente);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cliente;
	}

	@RequestMapping(value = "/agregarRequestBody", consumes = "application/json; charset=utf-8", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
	public @ResponseBody String agregarRequestBody(
			@RequestBody ClienteBean clienteBean) {
		Cliente cliente = new Cliente();
		try {
			BeanUtils.copyProperties(cliente, clienteBean);

			if (this.getClienteService().validarRUC(cliente)) {
				return "{\"ret\":\"El ruc " + clienteBean.getRuc()
						+ " ya existe\"}";
			}

			this.getClienteService().insert(cliente);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{\"ret\":\"Exito al registrar el cliente\"}";
	}

	@RequestMapping(value = "/actualizarRequestBody", consumes = "application/json; charset=utf-8", produces = "application/json; charset=utf-8", method = RequestMethod.PUT)
	public @ResponseBody Cliente actualizarRequestBody(
			@RequestBody ClienteBean clienteBean) {
		Cliente cliente = new Cliente();
		try {
			BeanUtils.copyProperties(cliente, clienteBean);
			this.getClienteService().update(cliente);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}

	@RequestMapping(value = "/delete/{id}", produces = "application/json; charset=utf-8", method = RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable("id") String id) {
		System.out.println("id " + id);
		Cliente cliente = new Cliente();
		cliente.setIdCliente(Long.valueOf(id));
		boolean sw = false;
		try {
			sw = this.getClienteService().delete(cliente);

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
