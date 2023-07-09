package testes;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelos.ControladorEstoque;
import modelos.ControladorProdutos;
import modelos.Produto;
import modelos.ProdutoCatalago;

class ControladorEstoqueTest {

	@BeforeEach
	void limpaLista() {
		ControladorEstoque.getEstoqueGeral().clear();
	}

	@Test
	void testCreateFirst() {
		ProdutoCatalago teste = ControladorEstoque.create("Manteiga");
		assertEquals(teste, ControladorEstoque.getEstoqueGeral().get(0));
	}

	@Test
	void testCreateSecond() {
		ControladorEstoque.create("Manteiga");
		ProdutoCatalago teste = ControladorEstoque.create("Margarina");
		assertEquals(teste, ControladorEstoque.getEstoqueGeral().get(1));
	}

	@Test
	void testReadEmpty() {
		assertEquals(1, ControladorEstoque.read());
	}

	@Test
	void testReadSucess() {
		ControladorEstoque.create("Manteiga");
		assertEquals(0, ControladorEstoque.read());

	}

	@Test
	void testDeleteTrue() {
		ControladorEstoque.create("Manteiga");
		assertTrue(ControladorEstoque.delete("PRDCT1"));
	}

	@Test
	void testDeleteFalse() {
		ControladorEstoque.create("Manteiga");
		assertFalse(ControladorEstoque.delete("PRDCT6"));
	}

	@Test
	void testGetEstoqueProduto() {
		ProdutoCatalago teste = ControladorEstoque.create("Manteiga");
		assertEquals(teste, ControladorEstoque.getEstoqueProduto("PRDCT1"));
	}

	
	@Test
	void testChecarQuantiaFalse() {
		ProdutoCatalago estoqueTeste = ControladorEstoque.create("Manteiga");
		Produto teste = ControladorProdutos.create("Manteiga", 7.99, "12-06-2042", 9.2);
		estoqueTeste.addProduto(teste);
		System.out.printf("%s", estoqueTeste.getQuantiaAtual());
		assertFalse(ControladorEstoque.checarQuantia(estoqueTeste, 10.0));
	}

	@Test
	void testChecarQuantiaTrue() {
		ProdutoCatalago teste = ControladorEstoque.create("Manteiga");
		ControladorProdutos.create("Manteiga", 7.99, "12-06-2042", 14.5);
		teste.addProduto(ControladorProdutos.getProduto("PRDCT1"));

		assertTrue(ControladorEstoque.checarQuantia(teste, 10.0));
	}

	@Test
	void testArremate() {

	}

}
