package Codigo.src;
import java.util.ArrayList;

public class Cliente {
    protected String cadName;
    protected String userName;
    protected String password;
    protected double discount;
    protected ArrayList<Compra> compras;

    public Cliente() {
        this.cadName = "";
        this.userName = "";
        this.password = "";
    }

    public Cliente(String cadName, String userName, String password) {
        this.cadName = cadName;
        this.userName = userName;
        this.password = password;
    }

    public Cliente(String cadName, String userName, String password, ArrayList<Compra> compras) {
        this.cadName = cadName;
        this.userName = userName;
        this.password = password;
        this.compras = compras;
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
        return this.discount;
    }

    //Rule methods
    public void newBuy() {
        
    }

    public void shopHistory() {
        compras.stream().forEach((compra) -> {
            System.out.println("---------------");
            System.out.println("Data da compra: " + compra.getDate());
            System.out.println("Jogos comprados: ");
            compra.printGames();
            System.out.println("Preço total da compra: " + compra.getTotalPrice());
            System.out.println("Preço final da compra: " + compra.getFinalPrice());
            System.out.println("---------------");
        });
    }


}
