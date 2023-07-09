package modelos;

import java.util.ArrayList;

/**
 * Modelo <b>ItemCardapio</b> herda da classe abstrata Entidade. ItemCardapio e
 * um modelo para os Objetos que irao compor o cardapio. O modelo nao possui
 * construtor alem do padrao, o metodo create do controlador funciona como um.
 * 
 * 
 */
public class ItemCardapio extends Entidade {
	private String descricao;
	private String categoria;
	private Double preco;
	
	/**
	 * Lista de produtos que compõem o prato
	 */
	private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	
	
	/**
	 * Setter para a descricao, recebe uma String e atribui o valor para a desricao
	 * do objeto instanciado.
	 * 
	 * @param descricao <b>String</b>
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Getter para o atributo descricao.
	 * 
	 * @return <b>String</b> - retorna a descricao da instancia.
	 */

	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * Setter para o atributo preco, recebe um Double.
	 * 
	 * @param preco Um <b>Double</b>.
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	/**
	 * Getter para o atributo preco, retorna um Double.
	 * 
	 * @return <b>Double</b>, quando atribuido, null assim que iniciado.
	 */
	public Double getPreco() {
		return this.preco;
	}

	/**
	 * Setter para o tipo de Item do cardapio, Utiliza switch case para atribuir.
	 * 
	 * @param opcao Variavel tipo int.
	 * @return <b>boolean</b> true quando atribui, false quando nao.
	 */
	public Boolean setTipo(int opcao) {
		switch (opcao) {
		case 1:
			this.categoria = "Entrada";
			break;
		case 2:
			this.categoria = "Massa";
			break;

		case 3:
			this.categoria = "Bebida";
			break;

		case 4:
			this.categoria = "Sobremesa";
			break;

		}
		return true;
	}

	/**
	 * Getter para o Tipo do Item.
	 * 
	 * @return String quando instanciado e atribuido, null quando nao.
	 */
	public String getTipo() {
		return this.categoria;
	}

	/**
	 * Setter para o ID do Item.
	 * 
	 * @param id <b>String</b>
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Ingrediente> getIngredientes() {
		return this.ingredientes;
	}

	/**
	 * 
	 * @param ingrediente
	 */
	public void addIngredientes(Ingrediente ingrediente) {
		this.ingredientes.add(ingrediente);
	}
	
	/**
	 * 
	 * @param newIngredientes
	 */
	public void setIngredientes(ArrayList<Ingrediente> newIngredientes) {
		this.ingredientes = newIngredientes;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void removeIngrediente(String id) {
		for (Ingrediente item : ingredientes) {
			if (item.getProdutoCatalago().getId().equals(id)) {
				ingredientes.remove(item);
			}
		}
	}
	
}
