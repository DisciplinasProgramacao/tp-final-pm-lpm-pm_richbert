package Codigo.src;

import java.util.ArrayList;

public class Fanatico extends Cliente {
    public Fanatico(String name, String userName, String password, ArrayList<Compra> compras){
        super(name, userName, password, compras);
        this.discount = 0.3;
        this.monthlyPayment = 25.0;
    }
}
