package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelos.ControladorCardapio;
import modelos.ControladorVendas;
import modelos.Ingrediente;
import modelos.Vendas;

/**
 * @author Wagner Alexandre
 * @author Antonio Felipe
 */

class ControladorVendasTest {

	@Test
	void testaConstrutor() {
		ControladorVendas teste = new ControladorVendas();
		assertNotNull(teste);
	}
	
	@BeforeEach
	void limpaLista() {
		ControladorVendas.getListaVendas().clear();
	}
	/**
	 * Test method for {@link modelos.ControladorVendas#create()}.
	 */
	@Test
	void testCreateNotNull() {
		assertNotNull(ControladorVendas.create());
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorVendas#addVenda(modelos.Vendas)}.
	 */
	@Test
	void testAddVenda() {
		Vendas v1 = new Vendas();
		assertTrue(ControladorVendas.addVenda(v1));
	}

	/**
	 * Test method for {@link modelos.ControladorVendas#createId()}.
	 */
	@Test
	void testCreateIdUm() {
		String id = ControladorVendas.createId();
		assertEquals("VENDS1", id);
	}
	/**
	 * Test method for {@link modelos.ControladorVendas#createId()}.
	 */
	@Test
	void testCreateIdDois() {
		ControladorVendas.createId();
		Vendas teste1 = ControladorVendas.create();
		ControladorVendas.addVenda(teste1);
		Vendas teste2 = ControladorVendas.create();
		ControladorVendas.addVenda(teste2);
		assertEquals("VENDS2", ControladorVendas.getListaVendas().get(1).getId());
	}

	/**
	 * Test method for {@link modelos.ControladorVendas#read()}.
	 */
	@Test
	void testReadTrue() {
		Vendas teste = ControladorVendas.create();
		ArrayList<Ingrediente> sucoDeManga = new ArrayList<Ingrediente>();		
		ControladorCardapio.create("Macarronada", "Macarrao", 2, 44.55, sucoDeManga);
		teste.addItem(ControladorCardapio.getItemCardapio("CRDPS1"));
		ControladorVendas.addVenda(teste);
		assertTrue(ControladorVendas.read());
	}
	
	/**
	 * Test method for {@link modelos.ControladorVendas#read()}.
	 */
	@Test
	void testReadFalha() {
		assertFalse(ControladorVendas.read());
	}

	/**
	 * Test method for
	 * {@link modelos.ControladorVendas#delete(java.lang.String)}.
	 */
	@Test
	void testDeleteTrue() {
		ArrayList<Ingrediente> sucoDeManga = new ArrayList<Ingrediente>();
		Vendas teste = ControladorVendas.create();
		ControladorCardapio.create("Macarronada", "Macarrao", 2, 44.55, sucoDeManga);
		teste.addItem(ControladorCardapio.getItemCardapio("CRDPS1"));
		ControladorVendas.addVenda(teste);
		assertTrue(ControladorVendas.delete("VENDS1"));
	}
	/**
	 * Test method for
	 * {@link modelos.ControladorVendas#delete(java.lang.String)}.
	 */
	@Test
	void testDeleteFalse() {
		Vendas teste = ControladorVendas.create();
		ArrayList<Ingrediente> sucoDeManga = new ArrayList<Ingrediente>();
		ControladorCardapio.create("Macarronada", "Macarrao", 2, 44.55, sucoDeManga);
		teste.addItem(ControladorCardapio.getItemCardapio("CRDPS1"));
		ControladorVendas.addVenda(teste);
		assertFalse(ControladorVendas.delete("VENDS44"));
	}
	
	// TESTES DO MODELO VENDAS
	
	

}
