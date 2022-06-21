package Codigo.src;

import java.util.ArrayList;

public class App {

    private static final String NOME_ARQUIVO_JOGOS = "./jogos.txt";
    ArrayList<Jogo> jogos = new ArrayList<Jogo>();

    public static void main(String[] args) {
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
}
