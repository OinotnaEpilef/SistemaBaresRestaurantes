package modelos;


/**
 * Classe abstrata Entidade, possui 2 atributos e setters e getters para estes.
 * Ambos os atributos sao <b>Strings</b>
 * 
 */

public abstract class Entidade {
	protected String id;
	protected String nome;

	/**
	 * Setter para o Id.
	 * 
	 * @param id Uma <b>String</b>.
	 */

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Getter para o ID.
	 * 
	 * @return <b>String</b>.
	 */

	public String getId() {
		return this.id;
	}

	/**
	 * Setter para o nome.
	 * 
	 * @param nome Uma <b>String</b>.
	 */

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Getter para o nome.
	 * 
	 * @return <b>String</b>.
	 */

	public String getNome() {
		return this.nome;
	}

}
