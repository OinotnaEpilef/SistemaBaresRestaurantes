package modelos;

import java.util.ArrayList;
import java.util.Date;

public class ProdutoCatalago extends Entidade {
	private Double quantiaAtual;

	/**
	 * Lista que guardara os produtos existentes
	 */
	private ArrayList<Produto> estoque = new ArrayList<Produto>();

	public ProdutoCatalago create(String nome) {
		ProdutoCatalago novo = new ProdutoCatalago();
		novo.setNome(nome);
		return novo;

	}

	public ArrayList<Produto> getCatalago() {
		return this.estoque;
	}

	/**
	 * Retorna o primeiro produto no estoque.
	 * 
	 * @return Produto
	 */
	public Produto getFirst() {
		return estoque.get(0);
	}

	/**
	 * Getter para a quantia atual total dos itens do catalago
	 * 
	 * @return Double Quantia restante do conjunto;
	 */
	public Double getQuantiaAtual() {
		return quantiaAtual;
	}

	/**
	 * Setter para a quantia total atual total dos itens do catalgo
	 * 
	 * @param quantiaAtual Double
	 */
	public void addQuantiaAtual(Double quantiaAtual) {
		this.quantiaAtual += quantiaAtual;
	}

	/**
	 * 
	 * @param adicionar Um objeto do tipo produto a ser adicionado ao catalago do
	 *                  item
	 * @return <b>true</b> ao adicionar.
	 */
	public boolean addProduto(Produto adicionar) {
		Date itemAtual = new Date();
		Date ItemAdd = new Date();

		if (this.estoque.isEmpty()) {
			this.addQuantiaAtual(adicionar.getQuantia());
			return this.estoque.add(adicionar);
			
		} else {
			for (int atual = 0; atual == this.estoque.size(); atual++) {
				if (itemAtual.compareTo(ItemAdd) > 0) {
					this.estoque.add(atual, adicionar);
				}
			}
			return this.estoque.add(adicionar);

		}
	}

	/**
	 * Metodo de remocao por id.
	 * 
	 * @param id O conjunto de itens a ser excluido.
	 * @return false Caso falhe/esteja vazio, true em caso de sucesso.
	 */
	public boolean removeProdutoId(String id) {
		if (this.estoque.isEmpty()) {
			return false;
		} else {
			for (Produto item : this.estoque) {
				if (item.getId().equals(id)) {
					this.estoque.remove(item);
					return true;
				}
			}
			return false;
		}
	}

	/**
	 * Metodo de remocao por objeto.
	 * 
	 * @param objeto O produto a ser excluido.
	 * @return true Em caso de sucesso, false em falha.
	 */
	public boolean removeProdutoObjeto(Produto objeto) {
		return this.estoque.remove(objeto);
	}

	public void setQuantiaAtual(double d) {
		this.quantiaAtual = d;
		
	}
}