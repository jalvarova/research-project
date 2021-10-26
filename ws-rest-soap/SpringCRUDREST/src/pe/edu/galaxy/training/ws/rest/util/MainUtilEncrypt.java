package pe.edu.galaxy.training.ws.rest.util;

import pe.edu.galaxy.training.ws.rest.util.UtilEncrypt;

public class MainUtilEncrypt {

	public MainUtilEncrypt() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UtilEncrypt.init("Training");
			System.out.println(UtilEncrypt.encrypt("admin"));
			System.out.println(UtilEncrypt.decrypt("7aCGbJsAjuI="));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
