package pe.edu.galaxy.training.ws.rest.util;

import sun.misc.BASE64Decoder;

public class Base64Converter {

	public static String[] parseBase64binary(String base64){
		
			String[] data = base64.split("\\s+");
			for (String d : data) {
				System.out.println(d);
			}
			String encripta = data[1];
			System.out.println("encripta " + encripta);

			byte[] bytes = null;
			try {
				bytes = new BASE64Decoder().decodeBuffer(encripta);
			} catch (Exception e) {

				e.printStackTrace();
			}
			String decode = new String(bytes);

			System.out.println(decode);
			String[] credenciales = decode.split(":");
			for (String s : credenciales) {
				System.out.println(s);
			}	
			return credenciales;
	}
}
