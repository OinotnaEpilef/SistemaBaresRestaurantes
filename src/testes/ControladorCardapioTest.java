package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelos.ControladorCardapio;
import modelos.ControladorEstoque;
import modelos.Ingrediente;
import modelos.ItemCardapio;

/**
 * @author Antonio Felipe
 * @author Wagner Alexandre
 */

class ControladorCardapioTest {

	/**
	 * Contrutor Vazio/Padrao
	 */
	@Test
	void testaConstrutor() {
		ControladorCardapio teste = new ControladorCardapio();
		assertNotNull(teste);
	}

	@BeforeEach
	void limpadordeLista() {
		ControladorCardapio.getCardapio().clear();
	}

	/**
	 * Metodo de teste isolado para o getter do preco de itemCardapio
	 */
	@Test
	void testaGetPreco() {
		modelos.ItemCardapio teste = new modelos.ItemCardapio();
		teste.setPreco(5.5);
		assertEquals(5.5, teste.getPreco());
	}

	/**
	 * Metodo de teste para o getItemCardapio() quando a lista esta vazia;
	 */
	@Test
	void testaGetItemCardapioVazio() {
		assertNull(ControladorCardapio.getItemCardapio("CRDPS3"));
	}

	/**
	 * Metodo de teste para o getItemCardapio() quando o item esta na lista;
	 */
	@Test
	void testaGetItemCardapioExistente() {
		Ingrediente manga = new Ingrediente();
		ArrayList<Ingrediente> sucoDeManga = new ArrayList<Ingrediente>();
		sucoDeManga.add(manga);

		ControladorCardapio.create("Lance", "Um poderoso MAC pbl feito", 2, 66.6, sucoDeManga);
		assertNotNull(ControladorCardapio.getItemCardapio("CRDPS1"));
	}

	/**
	 * Metodo de teste para o getItemCardapio() quando o item nao esta na lista;
	 */
	@Test
	void testaGetItemCardapioInexistente() {
		Ingrediente manga = new Ingrediente();
		ArrayList<Ingrediente> sucoDeManga = new ArrayList<Ingrediente>();
		sucoDeManga.add(manga);
		ControladorCardapio.create("Lance", "Um poderoso MAC pbl feito", 2, 66.6, sucoDeManga);
		assertNull(ControladorCardapio.getItemCardapio("CRDPS3"));
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorCardapio#create(java.lang.String, java.lang.String, int, double)}.
	 */

	@Test
	void testCreatePrimeiroSegundoItem() {
		Ingrediente manga = new Ingrediente();
		ArrayList<Ingrediente> sucoDeManga = new ArrayList<Ingrediente>();
		sucoDeManga.add(manga);

		String nome = "Eu";
		String descricao = "Batata";
		int tipo = 1;
		double valor = 22.50;
		ControladorCardapio.create(nome, descricao, tipo, valor, sucoDeManga);
		ControladorCardapio.create(nome, descricao, tipo, valor, sucoDeManga);
		assertEquals("CRDPS2", ControladorCardapio.getCardapio().get(1).getId());
	}

	/**
	 * Test method for {@link modelos.ControladorCardapio#read()}.
	 */

	@Test
	void testRead() {
		Ingrediente manga = new Ingrediente();
		ArrayList<Ingrediente> sucoDeManga = new ArrayList<Ingrediente>();
		sucoDeManga.add(manga);

		String nome = "Eu";
		String descricao = "Batata";
		int tipo = 1;
		double valor = 22.50;
		ControladorCardapio.create(nome, descricao, tipo, valor, sucoDeManga);
		assertTrue(ControladorCardapio.read());
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorCardapio#update(java.lang.String, int, java.lang.String)}.
	 */
	@Test
	void testUpdateInfoUm() {
		Ingrediente manga = new Ingrediente();
		ArrayList<Ingrediente> sucoDeManga = new ArrayList<Ingrediente>();
		sucoDeManga.add(manga);

		String nome = "Feijão";
		String descricao = "Raiz";
		int tipo = 1;
		double valor = 90.50;
		ControladorCardapio.create(nome, descricao, tipo, valor, sucoDeManga);
		String id = "CRDPS1";
		int newInfo = 1;
		String newContent = "Arroz";
		assertTrue(ControladorCardapio.update(id, newInfo, newContent));
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorCardapio#update(java.lang.String, int, java.lang.String)}.
	 */
	@Test
	void testUpdateInfoDois() {
		Ingrediente manga = new Ingrediente();
		ArrayList<Ingrediente> sucoDeManga = new ArrayList<Ingrediente>();
		sucoDeManga.add(manga);

		String nome = "Feijão";
		String descricao = "Raiz";
		int tipo = 1;
		double valor = 90.50;
		ControladorCardapio.create(nome, descricao, tipo, valor, sucoDeManga);
		String id = "CRDPS1";
		int newInfo = 2;
		String newContent = "Arroz";
		assertTrue(ControladorCardapio.update(id, newInfo, newContent));
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorCardapio#update(java.lang.String, int, java.lang.String)}.
	 */
	@Test
	void testUpdateInfoTres() {
		Ingrediente manga = new Ingrediente();
		ArrayList<Ingrediente> sucoDeManga = new ArrayList<Ingrediente>();
		sucoDeManga.add(manga);

		String nome = "Feijão";
		String descricao = "Raiz";
		int tipo = 3;
		double valor = 90.50;
		ControladorCardapio.create(nome, descricao, tipo, valor, sucoDeManga);
		String id = "CRDPS1";
		int newInfo = 3;
		String newContent = "2";
		assertTrue(ControladorCardapio.update(id, newInfo, newContent));
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorCardapio#update(java.lang.String, int, java.lang.String)}.
	 */
	@Test
	void testUpdateInfoQuatro() {
		Ingrediente manga = new Ingrediente();
		ArrayList<Ingrediente> sucoDeManga = new ArrayList<Ingrediente>();
		sucoDeManga.add(manga);

		String nome = "Macarrao";
		String descricao = "Italiano, original";
		int tipo = 4;
		double valor = 90.50;
		ControladorCardapio.create(nome, descricao, tipo, valor, sucoDeManga);
		String id = "CRDPS1";
		int newInfo = 4;
		String newContent = "33.87";
		assertTrue(ControladorCardapio.update(id, newInfo, newContent));
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorCardapio#update(java.lang.String, int, java.lang.String)}.
	 */
	@Test
	void testUpdateFalse() {
		Ingrediente manga = new Ingrediente();
		ArrayList<Ingrediente> sucoDeManga = new ArrayList<Ingrediente>();
		sucoDeManga.add(manga);

		String nome = "Feijão";
		String descricao = "Raiz";
		int tipo = 1;
		double valor = 90.50;
		ControladorCardapio.create(nome, descricao, tipo, valor, sucoDeManga);
		String id = "CRDPS6";
		int newInfo = 1;
		String newContent = "Arroz";
		assertFalse(ControladorCardapio.update(id, newInfo, newContent));
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorCardapio#delete(java.lang.String)}.
	 */
	@Test
	void testDelete() {
		Ingrediente manga = new Ingrediente();
		ArrayList<Ingrediente> sucoDeManga = new ArrayList<Ingrediente>();
		sucoDeManga.add(manga);

		String nome = "Comida";
		String descricao = "Comestível";
		int tipo = 3;
		double valor = 38.50;
		ItemCardapio i3 = new ItemCardapio();
		i3 = ControladorCardapio.create(nome, descricao, tipo, valor, sucoDeManga);
		String id = i3.getId();
		assertTrue(ControladorCardapio.delete(id));
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorCardapio#delete(java.lang.String)}.
	 */
	@Test
	void testDeleteFalse() {
		Ingrediente manga = new Ingrediente();
		ArrayList<Ingrediente> sucoDeManga = new ArrayList<Ingrediente>();
		sucoDeManga.add(manga);

		String nome = "Comida";
		String descricao = "Comestível";
		int tipo = 3;
		double valor = 38.50;
		ControladorCardapio.create(nome, descricao, tipo, valor, sucoDeManga);
		assertFalse(ControladorCardapio.delete("CRDPS6"));
	}

	/**
	 * Test method for {@link modelos.ControladorCardapio#read()}.
	 */

	@Test
	void testReadFalse() {
		assertFalse(ControladorCardapio.read());
	}

	/**
	 * Test method for {@link modelos.ControladorCardapio#createId()}.
	 */

	@Test
	void testCreate1() {
		String nome = "Ele";
		String descricao = "Batata e arroz";
		int tipo = 2;
		double valor = 2.50;
		ItemCardapio novo = new ItemCardapio();
		novo.setId(ControladorCardapio.createId());
		novo.setNome(nome);
		novo.setTipo(tipo);
		novo.setDescricao(descricao);
		novo.setPreco(valor);
		String idTeste = novo.getId();
		assertEquals("CRDPS1", idTeste);
	}

	/**
	 * Metodo de teste, usado somente para vereficar se a execucao chegou ao fim
	 */
	@Test
	void testeReadReceita() {
		Ingrediente manga = new Ingrediente();
		ControladorEstoque.create("MANGA");
		manga.setEstoqueNeeded(ControladorEstoque.getEstoqueProduto("PRDCT1"));
		manga.setQuantia(2.0);
		ArrayList<Ingrediente> sucoDeManga = new ArrayList<Ingrediente>();
		sucoDeManga.add(manga);
		ControladorCardapio.create("SUCO DE MANGA", "BEBIDA DE MANGA NATU", 3, 7.3, sucoDeManga);
		assertTrue(ControladorCardapio.readReceita(ControladorCardapio.getCardapio().get(0)));

	}

}
