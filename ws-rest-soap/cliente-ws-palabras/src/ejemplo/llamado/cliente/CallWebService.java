package ejemplo.llamado.cliente;

import java.rmi.RemoteException;
import java.util.UUID;

import ejemplo.ws.soap.ServicioPalabrasProxy;

public class CallWebService {
	
	public static void main(String[] args) throws RemoteException {
		ServicioPalabrasProxy ws = new ServicioPalabrasProxy();
		String message =
				ws.reportePalabra("ABC efg 123");
		System.out.println(message);
		
		String name = "Alvaro";
		String lastname = "Aguinaga";
		String code = UUID.randomUUID().toString();
		String ano = "2016";
		String age = "24";
		String curs = "Matemática";
		
		String result = ws.generaCodigo(name, lastname, code, ano, age, curs);
		
		System.out.println(result);
	}

}
