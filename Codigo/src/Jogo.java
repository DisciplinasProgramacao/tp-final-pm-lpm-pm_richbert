package Codigo.src;

public class Jogo {
 
    private Categoria category;
    private String name;

    public Jogo() {
        
    }

    public int getPontos() {
        return this.category.getPontos();
    }
}
