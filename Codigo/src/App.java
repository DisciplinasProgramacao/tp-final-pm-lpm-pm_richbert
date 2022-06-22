package Codigo.src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    static Scanner teclado = new Scanner(System.in);
    private static final String NOME_ARQUIVO_JOGOS = "./jogos.bin";
    private static final String NOME_ARQUIVO_CLIENTE = "./cliente.bin";
    private static final String NOME_ARQUIVO_HiSTORICO = "./historico.bin";
    static ArrayList<Jogo> jogos = new ArrayList<Jogo>();
    static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    static Historico historico = null;
    
    public static ArrayList<Jogo> carregarBinarioJogo(String arq) {
		ArrayList<Jogo> jogos = null;
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(arq));
			jogos = (ArrayList<Jogo>) entrada.readObject();
			entrada.close();
		} catch (FileNotFoundException fe) {
			jogos = new ArrayList<>(200);
		} catch (ClassNotFoundException ce) {
			System.out.println("Problema na conversão dos dados: classe inválida. Contacte o suporte.");
		} catch (IOException ie) {
			System.out.println("Problemas na operação de E/S. Contacte o suporte");
			System.out.println(ie.getMessage());
		}
		return jogos;
	}
    
    public static ArrayList<Cliente> carregarBinarioCliente(String arq) {
		ArrayList<Cliente> clientes = null;
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(arq));
			clientes = (ArrayList<Cliente>) entrada.readObject();
			entrada.close();
		} catch (FileNotFoundException fe) {
			clientes = new ArrayList<>(200);
		} catch (ClassNotFoundException ce) {
			System.out.println("Problema na conversão dos dados: classe inválida. Contacte o suporte.");
		} catch (IOException ie) {
			System.out.println("Problemas na operação de E/S. Contacte o suporte");
			System.out.println(ie.getMessage());
		}
		return clientes;
	}
    
    public static Historico carregarBinarioHistorico(String arq) {
		Historico hist = null;
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(arq));
			hist = (Historico) entrada.readObject();
			entrada.close();
		} catch (FileNotFoundException fe) {
			hist = null;
		} catch (ClassNotFoundException ce) {
			System.out.println("Problema na conversão dos dados: classe inválida. Contacte o suporte.");
		} catch (IOException ie) {
			System.out.println("Problemas na operação de E/S. Contacte o suporte");
			System.out.println(ie.getMessage());
		}
		return hist;
	}

	public static void salvarBinarioJogo(ArrayList<Jogo> jogos, String arq) {
		ObjectOutputStream saida = null;
		try {
			saida = new ObjectOutputStream(new FileOutputStream(arq));
			saida.writeObject(jogos);
			saida.close();
		} catch (FileNotFoundException fe) {
			System.out.println("Arquivo não encontrado, ou permissão negada. Tente novamente com outro arquivo");
		} catch (IOException ex) {
			System.out.println("Problemas na operação de E/S. Contacte o suporte");
			System.out.println(ex.getMessage());
		}
	}
	
	public static void salvarBinarioCliente(ArrayList<Cliente> clientes, String arq) {
		ObjectOutputStream saida = null;
		try {
			saida = new ObjectOutputStream(new FileOutputStream(arq));
			saida.writeObject(clientes);
			saida.close();
		} catch (FileNotFoundException fe) {
			System.out.println("Arquivo não encontrado, ou permissão negada. Tente novamente com outro arquivo");
		} catch (IOException ex) {
			System.out.println("Problemas na operação de E/S. Contacte o suporte");
			System.out.println(ex.getMessage());
		}
	}
	
	public static void salvarBinarioHistorico(Historico historico, String arq) {
		ObjectOutputStream saida = null;
		try {
			saida = new ObjectOutputStream(new FileOutputStream(arq));
			saida.writeObject(historico);
			saida.close();
		} catch (FileNotFoundException fe) {
			System.out.println("Arquivo não encontrado, ou permissão negada. Tente novamente com outro arquivo");
		} catch (IOException ex) {
			System.out.println("Problemas na operação de E/S. Contacte o suporte");
			System.out.println(ex.getMessage());
		}
	}
	
	public static void registrationClient() {
		System.out.println("Digite o nome: ");
    	String name = teclado.nextLine();
    	
    	System.out.println("Digite o apelido: ");
    	String username = teclado.nextLine();
    	
    	System.out.println("Digite uma senha: ");
    	String password = teclado.nextLine();
    	
    	Cliente cliente = new Cliente(name, username, password);
    	clientes.add(cliente);
    	
    	System.out.println("\nCliente cadastrado com sucesso.\n");
	}
	
	public static Categoria categoryChoice(String category) {
		switch(category) {
    	case "LANCAMENTO":
    		return Categoria.LANCAMENTO;   		
    		
    	case "PREMIUM":
    		return Categoria.PREMIUM;
    		
    	case "NORMAL":
    		return Categoria.NORMAL;
    	}
		
		return Categoria.NORMAL;
	}
	
	public static void registrationGame() {
		System.out.println("Digite o nome: ");
    	String name = teclado.nextLine();
    	
    	System.out.println("Digite a categoria(Lancamento, Premium ou Normal: ");
    	String category = teclado.nextLine().toUpperCase();
    	  	
    	System.out.println("Digite o nome: ");
    	double price = teclado.nextDouble();
    	
    	System.out.println("Digite o nome: ");
    	int id = teclado.nextInt();
    	
    	Jogo jogo = new Jogo(name, categoryChoice(category), price, id);
    	jogos.add(jogo);
    	
    	System.out.println("\nJogo cadastrado com sucesso.\n");
	}

	public static void registrationPurchase() {
		System.out.println("Digite o código do cliente:");
        int codCliente = teclado.nextInt();

        Cliente cliente = clientes.get(codCliente);

        while(cliente == null) {
            System.out.println("\nCliente inválido! Digite novamente o código de cliente: ");
            codCliente = teclado.nextInt();

            cliente = clientes.get(codCliente);
        }

        Compra compra = cliente.newBuy(jogos, teclado);

        historico.addPurchase(compra);
	}
	
	public static void historicClient() {
		System.out.println("Digite o apelido do cliente");
		String apelido = teclado.nextLine().toUpperCase();
		
		for (Cliente cliente : clientes) {
			if(cliente.getUserName() == apelido) {
				cliente.shopHistory(); 
			}
		}
	}

	
    public static void main(String[] args) {
        jogos = carregarBinarioJogo(NOME_ARQUIVO_JOGOS);
    	clientes = carregarBinarioCliente(NOME_ARQUIVO_CLIENTE);
    	historico = carregarBinarioHistorico(NOME_ARQUIVO_HiSTORICO);
    	
        int op = -1;

		do {
			op = menu();

			switch (op) {
			case 1:
				registrationClient();
				break;

			case 2:
				registrationGame();
				break;

			case 3:
                registrationPurchase();
				break;

			case 4:
				historicClient();
				break;
			
			case 5:
				System.out.println("Digite o ano desejado: ");
				Integer year = teclado.nextInt();
				System.out.println("Digite o mês desejado: ");
				Integer month = teclado.nextInt();
				historico.monthlyAmountSold(month, year);
				break;

			case 6:
				historico.avgSellPrice();
				break;
			
			case 7:
				historico.bestSoldGame(jogos);
				break;
			
			case 8:
				historico.leastSoldGame(jogos);
				break;
				
			case 0:
				System.out.println("Encerrando...");
				break;

			default:
				System.out.println("Opção Inválida.");
			}
		} while (op != 0);
		
		salvarBinarioJogo(jogos, "dados.bin");
		salvarBinarioCliente(clientes, "dados.bin");
		salvarBinarioHistorico(historico, "dados.bin");
    }

    public static int menu() {
		int op = -1;
		try {
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Cadastrar jogo");
			System.out.println("3 - Cadastrar compra");
			System.out.println("4 - Histórico de um cliente");
            System.out.println("5 - Valor mensal vendido");
			System.out.println("6 - Valor médio das compras");
			System.out.println("7 - Jogo mais vendido");
			System.out.println("8 - Jogo menos vendido");
			System.out.println("0 - Sair");
			op = teclado.nextInt();

		} catch (InputMismatchException e) {
			System.out.println("\nDigite um número.\n");
		}
		teclado.nextLine();
		return op;
	}
}
