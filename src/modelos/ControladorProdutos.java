package modelos;

import java.util.ArrayList;

/**
 * A classe <b>ControladorProdutos</b> faz o controle geral dos objetos do tipo
 * Produto.
 * 
 * 
 */

public class ControladorProdutos {

	/**
	 * Contrutor vazio
	 */
	public ControladorProdutos() {

	}

	/**
	 * <b>ListaProdutos</b> é um ArrayList que irá guardar todos os produtos
	 * cadastrados no sistema fornecidos pelos fornecedores.
	 */

	private static ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

	/**
	 * O metodo <b>getListaProdutos</b> ira retornar o <b>ArrayList</b> do tipo
	 * <b>Produto</b>, este metodo por enquanto possui uso exclusivo para testes.
	 * 
	 * @return ListaProdutos Uma ArrayList do tipo ItemCardapio.
	 */

	public static ArrayList<Produto> getListaProdutos() {
		return ControladorProdutos.listaProdutos;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Produto getProduto(String id) {
		if (listaProdutos.isEmpty()) {
			return null;
		} else {
			for (Produto item : listaProdutos) {
				if (item.getId().equals(id)) {
					return item;
				}
			}
		}
		return null;
	}

	/**
	 * Atua como construtor de objeto, no final, adiciona o objeto instanciado a
	 * lista de Produtos e o retorna.
	 * 
	 * @param nome       Uma <b>String</b>.
	 * @param preco      Um <b>Double</b>.
	 * @param Vencimento Uma <b>String</b>.
	 * @return Produto.
	 */

	public static Produto create(String nome, Double preco, String validade, Double quantia) {

		Produto novo = new Produto();
		novo.setId(ControladorProdutos.createId());
		novo.setNome(nome);
		novo.setPreco(preco);
		novo.setValidade(validade);
		novo.setQuantia(quantia);
		listaProdutos.add(novo);
		return novo;
	}

	/**
	 * Acessa a Lista de produtos para gerar um ID, cria o primeiro ID se a lista
	 * estiver vazio, caso contrario, acessa o ultimo elemento da lista, para pegar
	 * o NUMERICO desse ultimo ID, somar 1 e retornar o novo ID.
	 * 
	 * @return Uma <b>String</b>.
	 */

	public static String createId() {
		if (ControladorProdutos.listaProdutos.isEmpty()) {
			return "PRDTS1";
		} else {
			int ultimo = ControladorProdutos.listaProdutos.size() - 1;
			String fatia = (ControladorProdutos.listaProdutos.get(ultimo)).getId();
			fatia = fatia.substring(5);
			int newID = (Integer.parseInt(fatia) + 1);
			return ("PRDTS" + Integer.toString(newID));
		}
	}

	/**
	 * Simplesmente Lê a lista de produtos, formatando o Objeto <b>formato</b>
	 * enquanto percorre o Cardapio com as informações de cada Item.
	 *
	 * @return Boolean, false se a lista esta vazia, true se nao.
	 */

	public static Boolean read() {
		if (listaProdutos.isEmpty()) {
			return false;
		} else {
			System.out.println("|NOME              |PRECO            |QUANTIA          |VENCIMENTO                   |ID              |");
			String formato;
			for (Produto item : ControladorProdutos.listaProdutos) {
				System.out.printf("%s15", item.getPreco());
				formato = String.format("|%18s|%16s|%16s |%28s| %15s|", item.getNome(), item.getPreco(), item.getQuantia(), item.getValidade(),
						item.getId());
				System.out.println(formato);
			}
			System.out.println("FIM DA LISTA DE FORNECEDORES!");
			return true;
		}
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
		for (Produto item : ControladorProdutos.listaProdutos) {
			if (item.getId().equals(id)) {
				switch (newInfo) {
				case 1:
					item.setNome(newContent);
					break;

				case 2:
					item.setPreco(Double.parseDouble(newContent));
					break;

				case 3:
					item.setValidade(newContent);
					break;
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * O metodo ira percorrer a lista de produtos a procura do item com ID igual ao
	 * parametro passado.
	 * 
	 * @param id, Um objeto <b>String</b>, que indentifica o Item a ser removido.
	 * @return Boolean, <b>true</b> se o item tiver sido removido, <b>false</b> se o
	 *         item nao foi achado.
	 */

	public static Boolean delete(String id) {
		for (Produto item : ControladorProdutos.listaProdutos) {
			if (item.getId().equals(id)) {
				ControladorProdutos.listaProdutos.remove(item);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Sobrecarga do metodo delete, remove por objeto.
	 * @param remover
	 * @return true Se a lista possui o objeto, null se nao.
	 */
	public static Boolean delete(Produto remover) {
		if (listaProdutos.contains(remover)){
			return listaProdutos.remove(remover);
		}else {
			return null;
		}
	}
	
	
	
}
