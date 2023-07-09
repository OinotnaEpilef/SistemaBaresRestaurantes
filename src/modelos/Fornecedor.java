package modelos;

import java.util.ArrayList;

/**
 * Modelo <b>ItemCardapio</b> herda os metodos e atributos da classe abstrata
 * <b>Entidade</b>. ItemCardapio e um modelo para os Objetos que irao compor o
 * cardapio. O modelo nao possui construtor alem do padrao, o metodo create do
 * controlador funciona como um.
 * 
 * 
 */

public class Fornecedor extends Entidade {

	private String cnpj;
	private String endereco;
	private ArrayList<String> produtos = new ArrayList<String>();

	/**
	 * Setter para o CNPJ do objeto.
	 * 
	 * @param cnpj <b>String</b>.
	 */
	public void setCNPJ(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * Getter para o CNPJ.
	 * 
	 * @return String.
	 */
	public String getCNPJ() {
		return this.cnpj;
	}

	/**
	 * Setter para o Endereco do objeto.
	 * 
	 * @param adress String.
	 */
	public void setAdress(String adress) {
		this.endereco = adress;
	}

	/**
	 * Getter para o Endereco do objeto.
	 * 
	 * @return <b>String</b>.
	 */
	public String getAdress() {
		return this.endereco;
	}

	public ArrayList<String> getProdutos() {
		return produtos;
	}

	public void addProdutos(String produtos) {
		this.produtos.add(produtos);
	}

	public void delProdutos(int index) {
		this.produtos.remove(index);
	}
}