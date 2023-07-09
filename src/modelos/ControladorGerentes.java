package modelos;

import java.util.ArrayList;

/**
 * A classe <b>ControladorGerentes</b> faz o controle geral dos objetos do tipo
 * Gerente.
 * 
 * 
 *
 */

public class ControladorGerentes {
	/**
	 * Contrutor vazio/padrao
	 * 
	 * @return ControladorGerentes()
	 */
	public ControladorGerentes() {

	}

	/**
	 * <b>listaGerentes</b> E uma ArrayList que ira guardar todos os funcionarios
	 * gerentes cadastrados no sistema.
	 * 
	 */

	public static ArrayList<Gerente> listaGerentes = new ArrayList<Gerente>();

	/**
	 * O metodo <b>getCardapio</b> ira retornar o <b>ArrayList</b> do tipo
	 * <b>Cardapio</b>, este metodo por enquanto possui uso exclusivo para testes.
	 * 
	 * @return ControladorGerentes.listaGerentes Uma ArrayList do tipo Gerentes.
	 */
	public static ArrayList<Gerente> getListaGerentes() {
		return ControladorGerentes.listaGerentes;
	}

	/**
	 * Este metodo funciona como um construtor, instanciando um novo objeto do tipo
	 * <b>Gerente</b> e atribuindo os valores dos parametros no atributos do objeto
	 * instanciado utilizando os setters definidos na classe, o ID e gerado por
	 * outro metodo do Controlador, ao finalizar as atribuicoes, a instancia e
	 * adicionada na lista de Gerente e retornada.
	 * 
	 * @param nome     Uma String que tera o nome do gerente.
	 * @param password Uma String que sera a senha do gerente
	 * @return Gerente.
	 */
	public static Gerente create(String nome, String password) {
		Gerente novo = new Gerente();
		novo.setNome(nome);
		novo.setPassword(password);
		novo.setId(createId());
		ControladorGerentes.listaGerentes.add(novo);
		return novo;
	}

	/**
	 * Acessa a lista de gerentes para gerar um ID, se a lista estiver vazia, cria o
	 * primeiro ID caso contrario, acessa o ultimo elemento da lista, para pegar o
	 * NUMERICO desse ultimo ID, somar 1 e retornar o novo ID.
	 * 
	 * @return Uma <b>String</b>.
	 */

	public static String createId() {
		if (ControladorGerentes.listaGerentes.isEmpty()) {
			return "GRNTS1";
		} else {
			int ultimo = ControladorGerentes.listaGerentes.size() - 1;
			String fatia = (ControladorGerentes.listaGerentes.get(ultimo)).getId();
			fatia = fatia.substring(5);
			int newID = (Integer.parseInt(fatia) + 1);
			return ("GRNTS" + Integer.toString(newID));
		}
	}

	/**
	 * Simplesmente Le a lista de gerentes, formatando o Objeto <b>formato</b>
	 * enquanto percorre o Cardapio com as informacoes de cada Item.
	 *
	 * @return Boolean retorna false se a lista esta vazia, true se nao.
	 */

	public static Boolean read() {
		if (listaGerentes.isEmpty()) {
			return false;
		} else {
			System.out.println("|NOME              |ID              |");
			String formato;
			for (Gerente item : ControladorGerentes.listaGerentes) {
				formato = String.format("|%18s| %15s|", item.getNome(), item.getId());
				System.out.println(formato);
			}
			System.out.println("FIM DA LISTA DE GERENTES!");
			return true;
		}
	}

	/**
	 * Este metodo e especifico para checkar se a <b>String</b> ID recebida existe
	 * na lista de gerentes.
	 * 
	 * @param id <b>String</b>.
	 * @return Boolean retorna true se existir na lista, false se nao.
	 */
	public static Boolean checkId(String id) {
		for (Gerente item : ControladorGerentes.listaGerentes) {
			if (item.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * O metodo existe para alterar algumas informacoes de um determinado objeto.
	 * 
	 * @param id         Um objeto <b>String</b>, que sera o Item a ser modificado.
	 * @param newContent Um objeto <b>String</b>, o novo conteudo/informacao.
	 * @return Boolean <b>true</b> se alterou, <b>false</b> se nao houve alteracao.
	 */

	public static Boolean update(String id, String newContent) {
		for (Gerente item : ControladorGerentes.listaGerentes) {
			if (item.getId().equals(id)) {
				item.setNome(newContent);
				return true;
			}
		}
		return false;
	}

	/**
	 * O metodo ira percorrer a lista de gerentes a procura do item com ID igual ao
	 * parametro passado.
	 * 
	 * @param id, Um objeto <b>String</b>, que indentifica o Item a ser removido.
	 * @return Boolean, <b>true</b> se o item tiver sido removido, <b>false</b> se o
	 *         item nao foi achado.
	 */

	public static Boolean delete(String id) {
		for (Gerente item : ControladorGerentes.listaGerentes) {
			if (item.getId().equals(id)) {
				ControladorGerentes.listaGerentes.remove(item);
				return true;
			}
		}
		return false;
	}

	/**
	 * O metodo varre a lista de gerentes procurando um objeto com o id igual ao
	 * passado, e checando se sua senha e igual a de entrada.
	 * 
	 * @param id
	 * @param password
	 * @return
	 */
	public static Boolean checkIdSenha(String id, String password) {
		for (Gerente item : ControladorGerentes.listaGerentes) {
			if (item.getId().equals(id)) {
				if (item.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}
}
