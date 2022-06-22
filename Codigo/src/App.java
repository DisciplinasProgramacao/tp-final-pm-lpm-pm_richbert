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
    private static final String NOME_ARQUIVO_JOGOS = "./jogos.txt";
    static ArrayList<Jogo> jogos = new ArrayList<Jogo>();
    static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    static ArrayList<Compra> compras = new ArrayList<Compra>();
    
    public static ArrayList<Jogo> carregarBinarioJogo(String arq, Scanner teclado) {
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
    
    public static ArrayList<Cliente> carregarBinarioCliente(String arq, Scanner teclado) {
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
    
    public static ArrayList<Compra> carregarBinarioCompra(String arq, Scanner teclado) {
		ArrayList<Compra> compras = null;
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(arq));
			compras = (ArrayList<Compra>) entrada.readObject();
			entrada.close();
		} catch (FileNotFoundException fe) {
			compras = new ArrayList<>(200);
		} catch (ClassNotFoundException ce) {
			System.out.println("Problema na conversão dos dados: classe inválida. Contacte o suporte.");
		} catch (IOException ie) {
			System.out.println("Problemas na operação de E/S. Contacte o suporte");
			System.out.println(ie.getMessage());
		}
		return compras;
	}

	public static void salvarBinarioJogo(ArrayList<Jogo> jogos, String arq, Scanner teclado) {
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
	
	public static void salvarBinarioCliente(ArrayList<Cliente> clientes, String arq, Scanner teclado) {
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
	
	public static void salvarBinarioCompra(ArrayList<Compra> compras, String arq, Scanner teclado) {
		ObjectOutputStream saida = null;
		try {
			saida = new ObjectOutputStream(new FileOutputStream(arq));
			saida.writeObject(compras);
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
	
	public static void calculateNewPurchase() {
		
	}
	
    public static void main(String[] args) {
    	ArrayList<Jogo> jogos = null;
    	ArrayList<Cliente> clientes = null;
    	ArrayList<Compra> compras = null;
    	jogos = carregarBinarioJogo("dados.bin", teclado);
    	clientes = carregarBinarioCliente("dados.bin", teclado);
    	compras = carregarBinarioCompra("dados.bin", teclado);
    	
        int op = -1;

		do {
			op = menu(teclado);

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

				break;
				
			case 0:
				System.out.println("Encerrando...");
				break;

			default:
				System.out.println("Opção Inválida.");
			}
		} while (op != 0);
		
		salvarBinarioJogo(jogos, "dados.bin", teclado);
		salvarBinarioCliente(clientes, "dados.bin", teclado);
		salvarBinarioCompra(compras, "dados.bin", teclado);
    }

    public static int menu(Scanner teclado) {
		int op = -1;
		try {
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Cadastrar jogo");
			System.out.println("3 - Cadastrar compra");
			System.out.println("4 - Histórico de um cliente");
			System.out.println("5 - Cálculo do valor da uma nova compra");
            System.out.println("6 - Valor mensal vendido");
			System.out.println("7 - Valor médio das compras");
			System.out.println("8 - Jogo mais vendido");
			System.out.println("9 - Jogo menos vendido");
			System.out.println("0 - Sair");
			op = teclado.nextInt();

		} catch (InputMismatchException e) {
			System.out.println("\nDigite um número.\n");
		}
		teclado.nextLine();
		return op;
	}
}
