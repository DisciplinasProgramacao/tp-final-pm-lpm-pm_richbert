package Codigo.src;

import java.util.ArrayList;

public abstract class XulambGames {

    private Historico historico;

    public abstract double avgSellPrice();

    public abstract double monthlyAmountSold(int mes, int ano);

    public abstract String bestSoldGame();

    public abstract String leastSoldGame();
}
