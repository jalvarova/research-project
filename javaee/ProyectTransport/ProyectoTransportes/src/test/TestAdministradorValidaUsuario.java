package test;

import static org.junit.Assert.*;

import org.junit.Test;

import beans.AdministradorDTO;
import services.AdministradorService;

public class TestAdministradorValidaUsuario {

	@Test
	public void testValidaMetodo() {

		TestValidaUsuario testvalidausuario = new TestValidaUsuario();

		assertTrue(testvalidausuario.ValidaAdministrador("KPILLACA","1234"));

	}

	@Test
	public void testValidaUsuarioNoExist() {

		TestValidaUsuario testvalidausuario = new TestValidaUsuario();

		assertFalse(testvalidausuario.ValidaAdministrador("24432", "1234"));

	}

	@Test
	public void testValidaUsuarioexist() {

		TestValidaUsuario testvalidausuario = new TestValidaUsuario();

		assertTrue(testvalidausuario.ValidaAdministrador("KPILLACA", "1234"));

	}
	@Test
	public void testValidaCamposVacios() {

		TestValidaUsuario testvalidausuario = new TestValidaUsuario();

		assertFalse(testvalidausuario.ValidaAdministrador("",""));

	}@Test
	public void testValidaCamposNoVacios() {

		TestValidaUsuario testvalidausuario = new TestValidaUsuario();

		assertTrue(testvalidausuario.ValidaAdministrador("KPILLACA", "1234"));

	}
	@Test
	public void testValidaUsuarioClaveLenghtMin() {

		TestValidaUsuario testvalidausuario = new TestValidaUsuario();

		assertFalse(testvalidausuario.ValidaAdministrador("APANTIGOSO","123"));
		
	}
	@Test
	public void testValidaUsuarioClaveLenghtMax() {

		TestValidaUsuario testvalidausuario = new TestValidaUsuario();

		assertFalse(testvalidausuario.ValidaAdministrador("APANTIGOSO","123488889"));

	}
	@Test
	public void testValidaUsuarioClaveLenghtCorrecto() {

		TestValidaUsuario testvalidausuario = new TestValidaUsuario();

		assertTrue(testvalidausuario.ValidaAdministrador("APANTIGOSO","1234"));

	}
	@Test
	public void testValidaUsuarioNoToUpper() {

		TestValidaUsuario testvalidausuario = new TestValidaUsuario();

		assertFalse(testvalidausuario.ValidaAdministrador("dasasd","1234"));

	}
	@Test
	public void testValidaUsuarioToUpper() {

		TestValidaUsuario testvalidausuario = new TestValidaUsuario();

		assertTrue(testvalidausuario.ValidaAdministrador("APANTIGOSO","1234"));

	}
	@Test
	public void testValidaUsuarioNoAlnumeric() {

		TestValidaUsuario testvalidausuario = new TestValidaUsuario();

		assertFalse(testvalidausuario.ValidaAdministrador("APANTIG132","1234"));

	}
	@Test
	public void testValidaUsuarioAlnumeric() {

		TestValidaUsuario testvalidausuario = new TestValidaUsuario();

		assertTrue(testvalidausuario.ValidaAdministrador("APANTIGOSO","1234"));

	}
	@Test
	public void testValidaCredencialesIncorrectas() {

		TestValidaUsuario testvalidausuario = new TestValidaUsuario();

		assertFalse(testvalidausuario.ValidaAdministrador("APANTIGOSO","12345"));

	}
	
	@Test
	public void testValidaCredencialesCorrectas() {

		TestValidaUsuario testvalidausuario = new TestValidaUsuario();

		assertTrue(testvalidausuario.ValidaAdministrador("APANTIGOSO","1234"));
   
	}
}