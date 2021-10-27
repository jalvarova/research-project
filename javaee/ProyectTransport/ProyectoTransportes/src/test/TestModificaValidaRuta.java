package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import services.RutaService;
import beans.CiudadDTO;
import beans.RutaDTO;

public class TestModificaValidaRuta {



	@Test
	public void test() {
		TestModificaRuta testruta = new TestModificaRuta();
		
		CiudadDTO cuidadorigen = new CiudadDTO("CI001");
		CiudadDTO cuidadDestino = new CiudadDTO("CI009");
		
		RutaDTO x = new RutaDTO("RU017",cuidadorigen,cuidadDestino,45.00,"12:00:00",0);
		
		assertFalse(testruta.modificarRuta(x));
	}

	@Test
	public void testRutaDestinoNoOrigen() {
		
		
		TestModificaRuta testruta = new TestModificaRuta();
		
		
		CiudadDTO cuidadorigen = new CiudadDTO("CI001");
		CiudadDTO cuidadDestino = new CiudadDTO("CI009");
		
		RutaDTO x = new RutaDTO("RU017",cuidadorigen,cuidadDestino,45.00,"12:00:00",0);
		
	
		assertFalse(testruta.modificarRuta(x));
	}

	@Test
	public void testRutaDestinoOrigen() {
		TestModificaRuta testruta = new TestModificaRuta();
		CiudadDTO cuidadorigen = new CiudadDTO("CI001");
		CiudadDTO cuidadDestino = new CiudadDTO("CI009");
		
		RutaDTO x = new RutaDTO("RU001",cuidadorigen,cuidadDestino,45.00,"12:00:00",0);
		

		assertTrue(testruta.modificarRuta(x));
	}
	@Test
	public void testRutaOrigenDestino() {
		TestModificaRuta testruta = new TestModificaRuta();
		CiudadDTO cuidadorigen = new CiudadDTO("CI001");
		CiudadDTO cuidadDestino = new CiudadDTO("CI001");
		
		RutaDTO x = new RutaDTO("RU001",cuidadorigen,cuidadDestino,45.00,"12:00:00",0);
		

		assertFalse(testruta.modificarRuta(x));
	}
	@Test
	public void testRutaOrigenDestinoDistintos() {
		TestModificaRuta testruta = new TestModificaRuta();
		CiudadDTO cuidadorigen = new CiudadDTO("CI001");
		CiudadDTO cuidadDestino = new CiudadDTO("CI009");
		
		RutaDTO x = new RutaDTO("RU001",cuidadorigen,cuidadDestino,45.00,"12:00:00",0);
		

		assertTrue(testruta.modificarRuta(x));
	}
	
	@Test
	public void testValidarFormatoHora() {
		TestModificaRuta testruta = new TestModificaRuta();
		CiudadDTO cuidadorigen = new CiudadDTO("CI001");
		CiudadDTO cuidadDestino = new CiudadDTO("CI009");
		
		RutaDTO x = new RutaDTO("RU001",cuidadorigen,cuidadDestino,45.00,"12:00:00",0);
		

		assertTrue(testruta.modificarRuta(x));
	}
	
	@Test
	public void testValidarNoFormatoHora() {
		TestModificaRuta testruta = new TestModificaRuta();
		CiudadDTO cuidadorigen = new CiudadDTO("CI001");
		CiudadDTO cuidadDestino = new CiudadDTO("CI009");
		
		RutaDTO x = new RutaDTO("RU001",cuidadorigen,cuidadDestino,45.00,"12",0);
		

		assertFalse(testruta.modificarRuta(x));
	}
	@Test
	public void RutaHabilitado() {
		TestModificaRuta testruta = new TestModificaRuta();
		CiudadDTO cuidadorigen = new CiudadDTO("CI001");
		CiudadDTO cuidadDestino = new CiudadDTO("CI009");
		
		RutaDTO x = new RutaDTO("RU001",cuidadorigen,cuidadDestino,45.00,"12:00:00",1);
		testruta.modificarRuta(x);

		assertEquals(x.getEstado(), 1);
	}	@Test
	public void RutaDeshabilitado() {
		TestModificaRuta testruta = new TestModificaRuta();
		CiudadDTO cuidadorigen = new CiudadDTO("CI001");
		CiudadDTO cuidadDestino = new CiudadDTO("CI009");
		
		RutaDTO x = new RutaDTO("RU001",cuidadorigen,cuidadDestino,45.00,"12:00:00",0);
		testruta.modificarRuta(x);

		assertEquals(x.getEstado(), 0);
	}
//	@Test
//	public void testNoSonNumeros() {
//		TestModificaRuta testruta = new TestModificaRuta();
//		CiudadDTO cuidadorigen = new CiudadDTO("CI001");
//		CiudadDTO cuidadDestino = new CiudadDTO("CI009");
//		
//		String cadena = "asdasd";
//		double cantidad = Double.parseDouble(cadena);
//		
//		RutaDTO x = new RutaDTO("RU001",cuidadorigen,cuidadDestino,cantidad,"12:00:00",0);
//		
//
//		assertFalse(testruta.modificarRuta(x));
//	}
}
