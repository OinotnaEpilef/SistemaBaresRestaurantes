
package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelos.ControladorGerentes;
import modelos.Gerente;

/**
 * @author Wagner Alexandre
 * @author Antonio Felipe
 */
class ControladorGerentesTest {
	/**
	 * Teste para contrutor vazio/padrao
	 */
	@Test
	void testaContrutor() {
		ControladorGerentes teste = new ControladorGerentes();
		assertNotNull(teste);
	}

	@BeforeEach
	void limparLista() {
		ControladorGerentes.listaGerentes.clear();
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorGerentes#create(java.lang.String)}.
	 */
	@Test
	void testCreate() {
		String nome = "ricardo";
		String senha = "123";
		ControladorGerentes.create(nome, senha);
		assertEquals("GRNTS1", ControladorGerentes.getListaGerentes().get(0).getId());
	}

	/**
	 * Test method for {@link modelos.ControladorGerentes#createId()}.
	 */
	@Test
	void testCreateId() {
		String nome = "Jao";
		Gerente g2 = new Gerente();
		g2.setNome(nome);
		g2.setId(ControladorGerentes.createId());
		String id = g2.getId();
		assertEquals("GRNTS1", id);
	}

	@Test
	void testCreateIdSegundo() {
		String nome = "Jao paulo";
		String nome2 = "Jocivaldo";
	
		String senha = "123";
		ControladorGerentes.create(nome2, senha);
		ControladorGerentes.create(nome, senha);
		assertEquals(nome, ControladorGerentes.getListaGerentes().get(1).getNome());
	}

	/**
	 * Test method for {@link modelos.ControladorGerentes#read()}.
	 */
	@Test
	void testRead() {
		String nome = "roberto";
		String senha = "123";
		ControladorGerentes.create(nome, senha);
		assertTrue(ControladorGerentes.read());
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorGerentes#checkId(java.lang.String)}.
	 */
	@Test
	void testCheckId() {
		String nome = "Jao pedro";
		String senha = "123";
		ControladorGerentes.create(nome, senha);
		String id = "GRNTS1";
		assertTrue(ControladorGerentes.checkId(id));
	}

	@Test
	void testCheckIdInexistente() {
		String nome = "Jao gabriel";
		String senha = "123";
		ControladorGerentes.create(nome, senha);
		String id = "GRNTS2";
		assertFalse(ControladorGerentes.checkId(id));
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorGerentes#update(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testUpdate() {
		String nome = "pedrin";
		String senha = "123";
		ControladorGerentes.create(nome, senha);
		String id = "GRNTS1";
		String newContent = "robertin";
		assertTrue(ControladorGerentes.update(id, newContent));
	}

	@Test
	void testUpdateIdInexistente() {
		String nome = "carlos";
		String senha = "123";
		ControladorGerentes.create(nome, senha);
		String id = "GRNTS2";
		String newContent = "valadao";
		assertFalse(ControladorGerentes.update(id, newContent));
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorGerentes#delete(java.lang.String)}.
	 */
	@Test
	void testDelete() {
		String nome = "vitor";
		String senha = "123";
		ControladorGerentes.create(nome, senha);
		assertTrue(ControladorGerentes.delete("GRNTS1"));
	}

	@Test
	void testDeleteInexistente() {
		String nome = "victor";
		String senha = "123";
		ControladorGerentes.create(nome, senha);
		String id = "GRNTS4";
		assertFalse(ControladorGerentes.delete(id));
	}

	@Test
	void testReadVazio() {
		assertFalse(ControladorGerentes.read());
	}

	@Test
	void testCheckIdSenhaTrue() {
		String nome = "victor";
		String senha = "123";
		ControladorGerentes.create(nome, senha);
		assertTrue(ControladorGerentes.checkIdSenha("GRNTS1", senha));
	}

	@Test
	void testCheckIdSenhaFrue() {
		String nome = "victor";
		String senha = "123";
		ControladorGerentes.create(nome, senha);
		assertFalse(ControladorGerentes.checkIdSenha("GRNTS3", senha));
	}
	
}
