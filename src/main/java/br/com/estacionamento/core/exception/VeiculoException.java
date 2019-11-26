package br.com.estacionamento.core.exception;

public class VeiculoException extends RuntimeException {
    public VeiculoException(){
     super("Veiculo não Encontrado!!!");
    }

    public VeiculoException(String message) { super(message);}
}
