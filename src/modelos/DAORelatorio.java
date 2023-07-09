package modelos;

import java.io.FileOutputStream;
import java.io.IOException;

/*import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;*/

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;

/*public class DAORelatorio {*/
	/**
	 * Gera o arquivo pdf com o relatirio geral de todas as vendas
	 *
	 */
	/*public static Boolean reportAllSales() throws DocumentException, IOException {
		Document doc = new Document();
		try {
			PdfWriter.getInstance(doc, new FileOutputStream("RELATORIO-TODAS-AS-VENDAS.pdf"));
			if (!ControladorVendas.getListaVendas().isEmpty()) {
				doc.open();
				Paragraph p1 = new Paragraph("RELATORIO GERAL\n");
				p1.setAlignment(Element.ALIGN_CENTER);
				doc.add(p1);
				p1 = new Paragraph("|ID                       |PRECO         |HORA     |DATA     |\n");
				String formato;
				for (Vendas item : ControladorVendas.getListaVendas()) {
					formato = String.format("|%-18s|%-20s|%-15s|\n", item.getId(), item.getPreco(), item.getDataHora());
					p1.add(formato);
				}
				p1.setAlignment(Element.ALIGN_CENTER);
				doc.add(p1);
				doc.close();
				return true;
			}
		} catch (DocumentException e) {
			throw e;
		} catch (IOException o) {
			throw o;
		}
		return false;
	}/*

	/**
	 * Gera o arquivo pdf com o relatorio de todas as vendas feitas no dia atual
	 *
	 */
	/*public static Boolean reportSalesInDay() throws DocumentException, IOException {
		String dataHora = new SimpleDateFormat("dd-MM-YY").format(Calendar.getInstance().getTime());
		String nome = ("RELATORIO_VENDAS_DIA" + dataHora + ".pdf");
		Document doc = new Document();
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(nome));
			if (!ControladorVendas.getListaVendas().isEmpty()) {
				doc.open();
				Paragraph p1 = new Paragraph("RELATORIO DIARIO\n");
				p1.setAlignment(Element.ALIGN_CENTER);
				doc.add(p1);
				p1 = new Paragraph("|ID                       |PRECO         |HORA     |DATA     |\n");
				String formato;
				for (Vendas item : ControladorVendas.getListaVendas()) {
					if (item.getData().equals(dataHora)) {
						formato = String.format("|%-18s|%-20s|%-15s|\n", item.getId(), item.getPreco(),
								item.getDataHora());
						p1.add(formato);
					}
				}
				p1.setAlignment(Element.ALIGN_CENTER);
				doc.add(p1);
				doc.close();
				return true;
			}
		} catch (DocumentException e) {
			throw e;
		} catch (IOException o) {
			throw o;
		}
		return false;
	}/*

	/**
	 * Gera o arquivo pdf com o relatirio de todas as vendas feitas no mes atual
	 *
	 */
	/*public static Boolean reportSalesInMonth() throws DocumentException, IOException {
		String dataHora = new SimpleDateFormat("MM-YY").format(Calendar.getInstance().getTime());
		String nome = ("RELATORIO_VENDAS_MES-" + dataHora + ".pdf");

		Document doc = new Document();
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(nome));
			if (!ControladorVendas.getListaVendas().isEmpty()) {
				doc.open();
				Paragraph p1 = new Paragraph("RELATORIO MENSAL\n");
				p1.setAlignment(Element.ALIGN_CENTER);
				doc.add(p1);
				p1 = new Paragraph("|ID                       |PRECO         |HORA     |DATA     |\n");
				String formato;
				for (Vendas item : ControladorVendas.getListaVendas()) {
					if (item.getMesAno().equals(dataHora)) {
						formato = String.format("|%-18s|%-20s|%-15s|\n", item.getId(), item.getPreco(),
								item.getDataHora());
						p1.add(formato);
					}
				}
				p1.setAlignment(Element.ALIGN_CENTER);
				doc.add(p1);
				doc.close();
				return true;
			}
		} catch (DocumentException e) {
			throw e;
		} catch (IOException o) {
			throw o;
		}
		return false;
	}/*

	/**
	 * Gera o arquivo pdf com o relatorio de todas as vendas ordenadas por tipo de
	 * prato
	 *
	 */
	/*public static Boolean reportSalesPerType() throws DocumentException, IOException {
		ArrayList<Vendas> entradas = new ArrayList<Vendas>();
		ArrayList<Vendas> massas = new ArrayList<Vendas>();
		ArrayList<Vendas> bebidas = new ArrayList<Vendas>();
		ArrayList<Vendas> sobremesas = new ArrayList<Vendas>();
		ArrayList<Vendas> listaGeral = (ArrayList<Vendas>) ControladorVendas.getListaVendas();
		for (Vendas venda : listaGeral) {
			for (ItemCardapio item : venda.getPedidos()) {
				if (item.getTipo().equals("Entrada")) {
					entradas.add(venda);
				} else if (item.getTipo().equals("Massa")) {
					massas.add(venda);
				} else if (item.getTipo().equals("Bebidas")) {
					bebidas.add(venda);
				} else {
					sobremesas.add(venda);
				}
			}
		}
		Document doc = new Document();
		try {
			PdfWriter.getInstance(doc, new FileOutputStream("RELATORIO-VENDAS-POR-TIPO-DE-PRATO.pdf"));
			doc.open();
			Paragraph p1 = new Paragraph("RELATORIO VENDAS POR TIPO DE PRATO\n");
			p1.setAlignment(Element.ALIGN_CENTER);
			doc.add(p1);
			String formato;
			p1 = new Paragraph("ENTRADAS");
			p1.add("|ID                       |PRECO         |HORA     |DATA     |\n");
			for (Vendas venda : entradas) {
				formato = String.format("|%-18s|%-20s|%-15s|\n", venda.getId(), venda.getPreco(), venda.getDataHora());
				p1.add(formato);
			}
			doc.add(p1);
			p1.add("MASSAS");
			p1.add("|ID                       |PRECO         |HORA     |DATA     |\n");
			for (Vendas venda : massas) {
				formato = String.format("|%-18s|%-20s|%-15s|\n", venda.getId(), venda.getPreco(), venda.getDataHora());
				p1.add(formato);
			}
			p1.add("BEBIDAS");
			p1.add("|ID                       |PRECO         |HORA     |DATA     |\n");
			for (Vendas venda : bebidas) {
				formato = String.format("|%-18s|%-20s|%-15s|\n", venda.getId(), venda.getPreco(), venda.getDataHora());
				p1.add(formato);
			}
			p1.add("SOBREMESAS");
			p1.add("|ID                       |PRECO         |HORA     |DATA     |\n");
			for (Vendas venda : sobremesas) {
				formato = String.format("|%-18s|%-20s|%-15s|\n", venda.getId(), venda.getPreco(), venda.getDataHora());
				p1.add(formato);
			}
			p1.setAlignment(Element.ALIGN_CENTER);
			doc.add(p1);
			doc.close();
			return true;
		} catch (DocumentException e) {
			throw e;
		} catch (IOException o) {
			throw o;
		}
	}/*

	/**
	 * Gera o relatiro geral do estoque, mostrando todos os produtos
	 *
	 *
	 */
	/*public static Boolean reportStockGeral() throws DocumentException, IOException {
		Document doc = new Document();
		try {
			PdfWriter.getInstance(doc, new FileOutputStream("RELATORIO-ESTOQUE-GERAL.pdf"));
			if (!ControladorProdutos.getListaProdutos().isEmpty()) {
				doc.open();
				Paragraph p1 = new Paragraph("RELATORIO GERAL ESESTOQUE\n");
				p1.setAlignment(Element.ALIGN_CENTER);
				doc.add(p1);
				p1 = new Paragraph(
						"|NOME              |PRECO            |VENCIMENTO                   |ID              |\n");
				String formato;
				for (Produto item : ControladorProdutos.getListaProdutos()) {
					formato = String.format("|%18s| %16s| %28s| %15s|\n", item.getNome(), item.getPreco(),
							item.getValidade(), item.getId());
					p1.add(formato);
				}
				p1.setAlignment(Element.ALIGN_CENTER);
				doc.add(p1);
				doc.close();
				return true;
			}
		} catch (DocumentException e) {
			throw e;
		} catch (IOException o) {
			throw o;
		}
		return false;
	}/*

	/**
	* Gera o arquivo pdf com o relatorio do estoque ordenado por produto
	*
	*
	*/
	/*public static Boolean reportStockPerProduct() throws DocumentException, IOException {
		Document doc = new Document();
		try {
			PdfWriter.getInstance(doc, new FileOutputStream("RELATORIO-ESTOQUE-POR-PRODUTO.pdf"));
			Paragraph p1 = new Paragraph();
			doc.open();
			p1.setAlignment(Element.ALIGN_CENTER);
			doc.add(p1);
			String formato;
			p1 = new Paragraph("ESTOQUE DE PRODUTOS\n");
			for (Produto item : ControladorProdutos.getListaProdutos()) {
				formato = String.format("|%18s| %16s| %28s| %15s|\n", item.getNome(), item.getPreco(),
						item.getValidade(), item.getId());
				p1.add(formato);
			}
			p1.setAlignment(Element.ALIGN_CENTER);
			doc.add(p1);
			doc.close();
			return true;
		} catch (DocumentException e) {
			throw e;
		} catch (IOException o) {
			throw o;
		}
	}/*

	/**
	* Gera o arquivo pdf com o relatorio do estoque ordenado por data de validade
	*
	*
	*/
	/*public static Boolean reportStockPerProductValidade() throws DocumentException, IOException {
		Document doc = new Document();
		try {
			PdfWriter.getInstance(doc, new FileOutputStream("RELATORIO-ESTOQUE-POR-VALIDADE.pdf"));
			Paragraph p1 = new Paragraph();
			SimpleDateFormat form = new SimpleDateFormat("dd-MM-YY");
			doc.open();
			p1.setAlignment(Element.ALIGN_CENTER);
			doc.add(p1);
			String formato;
			p1 = new Paragraph("ESTOQUE DE PRODUTOS POR VALIDADE\n");
			p1.setAlignment(Element.ALIGN_CENTER);
			doc.add(p1);
			ArrayList<Produto> clone = new ArrayList<Produto>();
			Iterator<Produto> interativo = ControladorProdutos.getListaProdutos().iterator();
			Paragraph p11 = new Paragraph();
			while (interativo.hasNext()) {
				clone.add((Produto) interativo.next());
			}
			Collections.sort(clone, new SortByDate());
			p11.add("|NOME                |PRECO         |VENCIMENTO    |ID              |\n");
			for (Produto item : clone) {
				formato = String.format("|%-20s|%-15s|%-15s|%-15s|\n", item.getNome(), item.getPreco(),
						form.format(item.getValidade()), item.getId());
				p11.add(formato);
			}
			doc.add(p11);
			doc.close();
			return true;
		} catch (DocumentException e) {
			throw e;
		} catch (IOException o) {
			throw o;
		}
	}

	public void reportSuppliersByProduct() throws DocumentException, IOException {
		Document doc = new Document();
		try {
			PdfWriter.getInstance(doc, new FileOutputStream("RELATORIO-FORNECEDORES-POR-PRODUTO.pdf"));

		} catch (DocumentException e) {
			throw e;
		} catch (IOException o) {
			throw o;
		}
	}*/

	/**
	* Gera o documento com o arquivo pdf contendo o relarorio de todos os 
	* fornecedores
	*
	*/
	/*public static Boolean reportSupplierAll() throws DocumentException, IOException {
		Document doc = new Document();
		ArrayList<Fornecedor> clone = new ArrayList<Fornecedor>();
		Iterator<Fornecedor> interativo = ControladorFornecedores.getListaFornecedores().iterator();
		while (interativo.hasNext()) {
			clone.add((Fornecedor) interativo.next());
		}
		try {
			PdfWriter.getInstance(doc, new FileOutputStream("RELATORIO-FORNECEDORES-GERAL.pdf"));
			if (!ControladorFornecedores.getListaFornecedores().isEmpty()) {
				doc.open();
				Paragraph p1 = new Paragraph("RELATORIO GERAL FORNECEDORES\n");
				p1.setAlignment(Element.ALIGN_CENTER);
				doc.add(p1);
				p1 = new Paragraph(
						"|NOME              |CNPJ              |ENDERECO                     |ID              |\n");
				String formato;
				for (Fornecedor item : ControladorFornecedores.getListaFornecedores()) {
					formato = String.format("|%18s| %17s| %28s| %15s|\n", item.getNome(), item.getCNPJ(),
							item.getAdress(), item.getId());
					p1.add(formato);
				}
				p1.setAlignment(Element.ALIGN_CENTER);
				doc.add(p1);
				doc.close();
				return true;
			}
		} catch (DocumentException e) {
			throw e;
		} catch (IOException o) {
			throw o;
		}
		return false;
	}
}*/