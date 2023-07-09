package modelos;

import java.util.ArrayList;


/**
 * Esta classe e o modelo para as vendas que serao cadastradas no sistema. Nao
 * possui construtor alem do padrao, o metodo create do controlador funciona
 * como um.
 */

public class Vendas {
	private String id;
	private String dataHora;
	private Double precoTotal = 0.0;

	/**
	 * <b>listaPedidos</b> e uma ArrayList do tipo <b>ItemCardapio</b> que ira
	 * funcionar como a "comanda" da venda.
	 */
	private ArrayList<ItemCardapio> listaPedidos = new ArrayList<ItemCardapio>();

	/**
	 * Setter para o ID.
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
	 * Setter para a Data e horario.
	 * 
	 * @param newData Uma <b>String</b>.
	 */

	public void setDataHora(String newData) {
		this.dataHora = newData;
	}

	/**
	 * Getter para A Data e horario.
	 * 
	 * @return Uma <b>String</b>.
	 */

	public String getDataHora() {
		return this.dataHora;
	}

	/**
	 * Setter para o Preco.
	 * 
	 * @param valor Um <b>Double</b>.
	 */
	public void setPreco(Double valor) {
		this.precoTotal += valor;
	}

	/**
	 * Getter para o Preco.
	 * 
	 * @return <b>Double</b>.
	 */
	public Double getPreco() {
		return this.precoTotal;
	}

	/**
	 * Este metodo adiciona um Item do Cardapio a lista de pedidos e atualiza o
	 * valor da venda.
	 * 
	 * @param adicao Um objeto da classe <b>ItemCardapio</b> que sera adicionada a
	 *               lista de pedidos desta venda.
	 * 
	 * @return Boolean, <b>true</b> se adicionado, <b>false</b> se falha.
	 */
	public Boolean addItem(ItemCardapio adicao) {
		this.precoTotal += adicao.getPreco();
		return this.listaPedidos.add(adicao);
	}

	/**
	 * Este metodo remove um Item do Cardapio da lista de pedidos e atualiza o valor
	 * da venda.
	 * 
	 * @param id Uma <b>String</b> que marca o item da lista a ser removido.
	 * 
	 * @return Boolean, <b>true</b> se removido, <b>false</b> se falha.
	 */

	public Boolean removeItem(String id) {
		for (ItemCardapio item : this.listaPedidos) {
			if (item.id.equals(id)) {
				this.precoTotal -= item.getPreco();
				return this.listaPedidos.remove(item);
			}
		}
		return false;
	}

	/**
	 * Este metodo simplesmente lista os produtos dentro da lista e ainda imprime na
	 * tela o valor total ao final do laco.
	 * 
	 * @return Boolean, <b>false</b> se a lista de pedidos estiver vazia,
	 *         <b>true</b> se houver algum.
	 */
	public Boolean listagem() {
		if (this.listaPedidos.isEmpty()) {
			return false;
		} else {
			System.out.println(
					"                    NOME|                    DESCRICAO|                    TIPO|                 PRECO|        ID|");
			String formato;
			for (ItemCardapio item : this.listaPedidos) {
				formato = String.format("%-25s| %-28s| %-10s| %-15s| %-8s", item.getNome(), item.getDescricao(),
						item.getTipo(), item.getPreco(), item.getId());
				System.out.println(formato);
			}
			System.out.printf("VALOR TOTAL = %s", this.precoTotal);
			System.out.println("FIM DA LISTA DE PEDIDOS!");
		}
		return true;
	}
	
	public ArrayList<ItemCardapio> getPedidos(){
		return this.listaPedidos;
	}
	
	public String getData() {
		return this.dataHora.substring(11);
		
	}
	public String getMesAno() {
		return this.dataHora.substring(14);
	}
}
