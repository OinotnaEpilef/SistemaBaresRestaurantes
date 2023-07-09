
package testes;

import modelos.ControladorProdutos;
import modelos.Produto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Wagner Alexandre
 * @author Antonio Felipe
 */

class ControladorProdutosTest {

	@BeforeEach
	void limpalista() {
		ControladorProdutos.getListaProdutos().clear();
	}

	/**
	 * Contrutor vazio
	 */
	@Test
	void testConstrutor() {
		ControladorProdutos teste = new ControladorProdutos();
		assertNotNull(teste);
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorProdutos#create(java.lang.String, java.lang.Double, java.lang.String)}.
	 */
	@Test
	void testCreatePrimeiroSegundoItem() {
		String nome = "farinha";
		double preco = 2.80;
		String validade = "22/06";
		double quantia = 1.5;
		ControladorProdutos.create(nome, preco, validade, quantia);
		ControladorProdutos.create(nome, preco, validade, quantia);
		assertEquals("PRDTS2", ControladorProdutos.getListaProdutos().get(1).getId());
	}

	/**
	 * Test method for {@link modelos.ControladorProdutos#read()}.
	 */
	@Test
	void testRead() {
		String nome = "pó";
		double preco = 2.70;
		String vencimento = "15-06-2023";
		double quantia = 1.5;
		ControladorProdutos.create(nome, preco, vencimento, quantia);
		assertTrue(ControladorProdutos.read());
	}

	/**
	 * Test method for {@link modelos.ControladorProdutos#read()}.
	 */
	@Test
	void testReadFalse() {
		assertFalse(ControladorProdutos.read());
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorProdutos#update(java.lang.String, int, java.lang.String)}.
	 */
	@Test
	void testUpdateUm() {
		String nome = "álcool";
		double preco = 5.80;
		double quantia = 1.5;
		String vencimento = "06/12";
		ControladorProdutos.create(nome, preco, vencimento, quantia);
		String id = "PRDTS1";
		int newInfo = 1;
		String newContent = "Cachaca";
		assertTrue(ControladorProdutos.update(id, newInfo, newContent));
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorProdutos#update(java.lang.String, int, java.lang.String)}.
	 */
	@Test
	void testUpdateInfoDois() {
		String nome = "álcool";
		double preco = 5.80;
		String vencimento = "06/12";
		double quantia = 1.5;
		ControladorProdutos.create(nome, preco, vencimento, quantia);
		String id = "PRDTS1";
		int newInfo = 2;
		String newContent = "4.80";
		assertTrue(ControladorProdutos.update(id, newInfo, newContent));
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorProdutos#update(java.lang.String, int, java.lang.String)}.
	 */
	@Test
	void testUpdateInforTres() {
		String nome = "álcool";
		double quantia = 1.5;

		double preco = 5.80;
		String vencimento = "06/12";
		ControladorProdutos.create(nome, preco, vencimento, quantia);
		String id = "PRDTS1";
		int newInfo = 3;
		String newContent = "Cacha�a";
		assertTrue(ControladorProdutos.update(id, newInfo, newContent));
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorProdutos#update(java.lang.String, int, java.lang.String)}.
	 */
	@Test
	void testUpdateFalse() {
		String nome = "álcool";
		double preco = 5.80;
		double quantia = 1.5;
		String vencimento = "06/12";
		ControladorProdutos.create(nome, preco, vencimento, quantia);
		String id = "PRDTS2";
		int newInfo = 1;
		String newContent = "Cachaça";
		assertFalse(ControladorProdutos.update(id, newInfo, newContent));
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorProdutos#delete(java.lang.String)}.
	 */
	@Test
	void testDelete() {
		String nome = "ovo";
		double preco = 1.80;
		String vencimento = "22/05";
		double quantia = 1.5;
		Produto p4 = new Produto();
		p4 = ControladorProdutos.create(nome, preco, vencimento, quantia);
		String id = p4.getId();
		assertTrue(ControladorProdutos.delete(id));
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorProdutos#delete(java.lang.String)}.
	 */
	@Test
	void testDeleteFalse() {
		String id = "PRDTS1";
		assertFalse(ControladorProdutos.delete(id));
	}
	
	/**
	 * Test method for
	 * {@link modelos.ControladorProdutos#delete(java.lang.String)}.
	 */
	@Test
	void testGetProdutoNullEmpty() {
		String id = "PRDTS1";
		assertNull(ControladorProdutos.getProduto(id));
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorProdutos#delete(java.lang.String)}.
	 */
	@Test
	void testDeleteNullNotFound() {
		String nome = "álcool";
		double preco = 5.80;
		double quantia = 1.5;
		String vencimento = "06-12-2021";
		ControladorProdutos.create(nome, preco, vencimento, quantia);
		String id = "PRDTS3";
		assertFalse(ControladorProdutos.delete(id));
	}

	
	/**
	 * Test method for {@link modelos.ControladorProdutos#createId()}.
	 */
	@Test
	void testCreateId() {
		String nome = "comida";
		double preco = 100.80;
		Produto novo = new Produto();
		novo.setId(ControladorProdutos.createId());
		novo.setNome(nome);
		novo.setPreco(preco);
		assertEquals("PRDTS1", novo.getId());
	}

	@Test
	void testGetProduto() {
		String nome = "álcool";
		double preco = 5.80;
		double quantia = 1.5;
		String vencimento = "06-12-2021";
		Produto teste = ControladorProdutos.create(nome, preco, vencimento, quantia);

		assertEquals(teste,ControladorProdutos.getProduto("PRDTS1"));
	}

	@Test
	void testDeleteProdutoObjetoTrue() {
		Produto teste = ControladorProdutos.create("Leite light", 5.57, "12-08-2022", 6.6);
		assertTrue(ControladorProdutos.delete(teste));
	}

	@Test
	void testDeleteProdutoObjetoFalse() {
		Produto teste = new Produto();
		teste.setNome("Leite light");
		teste.setPreco(5.57);
		teste.setQuantia(6.5);
		teste.setValidade("15-11-2016");
		assertNull(ControladorProdutos.delete(teste));
		
	}
	
}
