package br.com.estacionamento.core.exception;

public class EstabelecimentoException extends RuntimeException{
    public EstabelecimentoException(){
        super("Estabelecimento não Encontrado!!!");
    }

    public EstabelecimentoException(String message) {super(message); }
}
