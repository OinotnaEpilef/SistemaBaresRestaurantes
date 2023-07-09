package pblum;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/*import com.itextpdf.text.DocumentException;*/

import modelos.ControladorCardapio;
import modelos.ControladorEstoque;
import modelos.ControladorFornecedores;
import modelos.ControladorProdutos;
import modelos.ControladorVendas;
/*import modelos.DAORelatorio;*/
import modelos.Ingrediente;
import view.Menu;
import java.util.Objects;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

/**
 * Autores: Antonio Felipe Ferreira de Jesus Moreira e Wagner Alexandre Ferreira
 * Junior Componente Curricular: Algoritmos II Concluido em: 11/04/2022 Declaro
 * que este codigo foi elaborado por mim, Wagner Alexandre e meu colega Antonio
 * Felipe em dupla e nao contem nenhum trecho de codigo de outro colega ou de
 * outro autor, tais como provindos de livros e apostilas, e paginas ou
 * documentos eletronicos da Internet. Qualquer trecho de codigo de outra
 * autoria que nao a nossa esta destacado com uma citacao para o autor e a fonte
 * do codigo, e estou ciente que estes trechos nao serao considerados para fins
 * de avaliacao.
 * 
 * @author Wagner Alexandre
 * @author Antonio Felipe
 */

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/ViewLogin.fxml")));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		// GERENTES
		modelos.ControladorGerentes.create("Beltano", "123");
		modelos.ControladorGerentes.create("Ciclano", "234");
		modelos.ControladorGerentes.create("Deltano", "a222");

		// FUNCIONARIOS
		modelos.ControladorFuncionarios.create("jao", "123");
		modelos.ControladorFuncionarios.create("vitrola", "333");
		modelos.ControladorFuncionarios.create("seu ze", "asdf");
		modelos.ControladorFuncionarios.create("manicoba", "qwerty");

		// PRODUTOS
		ControladorProdutos.create("Manteiga", 7.99, "12-06-2042", 10.5);
		ControladorProdutos.create("brocolis", 2.99, "11-06-2023", 4.0);
		ControladorProdutos.create("brocolis", 2.99, "11-06-2023", 25.0);
		ControladorProdutos.create("arroz", 12.99, "12-07-2024", 20.6);
		ControladorProdutos.create("feijao", 8.99, "15-09-2011", 0.5);
		ControladorProdutos.create("feijao", 8.99, "15-09-2011", 17.5);
		ControladorProdutos.create("batata", 3.33, "13-01-2021", 30.5);
		ControladorProdutos.create("margarina", 3.99, "22-07-2012", 18.6);
		ControladorProdutos.create("Carne", 3.99, "22-07-2012", 1.6);
		ControladorProdutos.create("Carne", 3.99, "22-07-2012", 18.6);
		ControladorProdutos.create("Spaggetti", 3.99, "22-07-2012", 18.6);
		ControladorProdutos.create("Manga", 3.99, "22-07-2012", 10.0);

		// ESTOQUE

		ControladorEstoque.create("Manteiga");
		ControladorEstoque.create("brocolis");
		ControladorEstoque.create("arroz");
		ControladorEstoque.create("feijao");
		ControladorEstoque.create("batata");
		ControladorEstoque.create("margarina");
		ControladorEstoque.create("Carne");
		ControladorEstoque.create("Spaggetti");
		ControladorEstoque.create("Manga");

		// INGREDIENTES
		Ingrediente manteiga = new Ingrediente();
		manteiga.setEstoqueNeeded(ControladorEstoque.getEstoqueProduto("PRDCT1"));
		manteiga.setQuantia(3.3);

		Ingrediente brocolis = new Ingrediente();
		brocolis.setEstoqueNeeded(ControladorEstoque.getEstoqueProduto("PRDCT2"));
		brocolis.setQuantia(2.6);

		Ingrediente arroz = new Ingrediente();
		arroz.setEstoqueNeeded(ControladorEstoque.getEstoqueProduto("PRDCT3"));
		brocolis.setQuantia(1.6);

		Ingrediente feijao = new Ingrediente();
		feijao.setEstoqueNeeded(ControladorEstoque.getEstoqueProduto("PRDCT4"));
		feijao.setQuantia(1.0);

		Ingrediente batata = new Ingrediente();
		batata.setEstoqueNeeded(ControladorEstoque.getEstoqueProduto("PRDCT5"));
		batata.setQuantia(1.5);

		Ingrediente margarina = new Ingrediente();
		margarina.setEstoqueNeeded(ControladorEstoque.getEstoqueProduto("PRDCT6"));
		margarina.setQuantia(3.2);

		Ingrediente carne = new Ingrediente();
		carne.setEstoqueNeeded(ControladorEstoque.getEstoqueProduto("PRDCT7"));
		carne.setQuantia(1.0);

		Ingrediente spaggetti = new Ingrediente();
		spaggetti.setEstoqueNeeded(ControladorEstoque.getEstoqueProduto("PRDCT8"));
		spaggetti.setQuantia(0.8);

		Ingrediente manga = new Ingrediente();
		manga.setEstoqueNeeded(ControladorEstoque.getEstoqueProduto("PRDCT9"));
		manga.setQuantia(2.0);

		// RECEITAS
		ArrayList<Ingrediente> sucoDeManga = new ArrayList<Ingrediente>();
		sucoDeManga.add(manga);

		ArrayList<Ingrediente> arrozComFeijao = new ArrayList<Ingrediente>();

		ArrayList<Ingrediente> batataComBrocolis = new ArrayList<Ingrediente>();

		ArrayList<Ingrediente> spaggetiComCarne = new ArrayList<Ingrediente>();

		ArrayList<Ingrediente> carneFritaNaManteiga = new ArrayList<Ingrediente>();

		ArrayList<Ingrediente> spaggetiComMargarina = new ArrayList<Ingrediente>();

		// Pratos
		ControladorCardapio.create("SUCO DE MANGA", "BEBIDA DE MANGA NATU", 3, 7.3, sucoDeManga);

		// FORNECEDORES

		ControladorFornecedores.create("SEU TIRINGA", "9882984094", "SERRA TALHADA");
		ControladorFornecedores.create("AMANDA MANGAS", "9883384094", "SERRA TALHADA");
		ControladorFornecedores.create("MARIO ESPAGATTI", "9842984094", "SERRA TALHADA");
		ControladorFornecedores.create("GERALDO GERAL", "1882984094", "SERRA TALHADA");

		ControladorFornecedores.getFornecedorbById("FRNCR1").addProdutos("Manteiga");
		ControladorFornecedores.getFornecedorbById("FRNCR1").addProdutos("batata");
		ControladorFornecedores.getFornecedorbById("FRNCR3").addProdutos("feijao");
		ControladorFornecedores.getFornecedorbById("FRNCR3").addProdutos("Spaggetti");
		ControladorFornecedores.getFornecedorbById("FRNCR4").addProdutos("arroz");
		ControladorFornecedores.getFornecedorbById("FRNCR2").addProdutos("Carne");
		ControladorFornecedores.getFornecedorbById("FRNCR1").addProdutos("brocolis");
		ControladorFornecedores.getFornecedorbById("FRNCR4").addProdutos("margarina");
		ControladorFornecedores.getFornecedorbById("FRNCR4").addProdutos("Carne");

		// VENDAS

		ControladorVendas.getListaVendas().add(ControladorVendas.create());
		ControladorVendas.getListaVendas().add(ControladorVendas.create());
		ControladorVendas.getListaVendas().add(ControladorVendas.create());

		launch(args);

	}
}
