package modelos;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A classe <b>ControladorFornecedores</b> funciona como um controlador geral
 * para os objetos do tipo Fornecedor.
 * 
 * 
 */


public class ControladorFornecedores {
	/**
	 * Contrutor vazio/padrao
	 */
	public ControladorFornecedores() {

	}

	/**
	 * <b>listaFornecedores</b> e um ArrayList que guardara todos os fornecedores
	 * cadastrados no sistema.
	 */

	private static ArrayList<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();

	/**
	 * O metodo <b>getListaFornecedores</b> ira retornar o <b>ArrayList</b> do tipo
	 * <b>Fornecedor</b>, que por enquanto, possui uso exclusivo para testes.
	 * 
	 * @return ControladorCardapio.Cardapio Uma ArrayList do tipo Fornecedor.
	 */

	public static ArrayList<Fornecedor> getListaFornecedores() {
		return ControladorFornecedores.listaFornecedores;
	}

	/**
	 * Este metodo funciona como um construtor, instanciando um novo objeto do tipo
	 * <b>Fornecedor</b> e atribuindo os valores dos parametros no atributos do
	 * objeto instanciado utilizando os setters definidos na classe, o ID e gerado
	 * por outro metodo do Controlador, ao finalizar as atribuicoes, a instancia e
	 * adicionada na lista de Fornecedores e retornada.
	 * 
	 * @param cnpj     Uma String.
	 * @param nome     Uma String.
	 * @param endereco Uma String.
	 * @return Fornecedor.
	 */

	public static Fornecedor create(String nome, String cnpj, String endereco) {
		Fornecedor novo = new Fornecedor();
		novo.setId(ControladorFornecedores.createId());
		novo.setNome(nome);
		novo.setAdress(endereco);
		novo.setCNPJ(cnpj);
		ControladorFornecedores.listaFornecedores.add(novo);
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
		if (ControladorFornecedores.listaFornecedores.isEmpty()) {
			return "FRNCR1";
		} else {
			int ultimo = ControladorFornecedores.listaFornecedores.size() - 1;
			String fatia = (ControladorFornecedores.listaFornecedores.get(ultimo)).getId();
			fatia = fatia.substring(5);
			int newID = (Integer.parseInt(fatia) + 1);
			return ("FRNCR" + Integer.toString(newID));
		}
	}

	/**
	 * Simplesmente Le a lista de fornecedores, formatando o Objeto <b>formato</b>
	 * enquanto percorre o Cardapio com as informacoes de cada Item.
	 *
	 * @return Boolean, false se a lista esta vazia, true se nao.
	 */

	public static Boolean read() {
		if (listaFornecedores.isEmpty()) {
			return false;
		} else {
			System.out
					.println("|NOME              |CNPJ              |ENDERECO                     |ID              |");
			String formato;
			for (Fornecedor item : ControladorFornecedores.listaFornecedores) {
				formato = String.format("|%18s| %17s| %28s| %15s|", item.getNome(), item.getCNPJ(), item.getAdress(),
						item.getId());
				System.out.println(formato);
			}
			System.out.println("FIM DA LISTA DE FORNECEDORES!");
			return true;
		}
	}

	/**
	 * O metodo existe para alterar algumas informacoes de uma determinada
	 * instancia.
	 * 
	 * @param id         Um objeto <b>String</b>, que sera o Item a ser modificado.
	 * @param newInfo    Uma variavel <b>int</b>, que determminara qual informacao
	 *                   sera modificada.
	 * @param newContent Um objeto <b>String</b>, o novo conteudo/informacao.
	 * @return Boolean <b>true</b> se alterou, <b>false</b> se nao houve alteracao.
	 */

	public static Boolean update(String id, int newInfo, String newContent) {
		for (Fornecedor item : ControladorFornecedores.listaFornecedores) {
			if ((item.getId()).equals(id)) {
				switch (newInfo) {
				case 1:
					item.setNome(newContent);
					return true;
				case 2:
					item.setCNPJ(newContent);
					return true;
				case 3:
					item.setAdress(newContent);
					return true;
				}
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
		for (Fornecedor item : ControladorFornecedores.listaFornecedores) {
			if ((item.getId()).equals(id)) {
				ControladorFornecedores.listaFornecedores.remove(item);
				return true;
			}
		}
		return false;
	}

	public static Fornecedor getFornecedorbById(String id) {
		for(Fornecedor user: listaFornecedores) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

}