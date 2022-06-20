package Codigo.src;
import java.util.ArrayList;
import java.util.Date;

public class Compra {
    private Cliente client;
    private ArrayList<Jogo> games;
    private Date date;
    private double price;
    private double sellingPrice;

    //Setters
    public void setClient(Cliente client) {
        this.client = client;
    }

    public void setGame(ArrayList<Jogo> games) {
        this.games = games;
    }

    public void setDate(Date date) {
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
    
    public Date getDate() {
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
        this.games.stream().forEach((game) -> {
            game.toString();
        });
    }
    
    public double getTotalPrice() {
        return this.games.stream().mapToDouble(Jogo::getPrice).sum();
    }

    public double getFinalPrice() {
        double preco = getTotalPrice();
        double disconto = discountRule();

        preco += (preco * disconto);

        return preco;
    }
}
