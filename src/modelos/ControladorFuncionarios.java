package modelos;

import java.util.ArrayList;

/**
 * A classe <b>ControladorFuncionarios</b> faz o controle geral dos objetos do
 * tipo Funcionario.
 * 
 * 
 */

public class ControladorFuncionarios {

	public ControladorFuncionarios() {
	}

	/**
	 * <b>listaFuncionarios</b> E um ArrayList que ira guardar todos os funcionarios
	 * (nao gerentes) cadastrados no sistema.
	 * 
	 */
	private static ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

	/**
	 * O metodo <b>getListaFuncionarios</b> ira retornar um <b>ArrayList</b> do tipo
	 * <b>Funcionario</b>, este metodo por enquanto possui uso exclusivo para
	 * testes.
	 * 
	 * @return ArrayList listaFuncionarios do tipo Funcionarios
	 */
	public static ArrayList<Funcionario> getListaFuncionarios() {
		return ControladorFuncionarios.listaFuncionarios;
	}

	/**
	 * Este metodo atua como constutor, recebendo somente um parametro
	 * <b>String</b>: o nome do funcionario. Ele instancia um novo objeto do tipo
	 * <b>Funcionario</b> e faz a atribuicao dos valores dos atributos utilizando os
	 * setters do modelo. Apos atribuir, ele adiciona a instancia a lista de
	 * funcionarios e a retorna para fins de teste.
	 * 
	 * @param nome     <b>Strings</b>.
	 * @param password <b>Strings</b>.
	 * @return Funcionario.
	 */
	public static Funcionario create(String nome, String password) {
		Funcionario novo = new Funcionario();
		novo.setNome(nome);
		novo.setId(createId());
		novo.setPassword(password);
		ControladorFuncionarios.listaFuncionarios.add(novo);
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
		if (ControladorFuncionarios.listaFuncionarios.isEmpty()) {
			return "FNCRS1";
		} else {
			int ultimo = ControladorFuncionarios.listaFuncionarios.size() - 1;
			String fatia = (ControladorFuncionarios.listaFuncionarios.get(ultimo)).getId();
			fatia = fatia.substring(5);
			int newID = (Integer.parseInt(fatia) + 1);
			return ("FNCRS" + Integer.toString(newID));
		}
	}

	/**
	 * Simplesmente Le a lista de funcionarios, formatando o Objeto <b>formato</b>
	 * enquanto percorre o Cardapio com as informacoes de cada Item.
	 *
	 * @return Boolean, false se a lista esta vazia, true se nao.
	 */
	public static Boolean read() {
		if (listaFuncionarios.isEmpty()) {
			return false;
		} else {
			System.out.println("|NOME              |ID              |");
			String formato;
			for (Funcionario item : ControladorFuncionarios.listaFuncionarios) {
				formato = String.format("|%18s| %15s|", item.getNome(), item.getId());
				System.out.println(formato);
			}
			System.out.println("FIM DA LISTA DE FUNCIONARIOS!");
			return true;
		}
	}

	/**
	 * O metodo existe para alterar algumas informacoes de um determinado objeto.
	 * 
	 * @param id         Um objeto <b>String</b>, que sera o Item a ser modificado.
	 *                   sera modificada.
	 * @param newContent Um objeto <b>String</b>, o novo conteudo/informacao.
	 * 
	 * @return Boolean <b>true</b> se alterou, <b>false</b> se nao houve alteracao.
	 */

	public static Boolean update(String id, String newContent) {
		for (Funcionario item : ControladorFuncionarios.listaFuncionarios) {
			if (item.getId().equals(id)) {
				item.setNome(newContent);
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
		for (Funcionario item : ControladorFuncionarios.listaFuncionarios) {
			if (item.getId().equals(id)) {
				ControladorFuncionarios.listaFuncionarios.remove(item);
				return true;
			}
		}
		return false;
	}

	/**
	 * O metodo varre a lista de funcionarios procurando um objeto com o id igual ao
	 * passado, e checando se sua senha e igual a de entrada.
	 * 
	 * @param id
	 * @param password
	 * @return Boolean se existente no sistema
	 */
	public static Boolean checkIdSenha(String id, String password) {
		for (Funcionario item : ControladorFuncionarios.listaFuncionarios) {
			if (item.getId().equals(id)) {
				if (item.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}
}