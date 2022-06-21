package Codigo.src;

public class Jogo {
 
    private Categoria category;
    private String name;
    private double price;
    private int id;
    private int vendido;

    public Jogo(String name, Categoria category, double price, int id) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.id = id;
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

    public void setId(int id) {
        this.id = id;
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
    
    public int getId() {
        return this.id;
    }

    public void addVendido() {
        this.vendido++;
    }
    
    public final int vendido() {
        return this.vendido;
    }

   
}
