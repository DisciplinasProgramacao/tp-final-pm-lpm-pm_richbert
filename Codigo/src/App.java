package Codigo.src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    static Scanner teclado = new Scanner(System.in);
    private static final String NOME_ARQUIVO_JOGOS = "./jogos.txt";
    ArrayList<Jogo> jogos = new ArrayList<Jogo>();

    public static void main(String[] args) {
        
        int op = -1;

		do {
			op = menu(teclado);

			switch (op) {
			case 1:

				break;

			case 2:

				break;

			case 3:

				break;

			case 4:

				break;

			case 5:

				break;

			case 6:

				break;
				
			case 7:

				break;
				
			case 0:
				System.out.println("Encerrando...");
				break;

			default:
				System.out.println("Opção Inválida.");
			}
		} while (op != 0);

    }

    public static void initializeGames() {
        ArquivoLeitura f = new ArquivoLeitura(NOME_ARQUIVO_JOGOS);

        String s = f.lerLinha();
        int quantPedidos = Integer.parseInt(s);
        Pedido[] pedidos = new Pedido[quantPedidos];

        for (int i = 0; i < quantPedidos; i++) {
            String[] dadosPedido = f.lerLinha().split(";");
            pedidos[i] = new Pedido(dadosPedido[0],
                    Integer.parseInt(dadosPedido[1]),
                    Integer.parseInt(dadosPedido[2]));

        }

        f.fecharArq();

        return pedidos;
    }

    public static int menu(Scanner teclado) {
		int op = -1;
		try {
			System.out.println("1 - Cadastro cliente");
			System.out.println("2 - Comprar jogo");
			System.out.println("3 - Histórico de compras do cliente");
			System.out.println("4 - Valor mensal vendido");
			System.out.println("5 - Valor médio das compras");
			System.out.println("6 - Jogo mais vendido");
			System.out.println("7 - Jogo menos vendido");
			System.out.println("0 - Sair");
			op = teclado.nextInt();

		} catch (InputMismatchException e) {
			System.out.println("\nDigite um número.\n");
		}
		teclado.nextLine();
		return op;
	}
}
