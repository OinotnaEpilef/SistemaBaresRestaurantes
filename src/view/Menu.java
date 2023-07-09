package view;

import java.util.Scanner;

/*import com.itextpdf.text.DocumentException;*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Objects;

import modelos.ControladorCardapio;
import modelos.ControladorEstoque;
import modelos.ControladorFornecedores;
import modelos.ControladorFuncionarios;
import modelos.ControladorGerentes;
import modelos.ControladorProdutos;
import modelos.ControladorVendas;
/*import modelos.DAORelatorio;*/
import modelos.Ingrediente;
import modelos.Vendas;

/**
 * @author Wagner Alexandre
 * @author Antonio Felipe
 */
public class Menu {
	@SuppressWarnings("resource")
	public static void menuPrincipal() throws ParseException, InputMismatchException {
		// declaracao das variaveis
		int opcao = 0;
		Scanner leitorInt = new Scanner(System.in);
		// declaracao das variaveis
		while (opcao != 7) {
			try {
				System.out.println(
						"1. Gerenciar usuários. \n2. Gerenciar fornecedores. \n3. Gerenciar produtos. \n4. Gerenciar cardï¿½pio. \n5. Gerenciar vendas. \n6.Gerar relat�rio \n7. Sair. \nSelecione a sua opï¿½o: ");
				opcao = leitorInt.nextInt();
			} catch (java.util.InputMismatchException e1) {
				System.out.println("ENTRADA INCORRETA!");
				leitorInt.nextLine();
			
			}
			switch (opcao) {
			case 1:
				Menu.menuUsuarios();
				break;
			case 2:
				Menu.menuFornecedores();
				break;
			case 3:
				Menu.menuProdutos();
				break;
			case 4:
				Menu.menuCardapio();
				break;
			case 5:
				Menu.menuVendas();
				break;
			case 6:
				Menu.menuRelatorioGeral();
				break;
			case 7:
				break;
			default:
				System.out.println("ENTRADA INCORRETA!!!");
				break;
			}
		}

	}

	@SuppressWarnings("resource")
	public static void menuUsuarios() {
		// variaves que serao utilizadas como inputs no menu de usuarios
		int opcao;
		int tipoUsuario;
		String nome;
		int listarUsuario;
		String idUser;
		Scanner leitorStr = new Scanner(System.in);
		Scanner leitorInt = new Scanner(System.in);
		String newUser;
		String idDelete;
		int updateUsuario;
		String password;
		// variaves que serao utilizadas como inputs no menu de usuarios

		System.out.println(
				"1. Cadastrar usuï¿½rio. \n2. Listar usuï¿½rios. \n3. Editar usuï¿½rio. \n4. Deletar usuï¿½rio. \n Selecione a sua opï¿½o: ");
		opcao = leitorInt.nextInt();
		switch (opcao) {
		case 1:
			System.out.println("Digite o nome de seu funcionï¿½rio: ");
			nome = leitorStr.nextLine();
			System.out.println("1. Gerente. \n2. Funcionï¿½rio. \nSelecione o tipo de usuï¿½rio: ");
			tipoUsuario = leitorInt.nextInt();
			System.out.println("Digite a sua senha:");
			password = leitorStr.nextLine();
			if (tipoUsuario == 1) {
				ControladorGerentes.create(nome, password);
				break;

			} else {
				ControladorFuncionarios.create(nome, password);
				break;
			}
		case 2:
			System.out.println(
					"1. Gerente. \n2. Funcionï¿½rio. \nSelecione o tipo de usuï¿½rio que deseja listar: ");
			listarUsuario = leitorInt.nextInt();
			if (listarUsuario == 1) {
				ControladorGerentes.read();
			} else {
				ControladorFuncionarios.read();
			}
			break;
		case 3:
			System.out.println("Digite o ID do usuï¿½rio a ser editado: ");
			idUser = leitorStr.nextLine();
			System.out.println("Digite o novo nome para o Usuï¿½rio: ");
			newUser = leitorStr.nextLine();
			System.out.println("1. Gerente. \n2. Funcionï¿½rio. \nSelecione o tipo de usuï¿½rio a ser editado: ");
			updateUsuario = leitorInt.nextInt();
			if (updateUsuario == 1) {
				ControladorGerentes.update(idUser, newUser);
			} else {
				ControladorFuncionarios.update(idUser, newUser);
			}
			break;
		case 4:
			System.out.println("Digite o ID do usuï¿½rio a ser deletado: ");
			idDelete = leitorStr.nextLine();
			System.out.println(
					"1. Gerente. \n2. Funcionï¿½rio. \nSelecione o tipo de usuï¿½rio que deseja listar: ");
			updateUsuario = leitorInt.nextInt();
			if (updateUsuario == 1) {
				ControladorGerentes.delete(idDelete);
			} else {
				ControladorFuncionarios.delete(idDelete);
			}
			break;
		default:
			System.out.println("Incorreto");
			break;
		}
	}

	@SuppressWarnings("resource")
	public static void menuFornecedores() {
		// declaracao das variaveis
		Scanner leitorStr = new Scanner(System.in);
		Scanner leitorInt = new Scanner(System.in);
		int opcao;
		String cnpj;
		String nome;
		String adress;
		String newContent;
		String idUser;
		int newChoice;
		String idDelete;
		// declaracao das variaveis
		System.out.println(
				" 1. Cadastrar fornecedor. \n2. Listar fornecedores. \n3. Editar fornecedor. \n 4. Deletar fornecedor");
		opcao = leitorInt.nextInt();
		switch (opcao) {
		case 1:
			System.out.println("Digite o CNPJ do fornecedor");
			cnpj = leitorStr.nextLine();
			System.out.println("Digite o nome do fornecedor");
			nome = leitorStr.nextLine();
			System.out.println("Digite o endereï¿½o do fornecedor");
			adress = leitorStr.nextLine();
			ControladorFornecedores.create(nome, cnpj, adress);
			break;
		case 2:
			ControladorFornecedores.read();
			break;
		case 3:
			System.out.println("Digite o ID do fornecedor a ser editado: ");
			idUser = leitorStr.nextLine();
			System.out.println("1. Editar nome \n2. Editar endereço \nDigite a opção a ser editada:");
			newChoice = leitorInt.nextInt();
			if (newChoice == 1) {
				System.out.println("Digite o novo nome para o fornecedor: ");
				newContent = leitorStr.nextLine();
			} else {
				System.out.println("Digite o novo endereço para o fornecedor: ");
				newContent = leitorStr.nextLine();
			}
			/*
			 * mudar para switch case
			 */
			ControladorFornecedores.update(idUser, newChoice, newContent);
			break;
		case 4:
			System.out.println("Digite o ID do fornecedor a ser deletado: ");
			idDelete = leitorStr.nextLine();
			ControladorFornecedores.delete(idDelete);
			break;
		default:
			break;
		}
	}

	@SuppressWarnings("resource")
	public static void menuProdutos() throws ParseException {
		// declaracao das variaveis
		Scanner leitorStr = new Scanner(System.in);
		Scanner leitorInt = new Scanner(System.in);
		int opcao;
		String nome;
		Double preco;
		String validade;
		String idUpdate;
		String newContent;
		String idDelete;
		Double quantia;
		int newInfo;
		// declaracao das variaveis
		System.out
				.println(" 1. Cadastrar produto. \n 2. Listar produtos. \n  3. Editar produto. \n 4. Deletar produto");
		opcao = leitorInt.nextInt();
		switch (opcao) {
		case 1:
			System.out.println("Digite o nome do produto:");
			nome = leitorStr.nextLine();
			System.out.println("Digite o preï¿½o do produto:");
			preco = leitorInt.nextDouble();
			System.out.println("Digite a quantia do produto em KG/LITROS:");
			quantia = leitorInt.nextDouble();
			System.out.println("Digite a validade do produto(Formato aaaa/mm/dd):");
			validade = leitorStr.nextLine();
			SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd");
			Date val1 = (Date) form.parse(validade);
			ControladorProdutos.create(nome, preco, val1.toString(), quantia);
			break;
		case 2:
			ControladorProdutos.read();
			break;
		case 3:
			System.out.println("Digite o ID do produto a ser editado: ");
			idUpdate = leitorStr.nextLine();
			newInfo = Menu.menuUpdateProdutos();
			System.out.println("Digite o novo conteï¿½do:");
			if (newInfo == 1 || newInfo == 3) {
				newContent = leitorStr.nextLine();
			} else {
				newContent = Double.toString(leitorInt.nextDouble());
			}
			ControladorProdutos.update(idUpdate, newInfo, newContent);
		case 4:
			System.out.println("Digite o ID do produto a ser deletado: ");
			idDelete = leitorStr.nextLine();
			ControladorProdutos.delete(idDelete);
			break;
		}
	}

	@SuppressWarnings("resource")
	public static int menuUpdateProdutos() {
		// declaracao das variaveis
		Scanner leitorInt = new Scanner(System.in);
		int opcao;
		int newInfo;
		// declaracao das variaveis
		do {
			System.out.println(
					"1. Nome \n2. Preï¿½o \n3. Validade \nDigite a opï¿½o que deseja editar, digite 4 para cancelar");
			opcao = leitorInt.nextInt();
			newInfo = 0;
			switch (opcao) {
			case 1:
				newInfo = 1;
				break;
			case 2:
				newInfo = 2;
				break;
			case 3:
				newInfo = 3;
				break;
			default:
				System.out.println("Opï¿½o invalida, tente novamente");
				break;
			}
		} while (opcao != 4);
		return newInfo;
	}

	@SuppressWarnings("resource")
	public static void menuCardapio() {
		// declaracao das variaveis
		Scanner leitorStr = new Scanner(System.in);
		Scanner leitorInt = new Scanner(System.in);
		int opcao;
		String nome;
		String descricao;
		int tipo;
		Double valor;
		String idUpdate;
		int newInfo;
		String newContent = "1";
		String idDelete;
		Ingrediente ingrediente = new Ingrediente();
		int escolhaProdutos;
		String idEstoqueProduto;
		double quantidade;
		ArrayList<Ingrediente> receita = new ArrayList<Ingrediente>();
		int opcaoEdicao;
		String ingredienteEdicao;
		// declaracao das variaveis
		System.out.println(
				" 1. Cadastrar item no cardï¿½pio. \n2. Listar cardï¿½pio. \n3. Editar itens do cardï¿½pio. \n4. Deletar item do cardï¿½pio");
		opcao = leitorInt.nextInt();
		switch (opcao) {
		case 1:
			System.out.println("Digite o nome do item a ser adicionado:");
			nome = leitorStr.nextLine();
			System.out.println("Digite a descriï¿½o do item:");
			descricao = leitorStr.nextLine();
			System.out.println("Digite o nï¿½mero referente ao tipo do item:");
			tipo = leitorInt.nextInt();
			System.out.println("Digite o valor do item:");
			valor = leitorInt.nextDouble();
			do {
				System.out.println("Digite o ID do Estoque do produto que compoe o prato:");
				idEstoqueProduto = leitorStr.nextLine();
				System.out.println("Digite a quantidade do produto necessaria para o prato:");
				quantidade = leitorInt.nextDouble();
				ingrediente.setEstoqueNeeded(ControladorEstoque.getEstoqueProduto(idEstoqueProduto));
				ingrediente.setQuantia(quantidade);
				receita.add(ingrediente);
				System.out.println("1. Adicionar novo produto \n2. Continuar\nDigite sua opcao:");
				escolhaProdutos = leitorInt.nextInt();
			} while (escolhaProdutos == 1);
			ControladorCardapio.create(nome, descricao, tipo, valor, receita);
		case 2:
			ControladorCardapio.read();
		case 3:
			System.out.println("Digite o ID do item a ser editado: ");
			idUpdate = leitorStr.nextLine();
			newInfo = Menu.menuUpdateCardapio();
			System.out.println("Digite o novo conteï¿½do:");
			if (newInfo == 1 || newInfo == 2 || newInfo == 4) {
				newContent = leitorStr.nextLine();
			} else if (newInfo == 3) {
				newContent = Integer.toString(leitorInt.nextInt());
			} else {
				System.out.println("1. Adicionar novo ingrediente \n2. Retirar ingrediente \nDigite sua opcao:");
				opcaoEdicao = leitorInt.nextInt();
				System.out.println("Digite o ID  do ingrediente:");
				ingredienteEdicao = leitorStr.nextLine();
				if (opcaoEdicao == 1) {
					System.out.println("Digite a quantidade do produto necessaria para o prato:");
					quantidade = leitorInt.nextDouble();
					ingrediente.setEstoqueNeeded(ControladorEstoque.getEstoqueProduto(ingredienteEdicao));
					ingrediente.setQuantia(quantidade);
					receita.add(ingrediente);
				}
			}
			ControladorCardapio.update(idUpdate, newInfo, newContent);
		case 4:
			System.out.println("Digite o ID do item a ser deletado: ");
			idDelete = leitorStr.nextLine();
			ControladorCardapio.delete(idDelete);
		default:
			break;
		}
	}

	@SuppressWarnings("resource")
	public static int menuUpdateCardapio() {
		// declaracao das variaveis
		Scanner leitorInt = new Scanner(System.in);
		int opcao;
		int newInfo;
		// declaracao das variaveis
		do {
			System.out.println(
					"1. Nome \n2. Descriï¿½o \n3. Categoria \n4. Preï¿½o \n1. Ingredientes \nDigite a opï¿½o que deseja editar, digite 6 para cancelar");
			opcao = leitorInt.nextInt();
			newInfo = 0;
			switch (opcao) {
			case 1:
				newInfo = 1;
				break;
			case 2:
				newInfo = 2;
				break;
			case 3:
				newInfo = 3;
				break;
			case 4:
				newInfo = 4;
			case 5:
				newInfo = 5;
			default:
				System.out.println("Opï¿½o invalida, tente novamente");
				break;
			}
		} while (opcao != 5);
		return newInfo;
	}

	@SuppressWarnings("resource")
	public static void menuVendas() {
		// declaracao das variaveis
		Scanner leitorStr = new Scanner(System.in);
		Scanner leitorInt = new Scanner(System.in);
		String idDelete = null;
		int opcao;
		// declaracao das variaveis

		do {
			System.out.println("1. Cadastrar venda. \n2. Listar vendas. \n3. Deletar venda\n4. Finalizar.");
			opcao = leitorInt.nextInt();
			switch (opcao) {
			case 1:
				view.Menu.menuCadastroVendas();
				break;
			case 2:
				modelos.ControladorVendas.read();
				break;
			case 3:
				System.out.println("Digite o ID da venda a ser deletada: ");
				idDelete = leitorStr.nextLine().toUpperCase();
				ControladorVendas.delete(idDelete);
				break;
			case 4:
				break;
			default:
				System.out.println("Entrada Incorreta!");
				break;
			}
		} while (opcao != 4);
	}

	public static void menuInicial() throws ParseException {
		@SuppressWarnings("resource")
		Scanner leitorStr = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner leitorInt = new Scanner(System.in);
		String id;
		String senha;
		int opcao = 1;
		int tipo;
		do {
			System.out.println("1. Logar \n2. Sair \nDigite sua opÃ§Ã£o:");
			opcao = leitorInt.nextInt();
			if (opcao == 1) {
				System.out.println("Digite seu id:");
				id = leitorStr.nextLine();
				System.out.println("Digite sua senha:");
				senha = leitorStr.nextLine();
				System.out.println("1. Gerente \n2. FuncionÃ¡rio \nDigite sua funÃ§Ã£o:");
				tipo = leitorInt.nextInt();
				if (tipo == 1) {
					if (modelos.ControladorGerentes.checkIdSenha(id, senha)) {
						view.Menu.menuPrincipal();
					} else {
						System.out.println("Senha ou id incorretos");
					}
				}
				if (tipo == 2) {
					if (modelos.ControladorFuncionarios.checkIdSenha(id, senha)) {
						view.Menu.menuFuncionario();
					} else {
						System.out.println("Senha ou id incorretos");
					}
				}
			}
		} while (opcao != 2);
	}

	public static void menuFuncionario() {
		@SuppressWarnings("resource")
		Scanner leitorInt = new Scanner(System.in);
		int opcao;
		System.out.println(
				"1. Cadastrar nova venda \n2. Listar vendas \n3. Listar cardÃ¡pio \nDigite sua opÃ§Ã£o(qualquer outra irÃ¡ sair do menu):");
		opcao = leitorInt.nextInt();
		switch (opcao) {
		case 1:
			view.Menu.menuCadastroVendas();
			break;
		case 2:
			modelos.ControladorCardapio.read();
			break;
		case 3:
			modelos.ControladorVendas.read();
			break;
		default:
			break;
		}
	}

	@SuppressWarnings("resource")
	public static void menuCadastroVendas() {
		int index;
		ArrayList<Ingrediente> contagem = new ArrayList<Ingrediente>();
		Scanner leitorStr = new Scanner(System.in);
		Scanner leitorInt = new Scanner(System.in);
		modelos.ItemCardapio cadastro;
		Vendas novaVenda = ControladorVendas.create();
		Boolean permit = null;
		int opcao2;
		String id;
		do {
			permit = true;
			System.out.println(
					"1. Adicionar Item.\n2. Remover Item.\n3. Ver o Cardapio.\n4. Cancelar Venda.\n5. Concluir Venda.");
			opcao2 = leitorInt.nextInt();
			novaVenda.listagem();
			if (opcao2 == 1) {
				System.out.println("Digite o ID do Prato a ser adicionado:");
				id = leitorStr.nextLine();

				cadastro = ControladorCardapio.getItemCardapio(id);

				if (Objects.isNull(cadastro)) {
					System.out.println("Item inexistente.");

				} else {
					for (int i = 0; i < cadastro.getIngredientes().size(); i++) {
						if (ControladorEstoque.listContains(contagem,
								cadastro.getIngredientes().get(i).getProdutoCatalago())) {
							index = contagem.indexOf(cadastro.getIngredientes().get(i));
							contagem.get(index).setQuantia(
									contagem.get(index).getQuantia() + cadastro.getIngredientes().get(i).getQuantia());
						} else {
							contagem.addAll(cadastro.getIngredientes());
						}
					}
					for (Ingrediente item : contagem) {
						if (!(ControladorEstoque.checarQuantia(item.getProdutoCatalago(), item.getQuantia()))) {
							System.out.printf("NAO HA %s SUFICIENTE\n", item.getProdutoCatalago().getNome());
							permit = false;

						}
					}
					if (permit) {
						novaVenda.addItem(cadastro);
					}
					permit = true;

				}
			} else if (opcao2 == 2) {

				// remover item da venda
				System.out.println("Digite o ID do Prato a ser removido:");
				id = leitorStr.nextLine();
				cadastro = ControladorCardapio.getItemCardapio(id);
				if (Objects.isNull(cadastro)) {
					System.out.println("Item inexistente.");
				} else {
					novaVenda.removeItem(id);
				}
			} else if (opcao2 == 3) {
				System.out.println("Abrindo Cardapio...");
				ControladorCardapio.read();
			} else if (opcao2 == 4) {
				System.out.println("Venda cancelada! Voltando ao Gerenciamento Geral das vendas...");
				break;
			} else if (opcao2 == 5) {

				for (Ingrediente ingrediente : contagem) {
					ControladorEstoque.arremate(ingrediente.getProdutoCatalago(), ingrediente.getQuantia());
				}

				System.out.println("Venda concluida! Voltando ao Gerenciamento Geral das vendas...");
				ControladorVendas.addVenda(novaVenda);
				break;

			} else if (opcao2 == 0) {
				break;
			} else {
				System.out.println("OPCAO INVALIDA.");
			}
		} while (opcao2 != 0);

	}

	@SuppressWarnings({ "resource" })
	public static void menuRelatorioGeral() {
		int opcao = 1;
		Scanner leitorInt = new Scanner(System.in);

		/*do {
			try {
				System.out.println(
						"1. Todas as vendas \n2. Vendas por dia \n3.Vendas por tipo de prato \n4. Quantidade total do estoque \n5. Quantidade por produto \n6. Produtos a vencer \n7. Fornecedores por produto \n8. Fornecedores \n 9. Sair \n Digite sua opcao");
				opcao = leitorInt.nextInt();
				break;
			} catch (java.util.InputMismatchException e1) {
				System.out.println("ENTRADA INCORRETA!");
				leitorInt.nextLine();
			}
			switch (opcao) {
			case 1:
				try {
					DAORelatorio.reportAllSales();
				} catch (DocumentException | IOException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					DAORelatorio.reportSalesInDay();
				} catch (DocumentException | IOException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					DAORelatorio.reportSalesInMonth();
				} catch (DocumentException | IOException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					DAORelatorio.reportSalesPerType();
				} catch (DocumentException | IOException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					DAORelatorio.reportStockGeral();
				} catch (DocumentException | IOException e) {
					e.printStackTrace();
				}
				break;
			case 6:
				try {
					DAORelatorio.reportStockPerProduct();
				} catch (DocumentException | IOException e) {
					e.printStackTrace();
				}
				break;
			case 7:
				try {
					DAORelatorio.reportStockPerProductValidade();
				} catch (DocumentException | IOException e) {
					e.printStackTrace();
				}
				break;
			case 8:
				try {
					DAORelatorio.reportSupplierAll();
				} catch (DocumentException | IOException e) {
					e.printStackTrace();
				}
				break;
			default:
				break;
			}
		} while (opcao != 9);*/
	}
}