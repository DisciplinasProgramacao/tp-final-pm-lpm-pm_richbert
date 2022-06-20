package Codigo.src;

import java.util.ArrayList;

public class Historico extends XulambGames{
    private ArrayList<Compra> compras;
 
    @Override
    public double avgSellPrice(){
        double media = compras.stream().mapToDouble(Compra::getPrice).average().getAsDouble();
        return media;
    }

    @Override
    public double monthlyAmountSold(int mes, int ano){
        double amountSoldByMonth = compras.stream()
                                    .map(C -> C.getDate().getMonth() == mes)
    }
}
