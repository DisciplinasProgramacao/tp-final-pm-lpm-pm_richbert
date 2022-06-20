package Codigo.src;

import java.util.ArrayList;

public class Empolgado extends Cliente{
    public Empolgado(String name, String userName, String password, ArrayList<Compra> compras){
        super(name, userName, password, compras);
        this.discount = 0.1;
        this.monthlyPayment = 10.0;
    }
}
