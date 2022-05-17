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
        int qntLancamentos = 0;
        int qntPremiuns = 0;
        int qntRegulares = 0;

        this.games.stream().forEach((game) -> {
            switch(game.getCategory()) {
                case "LANCAMENTO":
                    qntLancamentos++;
                    break;
                case "PREMIUM":
                    qntPremiuns++;
                    break;
                case "REGULAR":
                    qntRegulares++;
                    break;
            }
        });

        if(qntLancamentos >= 2) {

        }

        return discount;
    }
}
