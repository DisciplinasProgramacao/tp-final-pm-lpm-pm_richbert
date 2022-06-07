package Codigo.src;

public class Jogo {
 
    private Categoria category;
    private String name;
    private double price;

    public Jogo(String name, Categoria category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Categoria getCategory() {
        return this.category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPontos() {
        return this.category.getPontos();
    }

   
}
