package Codigo.src;

enum Categoria {
    LANCAMENTO(10),
    PREMIUM(5),
    NORMAL(3);

    int pontos;

    private Categoria(int pontos) {
        this.pontos = pontos;
    }

    public int getPontos() {
        return this.pontos;
    }
}
