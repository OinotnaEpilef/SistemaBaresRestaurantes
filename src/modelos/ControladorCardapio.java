package modelos;

import java.util.ArrayList;

/**
 * A classe <b>ControladorCardapio</b> faz o controle geral dos objetos do tipo
 * ItemCardapio.
 * 
 * @author Wagner Alexandre
 * @author Antonio Felipe
 *
 * @since abr 2022.
 */

public class ControladorCardapio {

	/**
	 * Contrutor vazio/padrao
	 */
	public ControladorCardapio() {

	}

	/**
	 * <b>Cardapio</b> E um ArrayList que ira funcionar como o "Cardapio Geral", ou
	 * seja, ira guardar todos os itens do cardapio.
	 */

	private static ArrayList<ItemCardapio> cardapio = new ArrayList<ItemCardapio>();

	/**
	 * O metodo <b>getCardapio</b> ira retornar o <b>ArrayList</b> do tipo
	 * <b>Cardapio</b>, este metodo por enquanto possui uso exclusivo para testes.
	 * 
	 * @return Cardapio Uma ArrayList do tipo ItemCardapio.
	 */
	public static ArrayList<ItemCardapio> getCardapio() {
		return ControladorCardapio.cardapio;
	}

	/**
	 * Metodo <b>getItemCardapio</b>, verefica se existe um objeto com o ID igual ao
	 * parametro <b>String</b> id no Cardapio.
	 * 
	 * @param id, Um objeto <b>String</b>.
	 * @return <b>itemCardapio</b> se existe um objeto com ID igual ao Parametro id
	 *         no Cardapio, ou <b>null</b> se nao.
	 */
	public static ItemCardapio getItemCardapio(String id) {
		if (cardapio.isEmpty()) {
			return null;

		} else {
			for (ItemCardapio item : cardapio) {
				if (item.getId().equals(id)) {
					return item;
				}
			}
			return null;
		}
	}

	/**
	 * Atua como construtor de objeto, no final, adiciona o objeto instanciado ao
	 * cardapio e o retorna.
	 * 
	 * @param nome      Um objeto <b>String</b>.
	 * @param descricao Um objeto <b>String</b>.
	 * @param tipo      Uma variavel <b>int</b>.
	 * @param valor     Uma variavel <b>double</b>;
	 * @return ItemCardapio quando cria um novo objeto a ser adicionado no
	 *         <b>Cardapio</b>.
	 */
	public static ItemCardapio create(String nome, String descricao, int tipo, double valor,
			ArrayList<Ingrediente> ingredientes) {

		ItemCardapio novo = new ItemCardapio();
		novo.setId(ControladorCardapio.createId());
		novo.setNome(nome);
		novo.setTipo(tipo);
		novo.setDescricao(descricao);
		novo.setPreco(valor);
		novo.setIngredientes(ingredientes);
		ControladorCardapio.cardapio.add(novo);
		return novo;
	}

	/**
	 * Acessa o Cardapio para gerar um ID, cria o primeiro ID se o Cardapio esta
	 * Vazio, caso contrario, acessa o ultimo elemento da lista, para pegar o
	 * NUMERICO desse ultimo ID, somar 1 e retornar o novo ID.
	 * 
	 * @return Uma <b>String</b>.
	 */

	public static String createId() {
		if (cardapio.isEmpty()) {
			return "CRDPS1";
		} else {
			int ultimo = cardapio.size() - 1;
			String fatia = (cardapio.get(ultimo)).getId();
			fatia = fatia.substring(5);
			int newID = (Integer.parseInt(fatia) + 1);
			return ("CRDPS" + Integer.toString(newID));
		}
	}

	/**
	 * Simplesmente Le o cardapio, formatando o Objeto <b>formato</b> enquanto
	 * percorre o Cardapio com as informacoes de cada Item.
	 *
	 * @return Boolean, false se a lista esta vazia, true se nao.
	 */

	public static Boolean read() {
		if (cardapio.isEmpty()) {
			return false;
		} else {
			System.out.println(
					"                     NOME|                    DESCRICAO|                    TIPO|                 ID|");
			String formato;
			for (ItemCardapio item : cardapio) {
				formato = String.format("%-25s| %-28s| %-23s| %-18s| ", item.getNome(), item.getDescricao(),
						item.getTipo(), item.getId());
				System.out.println(formato);
			}
			System.out.println("FIM DO CARDAPIO");
			return true;
		}
	}

	/**
	 * lista a receita (itens necessarios) para um prato
	 * 
	 * @param prato
	 */
	public static boolean readReceita(ItemCardapio prato) {
		System.out.println("|NOME               |QUANTIDADE         |ID              |");
		String formato;

		for (Ingrediente item : prato.getIngredientes()) {
			formato = String.format("|%.20s|%.20s|%.15s|", item.getProdutoCatalago().getNome(), item.getQuantia(),
					item.getProdutoCatalago().getId());
			System.out.println(formato);
		}
		System.out.println("FIM DA LISTA DE INGREDIENTES!!!");
		return true;
	}

	/**
	 * Este metodo existe para alterar algumas informacoes de um determinado objeto.
	 * 
	 * @param id         Um objeto <b>String</b>, que sera o Item a ser modificado.
	 * @param newInfo    Uma variavel <b>int</b>, que determminara qual informacao
	 *                   sera modificada.
	 * @param newContent Um objeto <b>String</b>, o novo conteudo/informacao.
	 * @return Boolean <b>true</b> se alterou, <b>false</b> se nao houve alteracao.
	 */

	public static Boolean update(String id, int newInfo, String newContent) {
		for (ItemCardapio item : cardapio) {
			if (item.getId().equals(id)) {
				switch (newInfo) {
				case 1:
					item.setNome(newContent);
					break;

				case 2:
					item.setDescricao(newContent);
					break;

				case 3:
					item.setTipo((Integer.parseInt(newContent)));
					break;

				case 4:
					Double newPreco = Double.parseDouble(newContent);
					item.setPreco(newPreco);
					break;
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * O metodo ira percorrer o <b>Cardapio</b> a procura do item com ID igual ao
	 * parametro passado.
	 * 
	 * @param id, Um objeto <b>String</b>, que indentifica o Item a ser removido.
	 * @return Boolean, <b>true</b> se o item tiver sido removido, <b>false</b> se o
	 *         item nao foi achado.
	 */

	public static Boolean delete(String id) {
		for (ItemCardapio item : cardapio) {
			if (item.getId().equals(id)) {
				return cardapio.remove(item);
			}
		}
		return false;
	}
}
