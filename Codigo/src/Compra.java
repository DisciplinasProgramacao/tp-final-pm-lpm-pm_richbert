package Codigo.src;
import java.time.LocalDate;
import java.util.ArrayList;

public class Compra {
    private Cliente client;
    private ArrayList<Jogo> games;
    private LocalDate date;
    private double price;
    private double sellingPrice;

    public Compra(Cliente client) {
        this.client = client;
        this.games = new ArrayList<Jogo>();
        this.date = LocalDate.now();
        this.price = 0;
        this.sellingPrice = 0;
    }

    public Compra(Cliente client, ArrayList<Jogo> games, LocalDate date, double price, double sellingPrice) {
        this.client = client;
        this.games = games;
        this.date = date;
        this.price = price;
        this.sellingPrice = sellingPrice;
    }

    //Setters
    public void setClient(Cliente client) {
        this.client = client;
    }

    public void setGame(ArrayList<Jogo> games) {
        this.games = games;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
    
    //Getters
    public Cliente getClient() {
        return this.client;
    }

    public ArrayList<Jogo> getGames() {
        return this.games;
    }
    
    public LocalDate getDate() {
        return this.date;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public double getSellingPrice() {
        return this.sellingPrice;
    }

    // Rules functions
    public double discountRule() {
        double discount = 0.0;
        int pontos = 0;

        pontos += this.games.stream().mapToInt(Jogo::getPontos).sum();

        if(pontos >= 13) {
            discount += 0.2;
        } else if(pontos >= 10) {
            discount += 0.1;
        }

        discount += this.client.getDiscount();

        return discount;
    }

    public void printGames() {
        System.out.println("************************");
        this.games.stream().forEach((game) -> {
            System.out.println(game.getName());
        });
        System.out.println("************************");
    }
    
    public double getTotalPrice() {
        return this.games.stream().mapToDouble(Jogo::getPrice).sum();
    }

    public double getFinalPrice() {
        double preco = getTotalPrice();
        double disconto = discountRule();

        preco -= (preco * disconto);

        return preco;
    }

    public void addGame(Jogo jogo) {
        this.games.add(jogo);
        jogo.addVendido();
    }
}
