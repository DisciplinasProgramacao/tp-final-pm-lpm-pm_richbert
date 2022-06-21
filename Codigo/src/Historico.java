package Codigo.src;

import java.util.ArrayList;

public class Historico extends XulambGames{
    private ArrayList<Compra> compras;
    private double soma;

    @Override
    public double avgSellPrice(){
        double media = compras.stream().mapToDouble(Compra::getFinalPrice).average().getAsDouble();
        return media;
    }

    @Override
    public double monthlyAmountSold(int mes, int ano){
        double amountSoldByMonth = compras.stream()
                                          .filter(c -> c.getDate().getYear() == ano && c.getDate().getMonthValue() == mes)
                                          .mapToDouble(Compra::getFinalPrice)
                                          .sum();

        return amountSoldByMonth;
    }

    @Override
    public String bestSoldGame(ArrayList<Jogo> jogos) {
        Jogo bestSoldGame = jogos.stream()
                                 .max((j1, j2) -> (
                                     j1.vendido() > j2.vendido() ? 1 : -1
                                 ))
                                 .get();

        return bestSoldGame.toString();
    }

    @Override
    public String leastSoldGame(ArrayList<Jogo> jogos) {
        Jogo bestSoldGame = jogos.stream()
                                 .min((j1, j2) -> (
                                     j1.vendido() > j2.vendido() ? 1 : -1
                                 ))
                                 .get();

        return bestSoldGame.toString();
    }
}