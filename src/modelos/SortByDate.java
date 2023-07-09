/**
 * 
 */
package modelos;

import java.util.Comparator;

/**
 * @author Antonio Felipe e Wagner Alexandre
 *
 */

 /**
 * Compara dois objetos do tipo Produto, trocando ambos de posição
 * se a data da validade for maior que a do seu sucessor, para ordenar
 * a lista de produtos
 * @param a
 * @param b
 *
 * @return int < 0 quando a < b
 * @return int = 0 quando a = b
 * @return int > 0 quando a > b 
 *
 */
public class SortByDate implements Comparator<Produto> {
	public int compare(Produto a, Produto b) {
		return a.getValidade().compareTo(b.getValidade());
	}
}
