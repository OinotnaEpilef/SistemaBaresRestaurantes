package modelos;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A classe <b>ControladorVendas</b> faz o controle geral dos objetos do tipo
 * Vendas.
 * 
 * 
 */


public class ControladorVendas {

	/**
	 * Contrutor vazio/padrao
	 */
	
	public ControladorVendas() {
		
	}
	
	/**
	 * <b>ListaVendas</b> E um ArrayList que ira guardar todas as vendas cadastradas
	 * no sistema.
	 */
	private static ArrayList<Vendas> listaVendas = new ArrayList<Vendas>();

	/**
	 * O metodo <b>getListaVendas</b> ira retornar o <b>ArrayList</b> do tipo
	 * <b>Vendas</b>, este metodo por enquanto possui uso exclusivo para testes.
	 * 
	 * @return <b>ListaVendas</b> Uma ArrayList do tipo Vendas.
	 */

	public static ArrayList<Vendas> getListaVendas() {
		return ControladorVendas.listaVendas;
	}

	/**
	 * Este metodo funciona como um construtor, ele instancia um objeto do tipo
	 * vendas, atribui valores basicos para seus atributos dataHora e ID e o
	 * retorna, o resto das atribuicoes ocorre fora do create, ao adicionar e
	 * remover Itens do cardapio da venda.
	 * 
	 * @return <b>Vendas</b> Um objeto da classe Vendas.
	 */
	public static Vendas create() {
		Vendas novo = new Vendas();
		String dataHora = new SimpleDateFormat("HH:mm:ss | dd-MM-YY").format(Calendar.getInstance().getTime());
		novo.setDataHora(dataHora);
		System.out.println(dataHora);
		novo.setId(createId());
		return novo;
	}

	/**
	 * Acessa a lista de vendas para gerar um ID, cria o primeiro ID se a lista
	 * estiver azia, caso contrario, acessa o ultimo elemento da lista, para pegar o
	 * NUMERICO desse ultimo ID, somar 1 e retornar o novo ID.
	 * 
	 * @return <b>String</b>.
	 */

	public static String createId() {
		if (ControladorVendas.listaVendas.isEmpty()) {
			return "VENDS1";
		} else {
			int ultimo = ControladorVendas.listaVendas.size() - 1;
			String fatia = (ControladorVendas.listaVendas.get(ultimo)).getId();
			fatia = fatia.substring(5);
			int newID = (Integer.parseInt(fatia) + 1);
			return ("VENDS" + Integer.toString(newID));
		}
	}

	/**
	 * Adiciona uma venda a lista de vendas. Metodo necessario pois a lista de
	 * vendas e privada.
	 * 
	 * @param novaVenda Um objeto da classe Vendas a ser adicionada
	 * @return Boolean true se a venda foi adicionada.
	 */

	public static Boolean addVenda(Vendas novaVenda) {
		return listaVendas.add(novaVenda);
	}

	/**
	 * Simplesmente Le a lista de Vendas, formatando o Objeto <b>formato</b>
	 * enquanto percorre o Cardapio com as informacoes de cada Item.
	 *
	 * @return Boolean, false se a lista esta vazia, true se nao.
	 */

	public static Boolean read() {
		if (listaVendas.isEmpty()) {
			return false;
		} else {
			System.out.println("|ID         |PRECO          |HORA     |DATA	 |");
			String formato;
			for (Vendas item : listaVendas) {
				formato = String.format("|%11s|%15s|%17s|",item.getId(), item.getPreco(),item.getDataHora());
				System.out.println(formato);
			}
			System.out.println("FIM DA LISTA DE VENDAS");
			return true;
		}
	}

	/**
	 * O metodo ira percorrer a lista de vendas a procura do item com ID igual ao
	 * parametro passado.
	 * 
	 * @param id, Um objeto <b>String</b>, que indentifica o Item a ser removido.
	 * @return Boolean, <b>true</b> se o item tiver sido removido, <b>false</b> se o
	 *         item nao foi achado.
	 */

	public static Boolean delete(String id) {
		for (Vendas item : listaVendas) {
			if (item.getId().equals(id)) {
				return listaVendas.remove(item);
			}
		}
		return false;
	}
	
}
