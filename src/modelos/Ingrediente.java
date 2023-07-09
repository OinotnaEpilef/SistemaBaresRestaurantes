package modelos;

public class Ingrediente {
	private ProdutoCatalago estoqueProd;
	private Double quantiaNecessaria;
	
	public Double getQuantia() {
		return this.quantiaNecessaria;
	}
	
	public void setQuantia(Double quantia) {
		this.quantiaNecessaria = quantia;
	}
	
	public ProdutoCatalago getProdutoCatalago() {
		return this.estoqueProd;
	}
	
	public void setEstoqueNeeded(ProdutoCatalago estoqueProd) {
		this.estoqueProd = estoqueProd;
	}
}
