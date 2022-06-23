package Codigo.src;

public class ClientNotExistsException extends IllegalArgumentException{
    public ClientNotExistsException() {
        super("Cliente Inexistente!");
    }
}