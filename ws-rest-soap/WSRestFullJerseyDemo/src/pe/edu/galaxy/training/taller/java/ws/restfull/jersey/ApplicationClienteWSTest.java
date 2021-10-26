package pe.edu.galaxy.training.taller.java.ws.restfull.jersey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.sun.research.ws.wadl.HTTPMethods;

public class ApplicationClienteWSTest {

	public static void main(String[] args) throws IOException {

		String output;

		HttpURLConnection connXML = (HttpURLConnection) resolveUri("talleresXML").openConnection();
		connXML.setRequestMethod(HTTPMethods.GET.toString());
		connXML.setRequestProperty("Content-Type", "application/xml; charset=utf8");
		connXML.setRequestProperty("Accept", "application/xml");

		if (connXML.getResponseCode() != HttpURLConnection.HTTP_OK) {
			throw new RuntimeException(
					"Failed : HTTP error code : " + connXML.getResponseCode() + connXML.getResponseMessage());
		}

		BufferedReader brXMl = new BufferedReader(new InputStreamReader((connXML.getInputStream())));

		System.out.println("Output from Server .... \n");
		while ((output = brXMl.readLine()) != null) {
			System.out.println("Response XMl: " + output);
		}
		connXML.disconnect();
		
		HttpURLConnection connGet = (HttpURLConnection) resolveUri("talleresJSON").openConnection();
		connGet.setRequestMethod(HTTPMethods.GET.toString());
		connGet.setRequestProperty("Content-Type", "application/json; charset=utf8");
		connGet.setRequestProperty("Accept", "application/json");

		if (connGet.getResponseCode() != HttpURLConnection.HTTP_OK) {
			throw new RuntimeException(
					"Failed : HTTP error code : " + connGet.getResponseCode() + connGet.getResponseMessage());
		}

		BufferedReader brGet = new BufferedReader(new InputStreamReader((connGet.getInputStream())));

		System.out.println("Output from Server .... \n");
		while ((output = brGet.readLine()) != null) {
			System.out.println("Response XML: " + output);
		}
		connGet.disconnect();


		HttpURLConnection conn = (HttpURLConnection) resolveUri("talleres").openConnection();
		conn.setRequestMethod(HTTPMethods.POST.toString());
		conn.setRequestProperty("Content-Type", "application/json; charset=utf8");
		conn.setRequestProperty("Accept", "application/json");
		conn.setDoOutput(true);

		String input = "{\"id\":1,\"nombre\":\"alvaro\",\"descripcion\":\"iPad 4\"}";

		OutputStream oss = conn.getOutputStream();
		oss.write(input.getBytes());
		oss.flush();

		if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
			throw new RuntimeException(
					"Failed : HTTP error code : " + conn.getResponseCode() + conn.getResponseMessage());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println("Response: " + output);
		}
		conn.disconnect();
	}

	private static URL resolveUri(String path) throws IOException {
		String baseUrl = "http://localhost:8080/WSRestFullJerseyDemo/rest/tallerService/";
		URL url = new URL(baseUrl + path);
		return url;
	}
}
