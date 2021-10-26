package pe.edu.galaxy.training.ws.rest.authorization;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.galaxy.training.ws.rest.entidad.User;
import pe.edu.galaxy.training.ws.rest.servicio.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.servicio.inf.UserService;
import pe.edu.galaxy.training.ws.rest.util.UtilEncrypt;

@Component
public class AuthorizationManager {

	@Autowired
	private UserService userService; 
	
	public boolean validateUser(String user, String password) throws ServiceException, UnsupportedEncodingException, GeneralSecurityException{
		
		User userValidate = new User();
		userValidate.setUser(user);
		userValidate.setPassword(UtilEncrypt.encrypt(password));
		
		User userValidat;
		try {
			userValidat = userService.validateAccess(user, password);
			if (userValidat !=null) {
				return true;
			}
		} catch (ServiceException e) {
			throw new ServiceException("User Denegeit");
		}
		return false;
	}
}
