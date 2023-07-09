
package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modelos.ControladorCardapio;
import modelos.Ingrediente;
import modelos.Vendas;

/**
 * Arquivo de teste para os metodos do modelo de vendas que nao foram incluidos
 * nos testes do controlador
 * 
 * @author Wagner Alexandre
 * @author Antonio Felipe
 */

public class TesteVendas {

	/**
	 * Ambiente, economia para os testes de adicionar e remover item
	 * 
	 */
	@BeforeAll
	public static void setAmbiente() {
		String nome = "Feijão";
		String descricao = "Raiz";
		int tipo = 1;
		ArrayList<Ingrediente> sucoDeManga = new ArrayList<Ingrediente>();
		double valor = 90.50;
		ControladorCardapio.create(nome, descricao, tipo, valor, sucoDeManga);
	}

	/**
	 * O setter do preco total da venda nao estava sendo reconhecido nos testes do
	 * controlador.
	 */

	@Test
	public void testaSetterPreco() {
		Vendas teste = new Vendas();
		teste.setPreco(55.5);
		assertEquals(55.5, teste.getPreco());

	}

	/**
	 * testa a adicao de um item a lista de compras
	 */

	@Test
	public void testaAddItem() {
		Vendas teste = new Vendas();
		assertTrue(teste.addItem(ControladorCardapio.getItemCardapio("CRDPS1")));
	}

	/**
	 * testa a remocao de um item da lista de compras
	 */
	@Test
	public void testaRemoveItemTrue() {
		Vendas teste = new Vendas();
		teste.addItem(ControladorCardapio.getItemCardapio("CRDPS1"));
		assertTrue(teste.removeItem("CRDPS1"));
	}

	/**
	 * testa a remocao de um item, caso o item nao esteja na lista de compras.
	 */
	@Test
	public void testaRemoveItemFalse() {
		Vendas teste = new Vendas();
		teste.addItem(ControladorCardapio.getItemCardapio("CRDPS1"));
		assertFalse(teste.removeItem("CRDPS33"));
	}

	/**
	 * testa a listagem da lista de compras
	 */
	@Test
	public void testaListagemTrue() {
		Vendas teste = new Vendas();
		teste.addItem(ControladorCardapio.getItemCardapio("CRDPS1"));
		assertTrue(teste.listagem());
	}

	/**
	 * testa a listagem da lista de compras, caso esteja vazia ou alguma coisa
	 * falhe.
	 */

	@Test
	public void testaListagemFalse() {
		Vendas teste = new Vendas();
		assertFalse(teste.listagem());
	}

}
