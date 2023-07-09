package modelos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A classe <b>Produto</b> e o modelo para os produtos que serao cadastrados no
 * sistema.
 *
 */

public class Produto extends Entidade {
	private String validade;
	private Double preco;
	private Double quantia;

	/**
	 * Setter para o atributo vencimento.
	 * 
	 * @param validade <b>String</b>.
	 */

	public void setValidade(String validade) {
		try {
			SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
			form.parse(validade);
			this.validade = validade;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	public Double getQuantia() {
		return this.quantia;
	}

	/**
	 * 
	 * @param quantia
	 */
	public void setQuantia(Double quantia) {
		this.quantia = quantia;
	}

	/**
	 * Getter para o atributo vencimento.
	 * 
	 * @return String.
	 */
	public Date getValidade() {
		SimpleDateFormat form = new SimpleDateFormat("dd-MM-YY");
		try {
			Date data = form.parse(this.validade);
			return data;
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return null;

	}

	/**
	 * Setter para o atributo preco.
	 * 
	 * @param preco <b>Double</b>.
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	/**
	 * Getter para o atributo preco.
	 * 
	 * @return <b>Double</b>.
	 */
	public Double getPreco() {
		return this.preco;
	}

}