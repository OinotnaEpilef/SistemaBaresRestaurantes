package modelos;

import java.util.ArrayList;

public class ControladorEstoque {

	/**
	 * estoqueGeral, uma lista estatica que ira guardar todo o estoque
	 */
	private static ArrayList<ProdutoCatalago> estoqueGeral = new ArrayList<ProdutoCatalago>();

	/**
	 * Este metodo retorna o estoqueGeral, por hora, possui uso exclusivo para
	 * testes
	 * 
	 * @return ArrayList<ProdutoCatalago>
	 */
	public static ArrayList<ProdutoCatalago> getEstoqueGeral() {
		return estoqueGeral;
	}

	/**
	 * Atua como construtor da classe, instancia um objeto, atribui valores aos
	 * atributos e o objeto criado.
	 * 
	 * @param nome    Uma String.
	 * @param quantia Um double.
	 * @return ProdutoCatalago.
	 */
	public static ProdutoCatalago create(String nome) {
		ProdutoCatalago novo = new ProdutoCatalago();
		novo.setNome(nome);
		novo.setId(createId());
		estoqueGeral.add(novo);
		return novo;
	}

	public static void addEstoque(ProdutoCatalago estoque) {
		ControladorEstoque.estoqueGeral.add(estoque);
	}
	
	/**
	 * Acessa o estoque geral para gerar um ID, cria o primeiro ID se a lista
	 * estiver vazio, caso contrario, acessa o ultimo elemento da lista, para pegar
	 * o NUMERICO desse ultimo ID, somar 1 e retornar o novo ID.
	 * 
	 * @return <b>String</b> O id gerado.
	 */
	public static String createId() {
		if (estoqueGeral.isEmpty()) {
			return "PRDCT1";
		} else {
			int ultimo = estoqueGeral.size() - 1;
			String fatia = (estoqueGeral.get(ultimo)).getId();
			fatia = fatia.substring(5);
			int newID = (Integer.parseInt(fatia) + 1);
			return ("PRDCT" + Integer.toString(newID));
		}
	}

	/**
	 * Simplesmente Le a lista de produtos, formatando e e imprimindo o Objeto
	 * <b>formato</b> enquanto percorre o estoque.
	 *
	 * @return Boolean, false se a lista esta vazia, true se nao.
	 */

	public static int read() {
		if (estoqueGeral.isEmpty()) {
			return 1;
		} else {
			String formato;
			System.out.println("|PRODUTO EM ESTOQUE  |QUANTIA ATUAL     |ID              |");
			for (ProdutoCatalago i : estoqueGeral) {
				formato = String.format("     |%.20s| %.15s|%.15s|", i.getNome(), i.getQuantiaAtual(), i.getId());
				System.out.println(formato);
			}
			System.out.println("FIM DA LISTA DE ESTOQUE!");

			return 0;
		}
	}

	/**
	 * Metodo de remocao por id.
	 * 
	 * @param id
	 * @return Boolean true se o objeto esta na lista e foi removido, false se nao.
	 */

	public static Boolean delete(String id) {
		for (ProdutoCatalago item : estoqueGeral) {
			if (item.getId().equals(id)) {
				return estoqueGeral.remove(item);
			}
		}
		return false;
	}

	/**
	 * Retorna o estoque de um determinado produto pelo id.
	 * 
	 * @param id
	 * @return ProdutoCatalago
	 */
	public static ProdutoCatalago getEstoqueProduto(String id) {
		for (ProdutoCatalago item : estoqueGeral) {
			if (item.getId().equals(id)) {
				return item;
			}
		}
		return null;
	}

	/**
	 * Checa se a quantia existente em um determinado estoque e igual ou maior a
	 * quantia passada.
	 * 
	 * @param estoque
	 * @param quantia
	 * @return Boolean true se a quantia no estoque e igual ou maior, false se nao.
	 */
	public static Boolean checarQuantia(ProdutoCatalago estoque, double quantia) {
		if (estoque.getQuantiaAtual() >= quantia) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Faz o arremate do estoque baseado na quantia passada, testa cada produto
	 * dentro do estoque, caso a quantia atual do produto na primeira posicao seja
	 * menor que a necessaria, e retirada da quantia necessaria a quantia que o
	 * produto no estoque e o produto e removido tanto do estoque do produto quanto
	 * da lista geral de produtos. Caso a quantidade atual do primeiro produto seja
	 * suficiente, ele retira do produto a quantia necessaria e zera q quantia,
	 * finalizando o metodo.
	 * 
	 * @param estoque
	 * @param quantia
	 */
	public static void arremate(ProdutoCatalago estoque, double quantia) {

		while (quantia > 0) {
			if (estoqueGeral.get(0).getQuantiaAtual() <= quantia) {
				quantia -= estoqueGeral.get(0).getQuantiaAtual();
				
				ControladorProdutos.delete(estoque.getFirst());
				estoque.removeProdutoObjeto(estoque.getFirst());

			} else {
				estoqueGeral.get(0).setQuantiaAtual(estoqueGeral.get(0).getQuantiaAtual() - quantia);
				quantia = 0;
			}
		}
	}

	public static Boolean listContains(ArrayList<Ingrediente> lista, ProdutoCatalago procurar) {
		for(Ingrediente item: lista) {
			if (item.getProdutoCatalago() == procurar) {
				return true;
			}
		}
		return false;
	}
	
	
}
