package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelos.ControladorFuncionarios;
import modelos.Funcionario;
import modelos.ItemCardapio;

/**
 * @author Wagner Alexandre
 * @author Antonio Felipe
 */
class ControladorFuncionariosTest {
	

	@BeforeEach
	void limpadordeLista() {
		ControladorFuncionarios.getListaFuncionarios().clear();
	}

	/**
	 * Metodo de teste para o construtor vazio do controlador.
	 */
	
	@Test
	void testaConstrutor() {
		ControladorFuncionarios teste = new ControladorFuncionarios();
		assertNotNull(teste);
	}
	
	/**
	 * Test method for
	 * {@link modelos.ControladorCardapio#create(java.lang.String, java.lang.String, int, double)}.
	 */

	@Test
	void testCreatePrimeiroSegundoItem() {
		String nome = "Eu";
		String senha = "123";
		ControladorFuncionarios.create(nome, senha);
		ControladorFuncionarios.create(nome, senha);
		assertEquals("FNCRS2", ControladorFuncionarios.getListaFuncionarios().get(1).getId());
	}

	/**
	 * Test method for {@link modelos.ControladorCardapio#read()}.
	 */

	@Test
	void testRead() {
		String nome = "Eu";
		String senha = "123";
		ControladorFuncionarios.create(nome, senha);
		assertTrue(ControladorFuncionarios.read());
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorCardapio#update(java.lang.String, int, java.lang.String)}.
	 */
	@Test
	void testUpdate() {
		String nome = "Fulanao";
		String senha = "123";
		ControladorFuncionarios.create(nome, senha);		
		String id = "FNCRS1";
		String newContent = "Fulanooo";
		assertTrue(ControladorFuncionarios.update(id, newContent));
	}
	
	/**
	 * Test method for
	 * {@link modelos.ControladorCardapio#update(java.lang.String, int, java.lang.String)}.
	 */
	@Test
	void testUpdateFalha() {
		String nome = "Fulanao";
		String senha = "123";
		ControladorFuncionarios.create(nome, senha);
		String id = "FNCRS2";
		String newContent = "Fulanooo";
		assertFalse(ControladorFuncionarios.update(id, newContent));
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorCardapio#delete(java.lang.String)}.
	 */
	@Test
	void testDelete() {
		String nome = "Fulanooo";
		String senha = "123";
		
		ControladorFuncionarios.create(nome, senha);
		String id = "FNCRS1";
		assertTrue(ControladorFuncionarios.delete(id));
	}
	
	/**
	 * Test method for
	 * {@link modelos.ControladorCardapio#delete(java.lang.String)}.
	 */
	@Test
	void testDeleteFalse() {
		String nome = "Fulanooo";
		String senha = "123";
		ControladorFuncionarios.create(nome, senha);

		assertFalse(ControladorFuncionarios.delete("FNCRS2"));
	}


	/**
	 * Test method for {@link modelos.ControladorCardapio#read()}.
	 */

	@Test
	void testReadFalse() {
		assertFalse(ControladorFuncionarios.read());
	}

	/**
	 * Test method for {@link modelos.ControladorCardapio#createId()}.
	 */

	@Test

	void testCreate1() {
		String nome = "Ele";
		ItemCardapio novo = new ItemCardapio();
		novo.setId(ControladorFuncionarios.createId());
		novo.setNome(nome);
		String idTeste = novo.getId();
		assertEquals("FNCRS1", idTeste);
	}

	@Test
	void testCheckIdSenhaTrue(){
		String nome = "Ele";
		String senha = "123";
		Funcionario teste = ControladorFuncionarios.create(nome, senha);
		
		assertTrue(ControladorFuncionarios.checkIdSenha("FNCRS1", senha));
	}

	@Test
	void testCheckIdSenhaFalse(){
		String nome = "Ele";
		String senha = "123";
		ControladorFuncionarios.create(nome, senha);
		assertFalse(ControladorFuncionarios.checkIdSenha("FRNCRS2", "1234"));
	}

}
