package Codigo.src;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private String cadName;
    private String userName;
    private String password;
    private ArrayList<Compra> compras;
    private TipoCliente tipo;

    public Cliente() {
        this.cadName = "";
        this.userName = "";
        this.password = "";
        this.compras = new ArrayList<Compra>();
    }

    public Cliente(String cadName, String userName, String password) {
        this.cadName = cadName;
        this.userName = userName;
        this.password = password;
        this.tipo = TipoCliente.CADASTRADO;
        this.compras = new ArrayList<Compra>();
    }

    public Cliente(String cadName, String userName, String password, TipoCliente tipo) {
        this.cadName = cadName;
        this.userName = userName;
        this.password = password;
        this.tipo = tipo;
        this.compras = new ArrayList<Compra>();
    }

    public Cliente(String cadName, String userName, String password, ArrayList<Compra> compras) {
        this.cadName = cadName;
        this.userName = userName;
        this.password = password;
        this.compras = compras;
        this.tipo = TipoCliente.CADASTRADO;
    }

    public Cliente(String cadName, String userName, String password, ArrayList<Compra> compras, TipoCliente tipo) {
        this.cadName = cadName;
        this.userName = userName;
        this.password = password;
        this.compras = compras;
        this.tipo = tipo;
    }

    //Setters
    public void setCadName(String cadName) {
        this.cadName = cadName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    //Getters
    public String getCadName() {
        return this.cadName;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public double getDiscount() {
        return this.tipo.getDiscount();
    }

    public double getMonthlyPayment() {
        return this.tipo.getMonthlyPayment();
    }

    //Rule methods
    public Compra newBuy(ArrayList<Jogo> games, Scanner scanner) {
        int op = 1;
        Compra compra = new Compra(this);

        do {
            System.out.println("Digite o código do jogo:");
            final int codJogo = scanner.nextInt();
            
            Jogo jogo = null;

            jogo = games.stream().filter(j -> j.getId() == codJogo).findFirst().get();
            
            if(jogo == null) {
                System.out.println("\nJogo não cadastrado com o código informado!");
            } else {
                compra.addGame(jogo);
                System.out.println("\nDeseja cadastrar mais jogos? (1- Sim / 2- Não)");
                op = scanner.nextInt();
                
                while(op != 1 && op != 2){
                    System.out.println("Opção inválida! - Digite a opção novamente: (1- Sim / 2- Não)");
                    op = scanner.nextInt();
                }
            }
        } while(op != 2);

        double price = compra.getTotalPrice();
        double totalPrice = compra.getFinalPrice();

        System.out.println("Preço total da compra: " + price);
        System.out.println("Preço final da compra após descontos: " + totalPrice + "\n\n");

        this.compras.add(compra);

        return compra;
    }

    public void shopHistory() {
        compras.stream().forEach((compra) -> {
            System.out.println("------------------------------------------");
            System.out.println("Data da compra: " + compra.getDate());
            System.out.println("Jogos comprados: ");
            compra.printGames();
            System.out.println("Preço total da compra: " + compra.getTotalPrice());
            System.out.println("Preço final da compra: " + compra.getFinalPrice());
            System.out.println("------------------------------------------");
        });
    }
}
