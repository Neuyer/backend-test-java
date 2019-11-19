package br.com.estacionamento.exceptions;

public class VeiculoNaoEncontradoException extends RuntimeException {
    public VeiculoNaoEncontradoException(){
     super("Veiculo não Encontrado!!!");
    }
}
