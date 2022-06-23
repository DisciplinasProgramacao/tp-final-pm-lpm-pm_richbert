package Codigo.src;

public class GameAlredyExistsException extends IllegalArgumentException{
    public GameAlredyExistsException() {
        super("Código de jogo Inexistente.");
    }
}
