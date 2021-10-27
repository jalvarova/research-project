package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestRegistroValidaCliente {

	
	public byte[] foto = "".getBytes();

	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void testValidaCodigoInvalido() {

		TestRegistroCliente testvalidausuario = new TestRegistroCliente();
       
		assertFalse(testvalidausuario.registroCliente("CL00", "Alvaro", "Aguianga", "Delgado", "1", 47082903, "M",
				"alvaro_9218@hotmail.com", 4373715,"1992/03/27", "CI002",foto, 1, "Aaguinaga", "12345"));

	}
	@Test
	public void testValidaCodigo() {

		TestRegistroCliente testvalidausuario = new TestRegistroCliente();
       
		assertTrue(testvalidausuario.registroCliente("CL007", "Alvaro", "Aguianga", "Delgado", "1", 47082903, "M",
				"alvaro_9218@hotmail.com", 4373715,"1992/03/27", "CI002",foto, 1, "Aaguinaga", "12345"));
	}
	
	@Test
	public void testValidarCorreo() {

		TestRegistroCliente testvalidausuario = new TestRegistroCliente();
       
			assertTrue(testvalidausuario.registroCliente("CL008","Diego", "Aguinaga", "123", "1", 47082903, "M",
				"alvaro_9218@hotmail.com", 4373715,"1992/03/27", "CI002",foto, 1, "Daguinaga", "12345"));
	}
	
	@Test
	public void testValidarNoCorreo() {

		TestRegistroCliente testvalidausuario = new TestRegistroCliente();
       
			assertFalse(testvalidausuario.registroCliente("CL015","Diego", "Aguinaga", "123", "1", 46809321, "M",
				"dienato_9218hhl", 4373715,"1992/03/27", "CI002",foto, 1, "Daguinaga", "12345"));
	}
	

	@Test
	public void testValidarNombresNOCadenas() {

		TestRegistroCliente testvalidausuario = new TestRegistroCliente();
       
			assertFalse(testvalidausuario.registroCliente("CL009","21312", "123", "123", "1", 47655634, "M",
				"alvaro_9218@hotmail.com", 4373715,"1992/03/27", "CI002",foto, 1, "Gaguinaga", "12345"));
	}
	
	@Test
	public void testValidarNombresCadenas() {

		TestRegistroCliente testvalidausuario = new TestRegistroCliente();
       
		assertTrue(testvalidausuario.registroCliente("CL010", "Gonzalo", "Aguianga", "Delgado", "1", 47655634, "M",
				"alvaro_9218@hotmail.com", 4373715,"1992/03/27", "CI002",foto, 1, "Gaguinaga", "12345"));
	}
	
	@Test
	public void testValidarNumeroDNI() {

		TestRegistroCliente testvalidausuario = new TestRegistroCliente();
       
		assertTrue(testvalidausuario.registroCliente("CL011", "Susan", "Paucar", "Usca", "1", 89782412, "F",
				"susanararacelli@hotmail.com", 4373715,"1992/03/27", "CI002",foto, 1, "Aaguinaga", "12345"));
	}
	@Test
	public void testValidarNoesDocumento() {

		TestRegistroCliente testvalidausuario = new TestRegistroCliente();
       
		assertFalse(testvalidausuario.registroCliente("CL012", "Susan", "Paucar", "Usca", "1", 1047082903, "F",
				"susanararacelli@hotmail.com", 4373715,"1992/03/27", "CI002",foto, 1, "SPaucar", "12345"));
	}
	@Test
	public void testValidarNumeroTelefono() {

		TestRegistroCliente testvalidausuario = new TestRegistroCliente();
       
		assertTrue(testvalidausuario.registroCliente("CL013", "Luciana", "Aguinaga", "Delgado", "1", 89545544, "F",
				"lu@hotmail.com", 4373715,"1992/03/27", "CI002",foto, 1, "Laguinaga", "12345"));
	}
	@Test
	public void testValidarNoNumeroTelefono() {

		TestRegistroCliente testvalidausuario = new TestRegistroCliente();
       
		assertFalse(testvalidausuario.registroCliente("CL014", "Alvaro", "Aguianga", "Delgado", "1", 47082903, "F",
				"lu@hotmail.com", 123,"1992/03/27", "CI002",foto, 1, "Aaguinaga", "12345"));
	}
	
	@Test
	public void testClaveNoValida() {

		TestRegistroCliente testvalidausuario = new TestRegistroCliente();
       
		assertFalse(testvalidausuario.registroCliente("CL016", "Maria", "Delgado", "Vasquez", "1", 47082903, "F",
				"brujis65@hotmail.com", 4373715,"1992/03/27", "CI002",foto, 1, "MDelagado", "1234"));
	}
	@Test
	public void testClaveValida() {

		TestRegistroCliente testvalidausuario = new TestRegistroCliente();
       
		assertTrue(testvalidausuario.registroCliente("CL017",  "Maria", "Delgado", "Vasquez", "1", 47082903, "F",
				"brujis65@hotmail.com", 4373715,"1992/03/27", "CI002",foto, 1, "MDelagado", "12345"));
	}
	
	@Test
	public void testCodigoExiste() {

		TestRegistroCliente testvalidausuario = new TestRegistroCliente();
       
		assertFalse(testvalidausuario.registroCliente("CL001", "Alvaro", "Aguianga", "Delgado", "1", 47082903, "M",
				"alvaro_9218@hotmail.com", 4373715,"1992/03/27", "CI002",foto, 1, "jatuncar", "12345"));
	}
	
	@Test
	public void testCodigoNoExiste() {

		TestRegistroCliente testvalidausuario = new TestRegistroCliente();
       
		assertTrue(testvalidausuario.registroCliente("CL018", "Carlos", "Aguianga","Anaya", "1", 87878952, "M",
				"carlosA@hotmail.com", 4373715,"1992/03/27", "CI002",foto, 1, "CAguinaga", "12345"));
	}
	
//	@Test
//	public void test() {
//
//		TestRegistroCliente testvalidausuario = new TestRegistroCliente();
//       
//		assertFalse(testvalidausuario.registroCliente("CL008", "Alvaro", "Aguianga", "Delgado", "1", 47082903, "M",
//				"alvaro_9218@hotmail.com", 4373715,"1992/03/27", "CI002",foto, 1, "Aaguinaga", "12345"));
//
//	}

	
}
