/**
 * 
 */
package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelos.ControladorFornecedores;
import modelos.Fornecedor;

/**
 * @author Felip
 *
 */
class ControladorFornecedoresTest {
	
	@BeforeEach
	void limpadorDeLista() {
		ControladorFornecedores.getListaFornecedores().clear();
	}

	/**
	 * Teste de contrutor
	 */
	@Test
	void testaConstrutor() {
		ControladorFornecedores teste = new ControladorFornecedores();
		assertNotNull(teste);
	}
	
	/**
	 * Test method for {@link modelos.ControladorFornecedores#create(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCreatePrimeiroSegundoItem() {
		String nome = "Eu";
		String cpnj = "591697535";
		String adress = "Logo ali";
		ControladorFornecedores.create(nome, cpnj, adress);
		ControladorFornecedores.create(nome, cpnj, adress);
		assertEquals("FRNCR2", ControladorFornecedores.getListaFornecedores().get(1).getId());
	}

	/**
	 * Test method for {@link modelos.ControladorFornecedores#read()}.
	 */
	@Test
	void testRead() {
		String nome = "le";
		String cnpj = "645975694885";
		String adress = "La na casa da noca";
		ControladorFornecedores.create(nome, cnpj, adress);
		assertTrue(ControladorFornecedores.read());
	}

	/**
	 * Test method for {@link modelos.ControladorFornecedores#update(java.lang.String, int, java.lang.String)}.
	 */
	@Test
	void testUpdateInfoUm() {
		String nome = "leko";
		String cnpj = "599697535";
		String adress = "na rua vazia";
		ControladorFornecedores.create(cnpj, nome, adress);
		String id = "FRNCR1";
		int newInfo = 1;
		String newContent = "7819454500";
		assertTrue(ControladorFornecedores.update(id, newInfo, newContent));
	}
	/**
	 * Test method for {@link modelos.ControladorFornecedores#update(java.lang.String, int, java.lang.String)}.
	 */
	@Test
	void testUpdateInfoDois() {
		String nome = "leko";
		String cnpj = "599697535";
		String adress = "na rua vazia";
		ControladorFornecedores.create(cnpj, nome, adress);
		String id = "FRNCR1";
		int newInfo = 2;
		String newContent = "Leki";
		assertTrue(ControladorFornecedores.update(id, newInfo, newContent));
	}
	/**
	 * Test method for {@link modelos.ControladorFornecedores#update(java.lang.String, int, java.lang.String)}.
	 */
	@Test
	void testUpdateInfoTres() {
		String nome = "leko";
		String cnpj = "599697535";
		String adress = "na rua vazia";
		ControladorFornecedores.create(cnpj, nome, adress);
		String id = "FRNCR1";
		int newInfo = 3;
		String newContent = "Rua da casa 0";
		assertTrue(ControladorFornecedores.update(id, newInfo, newContent));
	}
	/**
	 * Test method for {@link modelos.ControladorFornecedores#update(java.lang.String, int, java.lang.String)}.
	 */
	@Test
	void testUpdateFalha() {
		String nome = "leko";
		String cnpj = "599697535";
		String adress = "na rua vazia";
		ControladorFornecedores.create(cnpj, nome, adress);
		String id = "FRNCR3";
		int newInfo = 2;
		String newContent = "7819454500";
		assertFalse(ControladorFornecedores.update(id, newInfo, newContent));
	}

	/**
	 * Test method for {@link modelos.ControladorFornecedores#delete(java.lang.String)}.
	 */
	@Test
	void testDelete() {
		String nome = "elena";
		String cnpj = "486238543216";
		String adress = "avenida br";
		Fornecedor f4 = new Fornecedor();
		f4 = ControladorFornecedores.create(nome, cnpj, adress);
		String id = f4.getId();
		assertTrue(ControladorFornecedores.delete(id));
	}
	
	/**
	 * Test method for {@link modelos.ControladorFornecedores#delete(java.lang.String)}.
	 */
	@Test
	void testDeleteFalse() {
		String nome = "elena";
		String cnpj = "486238543216";
		String adress = "avenida br";
		ControladorFornecedores.create(nome, cnpj, adress);
		String id = "FRNCR2";
		assertFalse(ControladorFornecedores.delete(id));
	}

	/**
	 * Test method for {@link modelos.ControladorFornecedores#createId()}.
	 */
	@Test
	void testCreateId() {
		String nome = "tia";
		String cnpj = "7987465456";
		String adress = "La na esquina";
		Fornecedor novo = new Fornecedor();
		novo.setId(ControladorFornecedores.createId());
		novo.setNome(nome);
		novo.setAdress(adress);
		novo.setCNPJ(cnpj);
		String idTeste = novo.getId();
		assertEquals("FRNCR1", idTeste);
	}
	
	/**
	 * Teste para Lista Vazia
	 */
	@Test
	void testReadFalse() {
		assertFalse(ControladorFornecedores.read());
	}
	
	@Test
	void testGetFornecedorByIdFalse() {
		ControladorFornecedores.create("SEU TIRINGA", "9882984094", "SERRA TALHADA");
		ControladorFornecedores.create("AMANDA MANGAS", "9883384094", "SERRA TALHADA");
		ControladorFornecedores.create("MARIO ESPAGATTI", "9842984094", "SERRA TALHADA");
		
		assertNull(ControladorFornecedores.getFornecedorbById("FRNCD4"));
	}
	
	@Test
	void testGetFornecedorByIdTrue() {
		ControladorFornecedores.create("SEU TIRINGA", "9882984094", "SERRA TALHADA");
		Fornecedor teste = ControladorFornecedores.create("AMANDA MANGAS", "9883384094", "SERRA TALHADA");
		ControladorFornecedores.create("MARIO ESPAGATTI", "9842984094", "SERRA TALHADA");
		
		assertEquals(ControladorFornecedores.getFornecedorbById("FRNCR2"),teste );
	}


}
